package com.sh.spring;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class HelloService{
    public HelloService() {
        System.out.println("hello Service 构造");
    }
    public void sayHello(){
        System.out.println("hello service");
    }
}

class MyMethodInterceptor implements MethodInterceptor{
    /**
     * sub：cglib生成的代理对象
     * method：被代理对象方法
     * objects：方法入参
     * methodProxy: 代理方法
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(" --- 插入前置通知----");
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println(" --- 插入后置通知----");
        return object;
    }
}

public class DynamicProxy_CGlib {
    public static void main(String[] args) {
        //Enhancer是CGLIB的核心工具类,是一个字节码增强器，它可以方便的对类进行扩展
        Enhancer enhancer = new Enhancer();
        //设置enhancer对象的父类
        enhancer.setSuperclass(HelloService.class);
        //设置enhancer的回调对象
        enhancer.setCallback(new MyMethodInterceptor());
        //创建代理对象
        HelloService proxy = (HelloService) enhancer.create();
        //通过代理对象调用目标方法
        proxy.sayHello();
        //打印结果
        //hello Service 构造
        // --- 插入前置通知----
        //hello service
        // --- 插入后置通知----
    }
}

