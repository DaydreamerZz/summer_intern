package designpattern.singleton;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 14:00
 * desc   : 单例饿汉模式
 */
public class HungryObject {

    private static HungryObject instance = new HungryObject();
    private HungryObject(){}

    public static HungryObject getInstance(){
        return instance;
    }
}

