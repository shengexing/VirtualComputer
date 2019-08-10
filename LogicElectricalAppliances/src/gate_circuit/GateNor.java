package gate_circuit;

/**
 * 类名：或非门
 * 作用：实现或非门的所有逻辑
 */
public class GateNor implements Gate {

    /* 或非门的输入端的值 */
    private byte[] inputs;

    /* 或非门的输出端的值： output */
    private byte output;

    /* 或非门所依赖的 或门 和 非门 */
    private GateOr gateOr = new GateOr();
    private GateNot gateNot = new GateNot();

    /**
     * 默认无参的构造方法：构造缺省的或非门对象
     * 实现：
     * 1. 或非门的两个输入端都赋值为0
     * 2. 输出端的值由 createOutput 生成
     */
    public GateNor() {
        this.inputs = new byte[2];
        setInputValues(this.inputs);
    }

    /**
     * 含参的构造方法：使用输入端的值构造或非门对象
     * @param inputs 输入端的值
     */
    public GateNor(byte[] inputs) {
        setInputValues(inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>或非门</b> 输出端的值
     * @return 新的输出值
     */
    private byte createOutput() {
        gateOr.setInputValues(inputs);
        gateNot.setInputValues(gateOr.getOutputValue());
        return this.output = gateNot.getOutputValue();
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>或非门</b> 输入端的值
     * @param inputs 输入端的值
     */
    public void setInputValues(byte[] inputs) {
        this.inputs = inputs;
        createOutput();
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>或非门</b> 输入端的值
     * @return
     */
    @Override
    public byte[] getInputValues() {
        return this.inputs;
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>或非门</b> 输出端的值
     * @return
     */
    @Override
    public byte getOutputValue() {
        return this.output;
    }
}
