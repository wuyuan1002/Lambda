package lambda表达式;

/**
 * Lambda表达式其实的是一个实现了有且只有一个方法的接口的类的对象。
 * 这个有且只有一个自己的方法的接口叫做函数式接口。
 *
 * @author wuyuan
 * @version 1.0
 * @description 描述:
 * @date 2019/4/5 20:33
 */
public class Lambda {
    public static void qwe(asd asd, int i) {
        asd.aa(i);
    }

    public static void zxc(int i) {
        System.out.println(i);
    }

    public static void main(String[] args) {
        int as = 1;

        qwe((ppp) -> {
            System.out.println("b");
            System.out.println(ppp);
        }, as);

        //如果lambda表达式的方法调用的是一个已经被实现的方法，那么可以直接用方法引用来代替lambda表达式
        qwe(Lambda::zxc, as);

        asd asdd = (iii) -> {
            System.out.println("a");
            System.out.println(iii);
        };
        asdd.aa(as);

    }
}

interface asd {
    void aa(int i);
}