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

        int a = 0x1a;
        System.out.println(Integer.valueOf(a));
        System.out.println(Integer.toString(a));
        return;

        /*out.println(6);
        B b = new B();
        b.B1();*/

    }
    int foo(){
        int i = 10;
        try{
            i = --i / 0;
            return i--;
        }catch (Exception e){
            i = i-- / 0;
            return --i;
        }finally {
            --i;
            return  i--;
        }
    }

}

class B extends A{
    static{
        out.print(5);
    }
    static void B1(){
        out.print(1);
    }
    void B2(){
        out.print(2);
    }
}
class A{
    static void A1(){
        out.print(3);
    }
    void A2(){
        out.print(4);
    }
}