package multithread.ConditionLock;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 11:51
 * desc   :
 */
public class TestCondition {

    public static void main(String[] args) {
        ConditionService service = new ConditionService();
        MyThread myThread = new MyThread(service);
        myThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.toAwake();
        return;
    }
}

class MyThread extends Thread{
    private ConditionService service;
    public MyThread(ConditionService service){
        this.service = service;
    }

    @Override
    public void run() {
        service.toAwait();
    }
}
