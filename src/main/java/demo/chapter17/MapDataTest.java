package demo.chapter17;

import demo.chapter16.CountingGenerator;
import demo.chapter16.RandomGenerator;
import net.mindview.util.Generator;

import java.util.Iterator;


class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {

    private int size = 9;
    private int number = 1;
    private char letter = 'A';

    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++, "" + letter++);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            @Override
            public void remove() {
                throw new RuntimeException();
            }
        };
    }
}

/**
 * @ClassName MapDataTest
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/8 17:13
 */

public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(), 11));
        MapData<Character, String> map = MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3), 8);
        System.out.println(map);
        map = MapData.map(new CountingGenerator.Character(), "Value", 6);
        System.out.println(map);
        MapData<Integer, String> map1 = MapData.map(new Letters(), new RandomGenerator.String(3));
        System.out.println(map1);
        System.out.println(MapData.map(new Letters(), "Value"));
    }
}
