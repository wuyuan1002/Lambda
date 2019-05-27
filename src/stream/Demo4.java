package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuyuan
 * @version 1.0
 * @className: Demo4
 * @description 描述: map() 和 flatMap()
 * @date 2019/5/26
 */
public class Demo4 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "helloworld", "wuyuan");


        /**
         * 把list中的字符串都转换成大写，不放到新的list中，只是输出流中的结果
         */
        list.stream().map(String::toUpperCase).forEach(System.out::println);


        /**
         * 把list中的字符串都转换成大写，放到一个新的list中，然后输出它
         */
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

//        Stream.of(list).map(String::toUpperCase); // 这样写不行，map()操作的是list整体，而上一种是操作的list里面的元素




        /**
         * Lists里面是多个List，多个List中存储的是多个integer对象，使用flatMap方法将每一个List都转换成Stream，
         * 搞成一个整体的Stream，里面是单个List里面的元素.
         */
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(4, 2, 7, 5, 7, 3),
                Arrays.asList(8, 1, 9));


        List result = lists.stream()
                .flatMap(anyList -> anyList.stream())
                .map(integer -> integer * integer)
                .collect(Collectors.toList());
        System.out.println(result);


        /**
         * 把字符串List里的以空格隔开的单词去重放到一个List里.
         */
        List<String> stringList = Arrays.asList("hello world", "hello wuyuan nihao", "wuyuan nihao world");
        List<String> resultList = stringList.stream()
                .map(s -> s.split(" "))
                .flatMap(arr -> Stream.of(arr))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(resultList);


        /**
         * 将每一个打招呼语用在每个人上
         */
        List<String> list1 = Arrays.asList("hi", "hello", "nihao");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        List<String> hello = list1.stream()
                .flatMap(item -> list2.stream().map(item2 -> item + " " + item2))
                .collect(Collectors.toList());
        System.out.println(hello);

        //用map不行
//        list1.stream().map(item->list2.stream().map(item2->item+" "+item2).collect(Collectors.toList())).forEach(System.out::println);



    }
}
