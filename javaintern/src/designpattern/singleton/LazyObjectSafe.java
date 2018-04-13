package designpattern.singleton;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 14:00
 * desc   : 单例饿汉模式
 */
public class LazyObjectSafe {

    private static LazyObjectSafe instance;
    private LazyObjectSafe(){}

    // 方法一：效率低
    /*synchronized public static LazyObjectSafe getInstance(){
        if(instance == null){
            instance = new LazyObjectSafe();
        }
        return instance;
    }*/

    //失败的单例
    /*public static LazyObjectSafe getInstance(){
        if(instance == null){
            synchronized (LazyObjectSafe.class) { //几个线程阻塞在这里，每个获得对象锁之后都会new一个对象出来，完成没有用。需要再次判断对象是否存在
                instance = new LazyObjectSafe();
            }
        }
        return instance;
    }*/

    public static LazyObjectSafe getInstance(){
        if(instance == null){
            synchronized (LazyObjectSafe.class) {
                if(instance == null) {
                    instance = new LazyObjectSafe();
                }
            }
        }
        return instance;
    }
}

