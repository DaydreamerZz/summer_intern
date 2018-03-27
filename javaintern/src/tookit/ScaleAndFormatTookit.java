package tookit;

import static java.lang.System.out;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/3/25 17:40
 * @desc   : 进制转换和格式化输出问题
 */
public class ScaleAndFormatTookit {
    public static void main(String[] args){
        //十进制int型变量转转成N进制String变量
        int a = 0x1A;
        out.println(Integer.toBinaryString(a)); //输出2进制字符串11010
        out.println(Integer.toOctalString(a)); //输出8进制字符串32
        out.println(Integer.toHexString(a)); //输出16进制字符串1a

        out.println(Integer.toString(a, 10)); //输出10进制字符串26
        out.println(Integer.toString(a, 2)); //输出10进制字符串11010
        out.println(Integer.toString(a, 8)); //输出10进制字符串32
        out.println(Integer.toString(a, 16)); //输出10进制字符串1a

        a = -26;
        out.println(Integer.toBinaryString(a)); //输出2进制字符串11111111111111111111111111100110
        out.println(Integer.toOctalString(a)); //输出8进制字符串37777777746
        out.println(Integer.toHexString(a)); //输出16进制字符串ffffffe6

        //传输的是负数的时候，toString方法得到的结果是直接对整数转之后添加负号，不是补码的形式
        out.println(Integer.toString(a, 10)); //-26
        out.println(Integer.toString(a, 8)); //-32
        out.println(Integer.toString(a, 2)); //-11010


        //N进制String型变量转成十进制int型变量
        int value = Integer.parseInt("11", 16); //16进制表示的"2F"转成10进制的int型值
        out.println(value); //47
        value = Integer.valueOf("11", 16); //功能同parseInt，实际上是调用了parseInt函数
        out.println(value); //47

        //N进制String变量转成N进制String变量，需要借助方法先转成10进制
        out.println(Integer.toBinaryString(Integer.parseInt("2F", 16)));

        //浮点数的二进制String类型表示
        out.println(binaryToString(0.75)); //0.11



        int x = 5;
        double y = 1.23;
        //输出一般有下面三种方式
        out.println("x = " + x + ", y = " + y); //x = 5, y = 1.23
        out.format("x = %d, y = %f\n", x, y); //x = 5, y = 1.230000
        out.printf("x = %d, y = %f\n", x, y); //x = 5, y = 1.230000
        //printf是调用了format函数，两个是等价的。

        //也可以利用String的format方法格式化输出的内容
        String outStr = String.format("x = %d, y = %f\n", x, y);
        out.println(outStr);



    }

    private static String binaryToString(double x) {
        if(x >= 1 || x <= 0)
            return null;
        StringBuilder sb = new StringBuilder();
        sb.append("0.");

        double tmp = 0.0;
        while(x > 0){
            if(sb.length() >= 34){
                return null;
            }

            tmp = x * 2;
            if(tmp >= 1){
                x = tmp - 1;
                sb.append("1");
            }else{
                x = tmp;
                sb.append("0");
            }
        }
        return sb.toString();
    }
}

