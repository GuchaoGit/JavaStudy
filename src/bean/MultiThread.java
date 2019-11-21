package bean;

import thread.MyCallable;
import thread.MyRunnable;
import thread.MyThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author guc
 * @Date 2019/11/21 15:30
 * @Description 多线程测试
 */
public class MultiThread implements ITest {
    @Override
    public void test() {
        MyThread thread = new MyThread("thread");
        thread.start();
        new Thread(new MyRunnable(), "runnableThread").start();

        FutureTask<String> futureTask = new FutureTask<String>(new MyCallable());
        new Thread(futureTask, "futureTaskThread").start();
        System.out.println("before ------------------");
        try {
            System.out.println("MyCallable 返回：\n" + futureTask.get());//阻塞主线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("after ------------------");
    }
}
