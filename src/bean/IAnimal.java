package bean;

/**
 * 动物接口
 * 接口中的方法会被隐式的指定为 public abstract
 * 接口中的变量会被隐式的指定为 public static final 变量
 * 接口中不能含有静态代码块以及静态方法(用 static 修饰的方法)
 */
public interface IAnimal {
    void likeEat();
}
