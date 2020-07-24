package demo.chapter17.s09;

import demo.chapter17.Countries;

import java.util.*;

/**
 * @ClassName SimpleHashMap
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 18:46
 */
public class SimpleLinkedHashMap<K, V> implements Map<K, V> {
    static final int SIZE = 997;
    private int count = 0;

    LinkedMapEntry<K, V>[] buckets = new LinkedMapEntry[SIZE];

    @Override
    public V put(K k, V v) {
        V oldValue = get(k);
        int index = Math.abs(k.hashCode() % SIZE);
        if (buckets[index] == null) {
            buckets[index] = new LinkedMapEntry<>(k, v);
            return null;
        }
        LinkedMapEntry<K, V> loop = buckets[index];
        while (true) {
            count++;
            if (loop.getKey().equals(k)) {
                oldValue = loop.getValue();
                if (oldValue.equals(v)) {
                    System.err.println("count:" + count);
                    System.err.println("the same data:" + loop);
                    return loop.getValue();
                }
                loop.setValue(v);
                return oldValue;
            }
            if (Objects.nonNull(loop.next)) {
                loop = loop.next;
            } else {
                break;
            }
        }
        loop.next = new LinkedMapEntry<>(k, v);
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
        for (LinkedMapEntry<K, V> entry : buckets) {
            while (Objects.nonNull(entry)) {
                entry = entry.next;
                size++;
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
        Collection<V> v = values();
        return v.contains(value);
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode() % SIZE);
        LinkedMapEntry<K, V> bucket = buckets[index];
        while (Objects.nonNull(bucket)) {
            if (bucket.getKey().equals(key)) {
                return bucket.getValue();
            }
            bucket = bucket.next;
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<Entry<K, V>> set = new HashSet<>();
        for (LinkedMapEntry<K, V> entry : buckets) {
            while (Objects.nonNull(entry)) {
                set.add(entry);
                entry = entry.next;
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
        for (LinkedMapEntry<K, V> entry : buckets) {
            while (Objects.nonNull(entry)) {
                rtn.add(entry.getKey());
                entry = entry.next;
            }
        }
        return rtn;
    }

    @Override
    public Collection<V> values() {
        Set<K> ks = keySet();
        Collection<V> rtn = new ArrayList<>();
        for (K k : ks) {
            rtn.add(get(k));
        }
        return rtn;
    }

    @Override
    public V remove(Object key) {
        V old = null;
        int index = Math.abs(key.hashCode() % SIZE);
        LinkedMapEntry<K, V> bucket = buckets[index];
        if (Objects.isNull(bucket)) {
            return old;
        }
        LinkedMapEntry<K, V> pre = null;
        while (Objects.nonNull(bucket)) {
            if (bucket.getKey().equals(key)) {
                if (pre == null) {
                    buckets[index] = bucket.next;
                } else {
                    pre.next = bucket.next;
                }
            }
            pre = bucket;
            bucket = bucket.next;
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
        SimpleLinkedHashMap<String, String> map = new SimpleLinkedHashMap<>();
        map.putAll(Countries.capitals(25));
        System.out.println(map);
        map.put("denmark", "Copenhagen");
        map.remove("denmark");
        System.out.println(map.get("denmark"));
        map.clear();
        System.out.println(map);
    }
}
