package demo.chapter17.train;

import demo.chapter16.RandomGenerator;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName Practice09
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 10:24
 */
public class Practice09 {
    public static void main(String[] args) {
        Set<TestString> set = new TreeSet<>();

        RandomGenerator.String rand = new RandomGenerator.String(5);
        set.add(new TestString(rand.next()));
        set.add(new TestString(rand.next()));
        set.add(new TestString(rand.next()));
        set.add(new TestString(rand.next()));

        for (TestString string : set) {
            System.out.println(string);
        }
    }
}

class TestString implements Comparable<TestString> {
    String data;

    public TestString(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestString that = (TestString) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public int compareTo(TestString o) {
        char c = data.length() > 0 ? Character.toLowerCase(data.charAt(0)) : 0;
        char n = o.data.length() > 0 ? Character.toLowerCase(o.data.charAt(0)) : 0;
        return Integer.compare(c, n);
    }

    @Override
    public String toString() {
        return data;
    }
}
