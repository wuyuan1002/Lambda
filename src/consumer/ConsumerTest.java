package consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author wuyuan
 * @version 1.0
 * @description 描述: consumer函数式接口是接受一个参数，对该参数进行操作，没有返回值
 * @date 2019/4/6 19:32
 */
public class ConsumerTest {
    public static void main(String[] args) {
        System.out.println("--------遍历list---------");
        //遍历list
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        //lambda
        list.forEach(s -> System.out.println(s));
        //方法引用
        list.forEach(System.out::println);


        System.out.println("--------遍历map---------");
        //遍历map
        Map<String, String> map = new HashMap<>();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        map.forEach((s, s2) -> System.out.println(s + "     " + s2));





        System.out.println("--------第一种---------");
        Consumer<Integer> con = p -> System.out.println(p * p);
        con.accept(9);

        System.out.println("--------第二种---------");
        int i = 2;
        consumerTest(i, ii -> System.out.println(++ii));
    }


    //consumer方法接受一个参数和一个操作，说是并对这个参数所发布的做这个操作

    public static void consumerTest(Integer i, Consumer<Integer> con) {
        con.accept(i);
    }

}
