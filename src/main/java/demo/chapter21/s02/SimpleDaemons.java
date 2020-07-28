package demo.chapter21.s02;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SimpleDaemons
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/27 14:50
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {

            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("Sleep() interrupt");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
