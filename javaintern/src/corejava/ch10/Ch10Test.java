package corejava.ch10;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/3/30 14:43
 * desc   :
 */
public class Ch10Test{

    private static boolean done = false;
    public static void main(String[] args){

        String str1 = "bac";
        out.println(str1.intern() == "ba".intern());


        out.println();
        String str2 = new String("bac");
        out.println(str1.intern() == str2.intern());
        /*Runnable hellos = () ->{
            for(int i = 0; i < 1000; i++){
                out.println("hello" + i);
            }
            done = true;
        };
        Runnable goobays = () ->{
            int i = 0;
            while (!done) i++;
            out.println("goobay" + i);
        };

        Executor executor = Executors.newCachedThreadPool();
        executor.execute(hellos);
        executor.execute(goobays);*/



    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        super.run();

        out.println("123");
    }
}