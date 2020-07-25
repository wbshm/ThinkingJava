package demo.chapter17.s09;

import holding.MapOfList;
import typeinfo.pets.Pet;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName Individual
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/25 1:14
 */
public class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public Individual(String name) {
        this.name = name;
    }

    public Individual() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }

    public long id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Individual && id == ((Individual) o).id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (name != null) {
            result = result * 37 + name.hashCode();
        }
        result = result * 37 + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public int compareTo(Individual o) {
        String first = getClass().getSimpleName();
        String oFirst = o.getClass().getSimpleName();
        int firstCompare = first.compareTo(oFirst);
        if (firstCompare != 0) {
            return firstCompare;
        }
        if (name != null && o.name != null) {
            int secondCompare = name.compareTo(o.name);
            if (secondCompare != 0) {
                return secondCompare;
            }
        }
        return Long.compare(o.id, id);
    }
}

class IndividualTest {
    public static void main(String[] args) {
        Set<typeinfo.pets.Individual> set = new TreeSet<>();
        for (List<? extends Pet> lp : MapOfList.petPeople.values()) {
            for (Pet p : lp) {
                set.add(p);
            }
        }
        System.out.println(set);
    }

}
