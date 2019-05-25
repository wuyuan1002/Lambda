package predicate;

import java.util.function.Predicate;

/**
 * @author wuyuan
 * @version 1.0
 * @className: PredicateTest
 * @description 描述: 用来做判断用，接受一个参数，返回值是boolean类型。
 * 当输入值满足条件时返回true，不满足时返回false。
 * @date 2019/5/24
 */
public class PredicateTest {
    public static void main(String[] args) {

        System.out.println("--------第一种---------");
        Predicate<Integer> te = p -> p > 7;
        System.out.println(te.test(3));


        System.out.println("--------第二种---------");
        String ss = "wuyuan";
        if (testPredicate(ss, str -> str.length() > 3)) {
            System.out.println("判断为true");
        } else {
            System.out.println("判断为false");
        }
    }

    public static boolean testPredicate(String s, Predicate<String> pre) {
        boolean re = pre.test(s);
        return re;
    }
}
