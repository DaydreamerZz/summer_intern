package codeexam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/3/23 21:17
 * @desc :
 */
public class TecentQ1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int counter = scanner.nextInt();
        int x1 = 0, x2 = 0, x3 = 0, x4 = 0;
        int y1 = 0, y2 = 0, y3 = 0, y4 = 0;
        scanner.nextLine();
        for(int i = 0; i < counter; i++){
            String line = scanner.nextLine();
            String[] strs = line.split(" ");
            x1 = Integer.parseInt(strs[0]);
            x2 = Integer.parseInt(strs[1]);
            x3 = Integer.parseInt(strs[2]);
            x4 = Integer.parseInt(strs[3]);
            line = scanner.nextLine();
            strs = line.split(" ");
            y1 = Integer.parseInt(strs[0]);
            y2 = Integer.parseInt(strs[1]);
            y3 = Integer.parseInt(strs[2]);
            y4 = Integer.parseInt(strs[3]);
            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            Point p3 = new Point(x3, y3);
            Point p4 = new Point(x4, y4);

//            System.out.println(p1.x + " " + p1.y);
//            System.out.println(p4.x + " " + p4.y);

            int dis1 = distance(p1, p2);
            int dis2 = distance(p2, p3);
            int dis3 = distance(p3, p4);
            int dis4 = distance(p4, p1);
//            System.out.println(dis1 + " " + dis2 + "" + dis3 + "" + dis4);

            int[] arr = new int[]{dis1, dis2, dis3, dis4};

            int min = arr[0];
            for(int j = 1; j < arr.length; j++){
                if(arr[j] < min)
                    min = arr[j];
            }

            boolean flag = true;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] == min || arr[j] == min*2)
                    continue;
                else{
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println("yes");
            else
                System.out.println("no");

        }


    }
    public static int distance(Point p1, Point p2){
        int x = Math.abs(p1.x - p2.x);
        int y = Math.abs(p1.y - p2.y);
        return x*x + y*y;
    }
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;

        }
    }
}
