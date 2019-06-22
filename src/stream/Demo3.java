package stream;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuyuan
 * @version 1.0
 * @date 2019/5/26
 */
public class Demo3 {
    public static void main(String[] args) {
        String[] strings = new String[]{"hello", "world", "helloworld"};

        /**
         * 把字符串数组中的字符串拼接成一个字符串
         */
        /*.1*/
        String str1 = Stream.of(strings).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println(str1);

        /*.2*/
        String str2 = Stream.of(strings).collect(Collectors.joining());
        System.out.println(str2);

        /*.3 -->> .2的底层实现*/
        String str3 = Stream.of(strings).collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));
        System.out.println(str3);

        /*.4*/
        String str4 = Stream.of(strings).collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append)).toString();
        System.out.println(str4);

    }
}
