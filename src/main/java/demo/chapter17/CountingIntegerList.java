package demo.chapter17;

import java.util.AbstractList;

/**
 * @ClassName CountingIntegerList
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/11 22:42
 */
public class CountingIntegerList extends AbstractList<Integer> {
    private Integer size;

    public CountingIntegerList(Integer size) {
        this.size = Math.max(0, size);
    }

    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new CountingIntegerList(30));
    }
}
