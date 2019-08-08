package test;

import gate_circuit.GateAnd;

/**
 * 类名：测试类
 * 作用：用于测试 LogicElectricalAppliances 模块中所有的类
 */
public class TestClass {

    private static GateAnd gateAnd = new GateAnd();

    /**
     * 方法名：测试 GateAnd 类的所有方法
     * 作用：测试 <b>与门</b> 类的所有方法
     */
    private static void testClass_GateAnd() {

        /* 临时变量：用于测试的输入值*/
        byte testInput0;
        byte testInput1;

        /**
         * 测试用例：GateAnd001
         * 输入值：0,0
         * 预计输出：0
         */
        testInput0 = 0;
        testInput1 = 0;
        gateAnd.setInputValues(testInput0, testInput1);
        if (0 == gateAnd.getOutputValue()) {
            System.out.println("测试用例：GateAnd001" + " 通过！");
        } else {
            System.out.println("测试用例：GateAnd001" + " 不通过！");
        }

        /**
         * 测试用例：GateAnd002
         * 输入值：0,1
         * 预计输出：0
         */
        testInput0 = 0;
        testInput1 = 1;
        gateAnd.setInputValues(testInput0, testInput1);
        if (0 == gateAnd.getOutputValue()) {
            System.out.println("测试用例：GateAnd002" + " 通过！");
        } else {
            System.out.println("测试用例：GateAnd002" + " 不通过！");
        }

        /**
         * 测试用例：GateAnd003
         * 输入值：1,0
         * 预计输出：0
         */
        testInput0 = 1;
        testInput1 = 0;
        gateAnd.setInputValues(testInput0, testInput1);
        if (0 == gateAnd.getOutputValue()) {
            System.out.println("测试用例：GateAnd003" + " 通过！");
        } else {
            System.out.println("测试用例：GateAnd003" + " 不通过！");
        }

        /**
         * 测试用例：GateAnd004
         * 输入值：1,1
         * 预计输出：1
         */
        testInput0 = 1;
        testInput1 = 1;
        gateAnd.setInputValues(testInput0, testInput1);
        if (1 == gateAnd.getOutputValue()) {
            System.out.println("测试用例：GateAnd004" + " 通过！");
        } else {
            System.out.println("测试用例：GateAnd004" + " 不通过！");
        }

    }



    public static void main(String[] args) {
        /* 测试 GateAnd 类*/
        testClass_GateAnd();
    }

}
