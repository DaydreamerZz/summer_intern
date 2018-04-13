package multithread.producerconsumer;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/12 16:54
 * desc   :
 */
public class Producer {

    private ProductFactory factory;
    public Producer(ProductFactory factory){
        this.factory = factory;
    }

    public void produce(){
        factory.add();
    }

}
