package corejava.ch4;

import java.io.InputStream;
import java.util.*;

import static java.lang.System.out;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/3/29 10:44
 * @desc :
 */


public class Ch4Test {

    public enum Operation{
        ADD{
            public int eval(int arg1, int arg2){
                return arg1 + arg2;
            }
        },
        SUBTRACT{
            public int eval(int arg1, int arg2){
                return arg1 - arg2;
            }
        };
        public abstract int eval(int arg1, int arg2);
    }

    public static void main(String[] args){
        Object obj = new Employee(1);
        Class<?> c1 = obj.getClass();
        out.println(c1.getName());

        InputStream stream = Ch4Test.class.getResourceAsStream("Employee.java");
        Scanner scanner = new Scanner(stream);
        while(scanner.hasNext()){
            out.println(scanner.nextLine());
        }

//        Employee e = new Employee(1);
//        out.println(e.getSalary());

//        Manager m = new Manager(100);
//        m.work();
//        out.println(m.getSalary());

//
//        Employee e = new Employee(100);
//        e.setSalary(100);
//        Manager m = new Manager(100);
//        out.println(e);
//        out.println(m);
        /*if(e instanceof Manager){
            Manager manager = (Manager) e;
            manager.setBonus(10);
        }*/


//        Objects.equals()

        /*ArrayList<String> strings = new ArrayList<>();
        strings.clone();
        int[] numbers = new int[]{1,2,3};
        numbers.clone();


        out.println();*/



    }

    public void helper(){
        Thread thread = new Thread(this::print);
        thread.start();
    }
    public void print(){
        out.println("helo");
    }


}


class Manager extends Employee{

    private int bonus;
    public Manager(int salary) {
        super(salary);
        this.setSalary(this.getSalary()+100);
    }

    public void setBonus(int bouns){
        this.bonus = bouns;
    }



    @Override
    public void work() {
        Thread thread = new Thread(super::work);
        thread.start();
    }

    @Override
    public String toString() {
        return getClass().getName() + ": "  + super.toString();
    }
}
