package gate_circuit;

/**
 * 接口名：门
 * 作用：作为与、或、非门的基础接口
 */
public interface Gate {

    /**
     * 常量名：机器码
     * 含义：计算机中的机器码（0,1）
     */
    public static final byte[] MACHINE_CODE = new byte[] {0, 1};

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>门</b> 输入端的值
     * @return 输入值
     */
    byte[] getInputValues();

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>门</b> 输出端的值
     * @return 输出值
     */
    byte getOutputValue();

}
