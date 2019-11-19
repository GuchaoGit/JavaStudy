package bean;

/**
 * @Author guc
 * @Date 2019/11/19 13:48
 * @Description 小猫
 */
public class Cat extends Animal {
    public Cat(String name, int id) {
        super(name, id);
    }

    @Override
    public void introduction() {
        System.out.println("我是一只小猫" + name + " 编号" + id);
        super.introduction();
    }

    @Override
    public void likeEat() {
        super.likeEat();
        System.out.println(name + "喜欢吃老鼠");
    }
}
