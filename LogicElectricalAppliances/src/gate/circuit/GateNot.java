package gate.circuit;

import gate.data.base.MACHINE_CODE;

/**
 * 类名：非门
 * 作用：实现非门的所有逻辑
 */
public class GateNot implements Gate {

    /**
     * 非门的输入端的值： input
     */
    private MACHINE_CODE input;

    /**
     * 非门的输出端的值： output
     */
    private MACHINE_CODE output;

    /**
     * 默认无参的构造方法：构造缺省的非门对象
     * 实现：
     * 1. 非门的输入端赋值为0
     * 2. 输出端的值由 createOutput 生成
     */
    public GateNot() {
        setInputValues(MACHINE_CODE.binary_0);
    }

    /**
     * 含参的构造方法：使用输入端的值构造非门对象
     * @param input 输入端的值
     */
    public GateNot(MACHINE_CODE input) {
        setInputValues(input);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>非门</b> 输出端的值
     * @return 新的输出值
     */
    public MACHINE_CODE createOutput() {
        return this.output = this.input == MACHINE_CODE.binary_0 ? MACHINE_CODE.binary_1 : MACHINE_CODE.binary_0;
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>非门</b> 输入端的值
     * @param input 输入端的值
     */
    public void setInputValues(MACHINE_CODE input) {
        this.input = input;
        createOutput();
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>非门</b> 输入端的值
     * @return 输入端的值
     */
    @Override
    public MACHINE_CODE[] getInputValues() {
        return new MACHINE_CODE[] {this.input};
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>非门</b> 输出端的值
     * @return 输出端的值
     */
    @Override
    public MACHINE_CODE getOutputValue() {
        return this.output;
    }
}
