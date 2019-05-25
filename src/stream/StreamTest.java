package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author wuyuan
 * @version 1.0
 * @className: StreamTest
 * @description 描述:
 *
 *    流 >>> 将多个对数据的操作串联或并联起来执行
 *       >>> 由三部分构成:
 *        1). 源 -- 要操作的数据，数据的来源.
 *        2). 零个或多个中间操作 -- 每个操作都是对数据的操作并且返回值也是一个流流(将当前的流转换成另外一个流)，因此可以多次地流操作.
 *        3). 一个终止操作 -- 最终的操作，得到最后的结果
 *
 *
 *  流的特点：
 *      1.流本身不存储值，它是再调用时通过管道的方式从源上获取值
 *      2.流操作数据后会生成一个新的流，里面是修改后的数据，但流的操作不会修改数据源的数据
 *      3.流的中间操作都是惰性的，终止操作是立即执行的。只有遇到终止操作时中间操作才会执行，如果没有终止操作的话中间操作是不会执行的
 *      4.流的中间操作增多并不会降低效率
 *
 *
 * @date 2019/5/25
 */
public class StreamTest {
    public static void main(String[] args) {
        /**
         * 创建流的方式
         */

        /**一.Stream.of()静态方法，传入一个(list,map,数组)或多个数据*/
        /*.1*/
        Stream.of("hello","world","hello world");

        /*.2*/
        int[] aa = new int[]{1,2,3};
        Stream.of(aa);

        /*.3*/
        List<String> list = new ArrayList<>();
        list.add("asc");
        list.add("svd");
        list.add("jdb");
        list.stream();

        /*.4*/
        Map<String,String> as = new HashMap<>();
        as.put("ws","as");
        as.put("as","s");
        Stream.of(as);


        /**一.Arrays.stream()方法，传入一个数组*/
        /*.1*/
        int[] bb = new int[]{1,2,3};
        Arrays.stream(bb);

        /*.2*/
        Integer[] cc = new Integer[]{1,2};
        Arrays.stream(cc);


        /**一.Collection接口的stream()方法 --- 只有实现了该接口的集合对象才可以使用该方法，如list，set，queue等，map不行*/
        /*.1*/
        List<String> list1 = new ArrayList<>();
        list.add("asc");
        list.add("svd");
        list.add("jdb");
        list1.stream();


    }
}
