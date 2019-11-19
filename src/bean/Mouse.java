package bean;

/**
 * @Author guc
 * @Date 2019/11/19 13:56
 * @Description 老鼠
 */
public class Mouse extends AnimalAbs {
    public Mouse(String name, int id) {
        super(name, id);
    }

    @Override
    public void eat() {
        System.out.println(name + "正在吃");
    }

    @Override
    public void sleep() {
        System.out.println(name + "正在睡");
    }

    @Override
    public void introduction() {
        System.out.println("大家好！我是" + id + "号" + name + ".");
    }

    @Override
    public void likeEat() {
        System.out.println(name + "喜欢吃大米");
    }
}
