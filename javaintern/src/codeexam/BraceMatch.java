package codeexam;

import java.util.*;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/9 20:01
 * desc   :
 */
public class BraceMatch {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
//        String inputStr = scanner.nextLine();
        String inputStr = "()";
        char[] chars = inputStr.toCharArray();
        //找到每一个）的位置，和（交换并比较
        ArrayList<Integer> rightBraceIndex = new ArrayList<>();
        int startIndex = 0;
        while(true){
            int tmp = inputStr.indexOf(")", startIndex);
            if(tmp == -1)
                break;
            rightBraceIndex.add(tmp);
            startIndex = tmp+1;
        }

//        System.out.printf(rightBraceIndex.toString());

        boolean flag = true;
        for(int index : rightBraceIndex){
            for(int i = 0; i < chars.length; i++){
                if(chars[i] == ')'){
                    continue;
                }else{ //当前位置是（，交换并比较
                    char[] charsCopy = Arrays.copyOf(chars, chars.length);
                    charsCopy[index] = '(';
                    charsCopy[i] = ')';
                    String newStr = new String(charsCopy);
                    if(matches(newStr)){
                        System.out.printf("Yes");
                        flag = false;
                        return;
                    }

                }
            }
        }
        if(matches(inputStr)) {
            System.out.println("Yes");
            return;
        }
        if(flag)
            System.out.printf("No");
        return;
    }

    private static boolean matches(String newStr) {
        char[] chars = newStr.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char c : chars){
            if(c == '('){
                stack.push('(');
            }else if(!stack.isEmpty() && c == ')'){
                stack.poll();
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

}
