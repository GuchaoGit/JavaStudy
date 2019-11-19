package bean;

import exp.IllegalAgeException;

/**
 * @Author guc
 * @Date 2019/11/19 12:05
 * @Description 人类
 */
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAgeException {
        if (age < 0 || age > 200) throw new IllegalAgeException(age);
        this.age = age;
    }
}
