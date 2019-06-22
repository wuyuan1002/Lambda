package stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * toArray和collect的使用  >>>  练习流与数组，list，map，set等的相互转换
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/5/26
 */
public class Demo2 {
    public static void main(String[] args) {

        String[] strings = new String[]{"hello", "world", "helloworld"};

        /**
         * 把数组转换成流，再把流转换成数组
         */
        /*.1*/
        String[] s1 = Stream.of(strings).toArray(length -> new String[length]);

        /*.2*/
        String[] s2 = Stream.of(strings).toArray(String[]::new);





        /**
         * 把数组转换成流，再把流转换成List   ---   (同样地 也可以把流转成 map，set )
         */
        /*.1 -- 默认转换成ArrayList*/
        List<String> list1 = Stream.of(strings).collect(Collectors.toList());

        /*.2 -- 可以转换成自定义的Collection*/
        List<String> list2 = Stream.of(strings).collect(Collectors.toCollection(() -> new LinkedList<>()));

        /*.3 -- 可以转换成自定义的Collection*/
        List<String> list3 = Stream.of(strings).collect(Collectors.toCollection(LinkedList::new));

        /*.4*/
        List<String> list4 = Stream.of(strings).collect(() -> new ArrayList<>(),
                (thelist, item) -> thelist.add(item), (l1, l2) -> l1.addAll(l2));

        /*.5*/
        List<String> list5 = Stream.of(strings).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        /*.6*/
        List<String> list6 = Stream.of(strings).collect(Collector.of(ArrayList::new, ArrayList::add, (l1, l2) -> {l1.addAll(l2); return l1; }));









        /*.6 -- 默认转换成HashSet*/
        Set<String> set1 = Stream.of(strings).collect(Collectors.toSet());
        /*.7 -- 可以转换成自定义的Collection*/
        Set<String> set2 = Stream.of(strings).collect(Collectors.toCollection(() -> new HashSet<>()));

        /*.8 -- 可以转换成自定义的Collection*/
        Set<String> set3 = Stream.of(strings).collect(Collectors.toCollection(HashSet::new));

        /*.9*/
        Set<String> set4 = Stream.of(strings).collect(() -> new HashSet<String>(),
                (theset, item) -> theset.add(item), (ts1, ts2) -> ts1.addAll(ts2));

        /*.10*/
        Set<String> set5 = Stream.of(strings).collect(HashSet::new, HashSet::add, HashSet::addAll);









        /*.11*/
        Map<String, String> map1 = Stream.of(strings).collect(Collectors.toMap(i -> UUID.randomUUID().toString(), j -> j));

        /*.12*/
        Map<String, String> map2 = Stream.of(strings).collect(() -> new HashMap<>(),
                (themap, item) -> themap.put(UUID.randomUUID().toString(), item), (tm1, tm2) -> tm1.putAll(tm2));

        /*.13*/
        Map<String, String> map3 = Stream.of(strings).collect(HashMap::new,
                (tm, item) -> tm.put(UUID.randomUUID().toString(), item), HashMap::putAll);






    }
}
