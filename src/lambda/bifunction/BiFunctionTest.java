package lambda.bifunction;

import java.util.function.BiFunction;

/**
 * @author wuyuan
 * @version 1.0
 * @className: BiFunctionTest
 * @description 描述: BiFunction和Function接口差不多，BiFunction接口是接受两个参数，返回一个结果
 * @date 2019/5/24
 */
public class BiFunctionTest {
    public static void main(String[] args) {
        System.out.println("--------第一种---------");
        BiFunction<Integer, Integer, Integer> bif = (a, b) -> a * a + b;
        System.out.println(bif.apply(5, 6));

        System.out.println("--------第二种---------");
        Integer a = 2, b = 3;
        System.out.println(bifunctionTest(a, b, (aa, bb) -> aa * bb));
    }

    public static Integer bifunctionTest(Integer i, Integer j, BiFunction<Integer, Integer, Integer> bif) {
        Integer re = bif.apply(i, j);
        return re;
    }
}
