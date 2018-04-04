package corejava.ch10;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/4 14:47
 * desc   :
 */
public class SuperClass {
    static int i = 1;
    static {
        System.out.println("superclass: " + i);
    }
    public SuperClass() {
        System.out.println("superclass constructor");
    }
}
