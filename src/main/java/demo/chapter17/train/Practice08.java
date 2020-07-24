package demo.chapter17.train;

import demo.chapter17.Countries;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Practice08
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/23 11:09
 */
public class Practice08 {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>(Countries.names(10));
        SListIterator<String> iterator = new Slist<String>().iterator(data);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class Slist<T> {
    public T data;
    public Slist<T> next = null;

    public SListIterator<T> iterator(List<T> data) {
        Slist<T> tSlist;
        Slist<T> start = new Slist<>();
        Slist<T> tmp = start;
        for (T val : data) {
            tSlist = new Slist<>();
            tSlist.data = val;
            start.next = tSlist;
            start = start.next;
        }
        return new SListIterator<>(tmp.next);
    }


    @Override
    public String toString() {
        return "Slist{" +
                "data=" + data +
//                ", next=" + next +
                '}';
    }
}

class SListIterator<T> {
    public Slist<T> data;

    public SListIterator(Slist<T> data) {
        this.data = data;
    }

    public boolean hasNext() {
        return data != null;
    }

    public Slist<T> next() {
        Slist<T> next = data;
        data = data.next;
        return next;
    }
}

