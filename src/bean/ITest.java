package bean;

/**
 * 测试
 * 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
 */
public interface ITest {
    void test();

    static void printStatic() {
        System.out.println("这是测试接口中的静态默认方法");
    }

    default void print() {
        System.out.println("这是测试接口中的默认方法");
    }
}
