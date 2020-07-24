package demo.chapter17;

import javax.sound.midi.SoundbankResource;
import java.util.LinkedList;

/**
 * @ClassName Deque
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 14:03
 */
public class Deque<T> {
    private LinkedList<T> deque = new LinkedList<>();

    public void addFirst(T e) {
        deque.addFirst(e);
    }

    public void addLast(T e) {
        deque.addLast(e);
    }

    public T getFirst() {
        return deque.getFirst();
    }

    public T getLast() {
        return deque.getLast();
    }

    public T removeFirst() {
        return deque.removeFirst();
    }

    public T removeLast() {
        return deque.removeLast();
    }

    public int size() {
        return deque.size();
    }

    @Override
    public String toString() {
        return "Deque{" +
                "deque=" + deque +
                '}';
    }
}


class DequeTest {
    static void fillTest(Deque<Integer> deque) {
        for (int i = 20; i < 27; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i < 55; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> di = new Deque<>();
        fillTest(di);
        System.out.println(di);
        while (di.size() != 0) {
            System.out.print(di.removeFirst() + " ");
        }
        System.out.println();
        fillTest(di);
        while (di.size() != 0) {
            System.out.print(di.removeLast() + " ");
        }
    }
}
