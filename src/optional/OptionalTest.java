package optional;

import java.util.Optional;

/**
 * optional是一个容器类，里面有一个属性value用来存储一个可能为空也可能不为空的对象，
 * 作用是用来规避空指针异常的。该类没有公有的构造方法，里面的方法都是静态的。
 *
 * @author wuyuan
 * @version 1.0
 * @date 2019/5/25
 */
public class OptionalTest {
    public static void main(String[] args) {
        User u1 = new User();



        System.err.println("-----------构造optional------------");
        //新建一个optional，里面的值是null
        Optional<User> op1 = Optional.empty();
        //包含一个不可以为空的对象，如果为空则报空指针异常
        Optional<User> op2 = Optional.of(u1);
        //包含一个可以为空也可以不为空的对象
        Optional<String> op3 = Optional.ofNullable(u1.getName());


        System.err.println("------------里面的常用方法-------------");
        System.out.println("------------isPresent-------------");
        //判断里面的值是否为null --- 一般不用
        boolean b1 = op3.isPresent();
        System.out.println(b1);


        System.out.println("------------get-------------");
        //获取optional里的值，如果是null则报空指针异常
        User u3 = op2.get();
        System.out.println(u3.getName());


        System.out.println("-----------ifPresent--------------");
        //如果optional里的值不为null，则执行传入的Consumer，consumer的参数是optional里面的值，如果为null，则什么都不执行
        op2.ifPresent(u -> System.out.println("optional里的值不是null，是" + u));


        System.out.println("------------orElse-------------");
        //如果optional里的值不是null，则返回里面的值，如果是null，则返回传入的参数
        String st = op3.orElse("如果值是null，则返回传入的参数");
        System.out.println(st);


        System.out.println("------------map-------------");
        //接受一个function，返回值是一个optional，返回值里面的值是把当前optional对象里面的值传入参数function执行后的返回值
        //如果当前optional对象里面的值是null，则返回一个里面的值为null的新optional对象
        Optional<User> op4 = op2.map((user) -> {
            user.setName("wuy1");
            return user;
        });

        System.out.println("------------map组合使用-------------");
        op2.map((user) -> {
            user.setName("wuy2");
            return user;
        }).ifPresent(u -> System.out.println(u.getName()+"  map+ifPresent组合使用"));

        System.out.println("------------map组合使用-------------");
        User user = op2.map(u -> {
            u.setName("wuy2");
            return u;
        }).orElse(new User("新建的user"));
        System.out.println(user.getName()+"  map+orElse组合使用");

    }
}

class User {
    private String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}