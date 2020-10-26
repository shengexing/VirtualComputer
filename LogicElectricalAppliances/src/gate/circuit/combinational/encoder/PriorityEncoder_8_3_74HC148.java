package gate.circuit.combinational.encoder;

import gate.Gate;
import gate.circuit.*;
import gate.circuit.exception.BaseCircuitException;

/**
 * 类名：8线-3线优先编码器
 * 作用：实现 8线-3线优先编码器 的逻辑功能
 * 输入端：S'、I'0、I'1、I'2、I'3、I'4、I'5、I'6、I'7  -->  inputs[0]、inputs[1]、inputs[2]、inputs[3]、inputs[4]、inputs[5]、inputs[6]、inputs[7]、inputs[8]
 * 输出端：Y'2、Y'1、Y'0、Y‘s、Y'ex  -->  output[0]、output[1]、output[2]、output[3]、output[4]
 *
 * 真值表：
 * -------------------------------------------------------------------------
 *                        输入                   |           输出
 * -------------------------------------------------------------------------
 *  S' | I'0  I'1  I'2  I'3  I'4  I'5  I'6  I'7 | Y'2  Y'1  Y'0 | Y's  Y'ex
 * -------------------------------------------------------------------------
 *  1  |  x    x    x    x    x    x    x    x  |  1    1    1  |  1    1
 *  0  |  1    1    1    1    1    1    1    1  |  1    1    1  |  0    1
 *  1  |  x    x    x    x    x    x    x    0  |  0    0    0  |  1    0
 *  1  |  x    x    x    x    x    x    0    1  |  0    0    1  |  1    0
 *  1  |  x    x    x    x    x    0    1    1  |  0    1    0  |  1    0
 *  1  |  x    x    x    x    0    1    1    1  |  0    1    1  |  1    0
 *  1  |  x    x    x    0    1    1    1    1  |  1    0    0  |  1    0
 *  1  |  x    x    0    1    1    1    1    1  |  1    0    1  |  1    0
 *  1  |  x    0    1    1    1    1    1    1  |  1    1    0  |  1    0
 *  1  |  0    1    1    1    1    1    1    1  |  1    1    1  |  1    0
 * -------------------------------------------------------------------------
 *
 * @author 93710
 */
public class PriorityEncoder_8_3_74HC148 implements Gate {

    /**
     * 8线-3线优先编码器 的输入端个数 9
     */
    private static final int NUMBER_OF_INPUT = 9;

    /**
     * 8线-3线优先编码器 的输出端个数 5
     */
    private static final int NUMBER_OF_OUTPUT = 5;

