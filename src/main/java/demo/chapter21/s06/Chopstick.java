package demo.chapter21.s06;

/**
 * @ClassName Chopstick
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/30 14:36
 */
public class Chopstick {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
