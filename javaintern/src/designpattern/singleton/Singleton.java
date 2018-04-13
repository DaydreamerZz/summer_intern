package designpattern.singleton;

/*class SingletonObject {
    private static class SingletonHolder{

        private static final SingletonObject INSTANCE = new SingletonObject();
    }

    private SingletonObject(){}

    public static final SingletonObject getInstance(){
        return SingletonHolder.INSTANCE;
    }
}*/

class SingletonObject{
    private SingletonObject(){}
    private static SingletonObject instance;

    public static SingletonObject getInstance(){
        if(instance == null){
            synchronized (SingletonObject.class){
                if(instance == null)
                    instance = new SingletonObject();
            }
        }
        return instance;
    }
}
public class Singleton{
    public static void main(String[] args){
        SingletonObject object1 = SingletonObject.getInstance();
        SingletonObject object2 = SingletonObject.getInstance();
        System.out.println(object1 == object2);

    }
}