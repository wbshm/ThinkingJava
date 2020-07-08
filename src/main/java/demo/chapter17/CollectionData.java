package demo.chapter17;

import net.mindview.util.Generator;

import java.util.ArrayList;

/**
 * @ClassName CollectionData
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/8 11:26
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<>(gen, quantity);
    }
}
