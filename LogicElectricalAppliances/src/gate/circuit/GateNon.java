package gate.circuit;

import gate.Gate;
import gate.circuit.exception.BaseCircuitException;

/**
 * 类名：与非门
 * 作用：实现与非门的所有逻辑
 * @author 93710
 */
public class GateNon implements Gate {

    /**
     * 与非门 最小输入值
     */
    public final static int GATENON_MIN_INPUT_VALUE = 2;

    /**
     * 与非门的输入端的个数
     * 默认值：2
     */
    private int inputNums = GATENON_MIN_INPUT_VALUE;

    /**
     * 与非门的输出端的个数
     * 固定值：1
     */
    private final int outputNums = 1;

    /**
     * 与非门的输入端的值
     */
    private MACHINE_CODE[] inputs = new MACHINE_CODE[inputNums];

    /**
     * 与非门的输出端的值： output
     */
    private MACHINE_CODE[] outputs;

    /**
     * 与非门所依赖的 与门 和 非门
     */
    private GateAnd gateAnd = new GateAnd(inputs);
    private GateNot gateNot = new GateNot();

    /**
     * 默认无参的构造方法：构造缺省的与非门对象
     * 实现：
     * 1. 与非门的两个输入端都赋值为0
     * 2. 输出端的值由 createOutput 生成
     */
    public GateNon() {
        for (int i = 0; i < inputNums; i++) {
            this.inputs[i] = MACHINE_CODE.binary_0;
        }

        try {
            setInputValues(this.inputs);
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 含参的构造方法：使用输入端的值构造与非门对象
     * @param inputs 输入端的值
     */
    public GateNon(MACHINE_CODE[] inputs) {
        try {
            setInputValues(inputs);
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>与非门</b> 输出端的值
     * @return 新的输出值
     */
    private MACHINE_CODE[] createOutput() {
        try {
            gateAnd.setInputValues(inputs);
            gateNot.setInputValues(gateAnd.getOutputValue());
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }

        return this.outputs = gateNot.getOutputValue();
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>与非门</b> 输入端的值
     * @param inputs 输入端的值
     */
    public void setInputValues(MACHINE_CODE[] inputs) throws NullPointerException, BaseCircuitException {
        if (inputs == null) {
            throw new NullPointerException();
        } else if (inputs.length < GATENON_MIN_INPUT_VALUE) {
            throw new BaseCircuitException();
        } else {
            this.inputNums = inputs.length;
            this.inputs = inputs;
            createOutput();
        }
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>与非门</b> 输入端的值
     * @return 输入端的值
     */
    @Override
    public MACHINE_CODE[] getInputValues() {
        return this.inputs;
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>与非门</b> 输出端的值
     * @return 输出端的值
     */
    @Override
    public MACHINE_CODE[] getOutputValue() {
        return this.outputs;
    }
}
