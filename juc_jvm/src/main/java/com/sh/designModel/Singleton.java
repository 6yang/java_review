package com.sh.designModel;

/*
* 静态变量
* 饿汉式
* */
class  A{
    private static A a = new A();
    private A() { }
    public static A getInstance(){
        return a;
    }
}
/*
 * 静态代码块
 * 饿汉式
 * */
class B{
    private B() { }
    private static B b;
    static { b = new B(); }
    public static B getInstance(){
        return b;
    }
}
/*
 * 静态变量
 * 懒汉式
 * */
class  A_l{
    private static A_l a;
    private A_l() { }
    public static A_l getInstance(){
        if(a==null){
            a = new A_l();
        }
        return a;
    }
}

/*
 * 静态变量
 * 懒汉式-使用synchronized线程安全
 * 缺点：给性能带来了很大的问题，效率太低了，getInstance经常发生，每一次都要同步这个方法。
 * */
class  A_l_s{
    private static A_l_s a;
    private A_l_s() { }
    public synchronized static A_l_s getInstance(){
        if(a==null){
            a = new A_l_s();
        }
        return a;
    }
}
/*
 * 静态变量
 * 懒汉式-双重检查
 * 推荐使用------
 * */
class C{
    private C(){};
    private volatile static C c;
    public static C getInstance(){
        if(c==null){
            synchronized (C.class){
                if(c==null){
                    c = new C();
                }
            }
        }
        return c;
    }
}



public class Singleton {
}
