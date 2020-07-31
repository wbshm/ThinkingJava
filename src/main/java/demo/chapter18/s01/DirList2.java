package demo.chapter18.s01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @ClassName DirList2
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/31 9:43
 */
public class DirList2 {
    /**
     * 匿名内部类的参数必须是final。
     * 这样它才能够使用来自该范围之外的对象。
     *
     * @param regex
     * @return
     */
    public static FilenameFilter filter(String regex) {
        // Creation of anonymous inner class:
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        }; // End of anonymous inner class
    }

    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length != 0) {
            list = path.list();
        } else {
            list = path.list(filter("(.*).xml"));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
