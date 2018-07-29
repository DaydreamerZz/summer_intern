package vm.chapter3;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/8 21:02
 * @desc :
 * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class Test93 {

    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        testAllocation();

        return;
    }

    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[4 * _1MB];
        for(int i = 0; i < 1024; i++){
            allocation1[i] = (byte) 1;
        }
        allocation2 = new byte[4 * _1MB];
        for(int i = 0; i < 1024; i++){
            allocation1[i] = (byte) 1;
        }
        allocation3 = new byte[4 * _1MB];
        for(int i = 0; i < 1024; i++){
            allocation1[i] = (byte) 1;
        }
        allocation4 = new byte[4 * _1MB];
    }
}
