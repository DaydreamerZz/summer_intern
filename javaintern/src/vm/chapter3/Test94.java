package vm.chapter3;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/8 21:02
 * @desc :
 * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 */
public class Test94 {

    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        testPretenureSizeThreshold();

        return;
    }

    public static void testPretenureSizeThreshold(){

    }
}
