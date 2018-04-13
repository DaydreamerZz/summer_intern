package multithread.producerconsumer;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/12 16:26
 * desc   :
 */
public class TestProducerConsumer {

    public static void main(String[] args) {

        ProductFactory factory = new ProductFactory();
        Producer producer = new Producer(factory);
        ThreadP threadP = new ThreadP(producer);

        Consumer consumer = new Consumer(factory);
        Consumer consumer1 = new Consumer(factory);
        Consumer consumer2 = new Consumer(factory);
        Consumer consumer3 = new Consumer(factory);
        ThreadC threadC = new ThreadC(consumer);
        ThreadC threadC1 = new ThreadC(consumer1);
        ThreadC threadC2 = new ThreadC(consumer2);
        ThreadC threadC3 = new ThreadC(consumer3);


        Producer producer1 = new Producer(factory);
        Producer producer2 = new Producer(factory);
        Producer producer3 = new Producer(factory);
        ThreadP threadP1 = new ThreadP(producer1);
        ThreadP threadP2 = new ThreadP(producer2);
        ThreadP threadP3 = new ThreadP(producer3);


        threadC.start();
        threadC1.start();
        threadC2.start();
        threadC3.start();

        threadP.start();
        threadP1.start();
        threadP2.start();
        threadP3.start();



        return;
    }
}

class TaskP implements Runnable{

    Producer1 producer1;
    public TaskP(Producer1 producer1){
        this.producer1 = producer1;
    }
    @Override
    public void run() {
        while(true)
            producer1.produce();
    }
}

class TaskC implements Runnable{

    Consumer1 consumer1;
    public TaskC(Consumer1 consumer1){
        this.consumer1 = consumer1;
    }
    @Override
    public void run() {
        while(true)
            consumer1.consume();
    }
}


class ThreadP extends Thread{
    private Producer producer;

    public ThreadP(Producer producer){
        this.producer = producer;
    }

    @Override
    public void run() {
        while(true)
            producer.produce();
    }
}

class ThreadC extends Thread{
    private Consumer consumer;

    public ThreadC(Consumer consumer){
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while(true)
            consumer.consume();
    }
}