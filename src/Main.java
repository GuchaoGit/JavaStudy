import bean.FreshJuice;
import bean.Work;

public class Main {
    private static boolean ready;
    public static void main(String[] args) {
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.LARGE;
        testVolatile();
        testMath();
        testChar();
        testString();
    }

    /**
     * String 测试
     */
    private static void testString() {
        char[] chars =new char[]{'H','e','l','l','o','W','o','r','l','d'};
        String s = String.copyValueOf(chars);
        System.out.printf("%s",s);
        System.out.printf(".indexOf('e')=%d\n",s.indexOf('e'));
        System.out.println(s.charAt(4));
        System.out.println(s+".lastIndexOf(\"rl\")="+s.lastIndexOf("rl"));
        String car = "豫A9R13C";
        String reg = "^(([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z](([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领][A-Z][A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳使领]))$";
        System.out.println(car+"是否符合车牌规则=" + car.matches(reg));
        System.out.println(car+".replaceAll()"+car.replaceFirst("\\d","X"));
    }

    /**
     * Character测试
     */
    private static void testChar() {
        char  uniChar = '\u039A';
        System.out.println(uniChar);
        Character c = 'A';
        System.out.println("char("+c+").isUpperCase = "+Character.isUpperCase(c));
    }

    /**
     * 测试Math类
     */
    private static void testMath() {
        float b = -13.51f;
        System.out.println("Math.ceil("+b+")="+ Math.ceil(b));
        System.out.println("Math.floor("+b+")="+ Math.floor(b));
        System.out.println("Math.round("+b+")="+ Math.round(b));
        System.out.println("Math.random()="+ Math.random());
    }

    /**
     * 修饰符
     */
    private static void testVolatile() {
        Work work = new Work();
        for (int i=0;i<100;i++){
            System.out.println("i="+i);
            new Thread(work::run).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("运行了"+work.getCount());
    }

}
