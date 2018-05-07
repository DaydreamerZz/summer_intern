package codeexam.bytedance;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/4/30 11:41
 * @desc :
 */
public class SynchronizedQueue {

    private static int QUEUE_LENGHT = 5;
    private static int[] queue = null;

    private static int left = 0;
    private static int right = 0;

    private SynchronizedQueue(){}

    public static int[] getInstance(){
        if (queue == null){
            synchronized (SynchronizedQueue.class){
                queue = new int[QUEUE_LENGHT];
            }
        }
        return queue;
    }


    public synchronized boolean push(int value){
        try {
            if (full()) {
                System.out.println("queue full and queue wait");
//                this.wait();
                System.out.println("queue full!");
                return false;
            } else {
                queue[(right++) % QUEUE_LENGHT] = value;
                this.notifyAll();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    public  synchronized int pop(){
        try {
            if (empty()) {
                System.out.print("queue empty! : and wait");
                this.wait();
                return -1;
            } else {
                int i = queue[(left++) % QUEUE_LENGHT];
//                this.notifyAll();
                return i;
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean empty(){
        if(left == right){
            return true;
        }
        return false;
    }

    public boolean full(){
        if ((right + 1) % QUEUE_LENGHT == left){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }

    public static void main(String[] args) {

        SynchronizedQueue sq = new SynchronizedQueue();
        int[] queue = SynchronizedQueue.getInstance();
        /*sq.push(1);
        sq.push(2);
        sq.push(3);
        sq.push(4);
        sq.push(5);
        sq.push(6);
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());*/

        QueueThread1 thread1 = new QueueThread1(sq);
        QueueThread1 thread2 = new QueueThread1(sq);
        thread1.start();
        //thread2.start();

        return;
    }
}

class QueueThread1 extends Thread{
    private SynchronizedQueue queue;
    public QueueThread1(SynchronizedQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        while(i++ < 2){
            queue.push(1);
            queue.push(2);
            queue.push(3);
            queue.push(4);
            System.out.println(queue.pop());
            System.out.println(queue.pop());
//            queue.pop();
//            queue.pop();
            System.out.println(queue);
        }
    }
}

class QueueThread2 extends Thread{
    private SynchronizedQueue queue;
    public QueueThread2(SynchronizedQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        while(i++ < 2){
            queue.push(1);
            queue.push(2);
            queue.push(3);
            System.out.println(queue.pop());
        }
    }
}
