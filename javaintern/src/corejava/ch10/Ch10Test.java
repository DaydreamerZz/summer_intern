package corejava.ch10;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static java.lang.System.out;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/3/30 14:43
 * @desc :
 */
public class Ch10Test {
    public static void main(String[] args){
        Runnable hellos = () ->{
            for(int i = 0; i < 1000; i++){
                out.println("hello");
            }
        };
        Runnable goobays = () ->{
            for(int i = 0; i < 1000; i++){
                out.println("goobay");
            }
        };

        Executor executor = Executors.newCachedThreadPool();
        executor.execute(hellos);
        executor.execute(goobays);
    }
}
