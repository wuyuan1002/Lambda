package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
 *    流 >>> 将多个对数据的操作串联或并联起来
 *       >>> 由三部分构成:
 *        1). 源 -- 要操作的数据，数据的来源.
 *        2). 零个或多个中间操作 -- 每个操作都是对数据的操作并且返回值也是一个流流(将当前的流转换成另外一个流)，因此可以多次地流操作.
 *        3). 一个终止操作 -- 最终的操作，得到最后的结果
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
