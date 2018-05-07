package multithread;

import sun.misc.Unsafe;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/4/29 21:22
 * @desc :
 */
public class MTest {

    public static void main(String[] args) {

        UnsafeObject object = new UnsafeObject();
        MThread1 mThread1 = new MThread1(object);
        MThread2 mThread2 = new MThread2(object);
        mThread1.start();
        mThread2.start();
        return;
    }
}


class UnsafeObject{
    private int value;
    public int getValue(){
        return value++;
    }
}


class MThread1 extends Thread{
    private UnsafeObject object;
    public MThread1(UnsafeObject object){
        this.object = object;
    }
    @Override
    public void run() {
        while (true){
            System.out.println("one: " + object.getValue());
        }
    }
}

class MThread2 extends Thread{
    private UnsafeObject object;
    public MThread2(UnsafeObject object){
        this.object = object;
    }
    @Override
    public void run() {
        while (true){
            System.out.println("two: " + object.getValue());
        }
    }
}