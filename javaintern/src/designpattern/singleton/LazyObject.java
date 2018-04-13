package designpattern.singleton;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 14:00
 * desc   : 单例懒汉模式，线程不安全
 */
public class LazyObject {

    private static LazyObject instance;
    private LazyObject(){}

    public static LazyObject getInstance(){
        if(instance == null){
            instance = new LazyObject();
        }
        return instance;
    }
}

