package demo.chapter17.train;

import demo.chapter17.Countries;

import javax.sound.midi.SoundbankResource;
import java.util.*;

/**
 * @ClassName Practice07
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/23 10:35
 */
public class Practice07 {

    public static void main(String[] args) {


        List<String> arr = new ArrayList<>(Countries.names(25));
        List<String> link = new LinkedList<>(Countries.names(25));
        Iterator<String> arrIter = arr.iterator();

        System.out.println();
        Iterator<String> linkIter = link.iterator();

        System.out.println();
        ListIterator<String> ali = arr.listIterator();
        ListIterator<String> lli = link.listIterator();
        while (ali.hasNext()) {
            System.out.print(ali.next() + ", ");
        }
        while (lli.hasNext()) {
            System.out.print(lli.next() + ", ");
        }
        while (ali.hasPrevious()) {
            System.out.println(ali.previous());
            if (lli.hasPrevious()) {
                ali.add(lli.previous());
            }
        }
        while (ali.hasNext()) {
            System.out.print(ali.next() + ", ");
        }
    }
}
