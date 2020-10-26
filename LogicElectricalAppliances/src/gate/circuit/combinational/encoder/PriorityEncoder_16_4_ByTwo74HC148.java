package gate.circuit.combinational.encoder;

import gate.Gate;
import gate.circuit.GateNon;
import gate.circuit.GateNot;
import gate.circuit.exception.BaseCircuitException;

/**
 * 类名：16线-4线优先编码器
 * 作用：实现 16线-4线优先编码器 的逻辑功能
 * 输入端：S'、A'0、A'1、A'2、A'3、A'4、A'5、A'6、A'7、A'8、A'9、A'10、A'11、A'12、A'13、A'14、A'15  -->
 * inputs[0]、inputs[1]、inputs[2]、inputs[3]、inputs[4]、inputs[5]、inputs[6]、inputs[7]、inputs[8]、
 * inputs[9]、inputs[10]、inputs[11]、inputs[12]、inputs[13]、inputs[14]、inputs[15]、inputs[16]
 * 输出端：Z3、Z2、Z1、Z0、Y's、Y'ex  -->  output[0]、output[1]、output[2]、output[3]、output[4]、output[5]
 *
 * 真值表：
 * ----------------------------------------------------------------------------------------------------------------------
 *                                         输入                                               |           输出
 * ----------------------------------------------------------------------------------------------------------------------
 *  S' | A'0  A'1  A'2  A'3  A'4  A'5  A'6  A'7  A'8  A'9  A'10  A'11  A'12  A'13  A'14  A'15 | Z3  Z2  Z1  Z0 | Y's  Y'ex
 * ----------------------------------------------------------------------------------------------------------------------
 *  1  |  x    x    x    x    x    x    x    x    x    x    x     x     x     x     x     x   |  0   0   0   0 |  1    1
 *  0  |  1    1    1    1    1    1    1    1    1    1    1     1     1     1     1     1   |  0   0   0   0 |  0    1
 *  0  |  x    x    x    x    x    x    x    x    x    x    x     x     x     x     x     0   |  1   1   1   1 |  1    1
 *  0  |  x    x    x    x    x    x    x    x    x    x    x     x     x     x     0     1   |  1   1   1   0 |  1    1
 *  0  |  x    x    x    x    x    x    x    x    x    x    x     x     x     0     1     1   |  1   1   0   1 |  1    1
 *  0  |  x    x    x    x    x    x    x    x    x    x    x     x     0     1     1     1   |  1   1   0   0 |  1    1
 *  0  |  x    x    x    x    x    x    x    x    x    x    x     0     1     1     1     1   |  1   0   1   1 |  1    1
 *  0  |  x    x    x    x    x    x    x    x    x    x    0     1     1     1     1     1   |  1   0   1   0 |  1    1
 *  0  |  x    x    x    x    x    x    x    x    x    0    1     1     1     1     1     1   |  1   0   0   1 |  1    1
 *  0  |  x    x    x    x    x    x    x    x    0    1    1     1     1     1     1     1   |  1   0   0   0 |  1    1
 *  0  |  x    x    x    x    x    x    x    0    1    1    1     1     1     1     1     1   |  0   1   1   1 |  1    0
 *  0  |  x    x    x    x    x    x    0    1    1    1    1     1     1     1     1     1   |  0   1   1   0 |  1    0
 *  0  |  x    x    x    x    x    0    1    1    1    1    1     1     1     1     1     1   |  0   1   0   1 |  1    0
 *  0  |  x    x    x    x    0    1    1    1    1    1    1     1     1     1     1     1   |  0   1   0   0 |  1    0
 *  0  |  x    x    x    0    1    1    1    1    1    1    1     1     1     1     1     1   |  0   0   1   1 |  1    0
 *  0  |  x    x    0    1    1    1    1    1    1    1    1     1     1     1     1     1   |  0   0   1   0 |  1    0
 *  0  |  x    0    1    1    1    1    1    1    1    1    1     1     1     1     1     1   |  0   0   0   1 |  1    0
 *  0  |  0    1    1    1    1    1    1    1    1    1    1     1     1     1     1     1   |  0   0   0   0 |  1    0
 * ----------------------------------------------------------------------------------------------------------------------
 *
 * @author 93710
 */
public class PriorityEncoder_16_4_ByTwo74HC148 implements Gate {
    /**
     * 16线-4线优先编码器 的输入端个数 17
     */
    private static final int NUMBER_OF_INPUT = 17;

    /**
     * 16线-4线优先编码器 的输出端个数 6
     */
    private static final int NUMBER_OF_OUTPUT = 6;

