package gate.circuit;

import gate.Gate;
import gate.circuit.exception.BaseCircuitException;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名：与或非门
 * 作用：实现 与或非门 的所有逻辑
 * @author 93710
 */
public class GateAoi implements Gate {

    /**
     * 与或非门 最小输入值
     */
    public final static int GATEAOI_MIN_INPUT_VALUE = 4;

    /**
     * 与或非门的输入端的个数
     * 默认值：2
     */
    private int inputNums = GATEAOI_MIN_INPUT_VALUE;

    /**
     * 与或非门的输出端的个数
     * 固定值：1
     */
    private final int outputNums = 1;

    /**
     * 与或非门的输入端的值
     */
    private List<MACHINE_CODE[]> inputs = new ArrayList<MACHINE_CODE[]>();

    /**
     * 与或非门的输出端的值： output
     */
    private MACHINE_CODE[] outputs = new MACHINE_CODE[outputNums];

    /**
     * 与非门所依赖的 与门 或门 非门
     */
    private GateAnd[] gateAnds = new GateAnd[] {new GateAnd(), new GateAnd()};
    private GateNor gateNor = new GateNor();

    /**
     * 默认无参的构造方法：构造缺省的与或非门对象
     * 实现：
     * 1. 与非门的输入端都赋值为0
     * 2. 输出端的值由 createOutput 生成
     */
    public GateAoi() {
        this.inputs.add(Gate.getMachineCodeArray(1, 2)[0]);
        this.inputs.add(Gate.getMachineCodeArray(1, 2)[0]);
        setInputValues(inputs);
    }

    /**
     * 含参的构造方法：使用输入端的值构造与或非门对象
     * @param inputs 输入端的值
     */
    public GateAoi(List<MACHINE_CODE[]> inputs) {
        this.inputs = inputs;
        int i = 0;
        for (MACHINE_CODE[] inputArray: inputs) {
            gateAnds[i++] = new GateAnd(inputArray);
        }
        setInputValues(inputs);
    }

    /**
     * 方法名：创建输出端的值
     * 作用：创建 <b>与或非门</b> 输出端的值
     * @return 新的输出值
     */
    private MACHINE_CODE[] createOutput() {
        MACHINE_CODE[] gateNor_inputs = new MACHINE_CODE[gateAnds.length];

        for (int i = 0; i < gateAnds.length; i++) {
            try {
                gateAnds[i].setInputValues(inputs.get(i));
            } catch (BaseCircuitException e) {
                e.printStackTrace();
            }
            gateNor_inputs[i] = gateAnds[i].getOutputValue()[0];
        }

        try {
            gateNor.setInputValues(gateNor_inputs);
        } catch (BaseCircuitException e) {
            e.printStackTrace();
        }

        return this.outputs = gateNor.getOutputValue();
    }

    /**
     * 方法名：设置输入端的值
     * 作用：设置 <b>与或非门</b> 输入端的值
     * @param inputs 输入端的值
     */
    public void setInputValues(List<MACHINE_CODE[]> inputs) {
        this.inputs = inputs;
        createOutput();
    }

    /**
     * 方法名：获取输入端的值(真实值)
     * 作用：获取 <b>与或非门</b> 输入端的值
     * @return 输入端的值
     */
    public List<MACHINE_CODE[]> getInputValuesReal() {
        return this.inputs;
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>与或非门</b> 输入端的值
     * @return 输入端的值
     */
    @Override
    public MACHINE_CODE[] getInputValues() throws BaseCircuitException {
        throw new BaseCircuitException(this.getClass().getName(), "getInputValues()", "Call illegal function!");
    }

    /**-
     * 方法名：获取输出端的值
     * 作用：获取 <b>与或非门</b> 输出端的值
     * @return 输出端的值
     */
    @Override
    public MACHINE_CODE[] getOutputValue() {
        return this.outputs;
    }

}
