package codeexam.bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

    static final int[] numbers = new int[]{2, 3, 5, 7};
    public static void main(String[] args) {

        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        Scanner scanner = new Scanner(System.in);
        int inputInt = scanner.nextInt();
        //int inputInt = 5;
        for(int i = 2; i < 100; i++){
            if(match(i, result)){
                result.add(i);
            }
        }
        System.out.println(result);
        System.out.println(result.get(inputInt-1));

        return;
    }

    private static boolean match(int i, ArrayList<Integer> result) {
        if(i == 2 || i == 3 || i == 5)
            return true;
        //while(i != 0){
           for(int number : numbers){
               int tmp = i / number;
               int left = i % number;
               if(left == 0 && result.contains(tmp)){
                   return true;
               }else{
                   continue;
               }
           }
        //}
        return false;
    }
}
