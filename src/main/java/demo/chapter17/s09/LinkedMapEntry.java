package demo.chapter17.s09;

import java.util.Objects;

/**
 * @ClassName LinkMapEnty
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 23:39
 */
public class LinkedMapEntry<K, V> extends MapEntry<K, V> {

    LinkedMapEntry<K, V> next = null;

    public LinkedMapEntry(K k, V v) {
        super(k, v);
    }

    public void setNext(LinkedMapEntry<K, V> next) {
        this.next = next;
    }

    public LinkedMapEntry<K, V> next() {
        return next;
    }

    public boolean hasNext() {
        return Objects.nonNull(next);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
