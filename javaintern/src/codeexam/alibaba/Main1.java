package codeexam.alibaba;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main1 {

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String ipMatch(String ip, String[] ipRangeList) {
//        int[] lens = new int[]{4, 7, 9, 11};
        int[] lens = new int[]{10, 8, 7, 4};
        for(int i = 0; i < lens.length; i++){
            String substring = ip.substring(0, lens[i]);
            for(int j = 0; j < ipRangeList.length; j++){
                if(ipRangeList[j].startsWith(substring)){
                    return ipRangeList[j];
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;
        
        String _ip;
        try {
            _ip = in.nextLine();
        } catch (Exception e) {
            _ip = null;
        }
        
        List<String> _ipRangeList = new ArrayList<>();
        
        while (in.hasNextLine()) {
            try {
                String temp = in.nextLine();

                if ("end".equals(temp.trim())) {
                    break;
                }

                _ipRangeList.add(temp);

            } catch (Exception e) {
        
            }
        }
        
        res = ipMatch(_ip, _ipRangeList.toArray(new String[_ipRangeList.size()]));
        System.out.println(res);
    }
}