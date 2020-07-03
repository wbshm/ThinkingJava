package demo.chapter5;

/**
 * 5.5.3 终结条件 ， demo
 *
 *
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
