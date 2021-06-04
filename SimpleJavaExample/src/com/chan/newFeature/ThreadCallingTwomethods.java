package com.chan.newFeature;

class  PrintValues {
    void m1(){
        System.out.println("In m1 :"+Thread.currentThread().getName());
    }

    void m2()
    {
        System.out.println("In m2 :"+Thread.currentThread().getName());
    }
}

class TwoMethodSynchronization implements Runnable{

    private   int countOfThread=1;

    private String valueOfThread;

    private static  volatile int count=1;

    private static  PrintValues printValues=new PrintValues();


    public TwoMethodSynchronization(int countOfThread, String valueOfThread) {
        this.countOfThread = countOfThread;
        this.valueOfThread = valueOfThread;
    }

    public TwoMethodSynchronization(String valueOfThread) {
        this.valueOfThread = valueOfThread;
    }

    @Override
    public void run() {

        synchronized (printValues){
            while(count<100)
            {
                //System.out.println("count values is "+ count);
                if(valueOfThread.equalsIgnoreCase("secondThread")){
                    if(countOfThread%2!=0){
                        System.out.println(Thread.currentThread().getName());//+" : "+ "count "+ count+ "countOfThread :"+ countOfThread);
                        printValues.notify();
                        countOfThread++;
                        count++;
                        try {
                            printValues.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        printValues.m2();
                        countOfThread++;
                        count++;
                        printValues.notify();
                        try {
                            printValues.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }else {
                    printValues.m1();
                    count++;
                    try {
                        printValues.notifyAll();
                        printValues.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
            printValues.notifyAll();
        }
    }
}
public class ThreadCallingTwomethods {

    public static void main(String[] args) {
        TwoMethodSynchronization twoMethodSynchronization_1=new TwoMethodSynchronization(1,"secondThread" );
        TwoMethodSynchronization twoMethodSynchronization_2=new TwoMethodSynchronization("firstThread");
        Thread t1=new Thread(twoMethodSynchronization_1);
        Thread t2=new Thread(twoMethodSynchronization_2);
        t1.start();
        t2.start();

    }
}


