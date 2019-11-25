package bean;

import exp.IllegalAgeException;

import java.io.Serializable;

/**
 * @Author guc
 * @Date 2019/11/19 12:05
 * @Description 人类
 */
public class Person implements Serializable {
    private String name;
    private int age;
    private Long time;

    public Person() {
        time = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     * @throws IllegalAgeException
     */
    public void setAge(int age) throws IllegalAgeException {
        if (age < 0 || age > 200) throw new IllegalAgeException(age);
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " 年龄：" + age + " 创建时间：" + time;
    }
}
