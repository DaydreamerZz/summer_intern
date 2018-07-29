package vm.chapter2;

import java.util.ArrayList;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/14 21:59
 * @desc :
 * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */
public class TestOOMError {

    static class OOMObjct{}
    public static void main(String[] args) {

        ArrayList<OOMObjct> list = new ArrayList<>();
        while (true){
            list.add(new OOMObjct());
        }
    }
}
