package codeexam;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String[] replay_plan(String lostCreditNumberStr) {
        int lostCreditNumber = Integer.parseInt(lostCreditNumberStr);


    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] res;
            
        String lostCreditNumberStr;
        try {
            lostCreditNumberStr = in.nextLine();
        } catch (Exception e) {
            lostCreditNumberStr = null;
        }
  
        res = replay_plan(lostCreditNumberStr);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
