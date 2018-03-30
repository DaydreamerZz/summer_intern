package corejava.ch4;

import static java.lang.System.out;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/3/29 16:22
 * @desc :
 */
public class Employee implements Cloneable {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private int salary;

    public Employee(int salary) {
        this.salary = salary;
    }

    protected void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void work(){
        for(int i = 0; i < 100; i++)
            out.println("working");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }
}
