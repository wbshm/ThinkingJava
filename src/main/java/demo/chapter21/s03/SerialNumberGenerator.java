package demo.chapter21.s03;

/**
 * @ClassName SerialNumberGenerator
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/29 9:41
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public synchronized static int nextSerialNumber() {
        return serialNumber++;
    }
}
