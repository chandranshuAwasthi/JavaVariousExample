package com.balazsholczer.udemy;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

public class ForkJoinThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {

    private static int count = 0;
    private static String NAME = "Chandranshu-";

    @Override
    public final ForkJoinWorkerThread newThread(ForkJoinPool pool) {
        BlockChainForkJoinWorkerThread th= new BlockChainForkJoinWorkerThread(pool);
        th.setName(NAME + ++count);
        th.setUncaughtExceptionHandler(new ThreadExceptionHandler());
        return th;

    }


    static  class BlockChainForkJoinWorkerThread extends ForkJoinWorkerThread{

        /**
         * Creates a ForkJoinWorkerThread operating in the given pool.
         *
         * @param pool the pool this thread works in
         * @throws NullPointerException if pool is null
         */
         BlockChainForkJoinWorkerThread(ForkJoinPool pool) {
            super(pool);
        }
    }
}
