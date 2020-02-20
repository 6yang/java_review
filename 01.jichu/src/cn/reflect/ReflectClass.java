package cn.reflect;

import sun.rmi.runtime.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectClass {
    public static void main(String[] args) {
//        reflectNewInStance();
//        reflectPrivateConstructor();
//        reflectPrivateField();
        reflectPrivateMethod();

    }

    // 反射私有方法
    public static void reflectPrivateMethod() {
        try {
            Class<?> classBook = Class.forName("cn.reflect.Book");
            Method declaredMethod = classBook.getDeclaredMethod("declaredMethod", int.class);
            declaredMethod.setAccessible(true);
            Object o = classBook.newInstance();
            String invoke = (String) declaredMethod.invoke(o, 2);
            System.out.println(invoke);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // 反射私有属性
    private static void reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("cn.reflect.Book");
            Object o = classBook.newInstance();
            Field tag = classBook.getDeclaredField("TAG");
            tag.setAccessible(true);
            String s = (String) tag.get(o);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //反射私有构造方法
    private static void reflectPrivateConstructor() {
        try {
            Class<?> classBook = Class.forName("cn.reflect.Book");
            Constructor<?> declaredConstructor = classBook.getDeclaredConstructor(String.class, String.class);
            declaredConstructor.setAccessible(true);
            Object o = declaredConstructor.newInstance("hahaha", "java");
            Book book = (Book) o;
            System.out.println(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射创建对象
    private static void reflectNewInStance() {

        try {
            Class<?> classBook = Class.forName("cn.reflect.Book");
            Object o = classBook.newInstance();
            Book book = (Book) o;
            book.setName("liuyan");
            book.setAuthor("java面试");
            System.out.println(book);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

}
