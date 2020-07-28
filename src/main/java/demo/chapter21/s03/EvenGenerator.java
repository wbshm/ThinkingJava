package demo.chapter21.s03;

/**
 * @ClassName EvenGenerator
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/28 15:04
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
