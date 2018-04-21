package codeexam.alibaba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.out;

public class AliFinish {
    static ArrayList<ArrayList<Integer[]>> finishedRes = new ArrayList<>();
    static ArrayList<ArrayList<Integer[]>> unfinishedRes = new ArrayList<>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int countOfGoods, countOfBoms;

        /*String str[] = scanner.nextLine().split(",");
        countOfGoods = Integer.parseInt(str[0]);
        countOfBoms = Integer.parseInt(str[1]);*/
        countOfGoods = 3;
        countOfBoms = 3;

        ArrayList<Integer[]> boms = new ArrayList<>();


        Integer numberOfGood[] = new Integer[countOfGoods];
        /*str = scanner.nextLine().split(",");
        for(int i = 0; i < str.length; i++){
            numberOfGood[i] = Integer.parseInt(str[i]);
        }*/

        numberOfGood[0] = 3;
        numberOfGood[1] = 3;
        numberOfGood[2] = 2;

//        out.println(countOfGoods);
//        out.println(countOfBoms);
//        out.println(Arrays.toString(numberOfGood));

        /*for(int i = 0; i < countOfBoms; i++){
            Integer[] bom = new Integer[countOfGoods];
            str = scanner.nextLine().split(",");
            for(int j = 0; j < str.length; j++){
                bom[j] = (Integer.parseInt(str[j]));
            }
            boms.add(bom);
        }*/
        Integer[] bom = new Integer[countOfGoods];
        bom[0] = 2; bom[1] = 1; bom[2] = 1;
        boms.add(bom);
        bom = new Integer[countOfGoods];
        bom[0] = 1; bom[1] = 1; bom[2] = 0;
        boms.add(bom);
        bom = new Integer[countOfGoods];
        bom[0] = 0; bom[1] = 1; bom[2] = 1;
        boms.add(bom);

//        for(Integer[] tmp : boms){
//            for(int i = 0; i < tmp.length; i++){
//                out.print(tmp[i]);
//            }
//            out.println();
//        }

//        ArrayList<Integer[]> availItems = new ArrayList<>();
        ArrayList<Integer[]> res = new ArrayList<>();


        f(numberOfGood, boms, res);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= countOfBoms; i++){
            map.put(i, 0);
        }

        if(finishedRes.size() > 0){
            ArrayList<Integer[]> finalRes = new ArrayList<>();
            if(finishedRes.size() == 1){ //只有一个匹配项
                /*for(Integer[] i : finishedRes.get(0)){
                    for(Integer j : i)
                        out.print(j);
                }*/
                finalRes = finishedRes.get(0);
            }else{
                int maxIndex = 0;
                for(int i = 1; i <finishedRes.size(); i++){
                    if(finishedRes.get(i).size() > finishedRes.get(maxIndex).size()){
                        maxIndex = i;
                    }
                }
                finalRes = finishedRes.get(maxIndex);
            }
            for(Integer[] i : finalRes){
                for(Integer j : i)
                    out.print(j);
            }
            out.println();


            for(int i = 0; i < finalRes.size(); i++){
                int index = indexOfBoms(finalRes.get(i), boms);
                int newValue = map.get(index+1)+1;
                map.replace(index+1, newValue);
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= map.size(); i++){
                if(map.get(i) != 0)
                    sb.append("bom" + i + "*" + map.get(i) + ",");
    //            out.println(map.get(i));
            }
        out.println(sb.deleteCharAt(sb.length()-1).toString());
        }else{
            ArrayList<Integer[]> finalRes = new ArrayList<>();
            if(unfinishedRes.size() == 1){ //只有一个匹配项
                finalRes = unfinishedRes.get(0);
            }else{
                int maxIndex = 0;
                for(int i = 1; i <unfinishedRes.size(); i++){
                    if(unfinishedRes.get(i).size() > unfinishedRes.get(maxIndex).size()){
                        maxIndex = i;
                    }
                }
                finalRes = unfinishedRes.get(maxIndex);
            }
            for(int i = 0; i < finalRes.size(); i++){
                int index = indexOfBoms(finalRes.get(i), boms);
                int newValue = map.get(index+1)+1;
                map.replace(index+1, newValue);
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= map.size(); i++){
                if(map.get(i) != 0)
                    sb.append("bom" + i + "*" + map.get(i) + ",");
    //            out.println(map.get(i));
            }
            out.println(sb.deleteCharAt(sb.length()-1).toString());

        }



    }

    public static void f(Integer[] numberOfGood, ArrayList<Integer[]> boms, ArrayList<Integer[]> res){
        if(zeroNumber(numberOfGood)){
            /*out.print("zero number: ");
            for(Integer[] item : res){
                for(Integer i : item)
                    out.print(i);
            }
            out.println();*/
            finishedRes.add(res);

            return;
        }else if(!legalNumber(numberOfGood)){//如果剩下的商品数已经不合格,就是有小于0的情况了
            res.remove(res.size()-1);
            /*for(Integer[] item : res){
                for(Integer i : item)
                    out.print(i);
            }
            out.println();*/

            unfinishedRes.add(res);
            return;
        }
        for(int i = 0; i < boms.size(); i++){

            Integer[] leftNumberOfGood = new Integer[numberOfGood.length];
            Integer[] bom = boms.get(i);

            for(int j = 0; j < bom.length; j++){
                leftNumberOfGood[j] = numberOfGood[j] - bom[j];
            }
            ArrayList<Integer[]> tmpRes = new ArrayList<>(res);
            tmpRes.add(bom);
            f(leftNumberOfGood, boms, tmpRes);
        }

    }

    public static boolean legalNumber(Integer[] numberOfGood){
        boolean legal = true;
        for(int i : numberOfGood){
            if(i < 0){
                legal = false;
                break;
            }

        }
        return legal;
    }

    public static boolean zeroNumber(Integer[] numberOfGood){
        boolean legal = true;
        for(int i : numberOfGood){
            if(i != 0){
                legal = false;
                break;
            }

        }
        return legal;
    }

    public static int indexOfBoms(Integer[] x, ArrayList<Integer[]> boms){
        for(int i = 0; i < boms.size(); i++){
            Integer[] y = boms.get(i);
            if(Arrays.equals(x, y)){
                return i;
            }
        }
        return -1;
    }
}
