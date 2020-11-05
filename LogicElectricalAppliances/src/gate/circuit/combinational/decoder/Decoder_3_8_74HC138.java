package gate.circuit.combinational.decoder;

import gate.Gate;
import gate.circuit.GateAnd;
import gate.circuit.GateNon;
import gate.circuit.GateNot;
import gate.circuit.exception.BaseCircuitException;

/**
 * 类名：3线-8线译码器74HC138
 * 作用：实现 3线-8线译码器74HC138 的逻辑功能
 * 输入端：S1、S'2、S'3、A2、A1、A0  -->  inputs[0]、inputs[1]、inputs[2]、inputs[3]、inputs[4]、inputs[5]
 * 输出端：Y'0、Y'1、Y'2、Y'3、Y'4、Y'5、Y'6、Y'7  -->  output[0]、output[1]、output[2]、output[3]、output[4]、output[5]、output[6]、output[7]
 * 规则：Y'0 = (A'2*A'1*A'0)' = m'0
 *      Y'1 = (A'2*A'1*A0)' = m'1
 *      Y'2 = (A'2*A1*A'0)' = m'2
 *      Y'3 = (A'2*A1*A0)' = m'3
 *      Y'4 = (A2*A'1*A'0)' = m'4
 *      Y'5 = (A2*A'1*A0)' = m'5
 *      Y'6 = (A2*A1*A'0)' = m'6
 *      Y'7 = (A2*A1*A0)' = m'7
 *
 * 真值表：
 * --------------------------------------------------------------------
 *              输入           |                 输出
 * --------------------------------------------------------------------
 *  S1 | S'2+S'3 | A2  A1  A0 | Y'0  Y'1  Y'2  Y'3  Y'4  Y'5  Y'6  Y'7
 * --------------------------------------------------------------------
 *  0  |    x    | x   x   x  |  1    1    1    1    1    1    1    1
 *  x  |    1    | x   x   x  |  1    1    1    1    1    1    1    1
 *  1  |    0    | 0   0   0  |  0    1    1    1    1    1    1    1
 *  1  |    0    | 0   0   1  |  1    0    1    1    1    1    1    1
 *  1  |    0    | 0   1   0  |  1    1    0    1    1    1    1    1
 *  1  |    0    | 0   1   1  |  1    1    1    0    1    1    1    1
 *  1  |    0    | 1   0   0  |  1    1    1    1    0    1    1    1
 *  1  |    0    | 1   0   1  |  1    1    1    1    1    0    1    1
 *  1  |    0    | 1   1   0  |  1    1    1    1    1    1    0    1
 *  1  |    0    | 1   1   1  |  1    1    1    1    1    1    1    0
 * --------------------------------------------------------------------
 *
 * @author 93710
 */
public class Decoder_3_8_74HC138 implements Gate {

    /**
     * 3线-8线译码器74HC138 的输入端个数 6
     */
    private static final int NUMBER_OF_INPUT = 6;

    /**
     * 3线-8线译码器74HC138 的输出端个数 8
     */
    private static final int NUMBER_OF_OUTPUT = 8;

    /**
     * 输入 S1、S'2、S'3、A2、A1、A0 对应
     * inputs[0]、inputs[1]、inputs[2]、inputs[3]、inputs[4]、inputs[5]
     */
    private MACHINE_CODE[] inputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 输出 Y'0、Y'1、Y'2、Y'3、Y'4、Y'5、Y'6、Y'7 对应
     * output[0]、output[1]、output[2]、output[3]、output[4]、output[5]、output[6]、output[7]
     */
    private MACHINE_CODE[] outputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 3线-8线译码器74HC138 所依赖的 非门、与门、与非门
     */
    private GateNot[] gateNots_level1_in1 = {
            new GateNot(), new GateNot(), new GateNot(), new GateNot(), new GateNot()
    };

    private GateAnd gateAnd_level2_in3 = new GateAnd(Gate.getMachineCodeArray(1, 3)[0]);

    private GateNot[] gateNots_level2_in1 = {
            new GateNot(), new GateNot(), new GateNot()
    };

    private GateNon[] gateNons_level3_in4 = {
            new GateNon(Gate.getMachineCodeArray(1, 4)[0]),
            new GateNon(Gate.getMachineCodeArray(1, 4)[0]),
            new GateNon(Gate.getMachineCodeArray(1, 4)[0]),
            new GateNon(Gate.getMachineCodeArray(1, 4)[0]),
            new GateNon(Gate.getMachineCodeArray(1, 4)[0]),
            new GateNon(Gate.getMachineCodeArray(1, 4)[0]),
            new GateNon(Gate.getMachineCodeArray(1, 4)[0]),
            new GateNon(Gate.getMachineCodeArray(1, 4)[0])
    };

