package bean;

import exp.IllegalAgeException;
import utils.Util;

import java.util.List;

/**
 * @Author guc
 * @Date 2019/11/20 11:53
 * @Description 序列化测试 将对象写入文件 并读取
 */
public class SerializableTest implements ITest {

    @Override
    public void test() {
        Person person = new Person();
        person.setName("guc");
        try {
            person.setAge(29);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }

        boolean success = Util.FileUtils.writeObject2File("E:/JavaStudy/person.p", person, false);
        if (success) {
            System.out.println("成功把对象写入文件");
            List<Person> persons = Util.FileUtils.readFile2Object("E:/JavaStudy/person.p");
            if (persons != null) {
                for (Person p : persons) {
                    System.out.println(p.toString());
                }
            }
        }


    }
}
