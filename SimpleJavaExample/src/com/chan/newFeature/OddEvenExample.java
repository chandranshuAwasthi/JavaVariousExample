package com.chan.newFeature;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class ValuePrinter implements Runnable {

    private static Object printValues = new Object();
    private volatile static int maxValue = 1;
    private int reminder;

    public ValuePrinter(int reminder) {
        this.reminder = reminder;
    }

    public ValuePrinter() {

    }

    @Override
    public void run() {
        while (maxValue < 20) {
            synchronized (printValues) {
                if (maxValue % 2 == reminder) {
                    try {
                       printValues.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Thread.currentThread().getName() :" + Thread.currentThread().getName() + ":" + maxValue + ":" + reminder);
                printValues.notifyAll();
                maxValue = maxValue + 1;
            }
        }
    }
}


public class OddEvenExample {
    public static void main(String[] args) {


        Map<String,String> hashMap=new HashMap<String,String>();
        hashMap.put("chandranshu","awasthi");
        Set<Map.Entry<String,String>> setOfValues=hashMap.entrySet();
         for(Map.Entry<String,String> me:setOfValues){
             if("chandranshu".equalsIgnoreCase(me.getKey())){
                 hashMap.remove(me.getKey());

             }
         }

        /*for(String s1: hashMap.keySet())
        {
            hashMap.get()

        }*/


        ValuePrinter valuePrinter = new ValuePrinter(0);
        ValuePrinter valuePrinter2 = new ValuePrinter(1);
     //   ValuePrinter valuePrinter3 = new ValuePrinter(2);
        Thread t1 = new Thread(valuePrinter);
        Thread t2 = new Thread(valuePrinter2);
       // Thread t3 = new Thread(valuePrinter3);
        t1.start();
        t2.start();
       // t3.start();
    }
}
