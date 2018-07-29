package vm.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/9 14:30
 * @desc : 使用jdk/bin目录下JConsole工具，查看堆内存使用，以及gc方法内存释放情况
 * -Xms100m -Xmx100M -XX:+UseSerialGC
 */
public class Test117 {

    static class OOMObject {
        public byte[] placeHolder = new byte[61 * 1024];
    }

    public static void fillHeap(int number) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for(int i = 0; i < number; i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc(); //这里的gc过后，新生代基本清空了，但是老年代依然保持很高的使用率。如果在main方法的fillHeap()之后调用，那么老年代也会被释放。因为这里gc之后，list对象还在作用域内，gc无法释放。

    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
        System.gc();
        while (true){

        }
        //return;
    }
}
