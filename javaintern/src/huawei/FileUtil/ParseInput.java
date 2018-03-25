package FileUtil;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.out;

public class ParseInput {
    public static void main(String[] args){
        File input = new File("/home/lab2/IdeaProjects/Huawei/src/input/Demo/TestData_2015.2.20_2015.2.27.txt");
        FileInputStream fis = null;
        BufferedReader br = null;
        try {
             fis = new FileInputStream(input);
             br = new BufferedReader(new InputStreamReader(fis));
             String str = null;
             String[] splitStr = new String[4];
            StringTokenizer tokenizer = null;
             while((str = br.readLine()) != null){
//                 out.println(str);
                 tokenizer = new StringTokenizer(str);
                 int index = 0;
                 while(tokenizer.hasMoreElements()){
//                     out.println(tokenizer.nextToken());
                     splitStr[index++] = tokenizer.nextToken();
                 }
                 out.println(splitStr[0]  + splitStr[1] + splitStr[2] + splitStr[3]);
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
