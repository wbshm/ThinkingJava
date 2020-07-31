package demo.chapter18.train;

import java.io.*;

/**
 * @ClassName test01
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 11:05
 */
public class test01 {
    public static void read(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        StringBuffer sb = new StringBuffer();
        String s;
        while ((s = reader.readLine()) != null) {
            sb.append(s).append("\n");
        }
        reader.close();
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        read("D:\\P\\javaWorkSpace\\ThinkingJava\\src\\main\\java\\demo\\chapter18\\train\\test01.java");
    }
}
