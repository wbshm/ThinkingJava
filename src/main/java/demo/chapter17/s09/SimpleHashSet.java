package demo.chapter17.s09;

import java.util.*;
import java.util.function.Consumer;

/**
 * @ClassName SimpleHashSet
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 23:00
 */
public class SimpleHashSet<T> implements Set<T> {

    private static int SIZE = 999;

    private LinkedList<T>[] buckets = new LinkedList[SIZE];

    @Override
    public int size() {
        int size = 0;
        for (LinkedList<T> lists : buckets) {
            if (Objects.isNull(lists)) {
                continue;
            }
            size += lists.size();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (LinkedList<T> lists : buckets) {
            if (Objects.isNull(lists)) {
                continue;
            }
            if (lists.contains(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        Object[] rtn = new Object[size()];
        int index = 0;
        for (LinkedList<T> lists : buckets) {
            if (Objects.isNull(lists)) {
                continue;
            }
            for (T t : lists) {
                rtn[index++] = t;
            }
        }
        return rtn;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        int index = getIndex(t);
        boolean exists = false;
        if (Objects.nonNull(buckets[index])) {
            for (int i = 0; i < buckets[index].size(); i++) {
                if (buckets[index].get(i).equals(t)) {
                    exists = true;
                    break;
                }
            }
        }
        if (exists) {
            return false;
        } else {
            buckets[index].add(t);
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        int index = getIndex((T) o);
        if (Objects.nonNull(buckets[index])) {
            return buckets[index].remove(o);
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Iterator<? extends T> iterator = c.iterator();
        boolean isChanged = false;
        while (iterator.hasNext()) {
            isChanged = add(iterator.next()) || isChanged;
        }
        return isChanged;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isChanged = false;
        boolean b;
        for (int i = 0; i < SIZE; i++) {
            if (Objects.nonNull(buckets[i])) {
                b = buckets[i].retainAll(c);
                if (b) {
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        boolean isChanged = false;
        while (iterator.hasNext()) {
            isChanged = remove(iterator.next()) || isChanged;
        }
        return isChanged;
    }

    @Override
    public void clear() {
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = null;
        }
    }

    private int getIndex(T t) {
        return Math.abs(t.hashCode() % SIZE);
    }

    private class Itr implements Iterator<T> {
        int index = 0;
        T[] data = (T[]) toArray();

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            T rtn = data[index];
            index++;
            return rtn;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            throw new UnsupportedOperationException();
        }
    }
}
