package multithread.InAction177;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 10:50
 * desc   :
 */
public class TestPrint {

    public static void main(String[] args) {

        PrintService service = new PrintService();
        for(int i = 0; i < 10; i++){
            ThreadA threadA = new ThreadA(service);
            threadA.start();
            ThreadB threadB = new ThreadB(service);
            threadB.start();
        }
        return;
    }
}

class ThreadA extends Thread{
    private PrintService service;
    public ThreadA(PrintService service){
        this.service = service;
    }
    @Override
    public void run() {
        service.A();
    }
}

class ThreadB extends Thread{
    private PrintService service;
    public ThreadB(PrintService service){
        this.service = service;
    }
    @Override
    public void run() {
        service.B();
    }
}