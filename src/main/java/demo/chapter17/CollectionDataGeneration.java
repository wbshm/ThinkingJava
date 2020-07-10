package demo.chapter17;

import demo.chapter16.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @ClassName CollectionDataGeneration
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/8 16:14
 */
public class CollectionDataGeneration {
    public static void main(String[] args) {
        System.out.println(new ArrayList<>(
                CollectionData.list(new RandomGenerator.String(), 10)
        ));
        System.out.println(new HashSet<>(
                new CollectionData<>(new RandomGenerator.Integer(), 10)
        ));
    }
}
