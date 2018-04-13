package designpattern.singleton;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 16:59
 * desc   :
 */
public enum EnumObject {
    enumOne; //枚举变量

    private Object instance;

    private EnumObject(){ //枚举类的构造方法会自动被调用，所以在最开始的时候就初始化了一个实例
        instance = new Object();
    }

    public Object getInstance(){
        return instance;
    }

    public static Object getStaticInstance(){
        return EnumObject.enumOne.getInstance();
    }
}
