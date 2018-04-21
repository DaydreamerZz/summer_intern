package multithread;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 20:37
 * desc   :
 */
public class WhyInterupt extends Thread {

    volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        WhyInterupt thread = new WhyInterupt();
        System.out.println("Starting thread");
        thread.start();

        Thread.sleep(3000);

        System.out.println("Asking thread to stop");


        thread.stop = true; //线程阻塞时，也就是线程调用了sleep()方法时，是不会检查这个变量的。紧接着调用interrupt方法会让线程抛出异常，线程捕获异常并处理，下一个while的条件就不会满足，退出while，线程也就结束了。
        thread.interrupt();

        Thread.sleep(3000);

        System.out.println("Stopping application");

        return;
    }

    @Override
    public void run() {
        while(!stop){ //stop为true的时候退出while
            System.out.println("Thread running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
//                e.printStackTrace();
            }
        }
        System.out.println("Thread exiting under request");
    }
}
