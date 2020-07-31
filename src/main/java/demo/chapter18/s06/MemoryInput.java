package demo.chapter18.s06;

import java.io.IOException;
import java.io.StringReader;

/**
 * @ClassName MemoryInput
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 11:13
 */

public class MemoryInput {
    public static void main(String[] args)
            throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read("D:\\P\\javaWorkSpace\\ThinkingJava\\src\\main\\java\\demo\\chapter18\\s06\\MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
