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
        Integer i = 127;
        Integer j = 127;
        out.println(i == j);


    }

}
