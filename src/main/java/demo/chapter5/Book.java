package demo.chapter5;

/**
 * 5.5.3 终结条件 ， demo
 * <p>
 * 本例的终结条件： 所有的Book对象在本当做垃圾回收钱都应该被签入(check in)。
 * 在main方法中，有一本书未被签入。要是没有finalize()来验证终结条件，将很难发现这种缺陷。
 *
 * @ClassName Book
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/3 11:00
 */
public class Book {
    boolean checkedOut = false;

    public Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    @Override
    protected void finalize() {
        if (checkedOut) {
            System.out.println("Error : checked out");
            // Normally ,you'll also do this
            //super.finalize();
        }
    }

    public static void main(String[] args) {
        Book novel = new Book(true);
        // Proper cleanup
        novel.checkIn();
        // Drop the reference ,forget to clean up
        new Book(true);
        // Force garbage collection & finalization
        System.gc();
    }
}
