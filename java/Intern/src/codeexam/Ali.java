package codeexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class Ali {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> boms = new ArrayList<>();
        int countOfGoods, countOfBoms;
        String str[] = scanner.nextLine().split(",");
        countOfGoods = Integer.parseInt(str[0]);
        countOfBoms = Integer.parseInt(str[1]);

        int numberOfGood[] = new int[countOfGoods];
        str = scanner.nextLine().split(",");
        for(int i = 0; i < str.length; i++){
            numberOfGood[i] = Integer.parseInt(str[i]);
        }
//        out.println(countOfGoods);
//        out.println(countOfBoms);
//        out.println(Arrays.toString(numberOfGood));

        ArrayList<Integer> bom;
        for(int i = 0; i < countOfBoms; i++){
            bom = new ArrayList<>();
            str = scanner.nextLine().split(",");
            for(int j = 0; j < str.length; j++){
                bom.add(Integer.parseInt(str[j]));
            }
            boms.add(bom);
        }

//        for(ArrayList<Integer> tmp : boms){
//            for(int i = 0; i < tmp.size(); i++){
//                out.print(tmp.get(i));
//            }
//            out.println();
//        }

        ArrayList<Integer[]> availItems = new ArrayList<>();
        ArrayList<Integer[]> res = new ArrayList<>();

        f(numberOfGood, boms, res);

    }

    public static void f(int[] numberOfGood, ArrayList<ArrayList<Integer>> boms, ArrayList<Integer[]> res){
        if(!legalNumber(numberOfGood)){//如果剩下的商品数已经不合格,就是有小于0的情况了
            for(Integer[] item : res){
                for(Integer i : item)
                    out.print(i);
                out.println();
            }
        }

    }

    public static boolean legalNumber(int[] numberOfGood){
        boolean legal = true;
        for(int i : numberOfGood){
            if(i < 0){
                legal = false;
                break;
            }

        }
        return legal;
    }
}
