package function接口;

import java.util.function.Function;

/**
 * function函数式接口是接受一个参数，对该参数进行操作，然后返回操作的结果
 *
 * @author wuyuan
 * @version 1.0
 * @description 描述:
 * @date 2019/4/6 19:47
 */
public class Function_ {
    public static void main(String[] args) {
        Integer i = 2;
        Integer result = functionTest(i, ii -> ++ii * 6);
        System.out.println(result);
    }

    public static Integer functionTest(Integer i, Function<Integer, Integer> fun) {
        Integer result = fun.apply(i);
        return result;
    }
}
