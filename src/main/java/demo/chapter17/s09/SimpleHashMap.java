package demo.chapter17.s09;

import java.util.*;

/**
 * @ClassName SimpleHashMap
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 18:46
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;

    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[size()];

    @Override
    public V put(K k, V v) {
        V oldValue = get(k);
        int index = Math.abs(k.hashCode() % SIZE);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(k, v);
        boolean found = false;
        ListIterator<MapEntry<K, V>> iterator = bucket.listIterator();
        while (iterator.hasNext()) {
            MapEntry<K, V> next = iterator.next();
            if (next.getKey().equals(k)) {
                oldValue = next.getValue();
                iterator.set(pair);
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode() % SIZE);
        if (Objects.nonNull(buckets[index])) {
            for (MapEntry<K, V> entry : buckets[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
