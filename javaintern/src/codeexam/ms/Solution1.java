package codeexam.ms;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

public class Solution1 {
    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        out.println(solution1.findUnlockKey(1101));
    }

    long findUnlockKey(long lockingKey){
        long result = 0;
        String lockingKeyStr = Long.toString(lockingKey);
        char[] chars = lockingKeyStr.toCharArray();
//        int[] numbers = new int[chars.length];

        Arrays.sort(chars);
//        out.println(Arrays.toString(chars));
        StringBuilder sb = new StringBuilder();

        int zeroCount = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '0'){
                zeroCount++;
                continue;
            }

            sb.append(chars[i]);
        }
        if(zeroCount != 0){
            while(zeroCount-- > 0)
                sb.insert(1, '0');
        }
        String resultStr = sb.toString();

//        out.println(sb.toString());
        return Long.valueOf(resultStr);

    }
}
