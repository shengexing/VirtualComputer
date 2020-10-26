package gate.circuit.combinational.encoder;

import gate.Gate;
import gate.circuit.GateAnd;
import gate.circuit.GateNor;
import gate.circuit.GateNot;
import gate.circuit.exception.BaseCircuitException;

/**
 * 类名：二-十进制优先编码器
 * 作用：实现 二-十进制优先编码器 的逻辑功能
 * 输入端：I'1、I'2、I'3、I'4、I'5、I'6、I'7、I'8、I'9  -->  inputs[0]、inputs[1]、inputs[2]、inputs[3]、inputs[4]、inputs[5]、inputs[6]、inputs[7]、inputs[8]
 * 输出端：Y'3、Y'2、Y'1、Y'0  -->  output[0]、output[1]、output[2]、output[3]
 *
 * 真值表：
 * ------------------------------------------------------------------
 *                        输入                   |           输出
 * ------------------------------------------------------------------
 *  I'1  I'2  I'3  I'4  I'5  I'6  I'7  I'8  I'9 | Y'3  Y'2  Y'1  Y'0
 * ------------------------------------------------------------------
 *   1    1    1    1    1    1    1    1    1  |  1    1    1    1
 *   x    x    x    x    x    x    x    x    0  |  0    1    1    0
 *   x    x    x    x    x    x    x    0    1  |  0    1    1    1
 *   x    x    x    x    x    x    0    1    1  |  1    0    0    0
 *   x    x    x    x    x    0    1    1    1  |  1    0    0    1
 *   x    x    x    x    0    1    1    1    1  |  1    0    1    0
 *   x    x    x    0    1    1    1    1    1  |  1    0    1    1
 *   x    x    0    1    1    1    1    1    1  |  1    1    0    0
 *   x    0    1    1    1    1    1    1    1  |  1    1    0    1
 *   0    1    1    1    1    1    1    1    1  |  1    1    1    0
 * ------------------------------------------------------------------
 *
 * @author 93710
 */
public class PriorityEncoder_System_2_10_74LS147 implements Gate {

    /**
     * 二-十进制优先编码器 的输入端个数 9
     */
    private static final int NUMBER_OF_INPUT = 9;

    /**
     * 二-十进制优先编码器 的输出端个数 5
     */
    private static final int NUMBER_OF_OUTPUT = 4;

    /**
     * 输入 I'1、I'2、I'3、I'4、I'5、I'6、I'7、I'8、I'9  对应
     * inputs[0]、inputs[1]、inputs[2]、inputs[3]、inputs[4]、inputs[5]、inputs[6]、inputs[7]、inputs[8]
     */
    private MACHINE_CODE[] inputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 输出 Y'3、Y'2、Y'1、Y'0 对应 outputs[0]、outputs[1]、outputs[2]、outputs[3]
     */
    private MACHINE_CODE[] outputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 二-十进制优先编码器 所依赖的 非门、与门、或非门
     */
    private GateNot[] gateNots_level1_in1 = {
            new GateNot(), new GateNot(), new GateNot(),
            new GateNot(), new GateNot(), new GateNot(),
            new GateNot(), new GateNot(), new GateNot()
    };

    private GateNot[] gateNots_level2_in1 = {
            new GateNot(), new GateNot(), new GateNot(), new GateNot()
    };

    private GateNor gateNor_level2_in2 = new GateNor();

    private GateAnd gateAnd_level3_in5 = new GateAnd(Gate.getMachineCodeArray(1, 5)[0]);

    private GateAnd[] gateAnds_level3_in4 = {
            new GateAnd(Gate.getMachineCodeArray(1, 4)[0]),
            new GateAnd(Gate.getMachineCodeArray(1, 4)[0]),
            new GateAnd(Gate.getMachineCodeArray(1, 4)[0])
    };

    private GateAnd gateAnd_level3_in3 = new GateAnd(Gate.getMachineCodeArray(1, 3)[0]);

    private GateAnd[] gateAnds_level3_in2 = {
            new GateAnd(), new GateAnd(), new GateAnd(), new GateAnd(), new GateAnd(), new GateAnd(), new GateAnd()
    };

    private GateNor gateNor_level4_in5 = new GateNor(Gate.getMachineCodeArray(1, 5)[0]);

    private GateNor[] gateNors_level4_in4 = {
            new GateNor(Gate.getMachineCodeArray(1, 4)[0]),
            new GateNor(Gate.getMachineCodeArray(1, 4)[0])
    };

    private GateNor gateNor_level4_in2 = new GateNor();

