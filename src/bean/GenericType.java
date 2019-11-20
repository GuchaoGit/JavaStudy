package bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author guc
 * @Date 2019/11/20 10:58
 * @Description 泛型类 泛型方法
 */
public class GenericType<V, W extends Animal> implements ITest {
    private V value;
    private Animal animal;

    public GenericType(V value, W animal) {
        this.value = value;
        this.animal = animal;
    }

    @Override
    public void test() {
        System.out.println(value);
        animal.introduction();
        animal.likeEat();
        testGenericType(4);
        testGenericType("HelloWorld");
        testGenericType(15.2);
        List<Integer> data = new ArrayList<>();
        data.add(12);
        testGenericType(data);
    }

    private <T> void testGenericType(T in) {
        if (in instanceof String) {
            System.out.println("字符串：" + in);
        } else if (in instanceof Integer) {
            System.out.println("数字：" + in);
        } else {
            System.out.println(in);
        }
    }

    /**
     * 类型通配符
     *
     * @param data
     */
    private void testGenericType(List<? extends Number> data) {
        if (data != null && !data.isEmpty()) {
            System.out.println("data:" + data.get(0));
        }
    }
}
