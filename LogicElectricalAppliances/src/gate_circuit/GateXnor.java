package gate_circuit;

/**
 * 类名：同或门
 * 作用：实现同或门的所有逻辑
 */
public class GateXnor implements Gate {
    /* 同或门的两个输入端的值： input0, input1 */
    private byte input0;
    private byte input1;

    /* 同或门的输出端的值： output */
    private byte output;

    /* 同或门所依赖的 与门 或门 非门 */
    private GateNot gateNot0 = new GateNot();
    private GateNot gateNot1 = new GateNot();
    private GateAnd gateAnd0 = new GateAnd();
    private GateAnd gateAnd1 = new GateAnd();
    private GateOr gateOr= new GateOr();

    /**
     * 默认无参的构造方法：构造缺省的同或门对象
     * 实现：
     * 1. 同或门的两个输入端都赋值为0
     * 2. 输出端的值由 createOutput 生成
     */
    public GateXnor() {
        setInputValues((byte) 0, (byte) 0);
    }

    /**
     * 含参的构造方法：使用输入端的值构造同或门对象
     * @param input0 输入端 0 的值
     * @param input1 输入端 1 的值
     */
    public GateXnor(byte input0, byte input1) {
        setInputValues(input0, input1);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>同或门</b> 输出端的值
     * @return 新的输出值
     */
    private byte createOutput() {
        gateNot0.setInputValues(input0);
        gateNot1.setInputValues(input1);
        gateAnd0.setInputValues(new byte[] {input0, input1});
        gateAnd1.setInputValues(new byte[] {gateNot0.getOutputValue(), gateNot1.getOutputValue()});
        gateOr.setInputValues(new byte[] {gateAnd0.getOutputValue(), gateAnd1.getOutputValue()});
        return this.output = gateOr.getOutputValue();
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>同或门</b> 输入端的值
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
     * 作用：获取 <b>同或门</b> 输入端的值
     * @return
     */
    @Override
    public byte[] getInputValues() {
        return new byte[] {this.input0, this.input1};
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>同或门</b> 输出端的值
     * @return
     */
    @Override
    public byte getOutputValue() {
        return this.output;
    }
}
