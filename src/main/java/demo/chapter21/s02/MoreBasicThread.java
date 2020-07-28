package demo.chapter21.s02;

/**
 * @ClassName MoreBasicThread
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/27 10:07
 */
public class MoreBasicThread {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting of Liftoff");
    }
}
