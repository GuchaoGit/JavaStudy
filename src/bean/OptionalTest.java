package bean;

import java.util.Optional;

/**
 * @Author guc
 * @Date 2019/11/26 15:27
 * @Description Java 8 Optional 类
 */
public class OptionalTest implements ITest {
    @Override
    public void test() {
        System.out.println("+++++++++++++++++++Java 8 Optional+++++++++++++++++");
        Integer value1 = null;
        Integer value2 = new Integer(10);
        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.ofNullable(value2);
        System.out.println("null + 10 = " + sum(a, b));

    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer inta = a.orElse(0);
        Integer intb = b.orElse(0);
        //Optional.get - 获取值，值需要存在
        return inta + intb;
    }
}
