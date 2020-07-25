package demo.chapter17.s10;

import java.util.*;

/**
 * @ClassName SetPerformance
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/25 15:01
 */
public class SetPerformance {

    static List<Test<Set<String>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Set<String>>("add") {
            @Override
            int test(Set<String> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.add(Integer.toString(j));
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<String>>("contains") {
            @Override
            int test(Set<String> container, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++) {
                        container.contains(Integer.toString(j));
                    }
                }
                return loops * span;
            }
        });
        tests.add(new Test<Set<String>>("iterate") {

            @Override
            int test(Set<String> container, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<String> it = container.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                return loops * container.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        Tester.fieldWidth = 30;
        Tester.run(new TreeSet<>(), tests);
        Tester.run(new HashSet<>(), tests);
        Tester.run(new LinkedHashSet<>(), tests);
    }
}
