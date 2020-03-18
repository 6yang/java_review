package com.sh.collection;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 1.ArrayList的简单实现（手写）
 * 2.包括以下方法：
 *              int size();
 *              MyArrayList();
 *              MyArrayList(int initialCapacity);
 *              boolean isEmpty();
 *              Object get(int index);
 *              boolean add(Object obj);
 *              void add(int index,Object obj)
 *              Object remove(int index)
 *              boolean remove(Object obj)
 *              Object set(int index,Object obj)
 *              void rangeCheck(int index)
 *              void ensureCapacity()
 */
public class MyArrayList<E> {
    private Object element[];
    private int size;
    public MyArrayList() {
        this(10);

    }

    public MyArrayList(int capacity){
        if(capacity<0){
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        element = new Object[capacity];
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E get(int index){
        rangeCheck(index);
        return (E) element[index];
    }

    public boolean add(E elem){
        ensureCapacity();
        element[size++] = elem;
        return true;
    }

    public void add(int index,Object obj){
        /*
         * 插入操作（指定位置）
         * 1.下标合法性检查
         * 2.数组容量检查、扩容
         * 3.数组复制（原数组，开始下标，目的数组，开始下标，长度）
         */
        rangeCheck(index);
        ensureCapacity();
        System.arraycopy(element, index, element, index+1,size-index);
        element[index]=obj;
        size++;
    }

    public E remove(int index){

        rangeCheck(index);
        E oldValue =  get(index);
        System.arraycopy(element,index+1,element,index-1,size-index-1);
        size--;
        return oldValue;

    }



    private void rangeCheck(int index){
        if(index <0 || index>size-1){
            try {
                throw  new ArrayIndexOutOfBoundsException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    private void ensureCapacity(){
        if(size == element.length) {
            int newSize = size + (size >> 1);
            element = Arrays.copyOf(element, newSize);
        }
    }



}
