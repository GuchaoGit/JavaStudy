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
