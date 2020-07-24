package demo.chapter17.s09;

import demo.chapter17.Countries;

import java.util.*;

/**
 * @ClassName SlawMap
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 16:57
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    /**
     *
     * @param key 类型为Object，这是奖泛型注入到Java语言中的时刻如此之晚导致的结果。
     * @return
     */
    @Override
    public V get(Object key) {
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()) {
            set.add(new MapEntry<>(ki.next(), vi.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> slowMap = new SlowMap<>();
        slowMap.putAll(Countries.capitals(15));
        System.out.println(slowMap);
        System.out.println(slowMap.get("bulgaria"));
        System.out.println(slowMap.entrySet());
    }
}
