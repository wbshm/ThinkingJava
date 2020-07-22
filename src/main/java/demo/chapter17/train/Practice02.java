package demo.chapter17.train;

import demo.chapter17.Countries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Practice02
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/21 17:45
 */
public class Practice02 {

    private static Map<String, String> countryStartA() {
        Map<String, String> capitals = Countries.capitals();
        Map<String, String> rtn = new HashMap<>(1);
        for (String s : capitals.keySet()) {
            if (s.charAt(0) == 'a') {
                rtn.put(s, capitals.get(s));
            }
        }
        return rtn;
    }

    private static Set<String> countriesStartA() {
        Map<String, String> capitals = Countries.capitals();
        Set<String> rtn = new HashSet<>(1);
        for (String s : capitals.keySet()) {
            if (s.charAt(0) == 'a') {
                rtn.add(s);
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        System.out.println(countryStartA());
        System.out.println(countriesStartA());
    }
}
