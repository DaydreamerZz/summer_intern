package codeexam.wap;

import java.util.HashSet;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 2018/7/5 19:41
 * desc  :
 */
public class Main4 {

    public static HashSet<String> set;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];

        for(int i = 0;i<n;i++) {
            a[i] = in.nextInt();
        }
        long ans = 0;
        //write your code

        set = new HashSet<>();
        if(n <= 1000){
            for(int i = 1; i < 290; i++){
                set.add(7 * i + "");
            }
        }else{
            for(int i = 1; i < 1000000000; i++){
                set.add(7 * i + "");
            }
        }
        long x, y;
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                x = a[i]; y = a[j];
                if(test(x, y))
                    ans++;
                if(test(y, x))
                    ans++;
            }
        }
        System.out.println(ans);
        return;
    }

    private static boolean test(long x, long y) {
        String tmpStr = x + "" + y;
        if(set.contains(tmpStr))
            return true;
        else
            return false;
    }
}
