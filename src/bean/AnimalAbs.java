package bean;

/**
 * @Author guc
 * @Date 2019/11/19 13:54
 * @Description 抽象类
 */
public abstract class AnimalAbs implements IAnimal {
    protected String name;
    protected int id;

    public AnimalAbs(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract void eat();

    public abstract void sleep();

    public abstract void introduction();
}
