package bean;

import thread.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author guc
 * @Date 2020/1/2 10:56
 * @Description 线程池
 */
public class ThreadPool implements ITest {
    @Override
    public void test() {
        //创建一个单线程的线程池
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 99; i++) {
            service.submit(new MyRunnable("Single"));
        }
        //创建固定大小的线程池
        ExecutorService serviceFixed = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 99; i++) {
            serviceFixed.submit(new MyRunnable("Fixed"));
        }
        ScheduledExecutorService serviceScheduled = Executors.newScheduledThreadPool(3);
        serviceScheduled.schedule(new MyRunnable("Delayed"), 1000, TimeUnit.MILLISECONDS);
        serviceScheduled.scheduleAtFixedRate(new MyRunnable("Period"), 1100, 2000, TimeUnit.MILLISECONDS);
    }
}