    /**
     * 默认无参的构造方法：构造缺省 二-十进制优先编码器 对象
     * 实现：
     * 1. 二-十进制优先编码器 的输入端赋值为 0
     * 2. 输出端的值由 createOutput 生成
     */
    public PriorityEncoder_System_2_10_74LS147() {
        setInputValues(this.inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>二-十进制优先编码器</b> 输出端的值
     * 逻辑式：
     *      1. Y'3 = (I8 + I9)'
     *      2. Y'2 = (I7I'8I'9 + I6I'8I'9 + I5I'8I'9 + I4I'8I'9)'
     *      3. Y'1 = (I7I'8I'9 + I6I'8I'9 + I3I'4I'5I'8I'9 + I2I'4I'5I'8I'9)'
     *      4. Y'0 = (I9 + I7I'8I'9 + I5I'6I'8I'9 + I3I'4I'6I'8I'9 + I1I'2I'4I'6I'8I'9)'
     */
    private void createOutput(MACHINE_CODE[] inputs) throws BaseCircuitException {
        if (inputs == null || inputs.length != NUMBER_OF_INPUT) {
            throw new BaseCircuitException("PriorityEncoder_System_2_10_74LS147", "createOutput(MACHINE_CODE[] inputs)", "error input number!");
        }

        try {
            this.inputs = inputs;

            for (int i = 1; i <= NUMBER_OF_INPUT; i++) {
                gateNots_level1_in1[i - 1].setInputValues(new MACHINE_CODE[]{inputs[i - 1]});
            }

            gateNots_level2_in1[0].setInputValues(new MACHINE_CODE[]{gateNots_level1_in1[1].getOutputValue()[0]});
            gateNots_level2_in1[1].setInputValues(new MACHINE_CODE[]{gateNots_level1_in1[3].getOutputValue()[0]});
            gateNots_level2_in1[2].setInputValues(new MACHINE_CODE[]{gateNots_level1_in1[4].getOutputValue()[0]});
            gateNots_level2_in1[3].setInputValues(new MACHINE_CODE[]{gateNots_level1_in1[5].getOutputValue()[0]});
            gateNor_level2_in2.setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[7].getOutputValue()[0], gateNots_level1_in1[8].getOutputValue()[0]
            });

            gateAnd_level3_in5.setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[0].getOutputValue()[0], gateNots_level2_in1[0].getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0], gateNots_level2_in1[3].getOutputValue()[0],
                    gateNor_level2_in2.getOutputValue()[0]
            });
            gateAnds_level3_in4[0].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[2].getOutputValue()[0], gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[3].getOutputValue()[0], gateNor_level2_in2.getOutputValue()[0]
            });
            gateAnd_level3_in3.setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[4].getOutputValue()[0], gateNots_level2_in1[3].getOutputValue()[0],
                    gateNor_level2_in2.getOutputValue()[0]
            });
            gateAnds_level3_in2[0].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[6].getOutputValue()[0], gateNor_level2_in2.getOutputValue()[0]
            });
            gateAnds_level3_in4[1].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[1].getOutputValue()[0], gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[2].getOutputValue()[0], gateNor_level2_in2.getOutputValue()[0]
            });
            gateAnds_level3_in4[2].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[2].getOutputValue()[0], gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[2].getOutputValue()[0], gateNor_level2_in2.getOutputValue()[0]
            });
            gateAnds_level3_in2[1].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[5].getOutputValue()[0], gateNor_level2_in2.getOutputValue()[0]
            });
            gateAnds_level3_in2[2].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[6].getOutputValue()[0], gateNor_level2_in2.getOutputValue()[0]
            });
            gateAnds_level3_in2[3].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[3].getOutputValue()[0], gateNor_level2_in2.getOutputValue()[0]
            });
            gateAnds_level3_in2[4].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[4].getOutputValue()[0], gateNor_level2_in2.getOutputValue()[0]
            });
            gateAnds_level3_in2[5].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[5].getOutputValue()[0], gateNor_level2_in2.getOutputValue()[0]
            });
            gateAnds_level3_in2[6].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[6].getOutputValue()[0], gateNor_level2_in2.getOutputValue()[0]
            });

            gateNor_level4_in5.setInputValues(new MACHINE_CODE[]{
                    gateAnd_level3_in5.getOutputValue()[0], gateAnds_level3_in4[0].getOutputValue()[0],
                    gateAnd_level3_in3.getOutputValue()[0], gateAnds_level3_in2[0].getOutputValue()[0],
                    gateNots_level1_in1[8].getOutputValue()[0]
            });
            gateNors_level4_in4[0].setInputValues(new MACHINE_CODE[]{
                    gateAnds_level3_in4[1].getOutputValue()[0], gateAnds_level3_in4[2].getOutputValue()[0],
                    gateAnds_level3_in2[1].getOutputValue()[0], gateAnds_level3_in2[2].getOutputValue()[0]
            });
            gateNors_level4_in4[1].setInputValues(new MACHINE_CODE[]{
                    gateAnds_level3_in2[3].getOutputValue()[0], gateAnds_level3_in2[4].getOutputValue()[0],
                    gateAnds_level3_in2[5].getOutputValue()[0], gateAnds_level3_in2[6].getOutputValue()[0]
            });
            gateNor_level4_in2.setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[7].getOutputValue()[0], gateNots_level1_in1[8].getOutputValue()[0]
            });

            this.outputs[0] = gateNor_level4_in2.getOutputValue()[0];
            this.outputs[1] = gateNors_level4_in4[1].getOutputValue()[0];
            this.outputs[2] = gateNors_level4_in4[0].getOutputValue()[0];
            this.outputs[3] = gateNor_level4_in5.getOutputValue()[0];
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>二-十进制优先编码器</b> 输入端的值
     * @param inputs 输入端的值
     */
    public void setInputValues(MACHINE_CODE[] inputs) {
        try {
            createOutput(inputs);
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>门</b> 输入端的值
     *
     * @return 输入值
     * @throws BaseCircuitException
     */
    @Override
    public MACHINE_CODE[] getInputValues() throws BaseCircuitException {
        return this.inputs;
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>门</b> 输出端的值
     *
     * @return 输出值
     */
    @Override
    public MACHINE_CODE[] getOutputValue() {
        return this.outputs;
    }
}
