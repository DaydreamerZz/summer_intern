import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

public class Main{

    public class Member{
        int id;
        String name;
        public Member(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "name=" + name +
                    '}';
        }
    }

    public static void main(String[] args) {
        Integer[] x = new Integer[3];
        x[0] = 1;
        x[1] = 2;
        x[2] = 3;
        Integer[] y = new Integer[3];
        y[0] = 1;
        y[1] = 2;
        y[2] = 3;
        out.println(Arrays.equals(x, y));


    }

}
