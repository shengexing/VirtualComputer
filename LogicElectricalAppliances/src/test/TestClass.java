package test;

import gate.Gate.MACHINE_CODE;
import gate.circuit.*;
import gate.circuit.combinational.EasyDCBA;
import gate.circuit.combinational.encoder.Encoder_8_3;
import gate.circuit.combinational.encoder.PriorityEncoder_16_4_ByTwo74HC148;
import gate.circuit.combinational.encoder.PriorityEncoder_8_3_74HC148;
import gate.circuit.combinational.encoder.PriorityEncoder_System_2_10_74LS147;
import gate.circuit.exception.BaseCircuitException;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名：测试类
 * 作用：用于测试 LogicElectricalAppliances 模块中所有的类
 * @author 93710
 */
public class TestClass {

    /**
     * 设置测试数据
     */
    private static final int TEST_NUMBER_3 = 3;
    private static final int TEST_NUMBER_4 = 4;
    private static final int TEST_NUMBER_5 = 5;
    private static final int TEST_NUMBER_6 = 6;
    private static final int TEST_NUMBER_8 = 8;
    private static final int TEST_NUMBER_9 = 9;
    private static final int TEST_NUMBER_17 = 17;

    /**
     * 用于测试的 门 对象
     */
    private static final GateAnd gateAnd = new GateAnd();
    private static final GateOr gateOr = new GateOr();
    private static final GateNot gateNot = new GateNot();
    private static final GateNon gateNon = new GateNon();
    private static final GateNor gateNor = new GateNor();
    private static final GateXor gateXor = new GateXor();
    private static final GateXnor gateXnor = new GateXnor();
    private static final GateAoi gateAoi = new GateAoi();

    private static final EasyDCBA easyDCBA = new EasyDCBA();
    private static final Encoder_8_3 encoder_8_3 = new Encoder_8_3();
    private static final PriorityEncoder_8_3_74HC148 priorityEncoder_8_3_74HC148 = new PriorityEncoder_8_3_74HC148();
    private static final PriorityEncoder_16_4_ByTwo74HC148 priorityEncoder_16_4_ByTwo74HC148 = new PriorityEncoder_16_4_ByTwo74HC148();
    private static final PriorityEncoder_System_2_10_74LS147 priorityEncoder_System_2_10_74LS147 = new PriorityEncoder_System_2_10_74LS147();

