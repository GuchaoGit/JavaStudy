package bean;


import utils.Util;

/**
 * @Author guc
 * @Date 2019/11/25 9:42
 * @Description TODO
 */
public class ArrayTest implements ITest {
    @Override
    public void test() {
        String[] fruits = {"apple", "banana", "orange", "lemon"};
        System.out.println("原数据：");
        Util.printArray(fruits);
        System.arraycopy(fruits, 1, fruits, 0, fruits.length - 1);
        System.out.println("移位后：");
        Util.printArray(fruits);
    }
}
