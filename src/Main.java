import bean.*;
import exp.IllegalAgeException;
import net.Server;
import utils.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static boolean ready;

    public static void main(String[] args) {
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.LARGE;
        testMath();
        testChar();
        testString();
        testArray();
        testDate();
        testRegExp();
        testVarargs();
        testFile();
        testFileReader();
        testCustomExp();
        testExtends();
        testDataStructure();
        testGenericType();
        testSerializable();
//        testVolatile();
        testMultiThread();
//        testBufferedReader();
        testGraph();
    }

    /**
     * 绘制图形
     */
    private static void testGraph() {
        System.out.println("+++++++++++++++++++绘制图形+++++++++++++++++");
        DrawGraph drawGraph = new DrawGraph();
        drawGraph.test();
    }

    /**
     * 多线程编程
     */
    private static void testMultiThread() {
        System.out.println("+++++++++++++++++++多线程编程+++++++++++++++++");
        System.out.println("Main:" + Thread.currentThread());
        MultiThread thread = new MultiThread();
        thread.test();
        System.out.println("after in MainThread ------------------");
    }

    /**
     * 网络编程
     */
    private static void testSocket() {
        System.out.println("+++++++++++++++++++SocketServer+++++++++++++++++");
        Server server = Server.getInstance();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化测试
     */
    private static void testSerializable() {
        System.out.println("+++++++++++++++++++序列化+++++++++++++++++");
        SerializableTest serializableTest = new SerializableTest();
        serializableTest.test();
    }

    /**
     * 泛型测试
     */
    private static void testGenericType() {
        System.out.println("+++++++++++++++++++泛型方法+++++++++++++++++");
        GenericType genericType = new GenericType("GenericType", new Cat("cat", 5));
        genericType.test();
    }


    /**
     * 数据结构
     */
    private static void testDataStructure() {
        System.out.println("+++++++++++++++++++数据结构+++++++++++++++++");
        DataStructure dataStructure = new DataStructure();
        dataStructure.test();
    }

    /**
     * 集成测试
     */
    private static void testExtends() {
        System.out.println("+++++++++++++++++++继承+++++++++++++++++");
        Dog dog = new Dog("dog", 1);
        dog.introduction();
        Cat cat = new Cat("cat", 2);
        cat.introduction();
        Mouse mouse = new Mouse("mouse", 3);
        mouse.introduction();
        dog.likeEat();
        cat.likeEat();
        mouse.likeEat();
    }

    /**
     * 测试自定义异常
     */
    private static void testCustomExp() {
        Person person = new Person();
        person.setName("guc");
        try {
            person.setAge(-5);
        } catch (IllegalAgeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 读取文件
     */
    private static void testFileReader() {
    /*    File file = new File("E:/JavaStudy/hello.txt");
        try {
            FileInputStream is = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String line ;
            while ((line = reader.readLine())!=null){
                sb.append(line);
                sb.append("\r\n");
            }
            reader.close();
            inputStreamReader.close();
            is.close();
            System.out.println("读取文件："+file.getName());
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        String s = Util.FileUtils.readFile2String("E:/JavaStudy/hello.txt");
        System.out.println("+++++++++++++++++++文件读取");
        System.out.println(s);
    }

    /**
     * 创建文件并写入内容
     */
    private static void testFile() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        File file = new File("E:/JavaStudy/hello.txt");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            sb.append("first create at ");
            sb.append(sdf.format(new Date()));
        } else {
            sb.append("run at ");
            sb.append(sdf.format(new Date()));
        }
        sb.append("\r\n");
        Util.FileUtils.writeString2File("E:/JavaStudy/hello.txt", sb.toString(), true);
    }

    /**
     * 测试bufferReader
     */
    private static void testBufferedReader() {
        System.out.println("++++++++++++++++++++BufferedReader++++++++++++++++++++++++");
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        System.out.println("输入字符, 按下 's' 键启动SocketServer。");
        // 读取字符
        try {
            do {
                c = (char) br.read();
                System.out.println(c);
                if ('s' == c) {
                    testSocket();
                    break;
                }
            } while (c != 'q');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testVarargs() {
        System.out.println("++++++++++++++++++++可变参数++++++++++++++++++++++++");
        double max = Util.getMax(34, 25.4, 42, 98, 45);
        System.out.println("最大值是" + max);
    }

    /**
     * 正则表达式测试
     */
    private static void testRegExp() {
        System.out.println("++++++++++++++++++++正则表达式++++++++++++++++++++++++");
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println(m.groupCount());
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }

        String REGEX = "dog";
        String INPUT = "The dog says meow. " +
                "All dogs say meow.";
        String REPLACE = "cat";
        Pattern p = Pattern.compile(REGEX);
        Matcher matcher = p.matcher(INPUT);
        INPUT = matcher.replaceAll(REPLACE);
        System.out.println(INPUT);


    }

    /**
     * 日期测试
     */
    private static void testDate() {
        System.out.println("++++++++++++++++++++日期测试++++++++++++++++++++++++");
        Date date = new Date();
        System.out.printf("%tc%n", date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年第w周\nMM 月第W周");
        String s = sdf.format(date);
        System.out.println(s);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.println(gregorianCalendar.isLeapYear(gregorianCalendar.get(Calendar.YEAR)));
    }

    /**
     * 测试数组
     */
    private static void testArray() {
        System.out.println("++++++++++++++++++++测试数组++++++++++++++++++++++++");
        String[] fruits = new String[3];//指定大小创建
        fruits[0] = "apple";
        fruits[1] = "banana";
        fruits[2] = "orange";
        Util.printArray(fruits);
        Integer[] ages = {1, 5, 9};//直接根据内容创建
        Util.printArray(ages);
        ArrayTest test = new ArrayTest();
        test.test();

    }

    /**
     * String 测试
     */
    private static void testString() {
        char[] chars = new char[]{'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd'};
        String s = String.copyValueOf(chars);
        System.out.printf("%s", s);
        System.out.printf(".indexOf('e')=%d\n", s.indexOf('e'));
        System.out.println(s.charAt(4));
        System.out.println(s + ".lastIndexOf(\"rl\")=" + s.lastIndexOf("rl"));
        String car = "豫A9R13C";
        String reg = "^(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z](([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))$";
        System.out.println(car + "是否符合车牌规则=" + car.matches(reg));
        System.out.println(car + ".replaceAll()" + car.replaceFirst("\\d", "X"));
    }

    /**
     * Character测试
     */
    private static void testChar() {
        char uniChar = '\u039A';
        System.out.println(uniChar);
        Character c = 'A';
        System.out.println("char(" + c + ").isUpperCase = " + Character.isUpperCase(c));
    }

    /**
     * 测试Math类
     */
    private static void testMath() {
        float b = -13.51f;
        System.out.println("Math.ceil(" + b + ")=" + Math.ceil(b));
        System.out.println("Math.floor(" + b + ")=" + Math.floor(b));
        System.out.println("Math.round(" + b + ")=" + Math.round(b));
        System.out.println("Math.random()=" + Math.random());
    }

    /**
     * 修饰符
     */
    private static void testVolatile() {
        Work work = new Work();
        for (int i = 0; i < 100; i++) {
            System.out.println("i=" + i);
            new Thread(work::run).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("运行了" + work.getCount());
    }

}
