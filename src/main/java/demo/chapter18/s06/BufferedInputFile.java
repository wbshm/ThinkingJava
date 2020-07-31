package demo.chapter18.s06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @ClassName BufferedInputFile
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 11:04
 */
public class BufferedInputFile {
    // Throw exceptions to console:
    public static String read(String filename) throws IOException {
        // Reading input by lines:
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.print(read("D:\\P\\javaWorkSpace\\ThinkingJava\\src\\main\\java\\demo\\chapter18\\s06\\BufferedInputFile.java"));
    }
}
