package gate.circuit.combinational.decoder;

import gate.Gate;
import gate.circuit.exception.BaseCircuitException;

/**
 * 类名：4线-16线译码器
 * 作用：实现 4线-16线译码器 的逻辑功能
 * 输入端：S1、S'2、S'3、D3、D2、D1、D0  -->  inputs[0]、inputs[1]、inputs[2]、inputs[3]、inputs[4]、inputs[5]、inputs[6]
 * 输出端：Z'0、Z'1、Z'2、Z'3、Z'4、Z'5、Z'6、Z'7、Z'8、Z'9、Z'10、Z'11、Z'12、Z'13、Z'14、Z'15  -->
 *        output[0]、output[1]、output[2]、output[3]、output[4]、output[5]、output[6]、output[7]、
 *        output[8]、output[9]、output[10]、output[11]、output[12]、output[13]、output[14]、output[15]
 * 规则：Z'0 = (D'3*D'2*D'1*D'0)'
 *      Z'1 = (D'3*D'2*D'1*D0)'
 *      Z'2 = (D'3*D'2*D1*D'0)'
 *      Z'3 = (D'3*D'2*D1*D0)'
 *      Z'4 = (D'3*D2*D'1*D'0)'
 *      Z'5 = (D'3*D2*D'1*D0)'
 *      Z'6 = (D'3*D2*D1*D'0)'
 *      Z'7 = (D'3*D2*D1*D0)'
 *      Z'8 = (D3*D'2*D'1*D'0)'
 *      Z'9 = (D3*D'2*D'1*D0)'
 *      Z'10 = (D3*D'2*D1*D'0)'
 *      Z'11 = (D3*D'2*D1*D0)'
 *      Z'12 = (D3*D2*D'1*D'0)'
 *      Z'13 = (D3*D2*D'1*D0)'
 *      Z'14 = (D3*D2*D1*D'0)'
 *      Z'15 = (D3*D2*D1*D0)'
 *
 * 真值表：
 * ----------------------------------------------------------------------------------------------------------------------
 *                输入            |                                       输出
 * ----------------------------------------------------------------------------------------------------------------------
 *  S1 | S'2+S'3 | D3  D2  D1  D0 | Y'0  Y'1  Y'2  Y'3  Y'4  Y'5  Y'6  Y'7  Y'8  Y'9  Y'10  Y'11  Y'12  Y'13  Y'14  Y'15
 * ----------------------------------------------------------------------------------------------------------------------
 *  0  |    x    | x   x   x   x  |  1    1    1    1    1    1    1    1    1    1     1     1     1     1     1     1
 *  x  |    1    | x   x   x   x  |  1    1    1    1    1    1    1    1    1    1     1     1     1     1     1     1
 *  1  |    0    | 0   0   0   0  |  0    1    1    1    1    1    1    1    1    1     1     1     1     1     1     1
 *  1  |    0    | 0   0   0   1  |  1    0    1    1    1    1    1    1    1    1     1     1     1     1     1     1
 *  1  |    0    | 0   0   1   0  |  1    1    0    1    1    1    1    1    1    1     1     1     1     1     1     1
 *  1  |    0    | 0   0   1   1  |  1    1    1    0    1    1    1    1    1    1     1     1     1     1     1     1
 *  1  |    0    | 0   1   0   0  |  1    1    1    1    0    1    1    1    1    1     1     1     1     1     1     1
 *  1  |    0    | 0   1   0   1  |  1    1    1    1    1    0    1    1    1    1     1     1     1     1     1     1
 *  1  |    0    | 0   1   1   0  |  1    1    1    1    1    1    0    1    1    1     1     1     1     1     1     1
 *  1  |    0    | 0   1   1   1  |  1    1    1    1    1    1    1    0    1    1     1     1     1     1     1     1
 *  1  |    0    | 1   0   0   0  |  1    1    1    1    1    1    1    1    0    1     1     1     1     1     1     1
 *  1  |    0    | 1   0   0   1  |  1    1    1    1    1    1    1    1    1    0     1     1     1     1     1     1
 *  1  |    0    | 1   0   1   0  |  1    1    1    1    1    1    1    1    1    1     0     1     1     1     1     1
 *  1  |    0    | 1   0   1   1  |  1    1    1    1    1    1    1    1    1    1     1     0     1     1     1     1
 *  1  |    0    | 1   1   0   0  |  1    1    1    1    1    1    1    1    1    1     1     1     0     1     1     1
 *  1  |    0    | 1   1   0   1  |  1    1    1    1    1    1    1    1    1    1     1     1     1     0     1     1
 *  1  |    0    | 1   1   1   0  |  1    1    1    1    1    1    1    1    1    1     1     1     1     1     0     1
 *  1  |    0    | 1   1   1   1  |  1    1    1    1    1    1    1    1    1    1     1     1     1     1     1     0
 * ----------------------------------------------------------------------------------------------------------------------
 *
 * @author 93710
 */
