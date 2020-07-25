package demo.chapter17.s09;

import java.util.*;

/**
 * @ClassName CountedString
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/25 1:02
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private char c;
    private int id = 0;

    public CountedString(String str) {
        s = str;
        created.add(s);
        c = s.length() > 0 ? s.charAt(0) : 0;
        for (String s2 : created) {
            if (s2.equals(s)) {
                id++;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CountedString that = (CountedString) o;
        return id == that.id &&
                Objects.equals(s, that.s) && Objects.equals(c, that.c);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + c;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "s='" + s + '\'' +
                ", id=" + id +
                ", hashCode=" + hashCode() +
                '}';
    }

    public static void main(String[] args) {

        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString c : map.keySet()) {
            System.out.println("Looking up" + c);
            System.out.println(map.get(c));
        }
    }
}
