import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.out;
/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/15 19:52
 */


public class LengthComparator implements Comparator<String> {

    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

    public static void main(String[] args){
        String[] names = {"tom", "alice", "fred"};
        Arrays.sort(names, new LengthComparator());
        out.println(Arrays.toString(names));
    }
}
