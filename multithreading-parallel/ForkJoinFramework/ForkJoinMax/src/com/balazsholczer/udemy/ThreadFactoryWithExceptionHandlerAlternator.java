package com.balazsholczer.udemy;

public class ThreadFactoryWithExceptionHandlerAlternator  extends  NamedThreadFactory {

    private int count = 0;
    @Override
    public Thread newThread(Runnable r) {

        Thread t=super.newThread(r);
        int sequenceNumber = ++count;
        t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        return t;
    }
}
