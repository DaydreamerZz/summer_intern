package tookit;

import static java.lang.System.out;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/3/25 17:40
 * @desc   : java中的进制转换问题
 */
public class ScaleTookit {
    public static void main(String[] args){
        //Integer类中提供了int型变量转成某个进制String变量的方法
        int a = 0x2F;
        out.println(Integer.toBinaryString(a)); //输出二进制字符串101111
        out.println(Integer.toOctalString(a)); //输出八进制字符串57
        out.println(Integer.toHexString(a)); //输出十六进制字符串2f
        out.println(Integer.toString(a, 10)); //输出十进制字符串47

        //可以把其他进制之间的任意转化则需要借助十进制作为中间变量
        int value = Integer.valueOf("2F", 16);
        out.println(value); //47

    }
}

