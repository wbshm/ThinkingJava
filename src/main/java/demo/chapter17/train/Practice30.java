package demo.chapter17.train;

import typeinfo.interfacea.A;

import java.util.*;

/**
 * @ClassName Practice30
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/25 14:52
 */
public class Practice30 {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            data.add(i);
        }
        Collections.shuffle(data);
        LinkedList<Integer> link = new LinkedList<>(data);
        long start = System.nanoTime();
        Collections.sort(data);
        long end = System.nanoTime() - start;
        System.out.println("arrayList: " + end);

        start = System.nanoTime();
        Collections.sort(link);
        end = System.nanoTime() - start;
        System.out.println("linkedList:" + end);
    }
}
