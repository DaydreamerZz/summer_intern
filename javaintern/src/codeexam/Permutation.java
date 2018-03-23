package codeexam;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: Bruce Zhao
 * @email: zhzh402@163.com
 * @date: 2018/3/20 19:38
 */
public class Permutation {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3};
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        permutation(arr, res);
        for(ArrayList<Integer> x : res){
            for(Integer y : x){
                System.out.print(y);
            }
            System.out.println();
        }
    }

    private static void permutation(int[] arr, ArrayList<ArrayList<Integer>> res) {
        if(arr.length <= 1){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            res.add(list);
            return;
        }

        ArrayList<Integer> subArrList = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++){
            subArrList.add(arr[i]);
        }
        subArrList.remove(0);
        int[] subArr = new int[subArrList.size()];
        for(int i = 0; i < subArr.length; i++){
            subArr[i] = subArrList.get(i);
        }
        permutation(subArr, res);
//        int[] newArr = arr.removeFirst();

        ArrayList<Integer> tmp;
        int resSize = res.size();
        for(int i = 0; i < resSize; i++){
            tmp = res.get(0);
            res.remove(tmp);
            for(int j = 0; j <= tmp.size(); j++){
                ArrayList<Integer> x = new ArrayList<>(tmp);
                x.add(j, arr[0]);
                res.add(x);
            }
        }
    }

}
