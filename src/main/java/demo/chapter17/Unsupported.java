package demo.chapter17;

import java.util.*;

/**
 * @ClassName Unsupported
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/22 12:09
 */
public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        Collection<String> c2 = new ArrayList<>(subList);

        try {
            c.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }

        try {
            c.removeAll(c2);
        } catch (Exception e) {
            System.out.println("removeAll(): " + e);
        }

        try {
            c.clear();
        } catch (Exception e) {
            System.out.println("clear(): " + e);
        }

        try {
            c.add("X");
        } catch (Exception e) {
            System.out.println("add(): " + e);
        }

        try {
            c.addAll(c2);
        } catch (Exception e) {
            System.out.println("addAll(): " + e);
        }

        try {
            c.remove("C");
        } catch (Exception e) {
            System.out.println("remove(): " + e);
        }

        try {
            list.set(0, "X");
        } catch (Exception e) {
            System.out.println("List.set(): " + e);
        }
    }

    /**
     * Arrays.asList()会生成一个List,它是一个固定大小的数组，禁止抽那些不会改变数组大小的操作。
     * unmodifiableList的结果在任何情况下都应该不是可修改的
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" "));
        test("Modifiable Copy", new ArrayList<>(list));
        test("Array.asList()", list);
        test("unmodifiableList", Collections.unmodifiableList(new ArrayList<>(list)));
    }
}
