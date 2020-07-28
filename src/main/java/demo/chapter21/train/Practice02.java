package demo.chapter21.train;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Practice02
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/27 11:23
 */
public class Practice02 implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        int i = random.nextInt(10) + 1;
        try {
            TimeUnit.MILLISECONDS.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep:" + i);

    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            exec.execute(new Practice02());
        }
        exec.shutdown();
    }
}
