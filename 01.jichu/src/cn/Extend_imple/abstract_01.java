package cn.Extend_imple;

abstract class AbstractClassExample {

    protected int x;
    private int y;

    public abstract void func1();

    public void func2() {
        System.out.println("func2");
    }
}

class AbstractClassExample1 extends  AbstractClassExample{

    @Override
    public void func1() {
        System.out.println("func1");
    }
}

public class abstract_01 {
    public static void main(String[] args) {
        AbstractClassExample1 a = new AbstractClassExample1();
        a.func1();
        a.func2();
        //func1
        //func2
    }
}
