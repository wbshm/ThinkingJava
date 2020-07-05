package demo.chapter5;

/**
 * @ClassName InitialValues
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/3 11:36
 */
public class InitialValues {
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;

    void InitialValues() {
        System.out.println("Data type Initial value");
    }

    @Override
    public String toString() {
        return "InitialValues{" +
                "boolean t is :" + t + "\n" +
                "char c is :" + c + "\n" +
                "byte b is :[" + b + "]" + "\n" +
                "short s is :" + s + "\n" +
                "int i is :" + i + "\n" +
                "long l is :" + l + "\n" +
                "float f is :" + f + "\n" +
                "double d is :" + d + "\n" +
                ", reference=" + reference + "\n" +
                '}';
    }

    public static void main(String[] args) {
        InitialValues values = new InitialValues();
        System.out.println(values);
        System.out.println(new InitialValues().toString());
    }
}
