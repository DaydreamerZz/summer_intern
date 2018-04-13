package codeexam.bank;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputInt = scanner.nextInt();


//        int inputInt = 3;
        if(inputInt < 0){
            inputInt = Math.abs(inputInt);
        }
        int start = 0;
        int count = 0;
        while(start != inputInt){
            if(start == 0){
                start += 1;
                count += 1;
            }else{
                int x = start * 2;
                if(x == inputInt){
                    System.out.println(count);
                    return;
                }else if(x < inputInt){
                    start = x;
                    count += 1;
                    continue;
                }else{
                    int y = start + 1;
                    if((x-inputInt) >= (inputInt-y)){
                        start = y;
                        count += 1;
                    }else{
                        count += (x-inputInt);
                        System.out.println(count);
                        return;
                    }
                }

            }
        }
        System.out.println(count);
        return;
    }
}
