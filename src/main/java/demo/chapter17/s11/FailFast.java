package demo.chapter17.s11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * 程序运行时发生了异常，因为在容器取得迭代器之后，又有东西呗放入到该容器中。
 * 当程序的不同部分修改同一个容器时，就可能导致容器的状态不一致，所以，此异常提醒你，应该修改代码。
 *
 * 在此例中，应该在添加完所有的元素之后，在获取迭代器。
 *
 * @ClassName FailFast
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/25 22:41
 */
public class FailFast {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Iterator<String> it = c.iterator();
        c.add("An Object");
        try {
            String s = it.next();
        } catch (ConcurrentModificationException e) {
            System.out.println(e);
        }
    }
}
