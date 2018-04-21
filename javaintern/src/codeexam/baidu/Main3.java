package codeexam.baidu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/18 18:40
 * desc   :
 */
public class Main3 {


    public static void main(String[] args) {
        ArrayList<String> splits = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n, k;
        n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();
        String inputStr = scanner.nextLine();

        long max = 0;

        System.out.println(f(inputStr, n, k, splits));

        return;
    }

    static int f(String input, int n, int k, ArrayList<String> splits){
        int leftLen = n - k;
        for(int i = 0; i < k+1; i++){
            input.substring(i, i+leftLen-1);
            if(input.substring(i + leftLen-1).length() == k-1){
                splits.add(input.substring(i+leftLen-1));
            }
            //f(input.substring(i + leftLen), n - k, k - 1, splits);
        }
        return 144;


    }
}
