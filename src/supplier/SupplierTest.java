package supplier;

import java.util.function.Supplier;

/**
 * @author wuyuan
 * @version 1.0
 * @className: SupplierTest
 * @description 描述: 不接受参数，返回一个结果。
 *                    和consumer正好相反，consumer是接受一个参数不返回结果
 * @date 2019/5/25
 */
public class SupplierTest {
    public static void main(String[] args) {
        System.out.println("--------第一种---------");
        Supplier<String> su = () -> "hello world";
        System.out.println(su.get());




        System.out.println("--------第二.1种---------");
        Supplier<Student> s1 = () -> new Student();
        Student student1 = s1.get();
        System.out.println(student1.getName());

        System.out.println("--------第二.2种---------");
        Supplier<Student> s2 = Student::new;
        Student student2 = s2.get();
        System.out.println(student2.getName());

        System.out.println("--------第二.3种---------");
        Supplier<Student> s3 = () -> {
            Student stu = new Student();
            stu.setName("wuyuan");
            stu.setAge(23);
            return stu;
        };
        Student student3 = s3.get();
        System.out.println(student3.getName());

    }
}

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}