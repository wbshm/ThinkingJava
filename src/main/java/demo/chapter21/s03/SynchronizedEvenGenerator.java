package demo.chapter21.s03;

/**
 * @ClassName SynchronizedEvenGenerator
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/28 17:33
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
