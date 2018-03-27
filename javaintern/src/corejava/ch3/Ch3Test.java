package corejava.ch3;

interface Closeable{
    void close();
}
interface Channel extends Closeable{
    void open();
}
public class Ch3Test implements Closeable, Channel{
    public void close() { }
    public void open() { }
    public static void main(String[] args){
        Ch3Test t = new Ch3Test();
        t.close();t.open();
        Closeable c = (Closeable) t;
        c.close(); //实例c无法调用open方法
        Channel cc = (Channel) t;
        cc.open();
    }
}
