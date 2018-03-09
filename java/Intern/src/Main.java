import designpattern.factory.*;
import designpattern.observer.Subject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

import static java.lang.System.out;

public class Main extends Thread{
    static int age;
    String name;
    public static void print(){
        out.print(age);
    }
    enum week{
        monday,
        tuesday,
        wednesday,
        thursday,
        friday,
        saturday,
        sunday
    }
    public static void setPerson(Person p){
//        p.age = 100;
        p = new Person();
        p.age = 7;
    }
    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s3 = "Program" + "ming";
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1 == s1.intern());
//        String a = "ja";
//        String b = "va";
//        String c = "java";
//        String d = "ja" + "va";
//        out.println(c == a+b); //false
//        out.println(c == d);
        String a = "java";
        out.println("ja"+"va" == a);


    }
}
class Person{
    int age;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}

//class designpattern.factory.Singleton{
//    private static
//}
