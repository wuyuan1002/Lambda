package stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author wuyuan
 * @version 1.0
 * @className: Demo1
 * @description 描述:
 * @date 2019/5/26
 */
public class Demo1 {
    public static void main(String[] args) {

        Integer[] ins = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        /*
         * 输出把小于5的数字乘以2再相加的和
         */
        Stream.of(ins)
                .filter(i -> i < 5)
                .map(j -> j * 2)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);


    }
}
