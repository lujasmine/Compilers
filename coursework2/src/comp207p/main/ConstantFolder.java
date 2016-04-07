package comp207p.main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.Code;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.util.InstructionFinder;
import org.apache.bcel.generic.*;

public class ConstantFolder
{
	ClassParser parser = null;
	ClassGen gen = null;

	JavaClass original = null;
	JavaClass optimized = null;

	ConstantPoolGen cpgen = null;

	public ConstantFolder(String classFilePath)
	{
		try{
			this.parser = new ClassParser(classFilePath);
			this.original = this.parser.parse();
			this.gen = new ClassGen(this.original);
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	private void optimizeMethod(ClassGen cgen, ConstantPoolGen cpgen, Method method) {
	
		Code methodCode = method.getCode();
		InstructionList instList = new InstructionList(methodCode.getCode());
		MethodGen methodGen = new MethodGen(method.getAccessFlags(), method.getReturnType(), method.getArgumentTypes(), null, method.getName(), cgen.getClassName(), instList, cpgen);

		for (InstructionHandle handle : instList.getInstructionHandles()) {
			
			if (handle.getInstruction() instanceof NOP) {
                InstructionHandle handleDelete = handle;
                handle = handle.getNext();
                deleteInstruction(instList, handleDelete);
                instList.setPositions();
			} 
			else if (handle.getInstruction() instanceof ArithmeticInstruction) {
				
                InstructionHandle toHandle = handle.getNext();
                handle = handle.getNext();
                Number lastStackValue = last(instList, toHandle);
					

				if (lastStackValue != null) {

                    int index = 0;

                    if (lastStackValue instanceof Integer) {
                        index = cpgen.addInteger((int) lastStackValue);
                        instList.insert(handle, new LDC(index));
                        instList.setPositions();
                    }
                    if (lastStackValue instanceof Float) {
                        index = cpgen.addFloat((float) lastStackValue);
                        instList.insert(handle, new LDC(index));
                        instList.setPositions();
                    }
                    if (lastStackValue instanceof Double) {
                        index = cpgen.addDouble((double) lastStackValue);
                        instList.insert(handle, new LDC2_W(index));
                        instList.setPositions();
                    }
                    if (lastStackValue instanceof Long) {
                        index = cpgen.addLong((Long) lastStackValue);
                        instList.insert(handle, new LDC2_W(index));
                        instList.setPositions();
                    }
                }
			} 
			else {
				handle = handle.getNext();
				instList.setPositions();
			}
		
			instList.setPositions(true);
			methodGen.setMaxStack();
			methodGen.setMaxLocals();
			Method newMethod = methodGen.getMethod();
			Code newMethodCode = newMethod.getCode();
			InstructionList newInstList = new InstructionList(newMethodCode.getCode());
			cgen.replaceMethod(method, newMethod); 			
		}	

	}

	private Number last(InstructionList instList, InstructionHandle handle) {
        InstructionHandle lastItem = handle;
        do {
            lastItem = lastItem.getPrev();
        } while (!(stackChange(lastItem) || lastItem != null));

        if (lastItem.getInstruction() instanceof BIPUSH) {
            Number value = ((BIPUSH) lastItem.getInstruction()).getValue();
            deleteInstruction(instList, lastItem);
            return value;
        } else if (lastItem.getInstruction() instanceof ICONST) {
            Number value = ((ICONST) lastItem.getInstruction()).getValue();
            deleteInstruction(instList, lastItem);
            return value;
        } else if (lastItem.getInstruction() instanceof DCONST) {
            Number value = ((DCONST) lastItem.getInstruction()).getValue();
            deleteInstruction(instList, lastItem);
            return value;
        } else if (lastItem.getInstruction() instanceof FCONST) {
            Number value = ((FCONST) lastItem.getInstruction()).getValue();
            deleteInstruction(instList, lastItem);
            return value;
        } else if (lastItem.getInstruction() instanceof LCONST) {
            Number value = ((LCONST) lastItem.getInstruction()).getValue();
            deleteInstruction(instList, lastItem);
            return value;
        } else if (lastItem.getInstruction() instanceof IADD) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((int) number[0] + (int) number[1]);
        } else if (lastItem.getInstruction() instanceof IMUL) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((int) number[0] * (int) number[1]);
        } else if (lastItem.getInstruction() instanceof IDIV) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((int) number[1] / (int) number[0]);
        } else if (lastItem.getInstruction() instanceof ISUB) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((int) number[1] - (int) number[0]);
        } else if (lastItem.getInstruction() instanceof IREM) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((int) number[1] % (int) number[0]);
        } else if (lastItem.getInstruction() instanceof INEG) {
            Number firstNumber = last(instList, lastItem);
            if (firstNumber == null) {
                return null;
            }
            deleteInstruction(instList, lastItem);
            return (int)(0 - (int) firstNumber);
        } else if (lastItem.getInstruction() instanceof LADD) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((long) number[0] + (long) number[1]);
        } else if (lastItem.getInstruction() instanceof LMUL) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((long) number[0] * (long) number[1]);
        } else if (lastItem.getInstruction() instanceof LDIV) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((long) number[1] / (long) number[0]);
        } else if (lastItem.getInstruction() instanceof LSUB) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((long) number[1] - (long) number[0]);
        } else if (lastItem.getInstruction() instanceof LREM) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((long) number[1] % (long) number[0]);
        } else if (lastItem.getInstruction() instanceof LNEG) {
            Number firstNumber = last(instList, lastItem);
            if (firstNumber == null) {
                return null;
            }COMP2010 Coursework

Part 1 - Lexer and Parser

    To build and test, issue

$ make
$ make test

Part 2 - Folding optimisation

    To build and test, issue

$ ant


            deleteInstruction(instList, lastItem);
            return (long)(0 - (long) firstNumber);
        } else if (lastItem.getInstruction() instanceof FADD) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((float) number[0] + (float) number[1]);
        } else if (lastItem.getInstruction() instanceof FMUL) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((float) number[0] * (float) number[1]);
        } else if (lastItem.getInstruction() instanceof FDIV) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((float) number[1] / (float) number[0]);
        } else if (lastItem.getInstruction() instanceof FSUB) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((float) number[1] - (float) number[0]);
        } else if (lastItem.getInstruction() instanceof FREM) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((float) number[1] % (float) number[0]);
        } else if (lastItem.getInstruction() instanceof FNEG) {
            Number firstNumber = last(instList, lastItem);
            if (firstNumber == null) {
                return null;
            }
            deleteInstruction(instList, lastItem);
            return (float)(0 - (float) firstNumber);
        } else if (lastItem.getInstruction() instanceof DADD) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((double) number[0] + (double) number[1]);
        } else if (lastItem.getInstruction() instanceof DMUL) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((double) number[0] * (double) number[1]);
        } else if (lastItem.getInstruction() instanceof DDIV) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((double) number[1] / (double) number[0]);
        } else if (lastItem.getInstruction() instanceof DSUB) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((double) number[1] - (double) number[0]);
        } else if (lastItem.getInstruction() instanceof DREM) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            return ((double) number[1] % (double) number[0]);
        } else if (lastItem.getInstruction() instanceof DCMPG) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            if ((double) number[1] == (double) number[0]) {
                return 0;
            } else if ((double) number[1] > (double) number[0]) {
                return 1;
            } else {
                return -1;
            }
        } else if (lastItem.getInstruction() instanceof DCMPL) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            if ((double) number[1] == (double) number[0]) {
                return 0;
            } else if ((double) number[1] < (double) number[0]) {
                return 1;
            } else {
                return -1;
            }
        } else if (lastItem.getInstruction() instanceof DNEG) {
            Number firstNumber = last(instList, lastItem);
            if (firstNumber == null) {
                return null;
            }
            deleteInstruction(instList, lastItem);
            return (double)(0 - (double) firstNumber);

       } else if (lastItem.getInstruction() instanceof LCMP) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            if ((double) number[1] == (double) number[0]) {
                return 0;
            } else if ((double) number[1] > (double) number[0]) {
                return 1;
            } else {
                return -1;
            }
        } else if (lastItem.getInstruction() instanceof FCMPG) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            if ((float) number[1] == (float) number[0]) {
                return 0;
            } else if ((float) number[1] > (float) number[0]) {
                return 1;
            } else {
                return -1;
            }
        } else if (lastItem.getInstruction() instanceof FCMPL) {
            Number[] number = operations(instList, lastItem);
            if (number == null) {
                return null;
            }
            if ((float) number[1] == (float) number[0]) {
                return 0;
            } else if ((float) number[1] < (float) number[0]) {
                return 1;
            } else {
                return -1;
            }
        } else if (lastItem.getInstruction() instanceof LDC) {
            LDC ldc = (LDC) lastItem.getInstruction();
            Number value = (Number) ldc.getValue(cpgen);
            deleteInstruction(instList, lastItem);
            return value;
        } else if (lastItem.getInstruction() instanceof LDC2_W) {
            LDC2_W ldc2_w = (LDC2_W) lastItem.getInstruction();
            Number value = (Number) ldc2_w.getValue(cpgen);
            deleteInstruction(instList, lastItem);
            return value;
        } else if (lastItem.getInstruction() instanceof ConversionInstruction){
            if (lastItem.getInstruction() instanceof I2C) { 
                return null;
            }
            Number firstNumber = last(instList, lastItem);
            if (firstNumber == null) {
                return null;
            }
            Number convertedNum = convert(lastItem, firstNumber);
            deleteInstruction(instList, lastItem);
            return convertedNum;
        }
        return null;
    }
	
	private Boolean stackChange(InstructionHandle handle) {
        if (handle.getInstruction() instanceof ArithmeticInstruction || handle.getInstruction() instanceof BIPUSH ||
              handle.getInstruction() instanceof DCONST || handle.getInstruction() instanceof FCONST ||
              handle.getInstruction() instanceof ICONST || handle.getInstruction() instanceof DCMPG ||
              handle.getInstruction() instanceof DCMPL || handle.getInstruction() instanceof FCMPG ||
              handle.getInstruction() instanceof FCMPL || handle.getInstruction() instanceof LCMP) {
            return true;
        }
		else {
			return false;
		}
    }	
	
	private Number convert(InstructionHandle lastItem, Number firstNumber) {

        if (lastItem.getInstruction() instanceof I2D) {
            return (double)((int) firstNumber);
        } else if (lastItem.getInstruction() instanceof D2F) {
            return (float)((double) firstNumber);
        } else if (lastItem.getInstruction() instanceof D2I) {
            return (int)((double) firstNumber);
        } else if (lastItem.getInstruction() instanceof D2L) {
            return (long)((double) firstNumber);
        } else if (lastItem.getInstruction() instanceof F2D) {
            return (double)((float) firstNumber);
        } else if (lastItem.getInstruction() instanceof F2I) {
            return (int)((float) firstNumber);
        } else if (lastItem.getInstruction() instanceof F2L) {
            return (long)((float) firstNumber);
        } else if (lastItem.getInstruction() instanceof I2B) {
            return (byte)((int) firstNumber);
        } else if (lastItem.getInstruction() instanceof I2D) {
            return (double)((int) firstNumber);
        } else if (lastItem.getInstruction() instanceof I2F) {
            return (float)((int) firstNumber);
        } else if (lastItem.getInstruction() instanceof I2L) {
            return (long)((int) firstNumber);
        } else if (lastItem.getInstruction() instanceof I2S) {
            return (short)((int) firstNumber);
        } else if (lastItem.getInstruction() instanceof L2D) {
            return (double)((long) firstNumber);
        } else if (lastItem.getInstruction() instanceof L2F) {
            return (float)((long) firstNumber);
        } else if (lastItem.getInstruction() instanceof L2I) {
            return (int)((long) firstNumber);
        } else if (lastItem.getInstruction() instanceof L2F) {
            return (float)((long) firstNumber);
        }
        return null;
    }

	private void deleteInstruction(InstructionList instList, InstructionHandle item) {
		instList.redirectBranches(item, item.getPrev());
		try {
			instList.delete(item);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Number[] operations(InstructionList instList, InstructionHandle lastItem) {
        Number[] number = new Number[2];
        number[0] =  last(instList, lastItem);
        if (number[0] == null) {
            return null;
        }
        number[1] =  last(instList, lastItem);
        if (number[1] == null) {
            return null;
        }
        deleteInstruction(instList, lastItem);
        return number;
    }

	public void optimize()
	{
		ClassGen cgen = new ClassGen(original);
		ConstantPoolGen cpgen = cgen.getConstantPool();

		cgen.setMajor(50);

		Method[] method = cgen.getMethods();
		
		for (Method m: method) {
			
			optimizeMethod(cgen, cpgen, m);

		}
        
		this.optimized = gen.getJavaClass();
	}

	
	public void write(String optimisedFilePath)
	{
		this.optimize();

		try {
			FileOutputStream out = new FileOutputStream(new File(optimisedFilePath));
			this.optimized.dump(out);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
