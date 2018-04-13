package multithread.ThreadException;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 18:08
 * desc   :
 */
public class Main1 {

    public static void main(String[] args) {


        //MyThread myThread = new MyThread();
        //线程捕获异常的方式之一
        /*myThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + "throw exception");
                //e.printStackTrace();
            }
        });*/

        //为所有的该类型线程设置默认的异常处理
        /*MyThread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + "throw exception");
            }
        });*/

        //在main函数（main线程）捕获其他线程的异常是捕获不到的
        /*try {
            //myThread.start();
        }catch (Exception e){
            System.out.println("exception");
//            e.printStackTrace();
        }*/




//        ThreadGroup group = new ThreadGroup("group");
        /*MyThreadGroup group = new MyThreadGroup("group");
        MyThread2[] threads = new MyThread2[5];
        for(int i = 0; i < 5; i++){
            threads[i] = new MyThread2(group, "thread" + (i+1), "1");
            threads[i].start();
        }
        MyThread2 errorThead = new MyThread2(group, "errorThread", "a");
        errorThead.start();*/


        MyThreadGroup group = new MyThreadGroup("group");
        MyThread3 myThread3 = new MyThread3(group, "thread");

        //对对象设置异常处理
//        myThread3.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
        //对类设置异常处理
        MyThread3.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
        myThread3.start(); //对象的异常处理，说明是对象设置的异常起作用

        return;
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        Integer.parseInt("a");
    }
}

class MyThread2 extends Thread{
    private String num;
    public MyThread2(ThreadGroup group, String name, String num){
        super(group, name);
        this.num = num;
    }

    @Override
    public void run() {
        int numInt = Integer.parseInt(num);
        while (this.isInterrupted() == false){
            System.out.println("死循环" + Thread.currentThread().getName());
        }
    }
}

class MyThreadGroup extends ThreadGroup{
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        super.uncaughtException(t, e);
        System.out.println("线程组的异常处理");
        this.interrupt();
    }
}


class MyThread3 extends Thread{
    private String num = "a";
    public MyThread3(ThreadGroup group, String name){
        super(group, name);
    }
    @Override
    public void run() {
        int numInt = Integer.parseInt(num);
        System.out.println("在线程中输出：" + numInt+1);
    }
}

class ObjectUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        System.out.println("对象的异常处理");
        e.printStackTrace();
    }
}

class StateUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        System.out.println("静态的异常处理");
        e.printStackTrace();
    }
}