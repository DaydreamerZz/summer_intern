package codeexam.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/20 18:44
 * desc   :
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, n, m, p;
        N = scanner.nextInt();
        n = scanner.nextInt();
        m = scanner.nextInt();
        p = scanner.nextInt();
        int[] array = new int[N];
        array[0] = p;
        for(int i = 1; i < N; i++){
            array[i] = (array[i-1]+153) % p;
        }

        //System.out.println(Arrays.toString(array));

        long result = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int k = gcd(i, j);
                result += array[k-1];
            }
        }

        System.out.println(result);
        return;
    }

    private static int gcd(int i, int j) {
        int k;
        while ((k=i%j) != 0) {
            i = j;
            j = k;
        }
        return j;
    }
}
