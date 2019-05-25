package predicate;

import java.util.function.Predicate;

/**
 * @author wuyuan
 * @version 1.0
 * @className: MethodsOfPredicate
 * @description 描述:predicate的常用方法：
 *
 *                      1). and: 返回一个复合的prediacte，表示多个predicate的与。
 *                               先执行当前predicate，再执行参数predicate，
 *                               是多个predicate的短路与(&&).
 *
 *                      2). or:  返回一个复合的prediacte，表示多个prediacate的或。
 *                               先执行当前predicate，再执行参数predicate，
 *                               是多个predicate的短路或(||).
 *
 *                      3). negate: 表示当前prediacte求反(！).
 *
 *
 * @date 2019/5/25
 */
public class MethodsOfPredicate {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        //找出大于3并且是奇数的数字
        testAnd(integers, i -> i > 3, i -> (i & 1) == 1);
        System.out.println("------------------");

        //找出大于7或者是偶数的数字
        testOr(integers, i -> i > 7, i -> (i & 1) == 0);
        System.out.println("------------------");

        //找出大于5的数字
        testNegate(integers, i -> i <= 4);
    }

    public static void testAnd(Integer[] ints, Predicate<Integer> p1, Predicate<Integer> p2) {
        for (Integer i : ints) {
            if (p1.and(p2).test(i)) {
                System.out.println(i);
            }
        }
    }

    public static void testOr(Integer[] ints, Predicate<Integer> p1, Predicate<Integer> p2) {
        for (Integer i : ints) {
            if (p1.or(p2).test(i)) {
                System.out.println(i);
            }
        }
    }

    public static void testNegate(Integer[] ints, Predicate<Integer> p1) {
        for (Integer i : ints) {
            if (p1.negate().test(i)) {
                System.out.println(i);
            }
        }
    }


}
