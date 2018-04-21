package codeexam.sap;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/19 20:45
 * desc   :
 */
public class Main {

    public static void main(String[] args) {

        String str = "6[3[be]2[ac]]";
        StringBuilder sb = new StringBuilder(str);
        while(sb.toString().lastIndexOf("[") != -1){
            String tmp = sb.toString();
            System.out.println(tmp);
            int indexLeft = tmp.lastIndexOf("[");
            int indexRight = tmp.indexOf("]", indexLeft);
            String substring = tmp.substring(indexLeft+1, indexRight);
            System.out.println(substring);
            int times = Integer.parseInt(tmp.charAt(indexLeft-1)+"");
            System.out.println(times);

            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < times; i++){
                stringBuilder.append(substring);
            }
            sb.insert(indexRight+1, stringBuilder.toString());
            sb.delete(indexLeft-1, indexRight+1);
            System.out.println(sb.toString());
            //break;
        }
        return;
    }
}
