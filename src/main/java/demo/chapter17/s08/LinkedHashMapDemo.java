package demo.chapter17.s08;

import demo.chapter17.CountingMapData;

import java.util.LinkedHashMap;

/**
 * @ClassName LinkedHashMap
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 16:07
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap(new CountingMapData(9));
        System.out.println(linkedHashMap);
        linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.putAll(new CountingMapData(9));
        System.out.println(linkedHashMap);
        for (int i = 0; i < 6; i++) {
            System.out.println(linkedHashMap.get(i));
        }
        System.out.println(linkedHashMap);
        linkedHashMap.get(0);
        System.out.println(linkedHashMap);
    }
}
