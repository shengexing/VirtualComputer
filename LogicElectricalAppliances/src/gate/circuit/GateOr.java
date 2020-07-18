package gate.circuit;

import gate.data.base.MACHINE_CODE;

/**
 * 类名：或门
 * 作用：实现或门的所有逻辑
 * @author 93710
 */
public class GateOr implements Gate {

    /**
     * 或门的输入端的值
     */
    private MACHINE_CODE[] inputs;

    /**
     * 或门的输出端的值： output
     */
    private MACHINE_CODE output;

    /**
     * 默认无参的构造方法：构造缺省的或门对象
     * 实现：
     * 1. 或门的两个输入端都赋值为0
     * 2. 输出端的值由 createOutput 生成
     */
    public GateOr() {
        this.inputs = new MACHINE_CODE[2];
        setInputValues(this.inputs);
    }

    /**
     * 含参的构造方法：使用输入端的值构造或门对象
     * @param inputs 输入端的值
     */
    public GateOr(MACHINE_CODE[] inputs) {
        setInputValues(inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>或门</b> 输出端的值
     * @return 新的输出值
     */
    public MACHINE_CODE createOutput() {
        MACHINE_CODE out = MACHINE_CODE.binary_0;
        for (MACHINE_CODE input: this.inputs) {
            if (MACHINE_CODE.binary_1 == input) {
                out = MACHINE_CODE.binary_1;
                break;
            }
        }
        return this.output = out;
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>或门</b> 输入端的值
     * @param inputs 输入端的值
     */
    public void setInputValues(MACHINE_CODE[] inputs) {
        this.inputs = inputs;
        createOutput();
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>或门</b> 输入端的值
     * @return 输入端的值
     */
    @Override
    public MACHINE_CODE[] getInputValues() {
        return this.inputs;
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>或门</b> 输出端的值
     * @return 输出端的值
     */
    @Override
    public MACHINE_CODE getOutputValue() {
        return this.output;
    }
}
