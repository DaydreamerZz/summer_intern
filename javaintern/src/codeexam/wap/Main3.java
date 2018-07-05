package codeexam.wap;

import java.util.Arrays;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 2018/7/5 19:35
 * desc  :
 */
public class Main3 {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3};
        permutatioin(array, 0);
        return;
    }

    public static void permutatioin(int array[], int index){
        if(index == array.length-1){
            System.out.println(Arrays.toString(array));
        }else{
            for(int i = index; i <= array.length-1; i++)
            {
                swap(array, i, index);//相当于: 固定第 i 个字符
                permutatioin(array, index+1);//求出这种情形下的所有排列
                swap(array, index, i);//复位
            }
        }
    }

    private static void swap(int[] c, int i, int j){
        int tmp;
        tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
}
