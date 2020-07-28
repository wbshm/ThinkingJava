package demo.chapter21.s02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName SimplePriorities
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/27 11:34
 */
public class SimplePriorities extends SelfManaged {
    private int countDown = 5;
    private volatile double d;
    private final int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;

    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    /**
     * 优先级设置在run里面，而不是在构造器里。
     */
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 1000000000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 100000000 == 0) {
                    // 让步，建议具有相同优先级的其他线程可以运行。
                    // 这只是一个暗示，没有任何机制保证它将会被采纳。
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
