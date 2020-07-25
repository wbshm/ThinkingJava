package demo.chapter17.s10;


/**
 * @ClassName Test
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/25 10:54
 */
public abstract class Test<C> {
    String name;

    public Test(String name) {
        this.name = name;
    }

    abstract int test(C container, TestParam tp);
}
