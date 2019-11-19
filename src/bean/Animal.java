package bean;

/**
 * @Author guc
 * @Date 2019/11/19 13:40
 * @Description 动物
 */
public class Animal implements IAnimal {
    protected String name;
    protected int id;

    public Animal(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void eat() {
        System.out.println(name + "正在吃");
    }

    public void sleep() {
        System.out.println(name + "正在睡");
    }

    public void introduction() {
        System.out.println("大家好！我是" + id + "号" + name + ".");
    }

    @Override
    public void likeEat() {

    }
}
