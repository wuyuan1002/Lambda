package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

/**
 *   流 >>> 将多个对数据的操作串行(单线程)或并行(多线程 - 并发)起来执行
 *      >>> 由三部分构成:
 *       1). 源 -- 要操作的数据，数据的来源.
 *       2). 零个或多个中间操作 -- 每个操作都是对数据的操作并且返回值也是一个流(返回的是另外一个全新的流)，因此可以多次地流操作.
 *       3). 一个终止操作 -- 最终的操作，返回值不是流，得到最后的结果.
 *
 *
 *  流的特点：
 *     1.流本身不存储值，它是再调用时通过管道的方式从源上获取值.
 *     2.流操作数据后会生成一个新的流，里面是修改后的数据，但流的操作不会修改数据源的数据.
 *     3.流的中间操作都是惰性的，终止操作是立即执行的。只有遇到终止操作时中间操作才会执行，如果没有终止操作的话中间操作是不会执行的.
 *     4.每个Stream流只能使用一次，每调用流的一次中间操作返回的都是全新地一个流，原来的流已经不可以再重复使用了.
 *     5.流的中间操作增多并不会降低效率.
 *     6.流是将所有的操作合成一个整体，最终循环流中元素时一次性地作用于每个元素上，而不是循环一次元素作用一个操作，有几个操作
 *       就要循环几次元素。相反的流只需要循环一次元素将所有操作同时作用于元素上即可。
 *
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/5/25
 */
public class StreamTest {
    public static void main(String[] args) {
        /**
         * 创建流的方式
         */
        
        /**一.Stream.of()静态方法，传入一个(list,map,数组)或多个数据*/
        /*.1*/
        Stream.of("hello", "world", "hello world");//流中元素是每个字符串对象。
        
        /*.2*/
        int[] aa = new int[]{1, 2, 3};
        Stream.of(aa);//流中元素是整个数组对象，而不是数组中的每个元素。
        
        /*.3*/
        List<String> list = new ArrayList<>();
        list.add("asc");
        list.add("svd");
        list.add("jdb");
        Stream.of(list);//流中元素是整个list集合对象，而不是list中的每个元素。
        
        /*.4*/
        Map<String, String> as = new HashMap<>();
        as.put("ws", "as");
        as.put("as", "s");
        Stream.of(as);//流中元素是整个map集合对象，而不是map中的每个元素。
        
        
        /**二.Arrays.stream()方法，传入一个数组*/
        /*.1*/
        int[] bb = new int[]{1, 2, 3};
        Arrays.stream(bb);//流中元素是数组中的每个元素，而不是整个数组对象。
        
        /*.2*/
        Integer[] cc = new Integer[]{1, 2};
        Arrays.stream(cc);//流中元素是数组中的每个元素，而不是整个数组对象。
        
        
        /**三.Collection接口的stream()方法 --- 只有实现了Collection接口的集合的对象才能用，如 list，set，queue等，map不行*/
        /*.1*/
        List<String> list1 = new ArrayList<>();
        list1.add("asc");
        list1.add("svd");
        list1.add("jdb");
        list1.stream();//流中元素是list中的每个元素，而不是整个list集合对象。
        
        
        /**四.Stream的generate和iterate方法生成无限流(如果不指定生成的大小，则会无限创建)
         
         --->>>  之前的三种方法生成的都是有限流，流的大小是确定的(由数组或集合的大小确定) */
        
        /*.1 >>> 无限流，里面放的是无限个生成的对象，无限流需要与limit对象一起用来指定生成多少个(流的大小)*/
        Stream.generate(UUID.randomUUID()::toString).limit(3).forEach(System.out::println);
        
        /*.2 >>> 无限流，里面放的是无限个从1开始的奇数，无限流需要与limit对象一起用来指定生成多少个(流的大小)*/
        Stream.iterate(1, i -> i += 2).limit(7).forEach(System.out::println);
    }
}
