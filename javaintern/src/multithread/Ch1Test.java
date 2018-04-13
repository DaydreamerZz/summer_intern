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


        DeadLock deadLock = new DeadLock();
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
        thread2.start();

        return;
    }

}

class SynchronizedObject{
    private int num = 5;
    public void addI(String username) {
        synchronized (this) {
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
        }

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
