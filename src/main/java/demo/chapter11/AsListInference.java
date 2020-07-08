package demo.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName AsListInferrence
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/7 15:25
 */
public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snows1 = Arrays.asList(
                new Crusty(), new Slush(), new Powder());

        List<Snow> snows2 = Arrays.asList(
                new Light(), new Heavy()
        );
//        Collections.addAll();
        List<Snow> snows3 = new ArrayList<Snow>();
        Collections.addAll(snows3, new Light(), new Heavy());

        List<Snow> snows4 = Arrays.<Snow>asList(new Light(), new Heavy());
    }

}

class Snow {
}

class Powder extends Snow {
}

class Light extends Snow {
}

class Heavy extends Snow {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}
