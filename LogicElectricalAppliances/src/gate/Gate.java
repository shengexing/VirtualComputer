package gate;

import gate.circuit.exception.BaseCircuitException;

/**
 * 接口名：门
 * 作用：作为与、或、非门的基础接口
 * @author 93710
 */
public interface Gate {

    /**
     * MACHINE_CODE : 定义机器码的枚举值（0, 1）
     */
    public static enum MACHINE_CODE {
        binary_0, binary_1
    }

    /**
     * 方法名：创建非空的 MACHINE_CODE[][] 二维数组
     * @param row 二维数组的行
     * @param col 二维数组的列
     * @return
     */
    static MACHINE_CODE[][] getMachineCodeArray(int row, int col) {
        MACHINE_CODE[][] result = new MACHINE_CODE[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = MACHINE_CODE.binary_0;
            }
        }

        return result;
    }

    /**
     * 方法名：逻辑与运算
     * @param c0 输入1
     * @param c1 输入2
     * @return 结果
     */
    static MACHINE_CODE and(MACHINE_CODE c0, MACHINE_CODE c1){
        if (MACHINE_CODE.binary_0 == c0 || MACHINE_CODE.binary_0 == c1) {
            return MACHINE_CODE.binary_0;
        } else {
            return MACHINE_CODE.binary_1;
        }
    }

    /**
     * 方法名：逻辑或运算
     * @param c0 输入1
     * @param c1 输入2
     * @return 结果
     */
    static MACHINE_CODE or(MACHINE_CODE c0, MACHINE_CODE c1){
        if (MACHINE_CODE.binary_1 == c0 || MACHINE_CODE.binary_1 == c1) {
            return MACHINE_CODE.binary_1;
        } else {
            return MACHINE_CODE.binary_0;
        }
    }

    /**
     * 方法名：逻辑非运算
     * @param c 输入
     * @return 结果
     */
    static MACHINE_CODE not(MACHINE_CODE c) {
        if (MACHINE_CODE.binary_0 == c) {
            return MACHINE_CODE.binary_1;
        } else {
            return MACHINE_CODE.binary_0;
        }
    }

    /**
     * 方法名：获取输入端的值
     * 作用：获取 <b>门</b> 输入端的值
     * @return 输入值
     * @throws BaseCircuitException
     */
    MACHINE_CODE[] getInputValues() throws BaseCircuitException;

    /**
     * 方法名：获取输出端的值
     * 作用：获取 <b>门</b> 输出端的值
     * @return 输出值
     */
    MACHINE_CODE[] getOutputValue();

}
