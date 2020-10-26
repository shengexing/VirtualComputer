package gate.circuit.combinational;

import gate.Gate;
import gate.circuit.GateNon;
import gate.circuit.GateNot;
import gate.circuit.exception.BaseCircuitException;

/**
 * 类名：简易 DCBA 组合逻辑电路
 * 作用：实现判断 0~15 的数值范围
 * 输入端：D、C、B、A  -->  input[0]、input[1]、input[2]、input[3]
 * 输出端：Y2、Y1、Y0  -->  output[0]、output[1]、output[2]
 * 规则：[0, 5] -> 1
 *      [6, 10] -> 2
 *      [11, 15] -> 4
 * @author 93710
 */
public class EasyDCBA implements Gate {

    /**
     * DCBA 的输入端个数 4
     */
    private static final int NUMBER_OF_INPUT = 4;

    /**
     * DCBA 的输出端个数 3
     */
    private static final int NUMBER_OF_OUTPUT = 3;

    /**
     * 输入 D、C、B、A 对应 inputs[0]、inputs[1]、inputs[2]、inputs[3]
     */
    private MACHINE_CODE[] inputs = new MACHINE_CODE[]{
            MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 输出 Y2、Y1、Y0 对应 outputs[0]、outputs[1]、outputs[2]
     */
    private MACHINE_CODE[] outputs = new MACHINE_CODE[]{
        MACHINE_CODE.binary_0, MACHINE_CODE.binary_0, MACHINE_CODE.binary_0
    };

    /**
     * 简易 DCBA 组合逻辑电路 所依赖的 与门 或门 非门
     */
    private GateNot[] gateNot_level1_in1 = new GateNot[]{
            new GateNot(), new GateNot(), new GateNot(), new GateNot()
    };
    private GateNon[] gateNons_level2_in2 = new GateNon[]{
            new GateNon(), new GateNon(), new GateNon()
    };
    private GateNon[] gateNons_level2_in3 = new GateNon[]{
            new GateNon(), new GateNon(), new GateNon(), new GateNon()
    };
    private GateNon[] gateNons_level3_in2 = new GateNon[]{
            new GateNon(), new GateNon()
    };
    private GateNon[] gateNons_level3_in3 = new GateNon[]{
            new GateNon()
    };

    /**
     * 默认无参的构造方法：构造缺省 DCBA 对象
     * 实现：
     * 1. DCBA 的输入端赋值为 0
     * 2. 输出端的值由 createOutput 生成
     */
    public EasyDCBA() {
        setInputValues(this.inputs);
    }

    /**
     * 含参的构造方法：使用输入端的值构造 DCBA 对象
     * @param inputs
     */
    public EasyDCBA(MACHINE_CODE[] inputs) {
        setInputValues(inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>DCBA</b> 输出端的值
     */
    private void createOutput(MACHINE_CODE[] inputs) throws BaseCircuitException {
        if (inputs == null || inputs.length != NUMBER_OF_INPUT) {
            throw new BaseCircuitException("EasyDCBA", "createOutput(MACHINE_CODE[] inputs)", "error input number!");
        }

        this.inputs = inputs;
        try {
            for (int i = 0; i < inputs.length; i++) {
                gateNot_level1_in1[i].setInputValues(new MACHINE_CODE[]{inputs[i]});
            }

            gateNons_level2_in2[0].setInputValues(new MACHINE_CODE[]{
                    inputs[0], inputs[1]
            });
            gateNons_level2_in2[1].setInputValues(new MACHINE_CODE[]{
                    gateNot_level1_in1[0].getOutputValue()[0], gateNot_level1_in1[2].getOutputValue()[0]
            });
            gateNons_level2_in2[2].setInputValues(new MACHINE_CODE[]{
                    gateNot_level1_in1[0].getOutputValue()[0], gateNot_level1_in1[1].getOutputValue()[0]
            });

            gateNons_level2_in3[0].setInputValues(new MACHINE_CODE[]{
                    inputs[0], inputs[2], inputs[3]
            });
            gateNons_level2_in3[1].setInputValues(new MACHINE_CODE[]{
                    inputs[0], gateNot_level1_in1[1].getOutputValue()[0], gateNot_level1_in1[3].getOutputValue()[0]
            });
            gateNons_level2_in3[2].setInputValues(new MACHINE_CODE[]{
                    inputs[0], gateNot_level1_in1[1].getOutputValue()[0], gateNot_level1_in1[2].getOutputValue()[0]
            });
            gateNons_level2_in3[3].setInputValues(new MACHINE_CODE[]{
                    gateNot_level1_in1[0].getOutputValue()[0], inputs[1], inputs[2]
            });

            gateNons_level3_in2[0].setInputValues(new MACHINE_CODE[]{
                    gateNons_level2_in3[0].getOutputValue()[0], gateNons_level2_in2[0].getOutputValue()[0]
            });
            gateNons_level3_in2[1].setInputValues(new MACHINE_CODE[]{
                    gateNons_level2_in2[1].getOutputValue()[0], gateNons_level2_in2[2].getOutputValue()[0]
            });

            gateNons_level3_in3[0].setInputValues(new MACHINE_CODE[]{
                    gateNons_level2_in3[1].getOutputValue()[0],
                    gateNons_level2_in3[2].getOutputValue()[0],
                    gateNons_level2_in3[3].getOutputValue()[0]
            });

            this.outputs[0] = gateNons_level3_in2[0].getOutputValue()[0];
            this.outputs[1] = gateNons_level3_in3[0].getOutputValue()[0];
            this.outputs[2] = gateNons_level3_in2[1].getOutputValue()[0];
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>DCBA</b> 输入端的值
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
     * 作用：获取 <b>DCBA</b> 输出端的值
     * @return 输出端的值
     */
    @Override
    public MACHINE_CODE[] getOutputValue() {
        return this.outputs;
    }

}
