package bean;

import java.util.*;

/**
 * @Author guc
 * @Date 2019/11/20 9:35
 * @Description 数据结构
 */
public class DataStructure implements ITest {
    @Override
    public void test() {
        testVector();
        testStack();
        testHashtable();
        testProperties();
    }

    /**
     * Properties 继承于 Hashtable.表示一个持久的属性集
     */
    private void testProperties() {
        System.out.println("-------------Hashtable-------------");
        Properties properties = new Properties();
        properties.put("username", "guc");
        properties.put("password", "123456");
        Set set = properties.keySet();
        Iterator iterator = set.iterator();
        String key;
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            System.out.println(key + ":" + properties.getProperty(key));
        }
        key = properties.getProperty("token", "Not Found");
        System.out.println("token:" + key);
    }

    /**
     * 存放键值
     */
    private void testHashtable() {
        System.out.println("-------------Hashtable-------------");
        Hashtable<String, Double> hashtable = new Hashtable<>();
        Enumeration<String> keys;
        String key;
        hashtable.put("guc", new Double(1535));
        hashtable.put("guc2", new Double(2535));
        hashtable.put("guc3", new Double(3535));
        keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            key = keys.nextElement();
            System.out.println(key + ":" + hashtable.get(key));
        }
    }

    /**
     * Vector 类实现了一个动态数组
     */
    private void testVector() {
        System.out.println("-------------Vector-------------");
        Vector<String> colors = new Vector<>();
        colors.add("Red");
        colors.add("Yellow");
        colors.add("Blue");
        System.out.println("Vector:" + colors);
    }

    /**
     * 栈（Stack）实现了一个后进先出（LIFO）的数据结构
     * 是Vector的子类
     * 后进先出
     */
    private void testStack() {
        System.out.println("-------------Stack-------------");
        Stack<Integer> stack = new Stack<>();
        System.out.println("stack:" + stack);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack:" + stack);
        Integer i = stack.pop();
        System.out.println("pop:" + i);
        System.out.println("stack:" + stack);
        stack.pop();
        stack.pop();

        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("exp:stack is empty");
        }
    }
}
