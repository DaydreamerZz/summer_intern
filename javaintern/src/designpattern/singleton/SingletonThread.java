package designpattern.singleton;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/13 14:01
 * desc   :
 */
public class SingletonThread extends Thread{
    @Override
    public void run() {
//        System.out.println(HungryObject.getInstance().hashCode()); //一开始就初始化了，所以这个是线程安全的
//        System.out.println(LazyObject.getInstance().hashCode()); // 使用的时候才初始化，线程不安全的
//        System.out.println(LazyObject.getInstance().hashCode()); //使用synchronized同步方法，线程安全

//        System.out.println(StaticInnerClassObject.getInstance().hashCode()); //和懒汉方式差不多，也是线程安全的

//        System.out.println(StaticCodeObject.getInstance().hashCode());

        System.out.println(EnumObject.enumOne.getInstance().hashCode());
        System.out.println(EnumObject.getStaticInstance().hashCode()); //上面的例子中枚举类被暴露了，违反职责单一原则
    }
}
