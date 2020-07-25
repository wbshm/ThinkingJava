package demo.chapter17.s11;

import java.util.*;

/**
 * @ClassName Synchronization
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/25 21:22
 */
public class Synchronization {
    public static void main(String[] args) {
        Collection<String> c = Collections.synchronizedCollection(new ArrayList<>());

        List<String> list = Collections.synchronizedList(new ArrayList<>());

        Set<String> set = Collections.synchronizedSet(new HashSet<>());

        Set<String> sset = Collections.synchronizedSortedSet(new TreeSet<>());

        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());

        Map<String, String> smap = Collections.synchronizedSortedMap(new TreeMap<>());
    }
}
