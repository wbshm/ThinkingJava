package demo.chapter17.s09;

import java.util.Objects;

/**
 * @ClassName MapEntry
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 17:11
 */
public class MapEntry<K, V> implements java.util.Map.Entry<K, V> {
    private K k;
    private V v;

    public MapEntry(K k, V v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }

    @Override
    public V setValue(V value) {
        V old = this.v;
        this.v = value;
        return old;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
        return Objects.equals(k, mapEntry.getKey()) &&
                Objects.equals(v, mapEntry.getValue());
    }

    @Override
    public int hashCode() {
        return (k == null ? 0 : k.hashCode()) ^ (v == null ? 0 : v.hashCode());
    }

    @Override
    public String toString() {
        return k + " = " + v;
    }
}
