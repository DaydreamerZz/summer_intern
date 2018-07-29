package vm.chapter2;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/15 13:22
 * @desc :
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {


        String str2 = new StringBuilder("RuntimeConstantPoolOOM").toString();
        System.out.println(str2.intern() == str2);

        String str1 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1.intern() == str1);

        return;
    }
}
