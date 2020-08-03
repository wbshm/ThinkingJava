package demo.chapter18.train;

import demo.chapter18.s06.BufferedInputFile;

import java.io.*;
import java.util.Objects;

/**
 * @ClassName test01
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 11:05
 */
public class test01 {
    public static String read(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        StringBuffer sb = new StringBuffer();
        String s;
        while ((s = reader.readLine()) != null) {
            sb.append(s).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public static void read1(String fileName) throws IOException {
        String read = BufferedInputFile.read(fileName);
        System.out.println(read);
    }

    public static void write(String fileName, String test) {
        try {
            PrintWriter pt = new PrintWriter(new FileWriter(fileName));
            pt.print(test);
            pt.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws IOException {
//        read("D:\\P\\javaWorkSpace\\ThinkingJava\\src\\main\\java\\demo\\chapter18\\train\\test01.java");
        write("test.txt", "nihao\nhelloworld");
    }
}
