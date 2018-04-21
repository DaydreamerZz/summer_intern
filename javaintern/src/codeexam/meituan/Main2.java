/*package codeexam.meituan;

import java.util.Scanner;

*//**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/20 18:44
 * desc   :
 *//*
public class Main2 {

    public static void main(String[] args) {
        int[] array = new int[]{
                0, 10, 90, 900, 9000, 90000, 900000, 9000000, 90000000, 900000000
        };

        Scanner scanner = new Scanner(System.in);
        int inputTimes = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < inputTimes; i++){
            String numberStr = scanner.nextLine();
            int numberInt = Integer.parseInt(numberStr);
            StringBuilder sb = new StringBuilder(numberStr);
            long counter = 0;
            *//*if(numberStr.length() > 2) {
                while (numberStr.length() > 2) {
                    int len = numberStr.length();
                    *//**//*int countA = 1;
                    for(int j = 0; j < len; j++){
                        countA = countA * 10;
                    }*//**//*
                    String substring = numberStr.substring(1);
                    int countB = Integer.parseInt(substring);
                    counter += (countB+1) * len;
                    numberStr = substring;
                }
            }*//*

            if(numberStr.length() > 2){
                int len = numberStr.length();
                int m = Integer.parseInt(numberStr.charAt(0)+"");
                counter += (m-1)*array[len-1];
                for(int j = len-1; j > 0; j--){
                    counter += array[j] * j;
                }
                String substring = numberStr.substring(1);
                int countA = Integer.parseInt(substring);
                counter += (countA+1) * len;
                System.out.println(counter);
            }else{
                StringBuilder sb2 = new StringBuilder();
                for(int j = 1; j <= numberInt; j++){
                    sb2.append(j);
                }
                System.out.println(sb2.length());
            }


            *//*numberInt = Integer.parseInt(numberStr);
            StringBuilder sb2 = new StringBuilder();
            for(int j = 1; j <= numberInt; j++){
                sb2.append(j);
            }
            counter += sb2.length();
//            System.out.println(sb.toString());
            System.out.println(counter);*//*

        }
        return;
    }
}*/



package codeexam.meituan;

import java.util.Scanner;


public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int inputTimes = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < inputTimes; i++){
            int number = scanner.nextInt();
            scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            long counter = 0;
            for(int j = 1; j <= number; j++){
                sb.append(j);
                int length = sb.length();
                if(length >= 10000){
                    counter += length;
                    sb.delete(0, length-1);
                }
            }
            counter += sb.length();
//            System.out.println(sb.toString());
            System.out.println(counter);

        }
        return;
    }
}

