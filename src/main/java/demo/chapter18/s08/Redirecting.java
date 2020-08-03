package demo.chapter18.s08;

import java.io.*;

/**
 * @ClassName Redirecting
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 12:07
 */
public class Redirecting {
    public static void main(String[] args)
            throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("D:\\P\\javaWorkSpace\\ThinkingJava\\src\\main\\java\\demo\\chapter18\\s08\\Redirecting.java"));
        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("test.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        out.close(); // Remember this!
        System.setOut(console);
    }
}
