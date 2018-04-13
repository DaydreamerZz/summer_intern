package multithread.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/12 16:48
 * desc   :
 */
public class ProductFactoryOne {

    private List<String> productStack = new ArrayList<>();

    synchronized public void push(){
        try{
            while(productStack.size() == 1){
                this.wait();
            }
            productStack.add(Math.random()+"");
//            this.notify();
            this.notifyAll();
            System.out.println("add one");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String pop(){
        String value = "";
        try{
            if(productStack.size() == 0){
                this.wait();
            }

            value = productStack.get(0);
            productStack.remove(0);
//            this.notify();
            this.notifyAll();
            System.out.println("del one");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }
}
