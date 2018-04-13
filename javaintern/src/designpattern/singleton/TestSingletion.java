package designpattern.singleton;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 14:04
 * desc   :
 */
public class TestSingletion {

    public static void main(String[] args) {

        SingletonThread thread1 = new SingletonThread();
        SingletonThread thread2 = new SingletonThread();
        SingletonThread thread3 = new SingletonThread();
        thread1.start();
        thread2.start();
        thread3.start();
        return;
    }
}
