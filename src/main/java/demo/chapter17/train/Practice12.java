package demo.chapter17.train;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName Practice12
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 14:27
 */
public class Practice12 {
    private static void testHashMap() {
        Map<String, String> map = new HashMap<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Too many objects");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }

    private static void testTreeMap() {
        Map<String, String> map = new TreeMap<>();
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Too many objects");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }


    private static void testLinkedHashMap() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Too many objects");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }

    public static void main(String[] args) {
        testHashMap();
        testTreeMap();
        testLinkedHashMap();
    }
}
