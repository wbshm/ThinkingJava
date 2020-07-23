package demo.chapter17.train;

import net.mindview.util.TextFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @ClassName Practice04
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/21 18:41
 */
public class Practice04 {

    public static Collection createCollectionByFile() {
        /**
         * 1. 打开一个文件。
         * 2. 用TextFile将其断开为单词
         * 3. 讲这些单词作为所产生的Collection的数据源
         */
        String fileName = "D:\\P\\javaWorkSpace\\ThinkingJava\\src\\main\\resources\\chapter17-train-practice04.txt";
        String read = TextFile.read(fileName);
        return new ArrayList<>(Arrays.asList(read.split(" ")));
    }

    public static void main(String[] args) {
        Collection collectionByFile = createCollectionByFile();
        System.out.println(collectionByFile);
    }
}
