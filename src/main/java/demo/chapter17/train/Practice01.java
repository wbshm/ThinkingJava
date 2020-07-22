package demo.chapter17.train;

import demo.chapter17.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName CountingArrayList
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/21 17:35
 */
public class Practice01 {
    /**
     * 1. 创建一个list
     * 2. 用Countries来填充
     * 3. 排列打印
     * 4. 多次使用 Collections.shuffle() 。打印结果。
     */
    public static void testArrayList() {
        List<String> arrayList = new ArrayList<>(Countries.names(5));
        System.out.println("start ArrayList...");
        System.out.println(arrayList);
        for (int i = 0; i < 10; i++) {
            Collections.shuffle(arrayList);
            System.out.println(arrayList);
        }
        System.out.println("end ArrayList...");
    }

    public static void testLinkedList() {
        List<String> arrayList = new LinkedList<>(Countries.names(5));
        System.out.println(arrayList);
        for (int i = 0; i < 10; i++) {
            Collections.shuffle(arrayList);
            System.out.println(arrayList);
        }
    }

    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
    }
}

