package com.sh.juc._volatile;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Mydata{
    volatile int num = 0;
    
    public void addTo10(){
        this.num = 10;
    }

    public int getNum() {
        return num;
    }

    public void addPlusPlus(){
        num++;
    }
}
public class V_01_ProveVolatile3Property {
    public static void main(String[] args) {


    }

    private static void ProveNoAtom() {
        Mydata mydata = new Mydata();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    mydata.addPlusPlus();
                }
            },String.valueOf(i)).start();
        }
        if(Thread.activeCount()>2){
            Thread.yield();
        }
        //main	17328
        System.out.println(Thread.currentThread().getName()+"\t"+mydata.getNum());
    }

    //证明可见性
    private static void ProveCanSeeOK() {
        Mydata mydata = new Mydata();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 修改num");
            try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
            mydata.addTo10();
        },"A").start();

        while (mydata.num == 0){

        }
        System.out.println("main get new number" +mydata.getNum());
    }
}
