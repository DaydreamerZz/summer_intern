package corejava.ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/3/26 16:14
 * @desc :
 */
public class InterfaceUseCase {
    public static void main(String[] args){
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(20));
//        employees.add(new Employee(10));
//        employees.add(new Employee(30));
        Employee[] employees = new Employee[3];
        employees[0] = new Employee(20);
        employees[1] = new Employee(10);
        employees[2] = new Employee(30);
        Arrays.sort(employees);
        for(Employee e : employees){
            System.out.println(e);
        }
    }

    static class Employee implements Comparable<Employee>{
        private int id;
        public Employee(int id){this.id = id;}
        @Override
        public int compareTo(Employee o) {
            return this.id - o.id;
        }
        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    '}';
        }
    }
}
