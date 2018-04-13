package multithread.ConditionLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 11:48
 * desc   :
 */
public class ConditionService {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void toAwait(){
        try{
            lock.lock();
            System.out.println("await start: " + System.currentTimeMillis());
            condition.await();
            System.out.println("await end: " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void toAwake(){
        try{
            lock.lock();
            System.out.println("awake start: " + System.currentTimeMillis());
            System.out.println(lock.getHoldCount());
            System.out.println(lock.getQueueLength());
            System.out.println(lock.getWaitQueueLength(condition));
            condition.signal();

            System.out.println(lock.getWaitQueueLength(condition));
        }finally {
            lock.unlock();
        }
    }
}
