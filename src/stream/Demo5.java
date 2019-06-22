package stream;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * (.1)生成一个从5开始的无限流，流中的数字都是奇数，
 *      取出流中的前15个数字，
 *      过滤掉所有大于20的数字，
 *      然后把剩下的数字都乘以2，
 *      然后去掉重复的数字，
 *      然后求出剩下的数字从第4个开始之后的数字的总和，
 *      如果有元素的话输出总和，如果没有的话什么都不做
 *
 *  (.2 , .3 , .4)生成一个从5开始的无限流，流中的数字都是奇数，
 *      取出流中的前15个数字，
 *      过滤掉所有大于20的数字，
 *      然后把剩下的数字都乘以2，
 *      然后去掉重复的数字，
 *      然后把剩下的数字从第4个开始之后转换成字符串首尾相连,每个数字数字中间用-分割
 *
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/5/26
 */
public class Demo5 {
    public static void main(String[] args) {
        
        
        /*
         * .1
         */
        Stream.iterate(5, i -> i += 2)
                .limit(15)
                .filter(j -> j <= 20)
                .map(n -> n *= 2)
                .distinct()
                .skip(3)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
        
        
        /*
         * .2
         */
        String s = Stream.iterate(5, i -> i += 2)
                .limit(15)
                .filter(j -> j <= 20)
                .map(n -> n *= 2)
                .distinct()
                .skip(3)
                .collect(StringBuilder::new,
                        (sb, i) -> sb.append(i.toString().concat("-")),
                        StringBuilder::append)
                .toString();
        System.out.println(s);
        
        
        /*
         * .3
         */
        String s1 = Stream.iterate(5, i -> i += 2)
                .limit(15)
                .filter(j -> j <= 20)
                .map(n -> n *= 2)
                .distinct()
                .skip(3)
                .collect(Collector.of(
                        StringBuilder::new,
                        (sb, i) -> sb.append(i.toString().concat("-")),
                        StringBuilder::append,
                        StringBuilder::toString
                ));
        System.out.println(s1);
        
        
        /*
         * .4
         */
        String s2 = Stream.iterate(5, i -> i += 2)
                .limit(15)
                .filter(j -> j <= 20)
                .map(n -> n *= 2)
                .distinct()
                .skip(3)
                .map(d -> d.toString())
                .collect(Collectors.joining("-"));
        System.out.println(s2);
        
        
    }
}
