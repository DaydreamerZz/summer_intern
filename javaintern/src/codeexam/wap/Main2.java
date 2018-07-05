package codeexam.wap;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 2018/7/5 17:31
 * desc  :
 */
public class Main2 {

    public static ArrayList<String> leftLucky = new ArrayList<>();
    public static ArrayList<String> rightLucky = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];

        for(int i = 0;i<n;i++) {
            a[i] = in.nextInt();
        }
        long ans = 0;
        //write your code

        counter(a, 0, n-1);




        System.out.println(ans);
        return;
    }

    private static void counter(int[] a, int left, int right) {
        if(left < right) {
            if (right - left <= 2) { //to the end, 2 or 3 elements left, build lucky numbers
                build(a, left, right);
            }
            int mid = (left + right) / 2;
            counter(a, left, mid);
            counter(a, mid + 1, right);
//        merge();
        }
    }

    private static void build(int[] a, int left, int right) {
        boolean isLeft = true;
        if(right > a.length / 2){
            isLeft = false;
        }
        int k = right - left + 1;
        int x, y, z;
        if(k == 2){
            x = a[left]; y = a[right];
            test(x, y, isLeft);
            test(y, x, isLeft);
        }else{
            x = a[left]; y = a[left+1]; z = a[right];
            test(x, y, isLeft); test(y, x, isLeft);
            test(x, z, isLeft); test(z, x, isLeft);
            test(y, z, isLeft); test(z, y, isLeft);
        }
    }

    private static void test(int x, int y, boolean isLeft) {
        String tmpStr = x + "" + y;
        int tmpInt = Integer.valueOf(tmpStr);
        if(tmpInt % 7 == 0){ //lucky
            if(isLeft){
                leftLucky.add(tmpStr);
            }else
                rightLucky.add(tmpStr);

        }
    }
}
