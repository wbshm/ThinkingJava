package demo.chapter17;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @ClassName SortedSetDemo
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 10:09
 */
public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
        System.out.println(sortedSet);

        String first = sortedSet.first();
        String last = sortedSet.last();
        System.out.println(first);
        System.out.println(last);

        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3) {
                first = it.next();
            }
            if (i == 6) {
                last = it.next();
            } else {
                it.next();
            }
        }
        System.out.println(last);
        System.out.println(first);
        System.out.println(sortedSet.subSet(first, last));
        System.out.println(sortedSet.headSet(last));
        System.out.println(sortedSet.tailSet(first));
    }
}
