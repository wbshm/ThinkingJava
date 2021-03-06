package demo.chapter21.s02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName NaiveExceptionHandling
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/28 12:03
 */
public class NaiveExceptionHandling {
    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (RuntimeException ue) {
            System.out.println("Exception has been handled!");
        }
    }
}
