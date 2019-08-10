package gate_circuit;

/**
 * 类名：非门
 * 作用：实现非门的所有逻辑
 */
public class GateNot implements Gate {

    /* 非门的输入端的值： input */
    private byte input;

    /* 非门的输出端的值： output */
    private byte output;

    /**
     * 默认无参的构造方法：构造缺省的非门对象
     * 实现：
     * 1. 非门的输入端赋值为0
     * 2. 输出端的值由 createOutput 生成
     */
    public GateNot() {
        setInputValues((byte) 0);
    }

    /**
     * 含参的构造方法：使用输入端的值构造非门对象
     * @param input 输入端的值
     */
    public GateNot(byte input) {
        setInputValues(input);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>非门</b> 输出端的值
     * @return 新的输出值
     */
    public byte createOutput() {
        return this.output = (byte) (~this.input + 2);
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>非门</b> 输入端的值
     * @param input 输入端的值
     */
    public void setInputValues(byte input) {
        this.input = input;
        createOutput();
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>非门</b> 输入端的值
     * @return
     */
    @Override
    public byte[] getInputValues() {
        return new byte[] {this.input};
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>非门</b> 输出端的值
     * @return
     */
    @Override
    public byte getOutputValue() {
        return this.output;
    }
}
