package demo.chapter18.s06;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName TestEOF
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 11:22
 */
public class TestEOF {
    public static void main(String[] args)
            throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("D:\\P\\javaWorkSpace\\ThinkingJava\\src\\main\\java\\demo\\chapter18\\s06\\TestEOF.java")));
        while (in.available() != 0) {
            System.out.print((char) in.readByte());
        }
    }
}
