package demo.chapter17.s11;

import demo.chapter17.Countries;

import java.util.*;

/**
 * @ClassName ReadOnly
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/25 21:13
 */
public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));

    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableList(new ArrayList<>(data));
        System.out.println(c);
//        c.add("one");

        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));
        ListIterator<String> lit = a.listIterator();
        System.out.println(lit.next());
//        lit.add("one");

        Set<String> s = Collections.unmodifiableSet(new HashSet<>(data));
//        s.add("one");

        Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<>(data));
//        ss.add("one");

        Map<String, String> m = Collections.unmodifiableMap(new HashMap<>(Countries.capitals(6)));
        System.out.println(m);
//        m.put("1", "2");

        Map<String,String> sm = Collections.unmodifiableSortedMap(new TreeMap<>(Countries.capitals(6)));
//        sm.put("1", "2");

    }
}
