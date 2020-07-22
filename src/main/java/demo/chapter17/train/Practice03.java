package demo.chapter17.train;

import demo.chapter17.Countries;

import java.util.*;

/**
 * @ClassName Practice03
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/21 18:35
 */
public class Practice03 {
    private static List<String> duplicateData() {
        List<String> names = Countries.names(3);
        names.addAll(Countries.names(4));
        names.addAll(Countries.names(5));
        return names;
    }

    public static void main(String[] args) {
        Set set1 = new HashSet(duplicateData());
        System.out.println(set1);
        Set set2 = new LinkedHashSet(duplicateData());
        System.out.println(set2);
        Set set3 = new TreeSet(duplicateData());
        System.out.println(set3);
    }
}
