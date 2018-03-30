package codeexam.ctrip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String[]> array = new ArrayList<>();
        String line;

        line = scanner.nextLine();
        String[] split = line.split(" ");

        int len = split.length;
        String[][] matrix = new String[len][len];

        for(int i = 0; i < len; i++){
            matrix[0][i] = split[i];
        }

        for(int i = 1; i < len; i++){
            line = scanner.nextLine();
            split = line.split(" ");
            for(int j = 0; j < len; j++){
                matrix[i][j] = split[j];
            }
        }




        for(String[] strings : matrix){
            System.out.println(Arrays.toString(strings));
        }

        rotate(matrix, len);
        int j = 0;
        for(String[] strings : matrix){
            int i = 0;
            for(String tmp : strings){
                if(i < len-1){
                    System.out.print(tmp+" ");
                }else{
                    System.out.print(tmp);
                }
                i++;

            }
            if(j < len-1){
                System.out.println();
                j++;
            }

        }
    }
    public static void rotate(String[][] matrix, int n){
        for(int layer = 0; layer < n/2; ++layer){
            int first = layer;
            int last = n - layer - 1;
            for(int i = first; i < last; ++i){
                int offset = i-first;
                String top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        return;
    }

}
