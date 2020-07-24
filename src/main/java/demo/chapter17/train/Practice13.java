package demo.chapter17.train;

import demo.chapter17.s08.AssociativeArray;
import net.mindview.util.TextFile;

import java.util.Objects;

/**
 * @ClassName Practice13
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 14:30
 */
public class Practice13 {
    public static void main(String[] args) {
        String fileName = "D:\\P\\javaWorkSpace\\ThinkingJava\\src\\main\\resources\\chapter17-train-practice13.txt";
        String read = TextFile.read(fileName);
        String[] split = read.split("[\n|\\s|,|.]");
        AssociativeArray<String, Integer> res = new AssociativeArray<>(split.length);
        for (String s : split) {
            if (s.length() == 0) {
                continue;
            }
            Integer integer = res.get(s);
            if (Objects.isNull(integer)) {
                res.put(s, 1);
            } else {
                res.put(s, integer + 1);
            }
        }
        System.out.println(res);
    }
}
