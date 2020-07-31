package demo.chapter8.shape;

import static net.mindview.util.Print.print;

/**
 * @ClassName Circle
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/30 21:42
 */
public class Circle extends Shape {
    @Override
    public void draw() {
        print("Circle.draw()");
    }

    @Override
    public void erase() {
        print("Circle.erase()");
    }
}
