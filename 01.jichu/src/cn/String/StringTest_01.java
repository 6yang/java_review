package cn.String;


import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class StringTest_01 {

    public static void main(String[] args) {

        //证明StringBuffer线程安全，StringBuilder线程不安全
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        CountDownLatch latch1 = new CountDownLatch(10000);
        CountDownLatch latch2 = new CountDownLatch(10000);
        for(int i=0;i<10000;i++){

            new Thread(()->{
                try {
                    stringBuilder.append(1);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch1.countDown();
                }
            },String.valueOf(i)).start();
        }
        for(int i=0;i<10000;i++){
            new Thread(()->{
                try {
                    stringBuffer.append(1);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch2.countDown();
                }
            },String.valueOf(i)).start();
        }
        try {
            latch1.await();
            System.out.println(stringBuilder.length()); //9996
            latch2.await();
            System.out.println(stringBuffer.length()); // 10000
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
