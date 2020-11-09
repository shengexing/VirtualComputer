package gate.circuit.combinational.decoder;

import gate.Gate;
import gate.circuit.GateNon;
import gate.circuit.GateNot;
import gate.circuit.exception.BaseCircuitException;

/**
 * 类名：二-十进制译码器74HC42
 * 作用：实现 二-十进制译码器74HC42 的逻辑功能
 * 输入端：A3、A2、A1、A0  -->  inputs[0]、inputs[1]、inputs[2]、inputs[3]
 * 输出端：Y'0、Y'1、Y'2、Y'3、Y'4、Y'5、Y'6、Y'7、Y'8、Y'9  -->  output[0]、output[1]、output[2]、output[3]、output[4]、output[5]、output[6]、output[7]、output[8]、output[9]
 * 规则：Y'0 = (A'3*A'2*A'1*A'0)'
 *      Y'1 = (A'3*A'2*A'1*A0)'
 *      Y'2 = (A'3*A'2*A1*A'0)'
 *      Y'3 = (A'3*A'2*A1*A0)'
 *      Y'4 = (A'3*A2*A'1*A'0)'
 *      Y'5 = (A'3*A2*A'1*A0)'
 *      Y'6 = (A'3*A2*A1*A'0)'
 *      Y'7 = (A'3*A2*A1*A0)'
 *      Y'8 = (A3*A'2*A'1*A'0)'
 *      Y'9 = (A3*A'2*A'1*A0)'
 *
 * 真值表：
 * -------------------------------------------------------------------------
 *  序号 |     输入        |                      输出
 * -------------------------------------------------------------------------
 *      | A3  A2  A1  A0 | Y'0  Y'1  Y'2  Y'3  Y'4  Y'5  Y'6  Y'7  Y'8  Y'9
 * -------------------------------------------------------------------------
 *   0  | 0   0   0   0  |  0    1    1    1    1    1    1    1    1    1
 *   1  | 0   0   0   1  |  1    0    1    1    1    1    1    1    1    1
 *   2  | 0   0   1   0  |  1    1    0    1    1    1    1    1    1    1
 *   3  | 0   0   1   1  |  1    1    1    0    1    1    1    1    1    1
 *   4  | 0   1   0   0  |  1    1    1    1    0    1    1    1    1    1
 *   5  | 0   1   0   1  |  1    1    1    1    1    0    1    1    1    1
 *   6  | 0   1   1   0  |  1    1    1    1    1    1    0    1    1    1
 *   7  | 0   1   1   1  |  1    1    1    1    1    1    1    0    1    1
 *   8  | 1   0   0   0  |  1    1    1    1    1    1    1    1    0    1
 *   9  | 1   0   0   1  |  1    1    1    1    1    1    1    1    1    0
 * -------------------------------------------------------------------------
 *      | 1   0   1   0  |  1    1    1    1    1    1    1    1    1    0
 *      | 1   0   1   1  |  1    1    1    1    1    1    1    1    1    0
 *  伪  | 1   1   0   0  |  1    1    1    1    1    1    1    1    1    0
 *  码  | 1   1   0   1  |  1    1    1    1    1    1    1    1    1    0
 *      | 1   1   1   0  |  1    1    1    1    1    1    1    1    1    0
 *      | 1   1   1   1  |  1    1    1    1    1    1    1    1    1    0
 * -------------------------------------------------------------------------
 *
 * @author 93710
 */
public class Decoder_2_10_74HC42 implements Gate {

    /**
     * 二-十进制译码器74HC42 的输入端个数 4
     */
    private static final int NUMBER_OF_INPUT = 4;

    /**
     * 二-十进制译码器74HC42 的输出端个数 10
     */
    private static final int NUMBER_OF_OUTPUT = 10;

    /**
     * 输入 A3、A2、A1、A0 对应
     * inputs[0]、inputs[1]、inputs[2]、inputs[3]
     */
    private MACHINE_CODE[] inputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 输出 Y'0、Y'1、Y'2、Y'3、Y'4、Y'5、Y'6、Y'7、Y'8、Y'9 对应
     * output[0]、output[1]、output[2]、output[3]、output[4]、output[5]、output[6]、output[7]、output[8]、output[9]
     */
    private MACHINE_CODE[] outputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 二-十进制译码器74HC42 所依赖的 非门、与非门
     */
    private GateNot[] gateNots_level1_in1 = {
            new GateNot(), new GateNot(), new GateNot(), new GateNot()
    };

    private GateNot[] gateNots_level2_in1 = {
            new GateNot(), new GateNot(), new GateNot(), new GateNot()
    };

    private GateNon[] gateNons_level3_in4  = {
            new GateNon(), new GateNon(), new GateNon(), new GateNon(), new GateNon(),
            new GateNon(), new GateNon(), new GateNon(), new GateNon(), new GateNon()
    };