public class Decoder_4_16 implements Gate {

    /**
     * 4线-16线译码器 的输入端个数 7
     */
    private static final int NUMBER_OF_INPUT = 7;

    /**
     * 4线-16线译码器 的输出端个数 16
     */
    private static final int NUMBER_OF_OUTPUT = 16;

    /**
     * 输入 S1、S'2、S'3、D3、D2、D1、D0 对应
     * inputs[0]、inputs[1]、inputs[2]、inputs[3]、inputs[4]、inputs[5]、inputs[6]
     */
    private MACHINE_CODE[] inputs = new MACHINE_CODE[]{
        MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
        MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 输出 Z'0、Z'1、Z'2、Z'3、Z'4、Z'5、Z'6、Z'7、Z'8、Z'9、Z'10、Z'11、Z'12、Z'13、Z'14、Z'15  对应
     *     output[0]、output[1]、output[2]、output[3]、output[4]、output[5]、output[6]、output[7]、
     *     output[8]、output[9]、output[10]、output[11]、output[12]、output[13]、output[14]、output[15]
     */
    private MACHINE_CODE[] outputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 4线-16线译码器 所依赖的 3线-8线译码器74HC138
     */
    private Decoder_3_8_74HC138[] decoder_3_8_74HC138s = {
        new Decoder_3_8_74HC138(), new Decoder_3_8_74HC138()
    };

    /**
     * 默认无参的构造方法：构造缺省 4线-16线译码器 对象
     * 实现：
     * 1. 4线-16线译码器 的输入端赋值为 0
     * 2. 输出端的值由 createOutput 生成
     */
    public Decoder_4_16() {
        setInputValues(this.inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>4线-16线译码器</b> 输出端的值
     * 逻辑式：
     *      1、Z'0 = (D'3*D'2*D'1*D'0)'
     *      2、Z'1 = (D'3*D'2*D'1*D0)'
     *      3、Z'2 = (D'3*D'2*D1*D'0)'
     *      4、Z'3 = (D'3*D'2*D1*D0)'
     *      5、Z'4 = (D'3*D2*D'1*D'0)'
     *      6、Z'5 = (D'3*D2*D'1*D0)'
     *      7、Z'6 = (D'3*D2*D1*D'0)'
     *      8、Z'7 = (D'3*D2*D1*D0)'
     *      9、Z'8 = (D3*D'2*D'1*D'0)'
     *      10、Z'9 = (D3*D'2*D'1*D0)'
     *      11、Z'10 = (D3*D'2*D1*D'0)'
     *      12、Z'11 = (D3*D'2*D1*D0)'
     *      13、Z'12 = (D3*D2*D'1*D'0)'
     *      14、Z'13 = (D3*D2*D'1*D0)'
     *      15、Z'14 = (D3*D2*D1*D'0)'
     *      16、Z'15 = (D3*D2*D1*D0)'
     */
    private void createOutput(MACHINE_CODE[] inputs) throws BaseCircuitException {
        if (inputs == null || inputs.length != NUMBER_OF_INPUT) {
            throw new BaseCircuitException("Decoder_4_16", "createOutput(MACHINE_CODE[] inputs)", "error input number!");
        }

        this.inputs = inputs;

        decoder_3_8_74HC138s[0].setInputValues(inputs[0], inputs[3], inputs[3],
                new MACHINE_CODE[] { inputs[6], inputs[5], inputs[4] });
        decoder_3_8_74HC138s[1].setInputValues(inputs[3], inputs[1], inputs[2],
                new MACHINE_CODE[] { inputs[6], inputs[5], inputs[4] });

        for (int i = 0; i < NUMBER_OF_OUTPUT; i++) {
            this.outputs[i] = decoder_3_8_74HC138s[i / 8].getOutputValue()[i % 8];
        }
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>4线-16线译码器</b> 输入端的值
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
     * 作用：设置 <b>4线-16线译码器</b> 输入端的值
     * 注意：D4数组是倒序赋值的
     * @param S1 控制器S1
     * @param _S2 控制器_S2
     * @param _S3 控制器_S3
     * @param D4 编码输入值：D3~D0
     */
    public void setInputValues(MACHINE_CODE S1, MACHINE_CODE _S2, MACHINE_CODE _S3, MACHINE_CODE[] D4) {
        try {
            createOutput(new MACHINE_CODE[]{
                S1, _S2, _S3,
                D4[3], D4[2], D4[1], D4[0]
            });
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>4线-16线译码器</b> 输入端的值
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
     * 作用：获取 <b>4线-16线译码器</b> 输出端的值
     *
     * @return 输出值
     */
    @Override
    public MACHINE_CODE[] getOutputValue() {
        return this.outputs;
    }
    
}
