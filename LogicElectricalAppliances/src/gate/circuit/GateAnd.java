package gate.circuit;

import gate.data.base.MACHINE_CODE;

/**
 * 类名：与门
 * 作用：实现与门的所有逻辑
 * @author 93710
 */
public class GateAnd implements Gate {

    /**
     * 与门的输入端的值
     */
    private MACHINE_CODE[] inputs;

    /**
     * 与门的输出端的值： output
     */
    private MACHINE_CODE output;

    /**
     * 默认无参的构造方法：构造缺省的与门对象
     * 实现：
     * 1. 与门的输入端都赋值为0
     * 2. 输出端的值由 createOutput 生成
     */
    public GateAnd() {
        this.inputs = new MACHINE_CODE[2];
        setInputValues(this.inputs);
    }

    /**
     * 含参的构造方法：使用输入端的值构造与门对象
     * @param inputs 输入端的值
     */
    public GateAnd(MACHINE_CODE[] inputs) {
        setInputValues(inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>与门</b> 输出端的值
     * @return 新的输出值
     */
    private MACHINE_CODE createOutput() {
        MACHINE_CODE out = MACHINE_CODE.binary_1;
        for (MACHINE_CODE input: this.inputs) {
            if (MACHINE_CODE.binary_0 == input) {
                out = MACHINE_CODE.binary_0;
                break;
            }
        }
        return this.output = out;
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>与门</b> 输入端的值
     * @param inputs 输入端的值
     */
    public void setInputValues(MACHINE_CODE[] inputs) {
        this.inputs = inputs;
        createOutput();
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>与门</b> 输入端的值
     * @return 输入端的值
     */
    @Override
    public MACHINE_CODE[] getInputValues() {
        return this.inputs;
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>与门</b> 输出端的值
     * @return 输出端的值
     */
    @Override
    public MACHINE_CODE getOutputValue() {
        return this.output;
    }
}
