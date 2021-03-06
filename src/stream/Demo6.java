package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分组和分组 -->> 分组就是SQL的 group by ，分区是分组的特殊情况，分区是分为两组，一组是true组，一组是false组。
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/5/27
 */
public class Demo6 {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("wuyuan", 90, 23));
        students.add(new Student("zhangsan", 56, 22));
        students.add(new Student("lisi", 47, 24));
        students.add(new Student("wuyuan", 87, 56));
        students.add(new Student("zhangsan", 97, 27));
        students.add(new Student("wuyuan", 95, 22));


        /*
         * 按照姓名分组，组成员是list，里面是组成员对象
         */
        Map<String, List<Student>> map1 = students.stream().collect(Collectors.groupingBy(Student::getName));

        /*
         * 按照成绩分组，组成员是list，里面是组成员对象
         */
        Map<Integer, List<Student>> map2 = students.stream().collect(Collectors.groupingBy(Student::getScore));

        /*
         * 按照姓名分组，组成员long，是组中成员的个数
         */
        Map<String, Long> map3 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));

        /*
         * 先按照成绩分组，如果姓名相同，则按照成绩分组，组中成员是Student对象
         */
        Map<String, Map<Integer, List<Student>>> map4 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::getScore)));


        /*
         * 先按照姓名分组，如果姓名相同，则按照成绩分组，组中成员改成学生姓名放在set中
         */
        Map<String, Map<Integer, Set<String>>> map5 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.groupingBy(Student::getScore, Collectors.mapping(Student::getName, Collectors.toSet()))));


        /*
         * 按照姓名分组，组成员是Double(可以是其他)，组中成员的平均分
         */
        Map<String, Double> map6 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));


        /**
         * 按照成绩分区，(成绩大于60的在true区,小于六十的在false区)，区成员是list，里面是区成员对象
         */
        Map<Boolean, List<Student>> map7 = students.stream().collect(Collectors.partitioningBy(stu -> stu.getScore() >= 60));

        /**
         * 按照成绩分区，(成绩大于60的在true区,小于六十的在false区)，在同一个区的成员按照姓名分组
         */
        Map<Boolean, Map<String, List<Student>>> map8 = students.stream().collect(Collectors.partitioningBy(stu -> stu.getScore() >= 60, Collectors.groupingBy(Student::getName)));

        /**
         * 按照成绩分区，(成绩大于60的在true区,小于六十的在false区)，在同一个区的成员按照成绩分组，组中成员改成学生姓名放在list中
         */
        Map<Boolean, Map<Integer, List<String>>> map9 = students.stream().collect(Collectors.partitioningBy(stu -> stu.getScore() >= 60, Collectors.groupingBy(Student::getScore, Collectors.mapping(Student::getName, Collectors.toList()))));

    }
}

class Student {
    private String name;
    private int score;
    private int age;

    public Student(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}