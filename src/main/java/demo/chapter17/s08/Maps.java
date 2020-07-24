package demo.chapter17.s08;

import demo.chapter17.CountingMapData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName Maps
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 15:48
 */
public class Maps {
    public static void printKeys(Map<Integer, String> map) {
        System.out.print("Size = " + map.size() + ", ");
        System.out.print("Keys: ");
        System.out.println(map.keySet());
    }

    public static void test(Map<Integer, String> map) {
        System.out.println(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        map.putAll(new CountingMapData(25));
        printKeys(map);
        System.out.print("Values: ");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11):" + map.get(11));
        System.out.println("map.containsValue(\"F0\")" + map.containsValue("F0"));

        Integer key = map.keySet().iterator().next();
        System.out.println("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty():" + map.isEmpty());
        map.putAll(new CountingMapData(25));
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty():" + map.isEmpty());
    }

    public static void main(String[] args) {
        test(new HashMap<>());
        test(new TreeMap<>());
        test(new LinkedHashMap<>());
        test(new ConcurrentHashMap<>());
        test(new IdentityHashMap<>());
        test(new WeakHashMap<>());
    }
}
