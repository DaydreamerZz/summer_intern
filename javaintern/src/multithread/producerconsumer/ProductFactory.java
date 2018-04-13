package multithread.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/12 16:48
 * desc   :
 */
public class ProductFactory {

    private List<String> goods = new ArrayList<>();

    private static volatile int index;

    synchronized public void add(){
        try{
            while(goods.size() == 1){
                this.wait();
            }
            goods.add("商品" + ++index);
//            this.notify();
            this.notifyAll();
            System.out.println("add" + goods.get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public String del(){
        String value = "";
        try{
            while(goods.size() == 0){
                this.wait();
            }

            value = goods.get(0);
            goods.remove(0);
//            this.notify();
            this.notifyAll();
            System.out.println("del" + value);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }
}
