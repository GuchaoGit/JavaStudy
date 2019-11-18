package bean;

/**
 * @Author guc
 * @Date 2019/11/15 11:09
 * @Description volatile 修饰符
 * volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。
 * 而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。
 * 这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
 */
public class Work {
    private volatile int count = 0;
    public synchronized void run() {
        System.out.println("run() = "+count);
        count++;
    }

    public int getCount(){
        return count;
    }
}
