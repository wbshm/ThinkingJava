package demo.chapter21.s02;

/**
 * @ClassName SimpleThread
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/28 9:51
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadCount));
        start();
    }

    @Override
    public String toString() {
        return "SimpleThread{" + getName() +
                "countDown=" + countDown +
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
            new SimpleThread();
        }
    }
}
