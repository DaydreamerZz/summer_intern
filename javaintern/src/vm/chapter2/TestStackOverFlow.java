package vm.chapter2;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/14 22:32
 * @desc :
 * -Xss128k
 */
public class TestStackOverFlow {

    private int stackLength = 0;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        TestStackOverFlow t = new TestStackOverFlow();
        t.stackLeak();
        return;
    }
}
