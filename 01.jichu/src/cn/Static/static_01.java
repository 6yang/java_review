package cn.Static;

class Fu {

    public static String staticFiled = "Fu的静态变量";

    static {
        System.out.println("Fu静态代码块");
    }

    public String field = "FU实例变量";

    {
        System.out.println("FU普通语句块");
    }

    public Fu() {
        System.out.println("fu的构造方法");
    }

}
class zi extends Fu{
    public static String staticFiled = "ZI的静态变量";

    static {
        System.out.println("ZI静态代码块");
    }

    public String field = "ZI实例变量";

    {
        System.out.println("zi普通语句块");
    }

    public zi() {
        System.out.println("ZI的构造方法");
    }
}

public class static_01 {

    public static void main(String[] args) {

        zi zi = new zi();

        //Fu静态代码块
        //ZI静态代码块
        //FU普通语句块
        //fu的构造方法
        //zi普通语句块
        //ZI的构造方法
    }
}
