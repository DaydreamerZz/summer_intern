package corejava.ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntConsumer;

import static java.lang.System.out;
/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/15 19:52
 */


public class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        return str1.length() - str2.length();
    }
    public static void main(String[] args){
        String[] names = {"tom", "alice", "fred"};
        Arrays.sort(names);
        out.println(Arrays.toString(names));

        /*Comparator<String> comp = (first, second) -> first.length() - second.length();
        Arrays.sort(names, comp);

        Arrays.sort(names, (first, second) -> first.length() - second.length());*/

//        Arrays.sort(names, (x, y)->x.compareToIgnoreCase(y));

        repeat(10, (i) -> System.out.println("hello" + i));




    }
    public static void repeat(int n, IntConsumer action){
    for(int i = 0; i < n; i++)
        action.accept(i);
    }
}
