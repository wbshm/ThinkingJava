package demo.chapter17.s10;

import javax.sound.midi.Synthesizer;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MapPerformance
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/25 15:25
 */
public class MapPerformance {
    static List<Test<Map<Integer, Integer>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Map<Integer, Integer>>("put") {

            @Override
            int test(Map<Integer, Integer> container, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++) {
                        container.put(j, j);
                    }
                }
                return loops * size;
            }
        });

        tests.add(new Test<Map<Integer, Integer>>("get") {

            @Override
            int test(Map<Integer, Integer> container, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++) {
                        container.get(j);
                    }
                }
                return loops * span;
            }
        });

        tests.add(new Test<Map<Integer, Integer>>("iterate") {

            @Override
            int test(Map<Integer, Integer> container, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator it = container.entrySet().iterator();
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
        Tester.fieldWidth = 10;
        Tester.run(new TreeMap<>(), tests);
        Tester.run(new HashMap<>(), tests);
        Tester.run(new LinkedHashMap<>(), tests);
        Tester.run(new WeakHashMap<>(), tests);
        Tester.run(new ConcurrentHashMap<>(), tests);
        Tester.run(new IdentityHashMap<>(), tests);
    }

}
