package demo.chapter17.s09;

import demo.chapter17.Countries;

import java.util.*;

/**
 * @ClassName SimpleHashMap
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 18:46
 */
public class SimpleHashMap<K, V> implements Map<K, V> {
    static final int SIZE = 997;
    private int count = 0;

    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

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
            count++;
            MapEntry<K, V> next = iterator.next();
            if (next.getKey().equals(k)) {
                if (next.equals(pair)) {
                    System.err.println("count:" + count);
                    System.err.println("the same data:" + pair);
                    return next.getValue();
                }
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
    public void putAll(Map<? extends K, ? extends V> m) {
        count = 0;
        m.forEach(this::put);
    }

    @Override
    public int size() {
        int size = 0;
        for (LinkedList<MapEntry<K, V>> entries : buckets) {
            if (Objects.nonNull(entries)) {
                size += entries.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return Objects.nonNull(get(key));
    }

    @Override
    public boolean containsValue(Object value) {
        Collection v = values();
        return v.contains(value);
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
        HashSet<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> entries : buckets) {
            if (Objects.nonNull(entries)) {
                set.addAll(entries);
            }
        }
        return set;
    }

    @Override
    public void clear() {
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = null;
        }
        entrySet().clear();
    }

    @Override
    public Set<K> keySet() {
        Set<K> rtn = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> entries : buckets) {
            if (Objects.nonNull(entries)) {
                for (MapEntry<K, V> entry : entries) {
                    rtn.add(entry.getKey());
                }
            }
        }
        return rtn;
    }

    @Override
    public Collection<V> values() {
        Collection<V> rtn = new ArrayList<>();
        for (LinkedList<MapEntry<K, V>> entries : buckets) {
            if (Objects.nonNull(entries)) {
                for (MapEntry<K, V> entry : entries) {
                    rtn.add(entry.getValue());
                }
            }
        }
        return rtn;
    }

    @Override
    public V remove(Object key) {
        V old = null;
        for (int i = 0; i < SIZE; i++) {
            if (Objects.isNull(buckets[i])) {
                continue;
            }
            for (int j = 0; j < buckets[i].size(); j++) {
                if (buckets[i].get(j).getKey().equals(key)) {
                    old = buckets[i].get(j).getValue();
                    buckets[i].remove(j);
                    break;
                }
            }
        }
        return old;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (K k : keySet()) {
            sb.append(k);
            sb.append(" = ");
            sb.append(get(k));
            sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.putAll(Countries.capitals(25));
        System.out.println(map);
        map.put("denmark", "Copenhagen");
        map.remove("denmark");
        System.out.println(map.get("denmark"));
        map.clear();
        System.out.println(map);
    }
}
