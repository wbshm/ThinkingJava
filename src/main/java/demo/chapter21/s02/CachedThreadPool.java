package demo.chapter21.s02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CachedThreadPool
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/27 10:23
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        // 禁止exec再接受新的任务，但是会执行完已经接受的任务。
        exec.shutdown();
    }
}
