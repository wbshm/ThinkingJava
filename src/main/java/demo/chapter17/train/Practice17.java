package demo.chapter17.train;

import demo.chapter17.Countries;
import demo.chapter17.s09.MapEntry;

import java.util.*;

/**
 * @ClassName Practice16
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 17:48
 */
public class Practice17<K, V> implements Map<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.size() > 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public V put(K key, V value) {
        V old = null;
        if (containsKey(key)) {
            old = values.get(keys.indexOf(key));
            values.set(keys.indexOf(key), value);
            keys.set(keys.indexOf(key), key);
        } else {
            keys.add(key);
            values.add(value);
        }
        return old;
    }

    @Override
    public V remove(Object key) {
        V old = null;
        if (containsKey(key)) {
            old = values.get(keys.indexOf(key));
            values.remove(keys.indexOf(key));
            keys.remove(key);
        }
        return old;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Set<K> keySet() {
        return new HashSet<>(keys);
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        Set<Entry<K, V>> set = new HashSet<>();
        while (ki.hasNext()) {
            set.add(new MapEntry<>(ki.next(), vi.next()));
        }
        return set;
    }
}

class Test {
    public static void main(String[] args) {
        Practice17<String, String> map = new Practice17<>();
        map.putAll(Countries.capitals(10));

        map.put("c", "test");
        System.out.println(map.get("c"));
        map.remove("c");
        System.out.println(map.get("c"));
    }
}
