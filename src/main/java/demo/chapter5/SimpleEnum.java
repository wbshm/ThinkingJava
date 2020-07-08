package demo.chapter5;

/**
 * @ClassName SimpleEnum
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/5 23:45
 */
public class SimpleEnum {
    public static void main(String[] args) {
        for (Spiciness s : Spiciness.values()) {
            System.out.println(s + ":" + s.ordinal() + s.getValue());
        }
    }
}
