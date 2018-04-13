package multithread.producerconsumer;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/12 16:19
 * desc   :
 */
public class Consumer1 {
    private String lock;

    public Consumer1(String lock){
        this.lock = lock;
    }

    void consume(){
        try{
            synchronized (lock){
                if(ValueObject.value.equals("")) { //value为""说明为初始状态，自己要wait
                    lock.wait();
                }
                System.out.println("consumer1 saying: " + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}
