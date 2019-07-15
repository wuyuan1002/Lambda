package comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuyuan
 * @version 1.0
 * @className: ComparatorTest
 * @description 描述:
 * @date 2019/5/29
 */
public class ComparatorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("zhangsan", "liis", "wangwu", "wuyuan", "wangyi");
        list.sort(Comparator.comparing(String::length));
        list.stream().sorted((item1, item2) -> item2.length() - item1.length()).collect(Collectors.toList());
        Collections.sort(list, Comparator.comparingInt(o -> o.charAt(0)));
    }
}
