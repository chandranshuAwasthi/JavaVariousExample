package com.balazsholczer.udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class App_PPT {

	public static int THREASHOLD = 0;
	
	public static void main(String[] args) {
		List<Integer> listOfInteger=new ArrayList<Integer>();
		IntConsumer intConsumer=i->IntStream.range(0,4).forEach(j->listOfInteger.add(i));;
		IntStream.range(0,9).forEach(intConsumer);
	//	Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("THE_DEFAULT_ONE"));
		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors()*2,new ForkJoinThreadFactory(),new ThreadExceptionHandler(),true);
		PostIndependentParallelTask postIndependentParallelTask=new PostIndependentParallelTask(listOfInteger);
		forkJoinPool.invoke(postIndependentParallelTask);
		System.out.println("Chandranshu");


		//System.out.println(forkJoinPool.getAsyncMode());
		//System.out.println(forkJoinPool.getQueuedSubmissionCount());
		//System.out.println(forkJoinPool.getQueuedTaskCount());
	;
	}


}
