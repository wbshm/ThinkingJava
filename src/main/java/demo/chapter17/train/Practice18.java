package demo.chapter17.train;

import demo.chapter17.Countries;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @ClassName Practice18
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 18:05
 */
public class Practice18 {
    public static void main(String[] args) {
        SlowSet<String> set = new SlowSet<>();
        set.addAll(Countries.names(10));
        set.addAll(Countries.names(10));
        System.out.println(set);
        set.remove("bulgaria");
        System.out.println(set);
        System.out.println("set.contains(\"Poland\"):" + set.contains("Poland"));
        set.add("test");
        System.out.println(set);
        set.removeAll(Countries.names(10));
        System.out.println(set);
    }
}

class SlowSet<T> extends AbstractSet<T> {
    ArrayList<T> data = new ArrayList<>();

    @Override
    public boolean add(T t) {
        if (contains(t)) {
            return false;
        } else {
            data.add(t);
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    public int size() {
        return data.size();
    }
}
