package tookit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

/**
 * @author : Bruce Zhao
 * @email  : zhzh402@163.com
 * @date   : 2018/3/23 18:19
 * @desc   : Collections的使用技巧
 */
public class CollectionsTookit {
    public static void main(String[] args){
        /*
         * Collections的使用
         * Collections作用于List和Set
         */



        //排序
        Integer[] array = new Integer[]{3, 10, 4, 0, 2};
        List<Integer> integers = Arrays.asList(array);
        Collections.sort(integers);
        out.println(integers); //[0, 2, 3, 4, 10]

        //混排
        out.println(integers); //[0, 2, 3, 4, 10]
        Collections.shuffle(integers);
        out.println(integers); //[0, 3, 10, 2, 4]

        //反转
        Collections.reverse(integers);
        out.println(integers); //[3, 0, 4, 2, 10]

        //填充（覆盖）元素
        array = new Integer[]{3, 10, 4, 0, 2};
        integers = Arrays.asList(array);
        Collections.fill(integers, -1);
        out.println(integers); //[-1, -1, -1, -1, -1]
        out.println(Arrays.toString(array)); //[-1, -1, -1, -1, -1], 原数组的值也跟着发生了变化，因为是封装类型，所以Integer[]中和List<Integer>中的元素指向的是用一个Integer对象的地址，所以两个会一起变化。

        //替换元素
        array = new Integer[]{3, 10, 4, 4, 4};
        integers = Arrays.asList(array);
        Collections.replaceAll(integers, 4, -4);
        out.println(integers); //[3, 10, -4, -4, -4]


        //拷贝List
        List<Integer> integersCopy = new ArrayList<>();
        integersCopy.add(1);integersCopy.add(1);integersCopy.add(1);
        integersCopy.add(1);integersCopy.add(1);integersCopy.add(1); //如果不调用add方法，integerCopy还是空的
        Collections.copy(integersCopy, integers);
        out.println(integersCopy); //[3, 10, -4, -4, -4, 1]

        //返回List最小值
        array = new Integer[]{3, 10, 4, 0, 2};
        integers = Arrays.asList(array);
        out.println(integers);
        out.println(Collections.min(integers)); //0
        out.println(Collections.max(integers)); //10

        //源列表中第一次和最后一次出现指定列表的起始位置
        Integer[] array1 = new Integer[]{3, 10, 4, 0, 2, 4, 0};
        List integers1 = Arrays.asList(array1);
        Integer[] array2 = new Integer[]{4, 0};
        List integers2 = Arrays.asList(array2);
        out.println(Collections.lastIndexOfSubList(integers1, integers2)); //5
        out.println(Collections.indexOfSubList(integers1, integers2)); //2

        //循环移动
        out.println(integers);
        Collections.rotate(integers, 1); //依次右移一位
        out.println(integers);
        Collections.rotate(integers, -2); //依次左移一位
        out.println(integers);

        //二分查找，返回所在的下标。没有找到返回负的下标值。
        array = new Integer[]{0, 2, 4, 10, 20};
        integers = Arrays.asList(array);
        out.println(Collections.binarySearch(integers, 4)); //2
        out.println(Collections.binarySearch(integers, 9)); //-4

        //指定元素在集合中出现的次数
        array = new Integer[]{0, 2, 4, 4, 20};
        integers = Arrays.asList(array);
        out.println(Collections.frequency(integers, 4)); //2


    }
}