    /**
     * 输入 S'、A'0、A'1、A'2、A'3、A'4、A'5、A'6、A'7、A'8、A'9、A'10、A'11、A'12、A'13、A'14、A'15  对应
     * inputs[0]、inputs[1]、inputs[2]、inputs[3]、inputs[4]、inputs[5]、inputs[6]、inputs[7]、inputs[8]、
     * inputs[9]、inputs[10]、inputs[11]、inputs[12]、inputs[13]、inputs[14]、inputs[15]、inputs[16]
     */
    private MACHINE_CODE[] inputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0
    };

    /**
     * 输出 Z3、Z2、Z1、Z0、Y's、Y'ex  对应  outputs[0]、outputs[1]、outputs[2]、outputs[3]、outputs[4]、outputs[5]
     */
    private MACHINE_CODE[] outputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0,
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 16线-4线优先编码器 所依赖的 8线-3线优先编码器(74HC148) 非门、与非门
     */
    private PriorityEncoder_8_3_74HC148[] priorityEncoder_8_3_74HC148s = {
            new PriorityEncoder_8_3_74HC148(), new PriorityEncoder_8_3_74HC148()
    };

    private GateNot gateNot = new GateNot();

    private GateNon[] gateNons = {
            new GateNon(), new GateNon(), new GateNon()
    };

    /**
     * 默认无参的构造方法：构造缺省 16线-4线优先编码器 对象
     * 实现：
     * 1. 16线-4线优先编码器 的输入端赋值为 0
     * 2. 输出端的值由 createOutput 生成
     */
    public PriorityEncoder_16_4_ByTwo74HC148() {
        setInputValues(this.inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>8线-3线优先编码器</b> 输出端的值
     * 逻辑式：
     *      1. Z3 = (Y'1_ex)'
     *      2. Z2 = (Y'1_2 * Y'2_2)'
     *      3. Z1 = (Y'1_1 * Y'2_1)'
     *      4. Z0 = (Y'1_0 * Y'2_0)'
     *      5. Y's = Y'2_s
     *      6. Y'ex = Y'2_ex
     */
    private void createOutput(MACHINE_CODE[] inputs) throws BaseCircuitException {
        if (inputs == null || inputs.length != NUMBER_OF_INPUT) {
            throw new BaseCircuitException("PriorityEncoder_16_4_ByTwo74HC148",
                    "createOutput(MACHINE_CODE[] inputs)",
                    "error input number!");
        }

        try {
            this.inputs = inputs;

            priorityEncoder_8_3_74HC148s[0].setInputValues(new MACHINE_CODE[] {
                    inputs[0], inputs[9], inputs[10], inputs[11],
                    inputs[12], inputs[13], inputs[14], inputs[15],
                    inputs[16]
            });
            priorityEncoder_8_3_74HC148s[1].setInputValues(new MACHINE_CODE[] {
                    priorityEncoder_8_3_74HC148s[0].getOutputValue()[3],
                    inputs[1], inputs[2], inputs[3], inputs[4], inputs[5], inputs[6], inputs[7], inputs[8]
            });
            gateNot.setInputValues(new MACHINE_CODE[] {
                    priorityEncoder_8_3_74HC148s[0].getOutputValue()[4]
            });
            gateNons[0].setInputValues(new MACHINE_CODE[] {
                    priorityEncoder_8_3_74HC148s[0].getOutputValue()[2],
                    priorityEncoder_8_3_74HC148s[1].getOutputValue()[2]
            });
            gateNons[1].setInputValues(new MACHINE_CODE[] {
                    priorityEncoder_8_3_74HC148s[0].getOutputValue()[1],
                    priorityEncoder_8_3_74HC148s[1].getOutputValue()[1]
            });
            gateNons[2].setInputValues(new MACHINE_CODE[] {
                    priorityEncoder_8_3_74HC148s[0].getOutputValue()[0],
                    priorityEncoder_8_3_74HC148s[1].getOutputValue()[0]
            });

            this.outputs[0] = gateNot.getOutputValue()[0];
            this.outputs[1] = gateNons[2].getOutputValue()[0];
            this.outputs[2] = gateNons[1].getOutputValue()[0];
            this.outputs[3] = gateNons[0].getOutputValue()[0];
            this.outputs[4] = priorityEncoder_8_3_74HC148s[1].getOutputValue()[3];
            this.outputs[5] = priorityEncoder_8_3_74HC148s[1].getOutputValue()[4];
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>16线-4线优先编码器</b> 输入端的值
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
     * 作用：设置 <b>16线-4线优先编码器</b> 输入端的值
     * @param _S 控制器S'：S'=1时，所有输出端均被封锁在高电平；S'=0时，编码器正常工作
     * @param _A16 编码输入值：A'0 ~ A'15
     */
    public void setInputValues(MACHINE_CODE _S, MACHINE_CODE[] _A16) {
        try {
            createOutput(new MACHINE_CODE[]{
                    _S,
                    _A16[0], _A16[1], _A16[2], _A16[3], _A16[4], _A16[5], _A16[6], _A16[7],
                    _A16[8], _A16[9], _A16[10], _A16[11], _A16[12], _A16[13], _A16[14], _A16[15]
            });
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
