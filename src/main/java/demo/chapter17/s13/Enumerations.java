package demo.chapter17.s13;

import demo.chapter17.Countries;

import java.util.*;

/**
 * @ClassName Enumerations
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/25 23:06
 */
public class Enumerations {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>(Countries.names(10));
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
        e = Collections.enumeration(new ArrayList<>());
        long round = Math.round(-1.5);
        System.out.println(round);
    }
}
