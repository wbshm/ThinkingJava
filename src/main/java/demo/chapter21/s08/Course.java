package demo.chapter21.s08;

import net.mindview.util.Enums;

/**
 * @InterfaceName Course
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/30 17:03
 */

public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;

    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}
