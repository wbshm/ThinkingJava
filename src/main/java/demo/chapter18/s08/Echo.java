package demo.chapter18.s08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName Echo
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 12:02
 */

public class Echo {
    public static void main(String[] args)
            throws IOException {
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }
        // An empty line or Ctrl-Z terminates the program
    }
}
