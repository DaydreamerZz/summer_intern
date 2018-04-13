package multithread;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/11 14:32
 * desc   :
 */
public class DeadLock implements Runnable {

    Object lock1 = new Object();
    Object lock2 = new Object();

    String str;
    public void setStr(String str){
        this.str = str;
    }

    @Override
    public void run() {
        if (str.equals("A")) {
            synchronized (lock1) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                System.out.println(str + "lock1->lock2");
            }
                System.out.println(str);

            }
        } else {
            synchronized (lock2) {
                synchronized (lock1) {
                System.out.println(str + "lock2->lock1");
            }
                System.out.println(str);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
