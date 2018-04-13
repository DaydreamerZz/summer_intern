package designpattern.singleton;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 14:22
 * desc   :
 */
public class StaticCodeObject {

    private static StaticCodeObject instance;
    static {
        instance = new StaticCodeObject();
    }

    private StaticCodeObject(){}

    public static StaticCodeObject getInstance(){
        return instance;
    }
}
