package annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author guc
 * @Date 2020/4/9 14:34
 * @Description 测试注解
 */
public class UseCasesTest {
    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases);
    }

    private static void trackUseCases(List<Integer> useCases) {
        PasswordUtils passwordUtils = new PasswordUtils();
        Class cl = passwordUtils.getClass();
        for (Method m : cl.getDeclaredMethods()) {
            //获得注解的对象
            UseCase.UseCases uc = m.getAnnotation(UseCase.UseCases.class);
            if (uc != null) {
                System.out.println("Found Use Case:" + uc.id() + " "
                        + uc.description() + " " + getStringFromArray(uc.names()));
                try {
                    m.setAccessible(true);
                    Object rt = m.invoke(passwordUtils, "guc3360");
                    System.out.println(rt);
                } catch (Exception e) {
                    StringBuilder log = new StringBuilder();
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    //记录测试过程中，发生的异常的名称
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                    System.out.println(log.toString());
                }
                System.out.println("*********************************");
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static String getStringFromArray(String[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (array != null) {
            for (String str : array) {
                stringBuilder.append(str);
                stringBuilder.append(",");
            }
        }
        int last = stringBuilder.lastIndexOf(",");
        if (last != -1) stringBuilder.deleteCharAt(last);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
