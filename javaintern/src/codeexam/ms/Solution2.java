package codeexam.ms;

import java.util.*;

import static java.lang.System.out;

public class Solution2 {
    public static void main(String[] args){
        Solution2 solution2 = new Solution2();

        int[] array = new int[]{1,2,3};
        Arrays.asList(array);
        out.println(array.toString());


        //out.println(solution2.annoncement(8, "nncncncn"));
    }

    String annoncement(int numofNeighbors, String characteristic){
        String result = "";

        int max = -1;
        Queue<Integer> announceNumber = null;
        int[] states = new int[numofNeighbors];
        char[] chars = characteristic.toCharArray();
        Set<Integer> set = null;
        for(int i = 0; i < numofNeighbors; i++){
            states = new int[numofNeighbors];
            announceNumber = new ArrayDeque();
            announceNumber.add(i);
            states[i] = 1;
            set = new HashSet<>();
            set.add(i);
            while(!announceNumber.isEmpty()){
                int tmp = announceNumber.remove();
                if(chars[tmp] == 'c'){
                    if(tmp == 0){
                        states[tmp+1] = 1;
                        states[tmp+2] = 1;
                        if(!set.contains(tmp+1)) {
                            set.add(tmp+1);
                            announceNumber.add(tmp + 1);
                        }
                        if(!set.contains(tmp+2)) {
                            set.add(tmp+2);
                            announceNumber.add(tmp + 2);
                        }
                    }else if(tmp == numofNeighbors-1){
                        states[tmp-1] = 1;
                        states[tmp-2] = 1;
                        if(!set.contains(tmp-1)) {
                            set.add(tmp-1);
                            announceNumber.add(tmp-1);
                        }
                        if(!set.contains(tmp-2)) {
                            set.add(tmp-2);
                            announceNumber.add(tmp-2);
                        }
                    }else{
                        states[tmp-1] = 1;
                        states[tmp-2] = 1;
                        if(!set.contains(tmp-2)) {
                            set.add(tmp-2);
                            announceNumber.add(tmp-2);
                        }
                        if(!set.contains(tmp-1)) {
                            set.add(tmp-1);
                            announceNumber.add(tmp-1);
                        }
                        states[tmp+1] = 1;
                        states[tmp+2] = 1;
                        if(!set.contains(tmp+1)) {
                            set.add(tmp+1);
                            announceNumber.add(tmp + 1);
                        }
                        if(!set.contains(tmp+2)) {
                            set.add(tmp+2);
                            announceNumber.add(tmp + 2);
                        }
                    }
                }
            }

            //out.println(Arrays.toString(states));
            StringBuilder sb = new StringBuilder();
            int tmpCount = 0;
            for(int j = 0; j < states.length; j++){
                if(states[j] == 1) {
                    tmpCount++;
                    sb.append('I');
                }else{
                    sb.append('N');
                }
            }
            if(tmpCount == numofNeighbors){
                return sb.toString();
            }
            if(tmpCount > max){
                max = tmpCount;
                result = sb.toString();
            }


        }
        return result;
    }


}
