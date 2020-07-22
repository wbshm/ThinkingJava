package demo.chapter17;

import java.util.*;

/**
 * @ClassName CountingMapData
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/21 17:18
 */
public class CountingMapData extends AbstractMap<Integer, String> {
    private int size;
    private static final String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData() {

    }

    public CountingMapData(int size) {
        this.size = Math.max(size, 0);
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i));
        }
        return entries;
    }

    public static Map<Integer, String> entrySets(int size) {
        return new CountingMapData() {
            @Override
            public Set<Map.Entry<Integer, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    private static class Entry implements Map.Entry<Integer, String> {
        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] + (index / chars.length);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
    }

    private static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {
        int size;

        public EntrySet(int size) {
            this.size = Math.min(size, chars.length);
            this.size = Math.max(this.size, 0);
        }

        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iter();
        }

        @Override
        public int size() {
            return size;
        }

        private class Iter implements Iterator<Map.Entry<Integer, String>> {
            private final Entry entry = new Entry(-1);

            @Override
            public boolean hasNext() {
                entry.index++;
                return entry.index < size;
            }

            @Override
            public Map.Entry<Integer, String> next() {
                return entry;
            }
        }
    }

    private static AbstractSet<Map.Entry<Integer, String>> entries = new EntrySet(chars.length);

    public static Map<Integer, String> getEntries(int size) {
        return new CountingMapData(size);
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData(60));
        System.out.println(entrySets(60));
    }
}
