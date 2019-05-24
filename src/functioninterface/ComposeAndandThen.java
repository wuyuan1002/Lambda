package functioninterface;

import java.util.function.Function;

/**
 * @author wuyuan
 * @version 1.0
 * @className: ComposeAndandThen
 * @description 描述:
 *
 *    compose是function接口的一个方法，他接收一个function类型的参数，
 * 先执行参数function，然后执行当前function，然后返回function类型，作用是
 * 把两个function结合起来执行。因为返回值也是function类型，所以就可以
 * 连接多个function执行。
 *
 *
 *    andThen也是function接口的一个方法，它的作用和compose方法差不多，
 * 它也是接受一个function类型的参数，只是它是先执行当前function，再执行
 * 参数function，返回值也是function类型。
 *
 *
 * @date 2019/5/24
 */
public class ComposeAndandThen {

    public static void main(String[] args) {
        System.out.println(composeTest(3, i -> i + 1, j -> j * 2));
        System.out.println(andThenTest(3, i -> i + 1, j -> j * 2));
    }


    public static Integer composeTest(int a, Function<Integer, Integer> fun1, Function<Integer, Integer> fun2) {

        //先执行fun2，再执行fun1 -- fun2的结果是fun1的参数
        Integer i = fun1.compose(fun2).apply(a);
        return i;
    }

    public static Integer andThenTest(int a, Function<Integer, Integer> fun1, Function<Integer, Integer> fun2) {

        //先执行fun1，再执行fun2 -- fun1的结果是fun2的参数
        Integer i = fun1.andThen(fun2).apply(a);
        return i;
    }
}
