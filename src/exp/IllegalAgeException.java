package exp;

/**
 * @Author guc
 * @Date 2019/11/19 12:00
 * @Description 年龄不合法异常
 */
public class IllegalAgeException extends Exception {
    private double age;

    public IllegalAgeException(double age) {
        this.age = age;
    }

    public double getAge() {
        return age;
    }

    @Override
    public String getMessage() {
        return getAge() + "年龄不合法";
    }
}

/**
 * 可以包含多个类，但public一定只能有一个且与源文件名相同
 */
class CustomException extends Exception {

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
