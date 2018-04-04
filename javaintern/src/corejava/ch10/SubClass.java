package corejava.ch10;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/4 14:47
 * desc   :
 */
public class SubClass extends SuperClass {
    static int i = 2;
    static{
        System.out.println("subclass: " + i);
    }

    public SubClass() {
        System.out.println("subclass constructor");
    }
    public static void main(String[] args){
        System.out.println("main");
        SubClass b = new SubClass();
    }
}