    /**
     * 方法名：测试 GateAnd 类的基本逻辑功能
     * 作用：测试 <b>与门</b> 类的基本逻辑功能
     */
    private static void testClass_GateAnd() {
        System.out.println("测试 与门 的基本逻辑功能：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        MACHINE_CODE testInput0;
        MACHINE_CODE testInput1;
        MACHINE_CODE testOutput;

        /*
         * 测试用例：GateAnd_000
         * 输入值：0,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAnd_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateAnd_010
         * 输入值：0,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAnd_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateAnd_100
         * 输入值：1,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAnd_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateAnd_111
         * 输入值：1,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateAnd_Helper(testInput0, testInput1, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateAnd() 方法的辅助方法
     * 作用：为 testClass_GateAnd() 提供辅助功能
     */
    private static void testClass_GateAnd_Helper(MACHINE_CODE input0, MACHINE_CODE input1, MACHINE_CODE output) {
        String caseName = "GateAnd(" +
                ("" + input0).substring(7) +
                ("" + input1).substring(7) +
                "_" +
                ("" + output).substring(7) +
                ")";
        try {
            gateAnd.setInputValues(new MACHINE_CODE[] {input0, input1});
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
        if (output == gateAnd.getOutputValue()[0]) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    /**
     * 方法名：测试 GateAnd 类的基本逻辑功能（三输入）
     * 作用：测试 <b>与门</b> 类的基本逻辑功能
     */
    private static void testClass_GateAnd_3() {
        System.out.println("测试 与门 的基本逻辑功能（三输入）：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        MACHINE_CODE testInput0;
        MACHINE_CODE testInput1;
        MACHINE_CODE testInput2;
        MACHINE_CODE testOutput;

        /*
         * 测试用例：GateAnd_0000
         * 输入值：0,0,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAnd_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateAnd_0010
         * 输入值：0,0,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAnd_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateAnd_0100
         * 输入值：0,1,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAnd_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateAnd_0110
         * 输入值：0,1,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAnd_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateAnd_1000
         * 输入值：1,0,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAnd_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateAnd_1010
         * 输入值：1,0,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAnd_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateAnd_1100
         * 输入值：1,1,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAnd_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateAnd_1111
         * 输入值：1,1,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateAnd_Helper_3(testInput0, testInput1, testInput2, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateAnd_3() 方法的辅助方法
     * 作用：为 testClass_GateAnd_3() 提供辅助功能
     */
    private static void testClass_GateAnd_Helper_3(MACHINE_CODE input0, MACHINE_CODE input1, MACHINE_CODE input2, MACHINE_CODE output) {
        String caseName = "GateAnd(" +
                ("" + input0).substring(7) +
                ("" + input1).substring(7) +
                ("" + input2).substring(7) +
                "_" +
                ("" + output).substring(7) +
                ")";
        try {
            gateAnd.setInputValues(new MACHINE_CODE[] {input0, input1, input2});
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
        if (output == gateAnd.getOutputValue()[0]) {
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
        MACHINE_CODE testInput0;
        MACHINE_CODE testInput1;
        MACHINE_CODE testOutput;

        /*
         * 测试用例：GateOr_000
         * 输入值：0,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateOr_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateOr_011
         * 输入值：0,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateOr_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateOr_101
         * 输入值：1,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateOr_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateOr_111
         * 输入值：1,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateOr_Helper(testInput0, testInput1, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateOr() 方法的辅助方法
     * 作用：为 testClass_GateOr() 提供辅助功能
     */
    private static void testClass_GateOr_Helper(MACHINE_CODE input0, MACHINE_CODE input1, MACHINE_CODE output) {
        String caseName = "GateOr(" +
                ("" + input0).substring(7) +
                ("" + input1).substring(7) +
                "_" +
                ("" + output).substring(7) +
                ")";
        try {
            gateOr.setInputValues(new MACHINE_CODE[] {input0, input1});
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
        if (output == gateOr.getOutputValue()[0]) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    /**
     * 方法名：测试 GateOr 类的基本逻辑功能（三输入）
     * 作用：测试 <b>或门</b> 类的基本逻辑功能
     */
    private static void testClass_GateOr_3() {
        System.out.println("测试 与门 的基本逻辑功能（三输入）：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        MACHINE_CODE testInput0;
        MACHINE_CODE testInput1;
        MACHINE_CODE testInput2;
        MACHINE_CODE testOutput;

        /*
         * 测试用例：GateOr_0000
         * 输入值：0,0,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateOr_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateOr_0011
         * 输入值：0,0,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateOr_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateOr_0101
         * 输入值：0,1,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateOr_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateOr_0111
         * 输入值：0,1,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateOr_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateOr_1001
         * 输入值：1,0,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateOr_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateOr_1011
         * 输入值：1,0,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateOr_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateOr_1101
         * 输入值：1,1,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateOr_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateOr_1111
         * 输入值：1,1,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateOr_Helper_3(testInput0, testInput1, testInput2, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateOr_3() 方法的辅助方法
     * 作用：为 testClass_GateOr_3() 提供辅助功能
     */
    private static void testClass_GateOr_Helper_3(MACHINE_CODE input0, MACHINE_CODE input1, MACHINE_CODE input2, MACHINE_CODE output) {
        String caseName = "GateOr(" +
                ("" + input0).substring(7) +
                ("" + input1).substring(7) +
                ("" + input2).substring(7) +
                "_" +
                ("" + output).substring(7) +
                ")";
        try {
            gateOr.setInputValues(new MACHINE_CODE[] {input0, input1, input2});
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
        if (output == gateOr.getOutputValue()[0]) {
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
        MACHINE_CODE testInput;
        MACHINE_CODE testOutput;

        /*
         * 测试用例：GateNot_01
         * 输入值：0
         * 预计输出：1
         */
        testInput = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNot_Helper(testInput, testOutput);

        /*
         * 测试用例：GateNot_10
         * 输入值：1
         * 预计输出：0
         */
        testInput = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNot_Helper(testInput, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateNot() 方法的辅助方法
     * 作用：为 testClass_GateNot() 提供辅助功能
     */
    private static void testClass_GateNot_Helper(MACHINE_CODE input, MACHINE_CODE output) {
        String caseName = "GateNot(" +
                ("" + input).substring(7) +
                "_" +
                ("" + output).substring(7) +
                ")";
        gateNot.setInputValues(new MACHINE_CODE[]{input});
        if (output == gateNot.getOutputValue()[0]) {
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
        MACHINE_CODE testInput0;
        MACHINE_CODE testInput1;
        MACHINE_CODE testOutput;

        /*
         * 测试用例：GateNon_001
         * 输入值：0,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNon_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNon_011
         * 输入值：0,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNon_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNon_101
         * 输入值：1,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNon_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNon_110
         * 输入值：1,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNon_Helper(testInput0, testInput1, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateNon() 方法的辅助方法
     * 作用：为 testClass_GateNon() 提供辅助功能
     */
    private static void testClass_GateNon_Helper(MACHINE_CODE input0, MACHINE_CODE input1, MACHINE_CODE output) {
        String caseName = "GateNon(" +
                ("" + input0).substring(7) +
                ("" + input1).substring(7) +
                "_" +
                ("" + output).substring(7) +
                ")";
        try {
            gateNon.setInputValues(new MACHINE_CODE[] {input0, input1});
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
        if (output == gateNon.getOutputValue()[0]) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    /**
     * 方法名：测试 GateNon 类的基本逻辑功能（三输入）
     * 作用：测试 <b>与非门</b> 类的基本逻辑功能
     */
    private static void testClass_GateNon_3() {
        System.out.println("测试 与非门 的基本逻辑功能（三输入）：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        MACHINE_CODE testInput0;
        MACHINE_CODE testInput1;
        MACHINE_CODE testInput2;
        MACHINE_CODE testOutput;

        /*
         * 测试用例：GateNon_0001
         * 输入值：0,0,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNon_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNon_0011
         * 输入值：0,0,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNon_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNon_0101
         * 输入值：0,1,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNon_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNon_0111
         * 输入值：0,1,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNon_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNon_1001
         * 输入值：1,0,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNon_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNon_1011
         * 输入值：1,0,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNon_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNon_1101
         * 输入值：1,1,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNon_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNon_1110
         * 输入值：1,1,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNon_Helper_3(testInput0, testInput1, testInput2, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateNon_3() 方法的辅助方法
     * 作用：为 testClass_GateNon_3() 提供辅助功能
     */
    private static void testClass_GateNon_Helper_3(MACHINE_CODE input0, MACHINE_CODE input1, MACHINE_CODE input2, MACHINE_CODE output) {
        String caseName = "GateNon(" +
                ("" + input0).substring(7) +
                ("" + input1).substring(7) +
                ("" + input2).substring(7) +
                "_" +
                ("" + output).substring(7) +
                ")";
        try {
            gateNon.setInputValues(new MACHINE_CODE[] {input0, input1, input2});
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
        if (output == gateNon.getOutputValue()[0]) {
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
        MACHINE_CODE testInput0;
        MACHINE_CODE testInput1;
        MACHINE_CODE testOutput;

        /*
         * 测试用例：GateNor_001
         * 输入值：0,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNor_010
         * 输入值：0,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNor_100
         * 输入值：1,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNor_110
         * 输入值：1,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNor_Helper(testInput0, testInput1, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateNor() 方法的辅助方法
     * 作用：为 testClass_GateNor() 提供辅助功能
     */
    private static void testClass_GateNor_Helper(MACHINE_CODE input0, MACHINE_CODE input1, MACHINE_CODE output) {
        String caseName = "GateNor(" +
                ("" + input0).substring(7) +
                ("" + input1).substring(7) +
                "_" +
                ("" + output).substring(7) +
                ")";
        try {
            gateNor.setInputValues(new MACHINE_CODE[] {input0, input1});
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
        if (output == gateNor.getOutputValue()[0]) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    /**
     * 方法名：测试 GateNor 类的基本逻辑功能（三输入）
     * 作用：测试 <b>或非门</b> 类的基本逻辑功能
     */
    private static void testClass_GateNor_3() {
        System.out.println("测试 或非门 的基本逻辑功能（三输入）：");

        /* 临时变量：用于测试的输入值和预计的输出值*/
        MACHINE_CODE testInput0;
        MACHINE_CODE testInput1;
        MACHINE_CODE testInput2;
        MACHINE_CODE testOutput;

        /*
         * 测试用例：GateNor_0001
         * 输入值：0,0,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateNor_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNor_0010
         * 输入值：0,0,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNor_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNor_0100
         * 输入值：0,1,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNor_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNor_0110
         * 输入值：0,1,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNor_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNor_1000
         * 输入值：1,0,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNor_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNor_1010
         * 输入值：1,0,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNor_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNor_1100
         * 输入值：1,1,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNor_Helper_3(testInput0, testInput1, testInput2, testOutput);

        /*
         * 测试用例：GateNor_1110
         * 输入值：1,1,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateNor_Helper_3(testInput0, testInput1, testInput2, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateOr_3() 方法的辅助方法
     * 作用：为 testClass_GateOr_3() 提供辅助功能
     */
    private static void testClass_GateNor_Helper_3(MACHINE_CODE input0, MACHINE_CODE input1, MACHINE_CODE input2, MACHINE_CODE output) {
        String caseName = "GateNor(" +
                ("" + input0).substring(7) +
                ("" + input1).substring(7) +
                ("" + input2).substring(7) +
                "_" +
                ("" + output).substring(7) +
                ")";
        try {
            gateNor.setInputValues(new MACHINE_CODE[] {input0, input1, input2});
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
        if (output == gateNor.getOutputValue()[0]) {
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
        MACHINE_CODE testInput0;
        MACHINE_CODE testInput1;
        MACHINE_CODE testOutput;

        /*
         * 测试用例：GateXor_000
         * 输入值：0,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateXor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateNor_011
         * 输入值：0,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateXor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateXor_101
         * 输入值：1,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateXor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateXor_110
         * 输入值：1,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateXor_Helper(testInput0, testInput1, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateXor() 方法的辅助方法
     * 作用：为 testClass_GateXor() 提供辅助功能
     */
    private static void testClass_GateXor_Helper(MACHINE_CODE input0, MACHINE_CODE input1, MACHINE_CODE output) {
        String caseName = "GateXor(" +
                ("" + input0).substring(7) +
                ("" + input1).substring(7) +
                "_" +
                ("" + output).substring(7) +
                ")";
        gateXor.setInputValues(input0, input1);
        if (output == gateXor.getOutputValue()[0]) {
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
        MACHINE_CODE testInput0;
        MACHINE_CODE testInput1;
        MACHINE_CODE testOutput;

        /*
         * 测试用例：GateXnor_001
         * 输入值：0,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateXnor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateXnor_010
         * 输入值：0,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateXnor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateXnor_100
         * 输入值：1,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateXnor_Helper(testInput0, testInput1, testOutput);

        /*
         * 测试用例：GateXnor_111
         * 输入值：1,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateXnor_Helper(testInput0, testInput1, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateXnor() 方法的辅助方法
     * 作用：为 testClass_GateXnor() 提供辅助功能
     */
    private static void testClass_GateXnor_Helper(MACHINE_CODE input0, MACHINE_CODE input1, MACHINE_CODE output) {
        String caseName = "GateXnor(" +
                ("" + input0).substring(7) +
                ("" + input1).substring(7) +
                "_" +
                ("" + output).substring(7) +
                ")";
        gateXnor.setInputValues(input0, input1);
        if (output == gateXnor.getOutputValue()[0]) {
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
        MACHINE_CODE testInput0;
        MACHINE_CODE testInput1;
        MACHINE_CODE testInput2;
        MACHINE_CODE testInput3;
        MACHINE_CODE testOutput;

        /*
         * 测试用例：GateAoi_00001
         * 输入值：0,0,0,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_0;
        testInput3 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_00011
         * 输入值：0,0,0,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_0;
        testInput3 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_00101
         * 输入值：0,0,1,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_1;
        testInput3 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_00110
         * 输入值：0,0,1,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_1;
        testInput3 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_01001
         * 输入值：0,1,0,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_0;
        testInput3 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_01011
         * 输入值：0,1,0,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_0;
        testInput3 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_01101
         * 输入值：0,1,1,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_1;
        testInput3 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_01110
         * 输入值：0,0,1,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_0;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_1;
        testInput3 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_10001
         * 输入值：1,0,0,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_0;
        testInput3 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_10011
         * 输入值：1,0,0,1
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_0;
        testInput3 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_10101
         * 输入值：1,0,1,0
         * 预计输出：1
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_1;
        testInput3 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_1;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_10110
         * 输入值：1,0,1,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_0;
        testInput2 = MACHINE_CODE.binary_1;
        testInput3 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_11000
         * 输入值：1,1,0,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_0;
        testInput3 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_11010
         * 输入值：1,1,0,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_0;
        testInput3 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_11100
         * 输入值：1,1,1,0
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_1;
        testInput3 = MACHINE_CODE.binary_0;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        /*
         * 测试用例：GateAoi_11110
         * 输入值：1,1,1,1
         * 预计输出：0
         */
        testInput0 = MACHINE_CODE.binary_1;
        testInput1 = MACHINE_CODE.binary_1;
        testInput2 = MACHINE_CODE.binary_1;
        testInput3 = MACHINE_CODE.binary_1;
        testOutput = MACHINE_CODE.binary_0;
        testClass_GateAoi_Helper(testInput0, testInput1, testInput2, testInput3, testOutput);

        System.out.println();
    }

    /**
     * 方法名：testClass_GateAoi() 方法的辅助方法
     * 作用：为 testClass_GateAoi() 提供辅助功能
     */
    private static void testClass_GateAoi_Helper(MACHINE_CODE input0, MACHINE_CODE input1, MACHINE_CODE input2, MACHINE_CODE input3, MACHINE_CODE output) {
        String caseName = "GateAoi(" +
                ("" + input0).substring(7) +
                ("" + input1).substring(7) +
                ("" + input2).substring(7) +
                "_" +
                ("" + output).substring(7) +
                ")";
        List<MACHINE_CODE[]> inputs = new ArrayList<>();
        inputs.add(new MACHINE_CODE[]{input0, input1});
        inputs.add(new MACHINE_CODE[]{input2, input3});
        gateAoi.setInputValues(inputs);
        if (output == gateAoi.getOutputValue()[0]) {
            System.out.println("测试用例：" + caseName + " 通过！");
        } else {
            System.out.println("测试用例：" + caseName + " 不通过！");
        }
    }

    /**
     * 方法名：a 的 n 次幂
     * @param a 底数
     * @param n 指数 ( n 为正整数)
     * @return 幂
     */
    private static int getPow(int a, int n) {
        int result = a;

        if (a == 0) {
            return 0;
        }
        if (a == 1 || n == 0) {
            return 1;
        }

        for (int i = 1; i < n; i++) {
            result *= a;
        }

        return result;
    }

    /**
     * 方法名：判断两个 MACHINE_CODE 类型的数组是否相同
     * @param array1 数组1
     * @param array2 数组2
     * @return 是否相同
     */
    private static boolean isEqual_MachineCodeArray(MACHINE_CODE[] array1, MACHINE_CODE[] array2) {
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * 方法名：创建测试用例的输入
     * 实现：
     * @param count 二进制位数
     * @return 输入结果数组
     */
    private static MACHINE_CODE[][] createInputs(int count) {
        if (count == 0) {
            return null;
        }

        int row = getPow(2, count);
        MACHINE_CODE[][] result = new MACHINE_CODE[row][count];
        for (int j = 0; j < count; j++) {
            for (int i = 0; i < row; i++) {
                result[i][count - 1 - j] = (i/getPow(2, j))%2 > 0 ? MACHINE_CODE.binary_1 : MACHINE_CODE.binary_0;
            }
        }

        return result;
    }

    /**
     * 方法名：测试 EasyDCBA 类的基本逻辑功能
     * 作用：测试 <b>DCBA</b> 类的基本逻辑功能
     */
    private static void testClass_EasyDCBA() {
        System.out.println("测试 DCBA 的基本逻辑功能：");

        int i = 0;
        MACHINE_CODE[] case_output = new MACHINE_CODE[]{
                MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0};
        for (MACHINE_CODE[] inputs: createInputs(TEST_NUMBER_4)) {
            String caseName = "EasyDCBA(";
            if (i > 10) {
                case_output[0] = MACHINE_CODE.binary_1;
                case_output[1] = MACHINE_CODE.binary_0;
                case_output[2] = MACHINE_CODE.binary_0;
            } else if (i > 5) {
                case_output[0] = MACHINE_CODE.binary_0;
                case_output[1] = MACHINE_CODE.binary_1;
                case_output[2] = MACHINE_CODE.binary_0;
            } else if (i >= 0) {
                case_output[0] = MACHINE_CODE.binary_0;
                case_output[1] = MACHINE_CODE.binary_0;
                case_output[2] = MACHINE_CODE.binary_1;
            }
            i++;
            easyDCBA.setInputValues(inputs);
            MACHINE_CODE[] real_output = easyDCBA.getOutputValue();
            for (MACHINE_CODE input: inputs) {
                caseName += ("" + input).substring(7);
            }
            caseName += "_" +
                    ("" + case_output[0]).substring(7) +
                    ("" + case_output[1]).substring(7) +
                    ("" + case_output[2]).substring(7) +
                    ")";
            System.out.println("测试用例：" + caseName + (isEqual_MachineCodeArray(case_output, real_output) ? " 通过! " : " 不通过! "));
        }

        System.out.println();
    }

    /**
     * 方法名：测试 8线-3线编码器 类的基本逻辑功能
     * 作用：测试 <b>8线-3线编码器</b> 类的基本逻辑功能
     */
    private static void testClass_Encoder_8_3() {
        System.out.println("测试 Encoder_8_3 的基本逻辑功能：");

        MACHINE_CODE[][] case_inputs = createInputs(TEST_NUMBER_8);
        MACHINE_CODE[][] case_outputs = createInputs(TEST_NUMBER_3);
        for (int i = 0; i < TEST_NUMBER_8; i++) {
            String caseName = "Encoder_8_3(";

            MACHINE_CODE[] inputs = case_inputs[getPow(2, TEST_NUMBER_8 - 1 - i)];
            encoder_8_3.setInputValues(inputs);
            MACHINE_CODE[] real_output = encoder_8_3.getOutputValue();

            for (MACHINE_CODE input: inputs) {
                caseName += ("" + input).substring(7);
            }
            caseName += "_" +
                    ("" + case_outputs[i][0]).substring(7) +
                    ("" + case_outputs[i][1]).substring(7) +
                    ("" + case_outputs[i][2]).substring(7) +
                    ")";
            System.out.println("测试用例：" + caseName + (isEqual_MachineCodeArray(case_outputs[i], real_output) ? " 通过! " : " 不通过! "));
        }

        System.out.println();
    }

    /**
     * 方法名：测试 8线-3线优先编码器 类的基本逻辑功能
     * 作用：测试 <b>8线-3线优先编码器</b> 类的基本逻辑功能
     */
    private static void testClass_PriorityEncoder_8_3_74HC148() {
        System.out.println("测试 PriorityEncoder_8_3_74HC148 的基本逻辑功能：");

        MACHINE_CODE[][] case_inputs = createInputs(TEST_NUMBER_9);
        MACHINE_CODE[][] case_outputs = createInputs(TEST_NUMBER_5);

        for (MACHINE_CODE[] inputs: case_inputs) {
            String caseName = "PriorityEncoder_8_3_74HC148(";

            priorityEncoder_8_3_74HC148.setInputValues(inputs);
            MACHINE_CODE[] real_outputs = priorityEncoder_8_3_74HC148.getOutputValue();
            boolean flag = false;

            if (inputs[0] == MACHINE_CODE.binary_1) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 5) - 1], real_outputs);
            } else if (inputs[8] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 1)], real_outputs);
            } else if (inputs[7] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 2) + getPow(2, 1)], real_outputs);
            } else if (inputs[6] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 3) + getPow(2, 1)], real_outputs);
            } else if (inputs[5] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 4) - getPow(2, 1)], real_outputs);
            } else if (inputs[4] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 4) + getPow(2, 1)], real_outputs);
            } else if (inputs[3] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 4) + getPow(2, 2) + getPow(2, 1)], real_outputs);
            } else if (inputs[2] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 4) + getPow(2, 3) + getPow(2, 1)], real_outputs);
            } else if (inputs[1] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 5) - getPow(2, 1)], real_outputs);
            } else {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 5) - getPow(2, 1) - 1], real_outputs);
            }

            for (MACHINE_CODE input: inputs) {
                caseName += ("" + input).substring(7);
            }
            caseName += "_" +
                    ("" + real_outputs[0]).substring(7) +
                    ("" + real_outputs[1]).substring(7) +
                    ("" + real_outputs[2]).substring(7) +
                    ("" + real_outputs[3]).substring(7) +
                    ("" + real_outputs[4]).substring(7) +
                    ")";
            System.out.println("测试用例：" + caseName + (flag ? " 通过! " : " 不通过! "));
        }

        System.out.println();
    }

    /**
     * 方法名：测试 16线-4线优先编码器 类的基本逻辑功能
     * 作用：测试 <b>16线-4线优先编码器</b> 类的基本逻辑功能
     */
    private static boolean testClass_PriorityEncoder_16_4_ByTwo74HC148() {
        System.out.println("测试 PriorityEncoder_16_4_ByTwo74HC148 的基本逻辑功能：");

        MACHINE_CODE[][] case_inputs = createInputs(TEST_NUMBER_17);
        MACHINE_CODE[][] case_outputs = createInputs(TEST_NUMBER_6);

        for (MACHINE_CODE[] inputs: case_inputs) {
            String caseName = "PriorityEncoder_16_4_ByTwo74HC148(";

            priorityEncoder_16_4_ByTwo74HC148.setInputValues(inputs);
            MACHINE_CODE[] real_outputs = priorityEncoder_16_4_ByTwo74HC148.getOutputValue();
            boolean flag = false;

            if (inputs[0] == MACHINE_CODE.binary_1) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 1) + 1], real_outputs);
            } else if (inputs[16] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 6) - 1], real_outputs);
            } else if (inputs[15] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 6) - getPow(2, 2) - 1], real_outputs);
            } else if (inputs[14] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 6) - getPow(2, 3) - 1], real_outputs);
            } else if (inputs[13] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 6) - getPow(2, 3) - getPow(2, 2) - 1], real_outputs);
            } else if (inputs[12] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 6) - getPow(2, 4) - 1], real_outputs);
            } else if (inputs[11] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 6) - getPow(2, 4) - getPow(2, 2) - 1], real_outputs);
            } else if (inputs[10] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 6) - getPow(2, 4) - getPow(2, 3) - 1], real_outputs);
            } else if (inputs[9] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 5) + getPow(2, 1) + 1], real_outputs);
            } else if (inputs[8] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 6) - getPow(2, 5) - getPow(2, 1)], real_outputs);
            } else if (inputs[7] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 4) + getPow(2, 3) + getPow(2, 1)], real_outputs);
            } else if (inputs[6] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 4) + getPow(2, 2) + getPow(2, 1)], real_outputs);
            } else if (inputs[5] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 4) + getPow(2, 1)], real_outputs);
            } else if (inputs[4] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 3) + getPow(2, 2) + getPow(2, 1)], real_outputs);
            } else if (inputs[3] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 3) + getPow(2, 1)], real_outputs);
            } else if (inputs[2] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 2) + getPow(2, 1)], real_outputs);
            } else if (inputs[1] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 1)], real_outputs);
            } else {
                flag = isEqual_MachineCodeArray(case_outputs[1], real_outputs);
            }

            for (MACHINE_CODE input: inputs) {
                caseName += ("" + input).substring(7);
            }
            caseName += "_" +
                    ("" + real_outputs[0]).substring(7) +
                    ("" + real_outputs[1]).substring(7) +
                    ("" + real_outputs[2]).substring(7) +
                    ("" + real_outputs[3]).substring(7) +
                    ("" + real_outputs[4]).substring(7) +
                    ("" + real_outputs[5]).substring(7) +
                    ")";
            System.out.println("测试用例：" + caseName + (flag ? " 通过! " : " 不通过! "));

            if (!flag) {
                return false;
            }
        }

        System.out.println();

        return true;
    }

    /**
     * 方法名：测试 二-十进制优先编码器 类的基本逻辑功能
     * 作用：测试 <b>二-十进制优先编码器</b> 类的基本逻辑功能
     */
    private static boolean testClass_PriorityEncoder_System_2_10_74LS147() {
        System.out.println("测试 PriorityEncoder_System_2_10_74LS147 的基本逻辑功能：");

        MACHINE_CODE[][] case_inputs = createInputs(TEST_NUMBER_9);
        MACHINE_CODE[][] case_outputs = createInputs(TEST_NUMBER_4);

        for (MACHINE_CODE[] inputs: case_inputs) {
            String caseName = "PriorityEncoder_System_2_10_74LS147(";

            priorityEncoder_System_2_10_74LS147.setInputValues(inputs);
            MACHINE_CODE[] real_outputs = priorityEncoder_System_2_10_74LS147.getOutputValue();
            boolean flag = false;

            if (inputs[8] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 2) + getPow(2, 1)], real_outputs);
            } else if (inputs[7] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 3) - 1], real_outputs);
            } else if (inputs[6] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 3)], real_outputs);
            } else if (inputs[5] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 3) + 1], real_outputs);
            } else if (inputs[4] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 3) + getPow(2, 1)], real_outputs);
            } else if (inputs[3] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 3) + getPow(2, 1) + 1], real_outputs);
            } else if (inputs[2] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 3) + getPow(2, 2)], real_outputs);
            } else if (inputs[1] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 3) + getPow(2, 2) + 1], real_outputs);
            } else if (inputs[0] == MACHINE_CODE.binary_0) {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 4) - getPow(2, 1)], real_outputs);
            } else {
                flag = isEqual_MachineCodeArray(case_outputs[getPow(2, 4) - 1], real_outputs);
            }

            for (MACHINE_CODE input: inputs) {
                caseName += ("" + input).substring(7);
            }
            caseName += "_" +
                    ("" + real_outputs[0]).substring(7) +
                    ("" + real_outputs[1]).substring(7) +
                    ("" + real_outputs[2]).substring(7) +
                    ("" + real_outputs[3]).substring(7) +
                    ")";
            System.out.println("测试用例：" + caseName + (flag ? " 通过! " : " 不通过! "));

            if (!flag) {
                return false;
            }
        }

        System.out.println();

        return true;
    }

    /**
     * 方法名：打印二进制码数组
     */
    private static void printMachineCodeArray(MACHINE_CODE[] machine_codes) {
        for (MACHINE_CODE machine_code: machine_codes) {
            System.out.print(("" + machine_code).substring(7));
        }
        System.out.println();
    }

    /**
     * 方法名：测试方法
     * @param caseTest 测试编号
     */
    private static void test(int caseTest) {
        switch (caseTest) {
            case 0:
                /* 测试 GateAnd 类*/
                testClass_GateAnd();
                testClass_GateAnd_3();
                break;
            case 1:
                /* 测试 GateOr 类*/
                testClass_GateOr();
                testClass_GateOr_3();
                break;
            case 2:
                /* 测试 GateNot 类*/
                testClass_GateNot();
                break;
            case 3:
                /* 测试 GateNon 类*/
                testClass_GateNon();
                testClass_GateNon_3();
                break;
            case 4:
                /* 测试 GateNor 类*/
                testClass_GateNor();
                testClass_GateNor_3();
                break;
            case 5:
                /* 测试 GateXor 类*/
                testClass_GateXor();
                break;
            case 6:
                /* 测试 GateXnor 类*/
                testClass_GateXnor();
                break;
            case 7:
                /* 测试 GateAoi 类*/
                testClass_GateAoi();
                break;
            case 8:
                /* 测试 EasyDCBA 类*/
                testClass_EasyDCBA();
                break;
            case 9:
                /* 测试 Encoder_8_3 类 */
                testClass_Encoder_8_3();
                break;
            case 10:
                /* 测试 PriorityEncoder_8_3_74HC148 类 */
                testClass_PriorityEncoder_8_3_74HC148();
                break;
            case 11:
                /* 测试 PriorityEncoder_16_4_ByTwo74HC148 类 */
                System.out.println(testClass_PriorityEncoder_16_4_ByTwo74HC148());
                break;
            case 12:
                /* 测试 PriorityEncoder_System_2_10_74LS147 类 */
                System.out.println(testClass_PriorityEncoder_System_2_10_74LS147());
                break;
            default:
                break;
        }
    }

    /**
     * 方法名：主方法
     * @param args 主方法的参数
     */
    public static void main(String[] args) {
        test(12);
    }

}
