package demo.chapter21.s02;

/**
 * @ClassName Runnable
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/28 9:56
 */
public class SelfManaged implements Runnable {

    private int countDown = 5;
    private Thread t = new Thread(this);

    public SelfManaged() {
        t.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() +
                "{countDown=" + countDown +
                ", t=" + t +
                '}';
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}

