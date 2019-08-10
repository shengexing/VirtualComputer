package gate_circuit;

/**
 * 类名：与或非门
 * 作用：实现 与或非门 的所有逻辑
 */
public class GateAoi implements Gate {

    /* 与或非门的输入端的值 */
    private byte[][] inputs;

    /* 与或非门的输出端的值： output */
    private byte output;

    /* 与非门所依赖的 与门 或门 非门 */
    private GateAnd[] gateAnds = new GateAnd[] {new GateAnd(), new GateAnd()};
    private GateNor gateNor = new GateNor();

    /**
     * 默认无参的构造方法：构造缺省的与或非门对象
     * 实现：
     * 1. 与非门的输入端都赋值为0
     * 2. 输出端的值由 createOutput 生成
     */
    public GateAoi() {
        this.inputs = new byte[2][2];
        setInputValues(inputs);
    }

    /**
     * 含参的构造方法：使用输入端的值构造与或非门对象
     * @param inputs 输入端的值
     */
    public GateAoi(byte[][] inputs) {
        this.inputs = inputs;
        gateAnds = new GateAnd[inputs.length];
        setInputValues(inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>与或非门</b> 输出端的值
     * @return 新的输出值
     */
    private byte createOutput() {
        byte[] gateNor_inputs = new byte[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            gateAnds[i].setInputValues(inputs[i]);
            gateNor_inputs[i] = gateAnds[i].getOutputValue();
        }
        gateNor.setInputValues(gateNor_inputs);

        return this.output = gateNor.getOutputValue();
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>与或非门</b> 输入端的值
     * @param inputs 输入端的值
     */
    public void setInputValues(byte[][] inputs) {
        this.inputs = inputs;
        createOutput();
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>与或非门</b> 输入端的值
     * @return
     */
    @Override
    public byte[] getInputValues() {
        byte[] result;

        int len = 0;
        for (int i = 0; i < inputs.length; i++) {
            len += inputs[i].length;
        }
        result = new byte[len];

        int t = 0;
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs[i].length; j++) {
                result[t++] = inputs[i][j];
            }
        }

        return result;
    }

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>与或非门</b> 输出端的值
     * @return
     */
    @Override
    public byte getOutputValue() {
        return this.output;
    }
}
