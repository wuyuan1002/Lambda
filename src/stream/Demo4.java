package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuyuan
 * @version 1.0
 * @className: Demo4
 * @description 描述:
 * @date 2019/5/26
 */
public class Demo4 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "helloworld", "wuyuan");



        /**
         * 把list中的字符串都转换成大写，不放到新的list中，只是输出流中的结果
         */
        list.stream().map(String::toUpperCase).forEach(System.out::println);



        /**
         * 把list中的字符串都转换成大写，放到一个新的list中，然后输出它
         */
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);


//        Stream.of(list).map(String::toUpperCase); // 这样写不行，map()操作的是list整体，而上一种是操作的list里面的元素

    }
}