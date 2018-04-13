package designpattern.singleton;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 14:22
 * desc   :
 */
public class StaticInnerClassObject {

    private static class ObjectHandler{
        private static StaticInnerClassObject instance = new StaticInnerClassObject();
    }
    private static LazyObject instance;
    private StaticInnerClassObject(){}

    public static StaticInnerClassObject getInstance(){
        return ObjectHandler.instance;
    }


}
