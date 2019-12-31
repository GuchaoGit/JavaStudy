import utils.Util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author guc
 * @Date 2019/12/31 11:38
 * @Description 测试
 */
public class MsTest {
    public static void main(String[] args) {
        String hello = "HelloWorld";
        String helloReverse = Util.reverse(hello);
        System.out.println(helloReverse);
        System.out.println("++++++++++++++++日期格式化+++++++++++++++++");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDate date = LocalDate.now();
        System.out.println(date.format(dtf));
        System.out.println(getMsg(4));

        A ab = new B();
        ab = new B();
    }

    private static int getMsg(int a) {
        try {
            System.out.println("try");
            return a;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
        return a;
    }

}

class A {
    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }
}

class B extends A {
    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
    }
}