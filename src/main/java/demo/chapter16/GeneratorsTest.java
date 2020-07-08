package demo.chapter16;

import net.mindview.util.Generator;

/**
 * @ClassName GeneratorsTest
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/8 15:30
 */
public class GeneratorsTest {
    public static int size = 10;

    public static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()) {
            System.out.print(type.getSimpleName() + ": ");
            try {
                Generator<?> g = (Generator<?>) type.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.print(g.next() + " ");
                }
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) {
        test(CountingGenerator.class);
    }
}
