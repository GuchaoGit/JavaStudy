package codeCreater;

/**
 * @Author: guc
 * @Description: token获取异常
 * @Date: 2020/8/14 15:44
 * @Version: 1.0
 */
public class AccessTokenException extends Exception {
    @Override
    public void printStackTrace() {
        System.err.println(toString());
    }

    @Override
    public String toString() {
        return "access_token获取异常";
    }
}
