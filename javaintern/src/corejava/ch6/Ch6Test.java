package corejava.ch6;
import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;

import static java.lang.System.out;

public class Ch6Test {

    public static void main(String[] args){

//        int[] array = new int[]{1, 2, 3};
//        Integer[] array = new Integer[]{1, 2, 3};
//        swap(array, 1,3);

//        ArrayList<Manager> managers = new ArrayList<>();
//        managers.add(new Manager("Alice"));
//        managers.add(new Manager("Tom"));
//
//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("Alice");
//        strings.add("Tom");
//
//
//        process(managers, new PredicateImp());
//        process(managers, e->e.getName().length() > 3);
//        process(managers, e->e.toString().length() > 3);

//        String[] strings = Main.repeat(5, "hi", String[]::new);
//        out.println(Arrays.toString(strings));

        WordList words = new WordList();
        MyList<String> strings = words;
        out.println(words.add("1"));



    }

    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr){
        T[] result = constr.apply(n);
        for(int i = 0; i < n; i++)
            result[i] = obj;
        return result;

    }

    public static <T> void swap(T[] array, int i, int j){
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T extends ArrayList & Comparable & Runnable> void compare(ArrayList<T> items){
        Collections.sort(items);
    }

    public static void process(ArrayList<? extends Employee> staff, Predicate<? super Employee> filter){
        for(Employee e : staff){
            if(filter.test(e)){
                out.println(e.getName());
                out.println(e.getId());
            }
        }
        return;
    }
}
class MyList<String>{
    public boolean add(String s){
        out.println("MyList");
        return true;
    }
}

class WordList extends MyList<String>{
    @Override
    public boolean add(String s) {
        out.println("Wordlist");
        return s.length() < 3 ? false : super.add(s);
    }
}

class PredicateImp implements Predicate<Object>{
    @Override
    public boolean test(Object employee) {
        return employee.toString().length() > 3;
    }
}

class Employee {
    private String name;
    public int getId(){
        return 1;
    }
    public Employee(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
class Manager extends Employee {
    public int getId(){
        return 2;
    }
    public Manager(String name) {
        super(name);
    }
}

class Entry<K, V>{
    private K key;
    private V value;
    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}

class Job implements Comparable<Job>{
    private int priority;
    private String description;
    public Job(int priority, String description){
        this.priority = priority;
        this.description = description;
    }
    @Override
    public int compareTo(Job o) {
        return this.priority - o.priority;
    }

    @Override
    public String toString() {
        return "Job{" +
                "priority=" + priority +
                ", description='" + description + '\'' +
                '}';
    }
}
