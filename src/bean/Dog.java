package bean;

/**
 * @Author guc
 * @Date 2019/11/19 13:43
 * @Description 小狗
 */
public class Dog extends Animal {
    public Dog(String name, int id) {
        super(name, id);
    }

    @Override
    public void introduction() {
        super.introduction();
        System.out.println("我是一只小狗" + name + " 编号" + id);
    }

    @Override
    public void likeEat() {
        super.likeEat();
        System.out.println(name + "喜欢吃骨头");
    }

    /**
     * 重载  没对返回值有要求
     * 可修改返回值类型
     *
     * @param i
     * @return
     */
    public int likeEat(int i) {

        return i;
    }
}
