import designpattern.factory.*;
import designpattern.observer.Subject;

import java.util.*;

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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(100);
        for(Integer i : list)
            out.print(i);
        out.println();
        ArrayList<Integer> newList = new ArrayList<>(list);
        newList.add(-1);
        for(Integer i : list)
            out.print(i);
        out.println();
        for(Integer i : newList)
            out.print(i);
        out.println();

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
