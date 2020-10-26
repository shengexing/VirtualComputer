package gate.circuit.combinational.encoder;

import gate.Gate;
import gate.circuit.GateOr;
import gate.circuit.exception.BaseCircuitException;

/**
 * 类名：8线-3线编码器
 * 作用：实现 8线-3线编码器 的逻辑功能
 * 输入端：I0、I1、I2、I3、I4、I5、I6、I7  -->  inputs[0]、inputs[1]、inputs[2]、inputs[3]、inputs[4]、inputs[5]、inputs[6]、inputs[7]
 * 输出端：Y2、Y1、Y0  -->  output[0]、output[1]、output[2]
 * 规则：I[n] = 1 -> Y = n
 * @author 93710
 */
public class Encoder_8_3 implements Gate {

    /**
     * 8线-3线编码器 的输入端个数 8
     */
    private static final int NUMBER_OF_INPUT = 8;

    /**
     * 8线-3线编码器 的输出端个数 3
     */
    private static final int NUMBER_OF_OUTPUT = 3;

    /**
     * 输入 I0、I1、I2、I3、I4、I5、I6、I7 对应 inputs[0]、inputs[1]、inputs[2]、inputs[3]、inputs[4]、inputs[5]、inputs[6]、inputs[7]
     */
    private MACHINE_CODE[] inputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 输出 Y2、Y1、Y0 对应 output[0]、output[1]、output[2]
     */
    private MACHINE_CODE[] outputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 8线-3线编码器 所依赖的 或门
     */
    private GateOr[] gateOrs_level1_in4 = {
            new GateOr(Gate.getMachineCodeArray(1,4)[0]),
            new GateOr(Gate.getMachineCodeArray(1,4)[0]),
            new GateOr(Gate.getMachineCodeArray(1,4)[0])
    };

    /**
     * 默认无参的构造方法：构造缺省 8线-3线编码器 对象
     * 实现：
     * 1. 8线-3线编码器 的输入端赋值为 0
     * 2. 输出端的值由 createOutput 生成
     */
    public Encoder_8_3() {
        setInputValues(this.inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>8线-3线编码器</b> 输出端的值
     * 逻辑式：
     *      1. Y2 = I4 + I5 + I6 + I7
     *      2. Y1 = I2 + I3 + I6 + I7
     *      3. Y0 = I1 + I3 + I5 + I7
     */
    private void createOutput(MACHINE_CODE[] inputs) throws BaseCircuitException {
        if (inputs == null || inputs.length != NUMBER_OF_INPUT) {
            throw new BaseCircuitException("Encoder_8_3", "createOutput(MACHINE_CODE[] inputs)", "error input number!");
        }

        try {
            this.inputs = inputs;
            gateOrs_level1_in4[0].setInputValues(new MACHINE_CODE[]{
                    inputs[4], inputs[5], inputs[6], inputs[7]
            });
            gateOrs_level1_in4[1].setInputValues(new MACHINE_CODE[]{
                    inputs[2], inputs[3], inputs[6], inputs[7]
            });
            gateOrs_level1_in4[2].setInputValues(new MACHINE_CODE[]{
                    inputs[1], inputs[3], inputs[5], inputs[7]
            });
            this.outputs[0] = gateOrs_level1_in4[0].getOutputValue()[0];
            this.outputs[1] = gateOrs_level1_in4[1].getOutputValue()[0];
            this.outputs[2] = gateOrs_level1_in4[2].getOutputValue()[0];
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>8线-3线编码器</b> 输入端的值
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
     * @return 输入端的值
     * @throws BaseCircuitException
     */
    @Override
    public MACHINE_CODE[] getInputValues() throws BaseCircuitException {
        return this.inputs;
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>8线-3线编码器</b> 输出端的值
     * @return
     */
    @Override
    public MACHINE_CODE[] getOutputValue() {
        return this.outputs;
    }
}
