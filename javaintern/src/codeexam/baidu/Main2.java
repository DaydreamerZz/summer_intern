package codeexam.baidu;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/18 18:33
 * desc   :
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int told[] = new int[n];
        for(int i = 0; i < n; i++){
            told[i] = scanner.nextInt();
        }
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        ArrayList<Integer> list;
        for(int i = 0; i < n; i++){
            list = new ArrayList<>();
            list.add(i);
            result.add(list);
        }


        boolean flag = true;
        Arrays.sort(told);
        int tmp = told[0];
        int counter = 1;
        int max = -1;
        for(int i = 1; i < n; i++){
            if(tmp != told[i]){
                tmp = told[i];
                if(counter > max)
                    max = counter;
                counter = 1;
            }else{
                counter++;
            }
        }
        System.out.println(max+1);
        return;
    }


}