    /**
     * 输入 S'、I'0、I'1、I'2、I'3、I'4、I'5、I'6、I'7 对应
     * inputs[0]、inputs[1]、inputs[2]、inputs[3]、inputs[4]、inputs[5]、inputs[6]、inputs[7]、inputs[8]
     */
    private MACHINE_CODE[] inputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 输出 Y'2、Y'1、Y'0、Y'S、Y'EX 对应 outputs[0]、outputs[1]、outputs[2]、outputs[3]、outputs[4]
     */
    private MACHINE_CODE[] outputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0
    };

    /**
     * 8线-3线优先编码器 所依赖的 非门、与门、与非门、或非门
     */
    private GateNot[] gateNots_level1_in1 = {
            new GateNot(), new GateNot(), new GateNot(), new GateNot(),
            new GateNot(), new GateNot(), new GateNot(), new GateNot()
    };

    private GateNot[] gateNots_level2_in1 = {
            new GateNot(), new GateNot(), new GateNot(), new GateNot()
    };

    private GateNon gateNon_level3_in9 = new GateNon(Gate.getMachineCodeArray(1, 9)[0]);
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

    private GateNon gateNon_level4_in2 = new GateNon();
    private GateNor[] gateNors_level4_in4 = {
            new GateNor(Gate.getMachineCodeArray(1, 4)[0]),
            new GateNor(Gate.getMachineCodeArray(1, 4)[0]),
            new GateNor(Gate.getMachineCodeArray(1, 4)[0]),
            new GateNor(Gate.getMachineCodeArray(1, 4)[0])
    };


    /**
     * 默认无参的构造方法：构造缺省 8线-3线优先编码器 对象
     * 实现：
     * 1. 8线-3线优先编码器 的输入端赋值为 0
     * 2. 输出端的值由 createOutput 生成
     */
    public PriorityEncoder_8_3_74HC148() {
        setInputValues(this.inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>8线-3线优先编码器</b> 输出端的值
     * 逻辑式：
     *      1. Y2 = I4 + I5 + I6 + I7
     *      2. Y1 = I2 + I3 + I6 + I7
     *      3. Y0 = I1 + I3 + I5 + I7
     */
    private void createOutput(MACHINE_CODE[] inputs) throws BaseCircuitException {
        if (inputs == null || inputs.length != NUMBER_OF_INPUT) {
            throw new BaseCircuitException("PriorityEncoder_8_3_74HC148", "createOutput(MACHINE_CODE[] inputs)", "error input number!");
        }

        try {
            this.inputs = inputs;

            gateNots_level1_in1[7].setInputValues(new MACHINE_CODE[]{inputs[0]});
            for (int i = 2; i < NUMBER_OF_INPUT; i++) {
                gateNots_level1_in1[i - 2].setInputValues(new MACHINE_CODE[]{inputs[i]});
            }
            MACHINE_CODE g1_output = gateNots_level1_in1[7].getOutputValue()[0];

            gateNots_level2_in1[0].setInputValues(gateNots_level1_in1[1].getOutputValue());
            gateNots_level2_in1[1].setInputValues(gateNots_level1_in1[3].getOutputValue());
            gateNots_level2_in1[2].setInputValues(gateNots_level1_in1[4].getOutputValue());
            gateNots_level2_in1[3].setInputValues(gateNots_level1_in1[5].getOutputValue());

            gateNon_level3_in9.setInputValues(new MACHINE_CODE[]{
                    inputs[1], inputs[2], inputs[3],
                    inputs[4], inputs[5], inputs[6],
                    inputs[7], inputs[8], g1_output
            });
            gateAnd_level3_in5.setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[0].getOutputValue()[0],
                    gateNots_level2_in1[0].getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[3].getOutputValue()[0],
                    g1_output
            });
            gateAnds_level3_in4[0].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[2].getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[3].getOutputValue()[0],
                    g1_output
            });
            gateAnd_level3_in3.setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[4].getOutputValue()[0],
                    gateNots_level2_in1[3].getOutputValue()[0],
                    g1_output
            });
            gateAnds_level3_in2[0].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[6].getOutputValue()[0],
                    g1_output
            });

            gateAnds_level3_in4[1].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[2].getOutputValue()[0],
                    g1_output
            });
            gateAnds_level3_in4[2].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[2].getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[2].getOutputValue()[0],
                    g1_output
            });
            gateAnds_level3_in2[1].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[5].getOutputValue()[0],
                    g1_output
            });
            gateAnds_level3_in2[2].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[6].getOutputValue()[0],
                    g1_output
            });

            gateAnds_level3_in2[3].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[3].getOutputValue()[0],
                    g1_output
            });
            gateAnds_level3_in2[4].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[4].getOutputValue()[0],
                    g1_output
            });
            gateAnds_level3_in2[5].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[5].getOutputValue()[0],
                    g1_output
            });
            gateAnds_level3_in2[6].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[6].getOutputValue()[0],
                    g1_output
            });

            gateNon_level4_in2.setInputValues(new MACHINE_CODE[]{
                    gateNon_level3_in9.getOutputValue()[0],
                    g1_output
            });
            gateNors_level4_in4[2].setInputValues(new MACHINE_CODE[]{
                    gateAnd_level3_in5.getOutputValue()[0],
                    gateAnds_level3_in4[0].getOutputValue()[0],
                    gateAnd_level3_in3.getOutputValue()[0],
                    gateAnds_level3_in2[0].getOutputValue()[0]
            });
            gateNors_level4_in4[1].setInputValues(new MACHINE_CODE[]{
                    gateAnds_level3_in4[1].getOutputValue()[0],
                    gateAnds_level3_in4[2].getOutputValue()[0],
                    gateAnds_level3_in2[1].getOutputValue()[0],
                    gateAnds_level3_in2[2].getOutputValue()[0]
            });
            gateNors_level4_in4[0].setInputValues(new MACHINE_CODE[]{
                    gateAnds_level3_in2[3].getOutputValue()[0],
                    gateAnds_level3_in2[4].getOutputValue()[0],
                    gateAnds_level3_in2[5].getOutputValue()[0],
                    gateAnds_level3_in2[6].getOutputValue()[0]
            });

            this.outputs[0] = gateNors_level4_in4[0].getOutputValue()[0];
            this.outputs[1] = gateNors_level4_in4[1].getOutputValue()[0];
            this.outputs[2] = gateNors_level4_in4[2].getOutputValue()[0];
            this.outputs[3] = gateNon_level3_in9.getOutputValue()[0];
            this.outputs[4] = gateNon_level4_in2.getOutputValue()[0];
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>8线-3线优先编码器</b> 输入端的值
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
     * 作用：获取 <b>8线-3线优先编码器</b> 输入端的值
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
     * 作用：获取 <b>8线-3线优先编码器</b> 输出端的值
     *
     * @return 输出值
     */
    @Override
    public MACHINE_CODE[] getOutputValue() {
        return this.outputs;
    }
}
