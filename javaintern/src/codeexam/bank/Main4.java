package codeexam.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main4 {

//    static final int[] numbers = new int[]{2, 3, 5};
    int[] stack;
    public Main4(int size){
        stack = new int[size];

    }
    public static void main(String[] args) {

        Main4 m = new Main4(9);


        ArrayList<Integer> result = new ArrayList<>();

        result.add(1);
        result.add(2);
        result.add(3);
        result.add(5);
        Scanner scanner = new Scanner(System.in);
        int inputInt = scanner.nextInt();
        //int inputInt = 5;

        int index = 0;
        int currentValue, i, j, k;
        while(result.size() < inputInt*2){
            currentValue = result.get(index);
            i = currentValue * 2;
            j = currentValue * 3;
            k = currentValue * 5;
            if(!result.contains(i))
                result.add(i);
            if(!result.contains(j))
                result.add(j);
            if(!result.contains(k))
                result.add(k);
            index += 1;
            Collections.sort(result);
        }
        System.out.println(result);
        System.out.println(result.get(inputInt-1));
        return;
    }
}
