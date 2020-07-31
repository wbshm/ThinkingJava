package demo.chapter18.train;

import java.io.File;
import java.util.Arrays;

/**
 * @ClassName Practice01
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 9:32
 */
public class Practice01 {
    public static void main(String[] args) {
        File file = new File("./");
        String[] list = file.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String f : list) {
            System.out.println(f);
        }
    }
}
