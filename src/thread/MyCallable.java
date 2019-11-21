package thread;

import java.util.concurrent.Callable;

/**
 * @Author guc
 * @Date 2019/11/21 16:41
 * @Description 1、创建 Callable 接口的实现类
 * 2、FutureTask 类来包装 Callable 对象
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        return Thread.currentThread() + "create by 实现Callable接口";
    }
}
