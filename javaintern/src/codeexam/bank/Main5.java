package codeexam.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main5 {

//    static final int[] numbers = new int[]{2, 3, 5};

    public static void main(String[] args) {

        ArrayList<Long> result = new ArrayList<>();

        result.add(1L);
        result.add(2L);
        result.add(3L);
        result.add(5L);
        result.add(7L);
        Scanner scanner = new Scanner(System.in);
        String inputStr;

        int index = 0;
        while(scanner.hasNext()) {
            inputStr = scanner.nextLine();
            long inputLong = Long.parseLong(inputStr);
            //int inputInt = 5;
            boolean flag = true;

            long currentValue, i, j, k = 0L;
            while (true) {
                currentValue = result.get(index);
                i = currentValue * 2;
                j = currentValue * 3;
                k = currentValue * 5;
                if(i > inputLong)
                    break;
                if(i == inputLong){
                    System.out.println(i);
                    result.add(i);
                    flag = false;
                    break;
                }
                if(j == inputLong){
                    System.out.println(j);
                    result.add(j);
                    flag = false;
                    break;
                }
                if(k == inputLong){
                    System.out.println(k);
                    result.add(k);
                    flag = false;
                    break;
                }

                if (!result.contains(i))
                    result.add(i);
                if (!result.contains(j))
                    result.add(j);
                if (!result.contains(k))
                    result.add(k);
                index += 1;

                //Collections.sort(result);
                //if(result.get(result.size()/2) > inputLong)
                  //  break;
            }
            if(flag) {
                Collections.sort(result);
                long nearLessOne = 0L;
                int m = 0;
                for (; m < result.size(); m++) {
                    if (result.get(m) < inputLong)
                        continue;
                    else
                        break;
                }
                nearLessOne = result.get(m-1);
                long nearLargeOne = result.get(m);

                long a = inputLong-nearLessOne;
                long b = nearLargeOne-inputLong;
                if(a == b){
                    System.out.println(nearLessOne);
                }else if(a < b){
                    System.out.println(nearLessOne);
                }else{
                    System.out.println(nearLargeOne);
                }

//                System.out.println(nearLessOne + " " + nearLargeOne);
                System.out.println(result);
            }

        }
        return;
    }
}
