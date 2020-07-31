package demo.chapter8.music;

import static net.mindview.util.Print.print;

/**
 * @ClassName Wind
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/30 18:49
 */

class Instrument {
    public void play(Note n) {
        print("Instrument.play()");
    }
}

public class Wind extends Instrument {
    // Redefine interface method:
    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}
