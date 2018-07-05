package codeexam.wap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 2018/7/5 17:28
 * desc  :
 */
public class Main1 {
    private static int N = 100005;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] G = new int[N];
        int[] S = new int[N];

        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        ArrayList<Integer> innerList = null;
        for (int i = 1; i <= m; i++) {
            innerList = new ArrayList<>();
            int k = in.nextInt();
            while (k-- > 0) {
                int x = in.nextInt();
                innerList.add(x);
                G[x] = i;
                S[i] = x;
            }
            outerList.add(innerList);
        }

        int result = 0;
        // write your code
        outerList.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });

//        System.out.println(outerList.get(0));
        HashSet<Integer> set = new HashSet<>();
        while(true){
            ArrayList<Integer> tmpList = outerList.get(0);
            outerList.remove(0);
            boolean isChanged = false;
            for(Integer i : tmpList){
                if(!set.contains(i)){
                    isChanged = true;
                    set.add(i);
                }
            }
            if(isChanged){ // add new station
                result ++;
            }else{
                continue;
            }

            if(set.size() == n)
                break;
        }

        System.out.println(result);
        return;
    }
}
