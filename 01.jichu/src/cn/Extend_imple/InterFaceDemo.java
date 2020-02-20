package cn.Extend_imple;

public interface InterFaceDemo {

    void fun1();

    default void func2(){
        System.out.println("default func2");
    }
    int x = 10;

    public int z = 0;
}
class ints implements InterFaceDemo{
    public static void main(String[] args) {
        ints ints = new ints();
        ints.fun1();
        ints.func2();
    }

    @Override
    public void fun1() {
        System.out.println("func1");
    }
}