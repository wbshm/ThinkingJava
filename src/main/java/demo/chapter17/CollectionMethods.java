package demo.chapter17;

import java.util.*;

/**
 * @ClassName CollectionMethods
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/22 11:50
 */
public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.addAll(Countries.names(6));
        c.add("ten");
        c.add("eleven");
        System.out.println(c);

        Object[] array = c.toArray();
        System.out.println(Arrays.toString(array));
        String[] str = c.toArray(new String[0]);
        System.out.println(Arrays.toString(str));

        System.out.println("Collections.max(c): " + Collections.max(c));
        System.out.println("Collections.min(c): " + Collections.min(c));

        Collection<String> c2 = new ArrayList<>();
        c2.addAll(Countries.names(6));
        c.addAll(c2);
        System.out.println(c);
        c.remove(Countries.DATA[0][0]);
        System.out.println(c);
        c.remove(Countries.DATA[1][0]);
        System.out.println(c);

        c.removeAll(c2);
        System.out.println(c);
        c.addAll(c2);
        System.out.println(c);
        String val = Countries.DATA[3][0];

        System.out.println("c.contains(" + val + "): " + c.contains(val));

        System.out.println("c.containsAll(c2): " + c.containsAll(c2));
        Collection<String> c3 = ((List<String>) c).subList(3, 5);
        c2.containsAll(c3);
        System.out.println(c2);
        c2.removeAll(c3);
        System.out.println("c2.isEmpty(): " + c2.isEmpty());
        c = new ArrayList<>();
        c.addAll(Countries.names(6));
        System.out.println(c);
        c.clear();
        System.out.println("after c.clear(): " + c);
    }
}
