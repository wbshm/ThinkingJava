package demo.chapter17;

/**
 * @ClassName Pair
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/8 16:23
 */
public class Pair<K, V> {
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
