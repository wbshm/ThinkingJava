package demo.chapter21.s03;

/**
 * @ClassName IntGenerator
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/28 14:48
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
