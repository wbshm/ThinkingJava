package demo.chapter8.music;

/**
 * @ClassName Music
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/30 18:47
 */
public class Music {
    public static void tune(Instrument i) {
        // ...
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute); // Upcasting
    }
}
