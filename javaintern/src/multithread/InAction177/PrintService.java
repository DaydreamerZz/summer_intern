package multithread.InAction177;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 10:42
 * desc   :
 */
public class PrintService {

    private boolean flag = false;

    synchronized public void A(){
        try {
            while (flag) { // flag为false是初始状态，这个成立就非初始状态，自己等待
                wait();
            }
            for(int i = 0; i < 2; i++){
                System.out.println("function A working");
            }
            flag = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void B(){
        try{
            while(!flag){ //成立说明flag为false
                wait();
            }
            for(int i = 0; i < 2; i++){
                System.out.println("function B working");
            }
            flag = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
