package comp207p.main;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;
import org.apache.bcel.Repository;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.util.InstructionFinder;

public class ConstantFolder {

    ClassParser parser = null;
    ClassGen gen = null;

    JavaClass original = null;
    JavaClass optimized = null;

    ConstantPoolGen cpgen = null;

    public ConstantFolder(String classFilePath) {
        try {
            this.parser = new ClassParser(classFilePath);
            this.original = this.parser.parse();
            this.gen = new ClassGen(this.original);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void optimizeMethod(ClassGen cgen, ConstantPoolGen cpgen, Method method) {

        Code methodCode = method.getCode();

        InstructionList instructionList = new InstructionList(methodCode.getCode());

        MethodGen methodGen = new MethodGen(method.getAccessFlags(), method.getReturnType(), method.getArgumentTypes(), null, method.getName(), cgen.getClassName(), instructionList, cpgen);

        ConstantPool cp = cpgen.getConstantPool();
        Constant[] constants = cp.getConstantPool();

        for (InstructionHandle handle : instructionList.getInstructionHandles()) {
            
            if (handle != null) {
                if (handle.getInstruction() instanceof ArithmeticInstruction) {
                
                    Number result = optimizedOperations(instructionList, handle, cpgen);

                    if (result instanceof Integer) {
                        cpgen.addInteger((int) result);
                        instructionList.insert(handle, new PUSH(cpgen, (int)result));
                        deleteInstruction(instructionList, handle);
                    }
                    if (result instanceof Long) {
                        cpgen.addLong((long) result);
                        instructionList.insert(handle, new PUSH(cpgen, (long)result));
                        deleteInstruction(instructionList, handle);
                    }
                    if (result instanceof Float) {
                        cpgen.addFloat((float) result);
                        instructionList.insert(handle, new PUSH(cpgen, (float)result));
                        deleteInstruction(instructionList, handle);
                    }
                    if (result instanceof Double) {
                        cpgen.addDouble((double) result);
                        instructionList.insert(handle, new PUSH(cpgen, (double)result));
                        deleteInstruction(instructionList, handle);
                    } 

                } else if (comparisonOperator(handle)) {

                    Number result = optimizedOperations(instructionList, handle, cpgen);

                    cpgen.addInteger((int) result);
                    instructionList.insert(handle, new PUSH(cpgen, (int)result));
                    deleteInstruction(instructionList, handle);
                }

                else {
                    handle = handle.getNext();
                }
            }
            
        }

        instructionList.setPositions(true);
        methodGen.setMaxStack();
        methodGen.setMaxLocals();

        Method newMethod = methodGen.getMethod();
        cgen.replaceMethod(method, newMethod);

        cgen.setMajor(50);
    }

    private void optimize() {
        ClassGen cgen = new ClassGen(original);
        ConstantPoolGen cpgen = cgen.getConstantPool();

        Method[] methods = cgen.getMethods();
        for (Method method: methods)
        {
            optimizeMethod(cgen, cpgen, method);
        }

        cgen.setMajor(50);
        this.optimized = cgen.getJavaClass();
    }

    public Number optimizedOperations(InstructionList instructionList, InstructionHandle handle, ConstantPoolGen cpgen) {
        
        //int
        if (handle.getInstruction() instanceof IADD) {
            int int1 = (int)getValueFromStack(instructionList, handle, cpgen);
            int int2 = (int)getValueFromStack(instructionList, handle, cpgen);
            return int1 + int2;
        } else if (handle.getInstruction() instanceof ISUB) {
            int int1 = (int)getValueFromStack(instructionList, handle, cpgen);
            int int2 = (int)getValueFromStack(instructionList, handle, cpgen);
            return int2 - int1;
        } else if (handle.getInstruction() instanceof IMUL) {
            int int1 = (int)getValueFromStack(instructionList, handle, cpgen);
            int int2 = (int)getValueFromStack(instructionList, handle, cpgen);
            return int1 * int2;
        } else if (handle.getInstruction() instanceof IDIV) {
            int int1 = (int)getValueFromStack(instructionList, handle, cpgen);
            int int2 = (int)getValueFromStack(instructionList, handle, cpgen);
            return int2 / int1;
        } else if (handle.getInstruction() instanceof INEG) {
            return -(int)getValueFromStack(instructionList, handle, cpgen);
        } else if (handle.getInstruction() instanceof IREM) {
            int int1 = (int)getValueFromStack(instructionList, handle, cpgen);
            int int2 = (int)getValueFromStack(instructionList, handle, cpgen);
            return int2 % int1;
        } 

        //long
        else if (handle.getInstruction() instanceof LADD) {
            long long1 = (long)getValueFromStack(instructionList, handle, cpgen);
            long long2 = (long)getValueFromStack(instructionList, handle, cpgen);
            return long1 + long2;
        } else if (handle.getInstruction() instanceof LSUB) {
            long long1 = (long)getValueFromStack(instructionList, handle, cpgen);
            long long2 = (long)getValueFromStack(instructionList, handle, cpgen);
            return long2 - long1;
        } else if (handle.getInstruction() instanceof LMUL) {
            long long1 = (long)getValueFromStack(instructionList, handle, cpgen);
            long long2 = (long)getValueFromStack(instructionList, handle, cpgen);
            return long1 * long2;
        } else if (handle.getInstruction() instanceof LDIV) {
            long long1 = (long)getValueFromStack(instructionList, handle, cpgen);
            long long2 = (long)getValueFromStack(instructionList, handle, cpgen);
            return long2 / long1;
        } else if (handle.getInstruction() instanceof LNEG) {
            return -(long)getValueFromStack(instructionList, handle, cpgen);
        } else if (handle.getInstruction() instanceof LREM) {
            long long1 = (long)getValueFromStack(instructionList, handle, cpgen);
            long long2 = (long)getValueFromStack(instructionList, handle, cpgen);
            return long2 % long1;
        } 

        //float
        else if (handle.getInstruction() instanceof FADD) {
            float float1 = (long)getValueFromStack(instructionList, handle, cpgen);
            float float2 = (long)getValueFromStack(instructionList, handle, cpgen);
            return float1 + float2;
        } else if (handle.getInstruction() instanceof FSUB) {
            float float1 = (long)getValueFromStack(instructionList, handle, cpgen);
            float float2 = (long)getValueFromStack(instructionList, handle, cpgen);
            return float2 - float1;
        } else if (handle.getInstruction() instanceof FMUL) {
            float float1 = (long)getValueFromStack(instructionList, handle, cpgen);
            float float2 = (long)getValueFromStack(instructionList, handle, cpgen);
            return float1 * float2;
        } else if (handle.getInstruction() instanceof FDIV) {
            float float1 = (long)getValueFromStack(instructionList, handle, cpgen);
            float float2 = (long)getValueFromStack(instructionList, handle, cpgen);
            return float2 / float1;
        } else if (handle.getInstruction() instanceof FNEG) {
            return -(float)getValueFromStack(instructionList, handle, cpgen);
        } else if (handle.getInstruction() instanceof FREM) {
            float float1 = (long)getValueFromStack(instructionList, handle, cpgen);
            float float2 = (long)getValueFromStack(instructionList, handle, cpgen);
            return float2 % float1;
        }

        //double
        else if (handle.getInstruction() instanceof DADD) {
            double double1 = (double)getValueFromStack(instructionList, handle, cpgen);
            double double2 = (double)getValueFromStack(instructionList, handle, cpgen);
            return double1 + double2;
        } else if (handle.getInstruction() instanceof DSUB) {
            double double1 = (double)getValueFromStack(instructionList, handle, cpgen);
            double double2 = (double)getValueFromStack(instructionList, handle, cpgen);
            return double2 - double1;
        }else if (handle.getInstruction() instanceof DMUL) {
            double double1 = (double)getValueFromStack(instructionList, handle, cpgen);
            double double2 = (double)getValueFromStack(instructionList, handle, cpgen);
            return double1 * double2;
        } else if (handle.getInstruction() instanceof DDIV) {
            double double1 = (double)getValueFromStack(instructionList, handle, cpgen);
            double double2 = (double)getValueFromStack(instructionList, handle, cpgen);
            return double2 / double1;
        } else if (handle.getInstruction() instanceof DNEG) {
            return -(double)getValueFromStack(instructionList, handle, cpgen);
        } else if (handle.getInstruction() instanceof DREM) {
            double double1 = (double)getValueFromStack(instructionList, handle, cpgen);
            double double2 = (double)getValueFromStack(instructionList, handle, cpgen);
            return double2 % double1;
        } 

        //comparisons
        else if (handle.getInstruction() instanceof LCMP) {
            long long1 = (long)getValueFromStack(instructionList, handle, cpgen);
            long long2 = (long)getValueFromStack(instructionList, handle, cpgen);
            if (long1 == long2) {
                return 0;
            } else if (long1 > long2) {
                return 1;
            } else {
                return -1;
            }
        } else if (handle.getInstruction() instanceof FCMPG) {
            float float1 = (float)getValueFromStack(instructionList, handle, cpgen);
            float float2 = (float)getValueFromStack(instructionList, handle, cpgen);
            if (float1 == float2) {
                return 0;
            } else if (float1 > float2) {
                return 1;
            } else {
                return -1;
            }
        } else if (handle.getInstruction() instanceof FCMPL) {
            float float1 = (float)getValueFromStack(instructionList, handle, cpgen);
            float float2 = (float)getValueFromStack(instructionList, handle, cpgen);
            if (float1 == float2) {
                return 0;
            } else if (float2 > float1) {
                return 1;
            } else {
                return -1;
            }
        } else if (handle.getInstruction() instanceof DCMPG) {
            double double1 = (double)getValueFromStack(instructionList, handle, cpgen);
            double double2 = (double)getValueFromStack(instructionList, handle, cpgen);
            if (double1 == double2) {
                return 0;
            } else if (double1 > double2) {
                return 1;
            } else {
                return -1;
            }
        } else if (handle.getInstruction() instanceof DCMPL) {
            double double1 = (double)getValueFromStack(instructionList, handle, cpgen);
            double double2 = (double)getValueFromStack(instructionList, handle, cpgen);
            if (double1 == double2) {
                return 0;
            } else if (double2 > double1) {
                return 1;
            } else {
                return -1;
            }
        }

        return null;
    }

    public Boolean comparisonOperator(InstructionHandle handle) {

        if ( handle.getInstruction() instanceof LCMP
            || handle.getInstruction() instanceof FCMPG 
            || handle.getInstruction() instanceof FCMPL 
            || handle.getInstruction() instanceof DCMPG 
            || handle.getInstruction() instanceof DCMPL) {
            
            return true;
        }
        return false;

    }

    public void deleteInstruction(InstructionList instructionList, InstructionHandle handle) {
        instructionList.redirectBranches(handle, handle.getPrev());
        try {
            instructionList.delete(handle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Number getValueFromStack(InstructionList instructionList, InstructionHandle handle, ConstantPoolGen cpgen) {
        while(handle != null) {
            if (handle.getInstruction() instanceof BIPUSH) {
                Number value = ((BIPUSH) handle.getInstruction()).getValue();
                deleteInstruction(instructionList, handle);
                return value;
            } else if (handle.getInstruction() instanceof SIPUSH) {
                Number value = ((SIPUSH) handle.getInstruction()).getValue();
                deleteInstruction(instructionList, handle);
                return value;
            } else if (handle.getInstruction() instanceof ICONST) {
                Number value = ((ICONST) handle.getInstruction()).getValue();
                deleteInstruction(instructionList, handle);
                return value;
            } else if (handle.getInstruction() instanceof LCONST) {
                Number value = ((LCONST) handle.getInstruction()).getValue();
                deleteInstruction(instructionList, handle);
                return value;
            } else if (handle.getInstruction() instanceof FCONST) {
                Number value = ((FCONST) handle.getInstruction()).getValue();
                deleteInstruction(instructionList, handle);
                return value;
            } else if (handle.getInstruction() instanceof DCONST) {
                Number value = ((DCONST) handle.getInstruction()).getValue();
                deleteInstruction(instructionList, handle);
                return value;
            } else if (handle.getInstruction() instanceof LDC) {
                Number value = (Number)((LDC) handle.getInstruction()).getValue(cpgen);
                deleteInstruction(instructionList, handle);
                return value;
            } else if (handle.getInstruction() instanceof LDC2_W) {
                Number value = (Number)((LDC2_W) handle.getInstruction()).getValue(cpgen);
                deleteInstruction(instructionList, handle);
                return value;
            } else {
                handle = handle.getPrev();
            }
        }
        return null;
    }

    public void write(String optimisedFilePath)
    {
        this.optimize();

        try {
            FileOutputStream out = new FileOutputStream(new File(optimisedFilePath));
            this.optimized.dump(out);
        } catch (FileNotFoundException e) {
            // Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
    }
}