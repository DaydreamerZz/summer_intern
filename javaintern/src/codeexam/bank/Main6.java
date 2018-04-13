package codeexam.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main6 {

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

        int index = 1;
        long currentValue, i, j, k, v= 0L;
        while (index < 50) {
            currentValue = result.get(index);
            i = currentValue * 2;
            j = currentValue * 3;
            k = currentValue * 5;
            v = currentValue * 7;
            if (!result.contains(i))
                result.add(i);
            if (!result.contains(j))
                result.add(j);
            if (!result.contains(k))
                result.add(k);
            if (!result.contains(v))
                result.add(v);
            index += 1;

            //Collections.sort(result);
            //if(result.get(result.size()/2) > inputLong)
              //  break;
        }
        Collections.sort(result);
        //System.out.println(result);

        Long inputLong;
        while(true) {
            try {
                inputLong = scanner.nextLong();
            }catch (Exception e){
                return;
            }
            //long inputLong = Long.parseLong(inputStr);
            //int inputInt = 5;
            boolean flag = true;

            long nearLessOne = 0L;
            int m = 0;
            for (; m < result.size(); m++) {
                if (result.get(m) < inputLong)
                    continue;
                else if (result.get(m) == inputLong) {
                    flag = false;
                    System.out.println(inputLong);
                } else
                    break;
            }
            if (flag) {
                nearLessOne = result.get(m - 1);
                long nearLargeOne = result.get(m);

                long a = inputLong - nearLessOne;
                long b = nearLargeOne - inputLong;
                if (a == b) {
                    System.out.println(nearLessOne);
                } else if (a < b) {
                    System.out.println(nearLessOne);
                } else {
                    System.out.println(nearLargeOne);
                }
            }

//                System.out.println(nearLessOne + " " + nearLargeOne);
                System.out.println(result);

        }



    }
}
