package gate.circuit;

import gate.Gate;

/**
 * 类名：非门
 * 作用：实现非门的所有逻辑
 */
public class GateNot implements Gate {

    /**
     * 非门的输入端的个数
     * 固定值：1
     */
    private final int inputNums = 1;

    /**
     * 非门的输出端的个数
     * 固定值：1
     */
    private final int outputNums = 1;

    /**
     * 非门的输入端的值： input
     */
    private MACHINE_CODE[] inputs = new MACHINE_CODE[inputNums];

    /**
     * 非门的输出端的值： output
     */
    private MACHINE_CODE[] outputs = new MACHINE_CODE[outputNums];

    /**
     * 默认无参的构造方法：构造缺省的非门对象
     * 实现：
     * 1. 非门的输入端赋值为0
     * 2. 输出端的值由 createOutput 生成
     */
    public GateNot() {
        for (int i = 0; i < inputNums; i++) {
            this.inputs[i] = MACHINE_CODE.binary_0;
        }

        setInputValues(this.inputs);
    }

    /**
     * 含参的构造方法：使用输入端的值构造非门对象
     * @param inputs 输入端的值
     */
    public GateNot(MACHINE_CODE[] inputs) {
        setInputValues(inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>非门</b> 输出端的值
     * @return 新的输出值
     */
    public MACHINE_CODE[] createOutput() {
        this.outputs[0] = this.inputs[0] == MACHINE_CODE.binary_0 ? MACHINE_CODE.binary_1 : MACHINE_CODE.binary_0;
        return this.outputs;
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>非门</b> 输入端的值
     * @param inputs 输入端的值
     */
    public void setInputValues(MACHINE_CODE[] inputs) throws NullPointerException{
        this.inputs = inputs;
        createOutput();
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>非门</b> 输入端的值
     * @return 输入端的值
     */
    @Override
    public MACHINE_CODE[] getInputValues() {
        return this.inputs;
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>非门</b> 输出端的值
     * @return 输出端的值
     */
    @Override
    public MACHINE_CODE[] getOutputValue() {
        return this.outputs;
    }
}
