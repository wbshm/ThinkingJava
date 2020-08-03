package demo.chapter18.s08;

import java.io.PrintWriter;

/**
 * @ClassName ChangeSystemOut
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 12:03
 */

public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world");
    }
}
