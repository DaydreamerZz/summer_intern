package multithread.producerconsumer;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/12 16:19
 * desc   :
 */
public class Producer1 {

    private String lock;
    int index;
    public Producer1(String lock){
        this.lock = lock;
    }

    public void produce(){

        try{
            synchronized (lock){
                if(!ValueObject.value.equals("")) { //value的初始状态就是""，如果不是初始状态说明生产了商品，自己wait，让消费者先消费。
                    lock.wait();
                }
                //后面就是初始状态，开始生产商品，生产好先修改状态，即设置value的值，然后notify消费者取
                String value = "商品编号: " + ++index;
                System.out.println("producer1 saying: " + value);
                ValueObject.value = value;
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        return;
    }
}
