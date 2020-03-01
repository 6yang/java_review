package com.sh.spring;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IHello{
    void sayHello();
}
class IHelloImpl implements IHello{

    @Override
    public void sayHello() {
        System.out.println("say hello ");
    }
}
class MyInvocationHandler implements InvocationHandler{

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 执行目标对象的方法
     * @param proxy 代理对象
     * @param method 代理方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前调用");
        Object result = method.invoke(target, args);
        System.out.println("方法之后调用");
        return result;
    }
}

public class DynamicProxy_JDK {
    public static void main(String[] args) {
        IHelloImpl iHello = new IHelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(iHello);
        //获取目标对象的代理对象
        IHello proxyHello = (IHello)Proxy.newProxyInstance(IHelloImpl.class.getClassLoader(),
                IHelloImpl.class.getInterfaces(),
                handler);
        //调用代理方法
        proxyHello.sayHello();
        //方法之前调用
        //say hello
        //方法之后调用
    }
}

