package gate_circuit;

/**
 * 类名：与门
 * 作用：实现与门的所有逻辑
 */
public class GateAnd implements Gate {

    /* 与门的两个输入端的值： input0, input1 */
    private byte input0;
    private byte input1;

    /* 与门的输出端的值： output */
    private byte output;

    /**
     * 默认无参的构造方法：构造缺省的与门对象
     * 实现：
     * 1. 与门的两个输出端都赋值为0
     * 2. 输出端的值由
     */
    public GateAnd() {
        input0 = 0; input1 = 0; output = createOutput();
    }

    /**
     * 含参的构造方法：使用输入端的值构造玉门对象
     * @param input0
     * @param input1
     */
    public GateAnd(byte input0, byte input1) {
        this.input0 = input0;
        this.input1 = input1;
        this.output = createOutput();
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>与门</b> 输入端的值
     * @return 新的输出值
     */
    public byte createOutput() {
        this.output = (byte) (this.input0 & this.input1);
        return this.output;
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>与门</b> 输入端的值
     * @param input0 输入端 0 的值
     * @param input1 输入端 1 的值
     */
    public void setInputValues(byte input0, byte input1) {
        this.input0 = input0;
        this.input1 = input1;
        createOutput();
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>与门</b> 输入端的值
     * @return
     */
    @Override
    public int[] getInputValues() {
        return new int[] {this.input0, this.input1};
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>与门</b> 输出端的值
     * @return
     */
    @Override
    public int getOutputValue() {
        return this.output;
    }
}
