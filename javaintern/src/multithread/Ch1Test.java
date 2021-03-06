package multithread;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/10 18:43
 * desc   :
 */
public class Ch1Test {
    public static void main(String[] args) {
        /*Service service = new Service();

        MyThread1 thread1 = new MyThread1(service);
        thread1.start();
        MyThread2 thread2 = new MyThread2(service);
        thread2.start();*/


        /*DeadLock deadLock = new DeadLock();
        deadLock.setStr("A");
        Thread thread1 = new Thread(deadLock);
        thread1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        deadLock.setStr("B");
        Thread thread2 = new Thread(deadLock);
        thread2.start();*/


        /*MyThread myThread = new MyThread();
        myThread.start();
        myThread.interrupt();
        myThread.test();
        myThread.test();*/

        /*Ch1Test ch1Test = new Ch1Test();
        ch1Test.f1();*/


        SynchronizedObject object1 = new SynchronizedObject();
        SynchronizedObject object2 = new SynchronizedObject();
        MyThread1 myThread1 = new MyThread1(object1);
        MyThread2 myThread2 = new MyThread2(object2);
        myThread1.start();
        myThread2.start();

        return;
    }

    synchronized void f1(){
        f2();
        return;
    }

    synchronized void f2(){
        System.out.println("in f2");
        return;
    }
}

class SynchronizedObject{
    private static int num = 5;

    static synchronized public void addI(String username) {
//        synchronized (this) {
            try {
                if (username.equals("a")) {
                    num = 100;
                    System.out.println("set a");
                    Thread.sleep(200);
                } else {
                    num = 200;
                    System.out.println("set b");
                }
                System.out.println(username + " "+ num);
            } catch (Exception e) {
                e.printStackTrace();
            }
//        }

    }
}


class MyThread1 extends Thread{
    private SynchronizedObject object;
    public MyThread1(SynchronizedObject object){
        this.object = object;
    }
    @Override
    public void run() {
        object.addI("a");
    }
}

class MyThread2 extends Thread{
    private SynchronizedObject object;
    public MyThread2(SynchronizedObject object){
        this.object = object;
    }
    @Override
    public void run() {
        object.addI("b");
    }
}
/*
class MyThread1 extends Thread{

    Service service;
    public MyThread1(Service service){
        this.service = service;
    }
    @Override
    public void run() {
        service.f1();
    }
}

class MyThread2 extends Thread{

    Service service;
    public MyThread2(Service service){
        this.service = service;
    }
    @Override
    public void run() {
        service.f2();
    }
}
*/

class MyThread extends Thread{
    @Override
    public void run() {
        while (true){

        }
    }
    public void test(){
        System.out.println(this.isInterrupted());
    }
}
