package codeexam.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/11 18:56
 * @desc :
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();

        int oneNumber = count(number);
        String s = Long.toString(number, 2);
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
//        System.out.println(s);
        char[] chars = s.toCharArray();
        int[] ints = new int[chars.length];
        for(int i = 0; i < chars.length; i++){
            ints[i] = chars[i] - '0';
        }
        System.out.println(Arrays.toString(ints));

        int numberLen = s.length();
        int[] array = new int[numberLen];
        for(int i = 0; i < oneNumber; i++){
            array[i] = 1;
        }

//        System.out.println(Arrays.toString(array));

        int index = 1;
        int startIndex = oneNumber - 1; //第一个1的位置
        boolean flag = true;
        while(flag){

            for(int i = startIndex, count = 0; count < oneNumber; i--, count++){
                if(i+1 >= array.length){
                    continue;
                }
                swap(array, i, i + 1);
                if(Arrays.equals(array, ints)){
                    flag = false;
                    break;
                }else{
                    index ++;
                }
            }
            startIndex++;

        }
        System.out.println(index);
//        return;
    }

    private static void swap(int[] array, int startIndex, int next) {
        array[startIndex] = array[startIndex] ^ array[next];
        array[next] = array[startIndex] ^ array[next];
        array[startIndex] = array[startIndex] ^ array[next];
    }

    private static int count(long number) {
        int counter = 0;
        while(number > 0){
            if((number & 1) > 0)
                counter++;
            number = number >> 1;
        }
        return counter;
    }
}
