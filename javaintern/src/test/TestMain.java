package test;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/2 11:34
 * @desc :
 */
interface Closeable{
	void close();
	default void defaultF(){
	    return;
    }
}

interface Channel extends Closeable{
	void open();
}

class FatherObject{
    protected int salary;
    protected int protectedFuntion1(){
        System.out.println("in protected");
        return 1;
    }
}

public class TestMain extends FatherObject implements Closeable, Channel{


    int anInt;

	public void close() { }
	public void open() { }

	public void f(){
	    int a;
//	    a = anInt;
        System.out.println(anInt);
    }

 	public static void main(String[] args){
		TestMain t = new TestMain();
        t.protectedFuntion1();

        System.out.println(t.toString());
        t.f();

		t.close();t.open();
 		Closeable c = t; //
		c.close(); //实例c无法调用open方法
//        c.open();
		Channel cc = (Channel) t;
		cc.open();
	}
}