    /**
     * 默认无参的构造方法：构造缺省 二-十进制译码器74HC42 对象
     * 实现：
     * 1. 二-十进制译码器74HC42 的输入端赋值为 0
     * 2. 输出端的值由 createOutput 生成
     */
    public Decoder_2_10_74HC42() {
        setInputValues(this.inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>二-十进制译码器74HC42</b> 输出端的值
     * 逻辑式：
     *      1、Y'0 = (A'3*A'2*A'1*A'0)'
     *      2、Y'1 = (A'3*A'2*A'1*A0)'
     *      3、Y'2 = (A'3*A'2*A1*A'0)'
     *      4、Y'3 = (A'3*A'2*A1*A0)'
     *      5、Y'4 = (A'3*A2*A'1*A'0)'
     *      6、Y'5 = (A'3*A2*A'1*A0)'
     *      7、Y'6 = (A'3*A2*A1*A'0)'
     *      8、Y'7 = (A'3*A2*A1*A0)'
     *      9、Y'8 = (A3*A'2*A'1*A'0)'
     *      10、Y'9 = (A3*A'2*A'1*A0)'
     */
    private void createOutput(MACHINE_CODE[] inputs) throws BaseCircuitException {
        if (inputs == null || inputs.length != NUMBER_OF_INPUT) {
            throw new BaseCircuitException("Decoder_2_10_74HC42", "createOutput(MACHINE_CODE[] inputs)", "error input number!");
        }

        try {
            this.inputs = inputs;

            for (int i = 0; i < NUMBER_OF_INPUT; i++) {
                gateNots_level1_in1[i].setInputValues(new MACHINE_CODE[] {inputs[NUMBER_OF_INPUT - 1 - i]});
            }
            for (int i = 0; i < NUMBER_OF_INPUT; i++) {
                gateNots_level2_in1[i].setInputValues(new MACHINE_CODE[]{
                        gateNots_level1_in1[i].getOutputValue()[0]
                });
            }
            gateNons_level3_in4[0].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[0].getOutputValue()[0],
                    gateNots_level1_in1[1].getOutputValue()[0],
                    gateNots_level1_in1[2].getOutputValue()[0],
                    gateNots_level1_in1[3].getOutputValue()[0]
            });
            gateNons_level3_in4[1].setInputValues(new MACHINE_CODE[]{
                    gateNots_level2_in1[0].getOutputValue()[0],
                    gateNots_level1_in1[1].getOutputValue()[0],
                    gateNots_level1_in1[2].getOutputValue()[0],
                    gateNots_level1_in1[3].getOutputValue()[0]
            });
            gateNons_level3_in4[2].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[0].getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level1_in1[2].getOutputValue()[0],
                    gateNots_level1_in1[3].getOutputValue()[0]
            });
            gateNons_level3_in4[3].setInputValues(new MACHINE_CODE[]{
                    gateNots_level2_in1[0].getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level1_in1[2].getOutputValue()[0],
                    gateNots_level1_in1[3].getOutputValue()[0]
            });
            gateNons_level3_in4[4].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[0].getOutputValue()[0],
                    gateNots_level1_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[2].getOutputValue()[0],
                    gateNots_level1_in1[3].getOutputValue()[0]
            });
            gateNons_level3_in4[5].setInputValues(new MACHINE_CODE[]{
                    gateNots_level2_in1[0].getOutputValue()[0],
                    gateNots_level1_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[2].getOutputValue()[0],
                    gateNots_level1_in1[3].getOutputValue()[0]
            });
            gateNons_level3_in4[6].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[0].getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[2].getOutputValue()[0],
                    gateNots_level1_in1[3].getOutputValue()[0]
            });
            gateNons_level3_in4[7].setInputValues(new MACHINE_CODE[]{
                    gateNots_level2_in1[0].getOutputValue()[0],
                    gateNots_level2_in1[1].getOutputValue()[0],
                    gateNots_level2_in1[2].getOutputValue()[0],
                    gateNots_level1_in1[3].getOutputValue()[0]
            });
            gateNons_level3_in4[8].setInputValues(new MACHINE_CODE[]{
                    gateNots_level1_in1[0].getOutputValue()[0],
                    gateNots_level1_in1[1].getOutputValue()[0],
                    gateNots_level1_in1[2].getOutputValue()[0],
                    gateNots_level2_in1[3].getOutputValue()[0]
            });
            gateNons_level3_in4[9].setInputValues(new MACHINE_CODE[]{
                    gateNots_level2_in1[0].getOutputValue()[0],
                    gateNots_level1_in1[1].getOutputValue()[0],
                    gateNots_level1_in1[2].getOutputValue()[0],
                    gateNots_level2_in1[3].getOutputValue()[0]
            });

            for (int i = 0; i < NUMBER_OF_OUTPUT; i++) {
                this.outputs[i] = gateNons_level3_in4[i].getOutputValue()[0];
            }
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>二-十进制译码器74HC42</b> 输入端的值
     * @param inputs 输入端的值 (A3, A2, A1, A0)
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
     * 作用：获取 <b>二-十进制译码器74HC42</b> 输入端的值
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
     * 作用：获取 <b>二-十进制译码器74HC42</b> 输出端的值
     *
     * @return 输出值
     */
    @Override
    public MACHINE_CODE[] getOutputValue() {
        return this.outputs;
    }
}
