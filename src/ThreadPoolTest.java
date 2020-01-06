import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author guc
 * @Date 2020/1/2 11:04
 * @Description 线程池 + 文件工具测试
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//      ThreadPool threadPool = new ThreadPool();
//        threadPool.test();
//        Util.showDirectory(new File("E:/My项目资料"));
        testReg();
    }

    private static void testReg() {
        String str = "北京市(朝阳区)(西城区)(海淀区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if (m.find()) {
            System.out.println(m.group());
        }

    }

}
