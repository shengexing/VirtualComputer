package gate.circuit;

import gate.data.base.MACHINE_CODE;

/**
 * 接口名：门
 * 作用：作为与、或、非门的基础接口
 * @author 93710
 */
public interface Gate {
    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>门</b> 输入端的值
     * @return 输入值
     */
    MACHINE_CODE[] getInputValues();

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>门</b> 输出端的值
     * @return 输出值
     */
    MACHINE_CODE getOutputValue();

}
