package codeCreater;

/**
 * @Author: guc
 * @Description: 二维码生成异常
 * @Date: 2020/8/14 16:29
 * @Version: 1.0
 */
public class ACodeCreateException extends Exception {
    private Error error;
    private String fileName;

    public ACodeCreateException(String fileName, Error error) {
        this.error = error;
        this.fileName = fileName;
    }

    @Override
    public void printStackTrace() {
        System.err.println(toString());
    }

    @Override
    public String toString() {
        return "" + fileName + "生成错误：" + error.errcode + " " + error.errmsg;
    }
}