    /**
     * 默认无参的构造方法：构造缺省 3线-8线译码器74HC138 对象
     * 实现：
     * 1. 3线-8线译码器74HC138 的输入端赋值为 0
     * 2. 输出端的值由 createOutput 生成
     */
    public Decoder_3_8_74HC138() {
        setInputValues(this.inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>3线-8线译码器74HC138</b> 输出端的值
     * 逻辑式：
     *      1、Y'0 = (A'2*A'1*A'0)' = m'0
     *      2、Y'1 = (A'2*A'1*A0)' = m'1
     *      3、Y'2 = (A'2*A1*A'0)' = m'2
     *      4、Y'3 = (A'2*A1*A0)' = m'3
     *      5、Y'4 = (A2*A'1*A'0)' = m'4
     *      6、Y'5 = (A2*A'1*A0)' = m'5
     *      7、Y'6 = (A2*A1*A'0)' = m'6
     *      8、Y'7 = (A2*A1*A0)' = m'7
     */
    private void createOutput(MACHINE_CODE[] inputs) throws BaseCircuitException {
        if (inputs == null || inputs.length != NUMBER_OF_INPUT) {
            throw new BaseCircuitException("Decoder_3_8_74HC138", "createOutput(MACHINE_CODE[] inputs)", "error input number!");
        }

        try {
            this.inputs = inputs;

            gateNots_level1_in1[0].setInputValues(new MACHINE_CODE[]{inputs[1]});
            gateNots_level1_in1[1].setInputValues(new MACHINE_CODE[]{inputs[2]});
            gateNots_level1_in1[2].setInputValues(new MACHINE_CODE[]{inputs[5]});
            gateNots_level1_in1[3].setInputValues(new MACHINE_CODE[]{inputs[4]});
            gateNots_level1_in1[4].setInputValues(new MACHINE_CODE[]{inputs[3]});

            gateAnd_level2_in3.setInputValues(new MACHINE_CODE[]{
                    inputs[0],
                    gateNots_level1_in1[0].getOutputValue()[0],
                    gateNots_level1_in1[1].getOutputValue()[0]
            });
            gateNots_level2_in1[0].setInputValues(gateNots_level1_in1[2].getOutputValue());
            gateNots_level2_in1[1].setInputValues(gateNots_level1_in1[3].getOutputValue());
            gateNots_level2_in1[2].setInputValues(gateNots_level1_in1[4].getOutputValue());

            gateNons_level3_in4[0].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[2].getOutputValue()[0],
                    gateNots_level1_in1[3].getOutputValue()[0],
                    gateNots_level1_in1[4].getOutputValue()[0],
                    gateAnd_level2_in3.getOutputValue()[0]
            });
            gateNons_level3_in4[1].setInputValues(new MACHINE_CODE[]{
                    gateNots_level2_in1[0].getOutputValue()[0],
                    gateNots_level1_in1[3].getOutputValue()[0],
                    gateNots_level1_in1[4].getOutputValue()[0],
                    gateAnd_level2_in3.getOutputValue()[0]
            });
            gateNons_level3_in4[2].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[2].getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level1_in1[4].getOutputValue()[0],
                    gateAnd_level2_in3.getOutputValue()[0]
            });
            gateNons_level3_in4[3].setInputValues(new MACHINE_CODE[]{
                    gateNots_level2_in1[0].getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level1_in1[4].getOutputValue()[0],
                    gateAnd_level2_in3.getOutputValue()[0]
            });
            gateNons_level3_in4[4].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[2].getOutputValue()[0],
                    gateNots_level1_in1[3].getOutputValue()[0],
                    gateNots_level2_in1[2].getOutputValue()[0],
                    gateAnd_level2_in3.getOutputValue()[0]
            });
            gateNons_level3_in4[5].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[3].getOutputValue()[0],
                    gateNots_level2_in1[2].getOutputValue()[0],
                    gateNots_level2_in1[0].getOutputValue()[0],
                    gateAnd_level2_in3.getOutputValue()[0]
            });
            gateNons_level3_in4[6].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[2].getOutputValue()[0],
                    gateNots_level2_in1[2].getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0],
                    gateAnd_level2_in3.getOutputValue()[0]
            });
            gateNons_level3_in4[7].setInputValues(new MACHINE_CODE[]{
                    gateAnd_level2_in3.getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[0].getOutputValue()[0],
                    gateNots_level2_in1[2].getOutputValue()[0]
            });

            this.outputs[0] = gateNons_level3_in4[0].getOutputValue()[0];
            this.outputs[1] = gateNons_level3_in4[1].getOutputValue()[0];
            this.outputs[2] = gateNons_level3_in4[2].getOutputValue()[0];
            this.outputs[3] = gateNons_level3_in4[3].getOutputValue()[0];
            this.outputs[4] = gateNons_level3_in4[4].getOutputValue()[0];
            this.outputs[5] = gateNons_level3_in4[5].getOutputValue()[0];
            this.outputs[6] = gateNons_level3_in4[6].getOutputValue()[0];
            this.outputs[7] = gateNons_level3_in4[7].getOutputValue()[0];
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>3线-8线译码器74HC138</b> 输入端的值
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
     * 方法名：设置输入端的值
     * 作用：设置 <b>3线-8线译码器74HC138</b> 输入端的值
     * 注意：A3数组是倒序赋值的
     * @param S1 控制器S1
     * @param _S2 控制器_S2
     * @param _S3 控制器_S3
     * @param A3 编码输入值：A2~A0
     */
    public void setInputValues(MACHINE_CODE S1, MACHINE_CODE _S2, MACHINE_CODE _S3, MACHINE_CODE[] A3) {
        try {
            createOutput(new MACHINE_CODE[]{
                    S1, _S2, _S3,
                    A3[2], A3[1], A3[0]
            });
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>3线-8线译码器74HC138</b> 输入端的值
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
     * 作用：获取 <b>3线-8线译码器74HC138</b> 输出端的值
     *
     * @return 输出值
     */
    @Override
    public MACHINE_CODE[] getOutputValue() {
        return this.outputs;
    }
}
