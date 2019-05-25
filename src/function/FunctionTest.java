package function;

import java.util.function.Function;

/**
 * @author wuyuan
 * @version 1.0
 * @description 描述: function函数式接口是接受一个参数，对该参数进行操作，然后返回操作的结果
 * @date 2019/4/6 19:47
 */
public class FunctionTest {
    public static void main(String[] args) {
        System.out.println("--------第一种---------");
        Function<Integer, Integer> fun = i -> i + 1;
        System.out.println(fun.apply(2));


        System.out.println("--------第二种---------");
        Integer i = 2;
        Integer result = functionTest(i, ii -> ++ii * 6);
        System.out.println(result);
    }

    public static Integer functionTest(Integer i, Function<Integer, Integer> fun) {
        Integer result = fun.apply(i);
        return result;
    }
}
