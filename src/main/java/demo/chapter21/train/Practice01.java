package demo.chapter21.train;

/**
 * @ClassName Practice01
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/27 10:17
 */
public class Practice01 implements Runnable {
    int count = 3;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public Practice01() {
        System.out.println("#Id:" + id + " Start~~~");
    }

    @Override
    public void run() {
        while (count-- >= 0) {
            System.out.println("#id" + id + " is Running. count:" + count);
            Thread.yield();
        }
        System.out.println("#Id: " + id + " finished");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Practice01()).start();
        }
    }
}
