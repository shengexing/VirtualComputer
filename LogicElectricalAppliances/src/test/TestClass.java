package test;

import gate_circuit.*;

/**
 * 类名：测试类
 * 作用：用于测试 LogicElectricalAppliances 模块中所有的类
 */
public class TestClass {

    /* 用于测试的 门 对象 */
    private static GateAnd gateAnd = new GateAnd();
    private static GateOr gateOr = new GateOr();
    private static GateNot gateNot = new GateNot();
    private static GateNon gateNon = new GateNon();
    private static GateNor gateNor = new GateNor();
    private static GateXor gateXor = new GateXor();
    private static GateXnor gateXnor = new GateXnor();
    private static GateAoi gateAoi = new GateAoi();

    /**
     * 方法名：测试 GateAnd 类的基本逻辑功能
     * 作用：测试 <b>与门</b> 类的基本逻辑功能
     */
    private static void testClass_GateAnd() {
        System.out.println("测试 与门 的基本逻辑功能：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        byte testInput0;
        byte testInput1;
        byte testOutput;

        /*
         * 测试用例：GateAnd_000
         * 输入值：0,0
         * 预计输出：0
         */
        testInput0 = 0;
        testInput1 = 0;
        testOutput = 0;
        testClass_GateAnd_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateAnd_010
         * 输入值：0,1
         * 预计输出：0
         */
        testInput0 = 0;
        testInput1 = 1;
        testOutput = 0;
        testClass_GateAnd_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateAnd_100
         * 输入值：1,0
         * 预计输出：0
         */
        testInput0 = 1;
        testInput1 = 0;
        testOutput = 0;
        testClass_GateAnd_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateAnd_111
         * 输入值：1,1
         * 预计输出：1
         */
        testInput0 = 1;
        testInput1 = 1;
        testOutput = 1;
        testClass_GateAnd_Helper(testInput0, testInput1, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateAnd() 方法的辅助方法
     * 作用：为 testClass_GateAnd() 提供辅助功能
     */
    private static void testClass_GateAnd_Helper(byte input0, byte input1, byte output) {
        String caseName = "GateAnd_" + input0 + input1 + output;
        gateAnd.setInputValues(new byte[] {input0, input1});
        if (output == gateAnd.getOutputValue()) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    /**
     * 方法名：测试 GateOr 类的基本逻辑功能
     * 作用：测试 <b>或门</b> 类的基本逻辑功能
     */
    private static void testClass_GateOr() {
        System.out.println("测试 或门 的基本逻辑功能：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        byte testInput0;
        byte testInput1;
        byte testOutput;

        /*
         * 测试用例：GateOr_000
         * 输入值：0,0
         * 预计输出：0
         */
        testInput0 = 0;
        testInput1 = 0;
        testOutput = 0;
        testClass_GateOr_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateOr_011
         * 输入值：0,1
         * 预计输出：1
         */
        testInput0 = 0;
        testInput1 = 1;
        testOutput = 1;
        testClass_GateOr_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateOr_101
         * 输入值：1,0
         * 预计输出：1
         */
        testInput0 = 1;
        testInput1 = 0;
        testOutput = 1;
        testClass_GateOr_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateOr_111
         * 输入值：1,1
         * 预计输出：1
         */
        testInput0 = 1;
        testInput1 = 1;
        testOutput = 1;
        testClass_GateOr_Helper(testInput0, testInput1, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateOr() 方法的辅助方法
     * 作用：为 testClass_GateOr() 提供辅助功能
     */
    private static void testClass_GateOr_Helper(byte input0, byte input1, byte output) {
        String caseName = "GateOr_" + input0 + input1 + output;
        gateOr.setInputValues(new byte[] {input0, input1});
        if (output == gateOr.getOutputValue()) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    /**
     * 方法名：测试 GateNot 类的基本逻辑功能
     * 作用：测试 <b>非门</b> 类的基本逻辑功能
     */
    private static void testClass_GateNot() {
        System.out.println("测试 非门 的基本逻辑功能：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        byte testInput;
        byte testOutput;

        /*
         * 测试用例：GateNot_01
         * 输入值：0
         * 预计输出：1
         */
        testInput = 0;
        testOutput = 1;
        testClass_GateNot_Helper(testInput, testOutput);

        /*
         * 测试用例：GateNot_10
         * 输入值：1
         * 预计输出：0
         */
        testInput = 1;
        testOutput = 0;
        testClass_GateNot_Helper(testInput, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateNot() 方法的辅助方法
     * 作用：为 testClass_GateNot() 提供辅助功能
     */
    private static void testClass_GateNot_Helper(byte input, byte output) {
        String caseName = "GateNot_" + input + output;
        gateNot.setInputValues(input);
        if (output == gateNot.getOutputValue()) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    /**
     * 方法名：测试 GateNon 类的基本逻辑功能
     * 作用：测试 <b>与非门</b> 类的基本逻辑功能
     */
    private static void testClass_GateNon() {
        System.out.println("测试 与非门 的基本逻辑功能：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        byte testInput0;
        byte testInput1;
        byte testOutput;

        /*
         * 测试用例：GateNon_001
         * 输入值：0,0
         * 预计输出：1
         */
        testInput0 = 0;
        testInput1 = 0;
        testOutput = 1;
        testClass_GateNon_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNon_011
         * 输入值：0,1
         * 预计输出：1
         */
        testInput0 = 0;
        testInput1 = 1;
        testOutput = 1;
        testClass_GateNon_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNon_101
         * 输入值：1,0
         * 预计输出：1
         */
        testInput0 = 1;
        testInput1 = 0;
        testOutput = 1;
        testClass_GateNon_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNon_110
         * 输入值：1,1
         * 预计输出：0
         */
        testInput0 = 1;
        testInput1 = 1;
        testOutput = 0;
        testClass_GateNon_Helper(testInput0, testInput1, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateNon() 方法的辅助方法
     * 作用：为 testClass_GateNon() 提供辅助功能
     */
    private static void testClass_GateNon_Helper(byte input0, byte input1, byte output) {
        String caseName = "GateNon_" + input0 + input1 + output;
        gateNon.setInputValues(new byte[] {input0, input1});
        if (output == gateNon.getOutputValue()) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    /**
     * 方法名：测试 GateNor 类的基本逻辑功能
     * 作用：测试 <b>或非门</b> 类的基本逻辑功能
     */
    private static void testClass_GateNor() {
        System.out.println("测试 或非门 的基本逻辑功能：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        byte testInput0;
        byte testInput1;
        byte testOutput;

        /*
         * 测试用例：GateNor_001
         * 输入值：0,0
         * 预计输出：1
         */
        testInput0 = 0;
        testInput1 = 0;
        testOutput = 1;
        testClass_GateNor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNor_010
         * 输入值：0,1
         * 预计输出：0
         */
        testInput0 = 0;
        testInput1 = 1;
        testOutput = 0;
        testClass_GateNor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNor_100
         * 输入值：1,0
         * 预计输出：0
         */
        testInput0 = 1;
        testInput1 = 0;
        testOutput = 0;
        testClass_GateNor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNor_110
         * 输入值：1,1
         * 预计输出：0
         */
        testInput0 = 1;
        testInput1 = 1;
        testOutput = 0;
        testClass_GateNor_Helper(testInput0, testInput1, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateNor() 方法的辅助方法
     * 作用：为 testClass_GateNor() 提供辅助功能
     */
    private static void testClass_GateNor_Helper(byte input0, byte input1, byte output) {
        String caseName = "GateNor_" + input0 + input1 + output;
        gateNor.setInputValues(new byte[] {input0, input1});
        if (output == gateNor.getOutputValue()) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    /**
     * 方法名：测试 GateXor 类的基本逻辑功能
     * 作用：测试 <b>异或门</b> 类的基本逻辑功能
     */
    private static void testClass_GateXor() {
        System.out.println("测试 异或门 的基本逻辑功能：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        byte testInput0;
        byte testInput1;
        byte testOutput;

        /*
         * 测试用例：GateXor_000
         * 输入值：0,0
         * 预计输出：0
         */
        testInput0 = 0;
        testInput1 = 0;
        testOutput = 0;
        testClass_GateXor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNor_011
         * 输入值：0,1
         * 预计输出：1
         */
        testInput0 = 0;
        testInput1 = 1;
        testOutput = 1;
        testClass_GateXor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateXor_101
         * 输入值：1,0
         * 预计输出：1
         */
        testInput0 = 1;
        testInput1 = 0;
        testOutput = 1;
        testClass_GateXor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateXor_110
         * 输入值：1,1
         * 预计输出：0
         */
        testInput0 = 1;
        testInput1 = 1;
        testOutput = 0;
        testClass_GateXor_Helper(testInput0, testInput1, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateXor() 方法的辅助方法
     * 作用：为 testClass_GateXor() 提供辅助功能
     */
    private static void testClass_GateXor_Helper(byte input0, byte input1, byte output) {
        String caseName = "GateXor_" + input0 + input1 + output;
        gateXor.setInputValues(input0, input1);
        if (output == gateXor.getOutputValue()) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    /**
     * 方法名：测试 GateXnor 类的基本逻辑功能
     * 作用：测试 <b>同或门</b> 类的基本逻辑功能
     */
    private static void testClass_GateXnor() {
        System.out.println("测试 同或门 的基本逻辑功能：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        byte testInput0;
        byte testInput1;
        byte testOutput;

        /*
         * 测试用例：GateXnor_001
         * 输入值：0,0
         * 预计输出：1
         */
        testInput0 = 0;
        testInput1 = 0;
        testOutput = 1;
        testClass_GateXnor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateXnor_010
         * 输入值：0,1
         * 预计输出：0
         */
        testInput0 = 0;
        testInput1 = 1;
        testOutput = 0;
        testClass_GateXnor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateXnor_100
         * 输入值：1,0
         * 预计输出：0
         */
        testInput0 = 1;
        testInput1 = 0;
        testOutput = 0;
        testClass_GateXnor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateXnor_111
         * 输入值：1,1
         * 预计输出：1
         */
        testInput0 = 1;
        testInput1 = 1;
        testOutput = 1;
        testClass_GateXnor_Helper(testInput0, testInput1, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateXnor() 方法的辅助方法
     * 作用：为 testClass_GateXnor() 提供辅助功能
     */
    private static void testClass_GateXnor_Helper(byte input0, byte input1, byte output) {
        String caseName = "GateXnor_" + input0 + input1 + output;
        gateXnor.setInputValues(input0, input1);
        if (output == gateXnor.getOutputValue()) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    /**
     * 方法名：测试 GateAoi 类的基本逻辑功能
     * 作用：测试 <b>与或非门</b> 类的基本逻辑功能
     */
    private static void testClass_GateAoi() {
        System.out.println("测试 与或非门 的基本逻辑功能：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        byte testInput0;
        byte testInput1;
        byte testInput2;
        byte testInput3;
        byte testOutput;

        /*
         * 测试用例：GateAoi_00001
         * 输入值：0,0,0,0
         * 预计输出：1
         */
        testInput0 = 0;
        testInput1 = 0;
        testInput2 = 0;
        testInput3 = 0;
        testOutput = 1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_00011
         * 输入值：0,0,0,1
         * 预计输出：1
         */
        testInput0 = 0;
        testInput1 = 0;
        testInput2 = 0;
        testInput3 = 1;
        testOutput = 1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_00101
         * 输入值：0,0,1,0
         * 预计输出：1
         */
        testInput0 = 0;
        testInput1 = 0;
        testInput2 = 1;
        testInput3 = 0;
        testOutput = 1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_00110
         * 输入值：0,0,1,1
         * 预计输出：0
         */
        testInput0 = 0;
        testInput1 = 0;
        testInput2 = 1;
        testInput3 = 1;
        testOutput = 0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_01001
         * 输入值：0,1,0,0
         * 预计输出：1
         */
        testInput0 = 0;
        testInput1 = 1;
        testInput2 = 0;
        testInput3 = 0;
        testOutput = 1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_01011
         * 输入值：0,1,0,1
         * 预计输出：1
         */
        testInput0 = 0;
        testInput1 = 1;
        testInput2 = 0;
        testInput3 = 1;
        testOutput = 1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_01101
         * 输入值：0,1,1,0
         * 预计输出：1
         */
        testInput0 = 0;
        testInput1 = 1;
        testInput2 = 1;
        testInput3 = 0;
        testOutput = 1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_01110
         * 输入值：0,0,1,1
         * 预计输出：0
         */
        testInput0 = 0;
        testInput1 = 1;
        testInput2 = 1;
        testInput3 = 1;
        testOutput = 0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_10001
         * 输入值：1,0,0,0
         * 预计输出：1
         */
        testInput0 = 1;
        testInput1 = 0;
        testInput2 = 0;
        testInput3 = 0;
        testOutput = 1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_10011
         * 输入值：1,0,0,1
         * 预计输出：1
         */
        testInput0 = 1;
        testInput1 = 0;
        testInput2 = 0;
        testInput3 = 1;
        testOutput = 1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_10101
         * 输入值：1,0,1,0
         * 预计输出：1
         */
        testInput0 = 1;
        testInput1 = 0;
        testInput2 = 1;
        testInput3 = 0;
        testOutput = 1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_10110
         * 输入值：1,0,1,1
         * 预计输出：0
         */
        testInput0 = 1;
        testInput1 = 0;
        testInput2 = 1;
        testInput3 = 1;
        testOutput = 0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_11000
         * 输入值：1,1,0,0
         * 预计输出：0
         */
        testInput0 = 1;
        testInput1 = 1;
        testInput2 = 0;
        testInput3 = 0;
        testOutput = 0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_11010
         * 输入值：1,1,0,1
         * 预计输出：0
         */
        testInput0 = 1;
        testInput1 = 1;
        testInput2 = 0;
        testInput3 = 1;
        testOutput = 0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_11100
         * 输入值：1,1,1,0
         * 预计输出：0
         */
        testInput0 = 1;
        testInput1 = 1;
        testInput2 = 1;
        testInput3 = 0;
        testOutput = 0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_11110
         * 输入值：1,1,1,1
         * 预计输出：0
         */
        testInput0 = 1;
        testInput1 = 1;
        testInput2 = 1;
        testInput3 = 1;
        testOutput = 0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateAoi() 方法的辅助方法
     * 作用：为 testClass_GateAoi() 提供辅助功能
     */
    private static void testClass_GateAoi_Helper(byte input0, byte input1, byte input2, byte input3, byte output) {
        String caseName = "GateAoi_" + input0 + input1 + input2 + input3 + output;
        gateAoi.setInputValues(new byte[][] {{input0, input1}, {input2, input3}});
        if (output == gateAoi.getOutputValue()) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    public static void main(String[] args) {
        /* 测试 GateAnd 类*/
        testClass_GateAnd();

        /* 测试 GateOr 类*/
        testClass_GateOr();

        /* 测试 GateNot 类*/
        testClass_GateNot();

        /* 测试 GateNon 类*/
        testClass_GateNon();

        /* 测试 GateNor 类*/
        testClass_GateNor();

        /* 测试 GateXor 类*/
        testClass_GateXor();

        /* 测试 GateXnor 类*/
        testClass_GateXnor();

        /* 测试 GateAoi 类*/
        testClass_GateAoi();
    }

}
