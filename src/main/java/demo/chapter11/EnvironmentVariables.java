package demo.chapter11;

import java.util.Map;

/**
 * @ClassName EnvironmentVariables
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/7 19:56
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
