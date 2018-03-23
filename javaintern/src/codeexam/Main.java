package codeexam;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String getMaxSimilarChar(String str1, String str2) {
        String result = "#";
        if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
            return result;

        HashMap<Integer, String> map = new HashMap<>();
        String strMax, strMin;
        if(str1.length() > str2.length()){
            strMax = new String(str1);
            strMin = new String(str2);
        }else{
            strMax = new String(str2);
            strMin = new String(str1);
        }

        char[] max = strMax.toCharArray();
        char[] min = strMin.toCharArray();
        int currentMax = 0;
        for(int i = 0; i < min.length; i++){
            int tmpI = i;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < max.length; j++){
                if(max[j] != min[tmpI]){ //
                    currentMax = 0;
                    continue;
                }else{
                    currentMax++;
                    tmpI++;
                    sb.append(max[j]);
                    if(tmpI == min.length) {
                        map.put(currentMax, sb.toString());
                        break;
                    }
                }

            }
        }

        Set<Integer> integers = map.keySet();
        int maxLen = 0;
        String res = "";
        for(Integer i : integers){
            System.out.println(i);
            String value = map.get(i);
            if(i > maxLen){
                maxLen = i;
                res = value;
            }
        }
        return "" + maxLen + "=>" + res;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;
            
        String _str1;
        try {
            _str1 = in.nextLine();
        } catch (Exception e) {
            _str1 = null;
        }
        
        String _str2;
        try {
            _str2 = in.nextLine();
        } catch (Exception e) {
            _str2 = null;
        }
  
        res = getMaxSimilarChar(_str1, _str2);
        System.out.println(res);
    }
}