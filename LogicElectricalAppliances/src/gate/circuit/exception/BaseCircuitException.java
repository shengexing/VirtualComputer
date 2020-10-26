package gate.circuit.exception;

/**
 * 门电路基础的异常类
 * @author 93710
 */
public class BaseCircuitException extends Exception{

    private String className = "ClassName";
    private String functionName = "FunctionName";
    private String message = "exception message";

    public BaseCircuitException() {
        super();
    }

    public BaseCircuitException(String className, String functionName, String message) {
        super("{" + className + "}[" + functionName + "](" + message + ")");
    }
}
