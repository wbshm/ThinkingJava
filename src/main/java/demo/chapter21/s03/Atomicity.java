package demo.chapter21.s03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 执行 以下命令
 * javac src/main/java/demo/chapter21/s03/Atomicity.java
 * javap -c src/main/java/demo/chapter21/s03/Atomicity
 *
 * @ClassName Atomicity
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/29 9:03
 */
public class Atomicity {
    private int i = 0;

    public synchronized int getI() {
        return i;
    }

    synchronized void f2() {
        i++;
        i++;
    }


    public static void main(String[] args) {
        Atomicity atomicity = new Atomicity();
        Thread thread = new Thread(() -> {
            while (true) {
                atomicity.f2();
                if (atomicity.getI() % 2 != 0) {
                    System.out.println(atomicity.i);
                    System.exit(0);
                }
            }
        });

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(thread);
        }
        exec.shutdown();
    }
}
