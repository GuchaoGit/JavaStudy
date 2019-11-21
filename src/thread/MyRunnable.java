package thread;

/**
 * @Author guc
 * @Date 2019/11/21 15:59
 * @Description 通过实现Runnable接口实现线程
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "create by 实现Runnable接口");
    }
}
