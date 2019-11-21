package thread;

/**
 * @Author guc
 * @Date 2019/11/21 15:37
 * @Description 自定义线程
 */
public class MyThread extends Thread {
    public MyThread() {
        super();
    }

    public MyThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + "create by 继承Thread类");
    }
}
