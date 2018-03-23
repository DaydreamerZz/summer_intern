package tookit;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/3/23 15:38
 * @desc   : Arrays的使用技巧
 */
public class ArraysTookit {
    public static void main(String[] args){
        /*
        Arrays的使用
         */

        //数组转字符串
        int[] array = new int[]{1, 2, 3};
        out.println(Arrays.toString(array)); //[1, 2, 3]

        int[][] deepArray = new int[][]{{1, 3},{2, 4}};
        out.println(Arrays.toString(deepArray)); //[[I@1540e19d, [I@677327b6]
        out.println(Arrays.deepToString(deepArray)); //[[1, 3], [2, 4]]

        //填充数组
        array = new int[5];
        Arrays.fill(array, 2);
        out.println(Arrays.toString(array)); //[2, 2, 2, 2, 2]

        array = new int[5];
        Arrays.fill(array, 1, 4, 2); //部分填充
        out.println(Arrays.toString(array));//[0, 2, 2, 2, 0]

        //数组元素排序
        array = new int[]{3, 10, 4, 0, 2};
        Arrays.sort(array);
        out.println(Arrays.toString(array)); //[0, 2, 3, 4, 10]

        array = new int[]{3, 10, 4, 0, 2};
        Arrays.parallelSort(array); //和sort相比是这个是并行的
        out.println(Arrays.toString(array)); //[0, 2, 3, 4, 10]


        array = new int[]{3, 10, 4, 0, 2};
        Arrays.sort(array, 0, 4); //部分排序
        out.println(Arrays.toString(array)); //[0, 3, 4, 10, 2]


        //数组的比较
        array = new int[]{1, 2, 3};
        int[] array2 = new int[]{1, 2, 3};
        out.println(Arrays.equals(array, array2)); //true

        int[][] deepArray1 = new int[][]{{1, 3},{2, 4}};
        int[][] deepArray2 = new int[][]{{1, 3},{2, 4}};
        out.println(Arrays.equals(deepArray1, deepArray2)); //false
        out.println(Arrays.deepEquals(deepArray1, deepArray2)); //true
        //deepEquals用于判定两个指定数组彼此是否深层相等，此方法适用于任意深度的嵌套数组。equals用于判定两个数组是否相等，如果两个数组以相同顺序包含相同元素，则返回true。如果两个数组使用equals返回true，则使用deepEquals必定也返回true，也就是说在比较的两个数组均为一维数组的前提下，equals和deepEquals的比较结果没有差别；


        //数组复制
        array = new int[]{3, 10, 4, 0, 2};
        int[] arrayCopy = Arrays.copyOf(array, 3);
        out.println(Arrays.toString(arrayCopy)); //[3, 10, 4]
        arrayCopy = Arrays.copyOf(array, 7);
        out.println(Arrays.toString(arrayCopy)); //[3, 10, 4, 0, 2, 0, 0], 多出的长度补0

        arrayCopy = Arrays.copyOfRange(array, 1, 4);
        out.println(Arrays.toString(arrayCopy)); //[10, 4, 0]

        //二分查找返回下标
        array = new int[]{0, 3, 4, 10, 20};
        out.println(Arrays.binarySearch(array, 10)); //3, array必须是排序的，否则得到的是错误的结果
        out.println(Arrays.binarySearch(array, 6)); //-4, 找不到的值，从-1开始，6如果存在下标是3， 所以返回-4
        out.println(Arrays.binarySearch(array, 2, 5, 10)); //3, 返回的还是全局的下标值。

        //数组转List
        array = new int[]{3, 10, 4, 0, 2};
//        List<int[]> ints = Arrays.asList(array);
        out.println(Arrays.asList(array).contains(3)); //false
        Integer arr[] = new Integer[]{3, 10, 4, 0, 2};
//        List<Integer> integers = Arrays.asList(arr);
        out.println(Arrays.asList(arr).contains(3)); //true

        //对数组元素采用指定的方法计算
        array = new int[]{3, 10, 4, 0, 2};
        Arrays.parallelPrefix(array, (x,y)->(x+y)); //[3, 13, 17, 17, 19]
        out.println(Arrays.toString(array));

        array = new int[]{3, 10, 4, 0, 2};
        Arrays.parallelSetAll(array, (x)->(x*x)); //[0, 1, 4, 9, 16]
        out.println(Arrays.toString(array));
        Arrays.setAll(array, (x)->(x%3));
        out.println(Arrays.toString(array)); //[0, 1, 2, 0, 1], 与parallelSetAll相比只是不并行
    }
}
