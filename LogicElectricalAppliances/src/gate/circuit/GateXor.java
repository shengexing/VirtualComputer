package gate.circuit;

import gate.Gate;
import gate.circuit.exception.BaseCircuitException;

/**
 * 类名：异或门
 * 作用：实现异或门的所有逻辑
 */
public class GateXor implements Gate {

    /**
     * 异或门的输入端的个数
     * 固定值：2
     */
    private final int inputNums = 2;

    /**
     * 异或门的输出端的个数
     * 固定值：1
     */
    private final int outputNums = 1;

    /**
     * 异或门的输入端的值
     */
    private MACHINE_CODE[] inputs = new MACHINE_CODE[inputNums];

    /**
     * 异或门的输出端的值： output
     */
    private MACHINE_CODE[] outputs = new MACHINE_CODE[outputNums];

    /**
     * 异或门所依赖的 与门 或门 非门
     */
    private GateNot gateNot0 = new GateNot();
    private GateNot gateNot1 = new GateNot();
    private GateOr gateOr0 = new GateOr();
    private GateOr gateOr1 = new GateOr();
    private GateAnd gateAnd = new GateAnd();

    /**
     * 默认无参的构造方法：构造缺省的异或门对象
     * 实现：
     * 1. 异或门的两个输入端都赋值为0
     * 2. 输出端的值由 createOutput 生成
     */
    public GateXor() {
        setInputValues(MACHINE_CODE.binary_0, MACHINE_CODE.binary_0);
    }

    /**
     * 含参的构造方法：使用输入端的值构造异或门对象
     * @param input0 输入端 0 的值
     * @param input1 输入端 1 的值
     */
    public GateXor(MACHINE_CODE input0, MACHINE_CODE input1) {
        setInputValues(input0, input1);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>异或门</b> 输出端的值
     * @return 新的输出值
     */
    private MACHINE_CODE[] createOutput() {
        try {
            gateNot0.setInputValues(new MACHINE_CODE[]{this.inputs[0]});
            gateNot1.setInputValues(new MACHINE_CODE[]{this.inputs[1]});
            gateOr0.setInputValues(this.inputs);
            gateOr1.setInputValues(new MACHINE_CODE[] {gateNot0.getOutputValue()[0], gateNot1.getOutputValue()[0]});
            gateAnd.setInputValues(new MACHINE_CODE[] {gateOr0.getOutputValue()[0], gateOr1.getOutputValue()[0]});
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }
        return this.outputs = gateAnd.getOutputValue();
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>异或门</b> 输入端的值
     * @param input0 输入端 0 的值
     * @param input1 输入端 1 的值
     */
    public void setInputValues(MACHINE_CODE input0, MACHINE_CODE input1) {
        this.inputs[0] = input0;
        this.inputs[1] = input1;
        createOutput();
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>异或门</b> 输入端的值
     * @return 输入端的值
     */
    @Override
    public MACHINE_CODE[] getInputValues() {
        return this.inputs;
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>异或门</b> 输出端的值
     * @return 输出端的值
     */
    @Override
    public MACHINE_CODE[] getOutputValue() {
        return this.outputs;
    }
}
