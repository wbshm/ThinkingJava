package demo.chapter11;

import java.util.*;

/**
 * @ClassName AdapterMethodIdiom
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/7 20:04
 */
public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(
                Arrays.asList("To be or not to be".split(" "))
        );
        for (String s : ral) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : ral.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : ral.randomized()) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reversed() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }


    public Iterable<T> randomized() {
        return () -> {
            T[] objects = (T[]) super.toArray();
            List<T> str = Arrays.asList(objects);
            Collections.shuffle(str);
            return str.iterator();
        };
    }
}
