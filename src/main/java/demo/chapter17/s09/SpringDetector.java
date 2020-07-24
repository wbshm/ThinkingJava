package demo.chapter17.s09;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName SpringDetector
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/24 16:23
 */
public class SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<>();
        for (int i = 0; i < 19; i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }
        System.out.println("map = " + map);
        Groundhog gh = ghog.newInstance(3);
        System.out.println("Looking up prediction for " + gh);
        if (map.containsKey(gh)) {
            System.out.println(map.get(gh));
        } else {
            System.out.println("key not found: " + gh);
        }
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        detectSpring(Groundhog.class);
    }

}


class Groundhog {
    protected int number;

    public Groundhog(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Groundhog{" +
                "number=" + number +
                '}';
    }
}

class Prediction {
    private static Random random = new Random(47);
    private boolean shadow = random.nextDouble() > 0.5;

    @Override
    public String toString() {
        if (shadow) {
            return "Six more weeks of Winter!";
        }
        return "Early Spring!";
    }
}

class Groundhog2 extends Groundhog {

    public Groundhog2(int number) {
        super(number);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Groundhog2 && number == ((Groundhog2) obj).number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SpringDetector.detectSpring(Groundhog2.class);
    }
}
