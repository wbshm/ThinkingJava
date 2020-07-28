package demo.chapter21.s02;

/**
 * @ClassName BasicThreads
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/27 10:01
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
