package designpattern;

class SingletonObject {
    private static class SingletonHolder{

        private static final SingletonObject INSTANCE = new SingletonObject();
    }


    private SingletonObject(){}

    public static final SingletonObject getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

public class Singleton{
    public static void main(String[] args){
        SingletonObject object1 = SingletonObject.getInstance();
        SingletonObject object2 = SingletonObject.getInstance();
        System.out.println(object1 == object2);

    }
}