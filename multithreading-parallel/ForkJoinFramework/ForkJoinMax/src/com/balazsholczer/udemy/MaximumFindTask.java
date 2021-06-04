package com.balazsholczer.udemy;

import java.util.concurrent.RecursiveTask;

public class MaximumFindTask extends RecursiveTask<Long> {

	private long[] nums;
	private int lowIndex;
	private int highIndex;
	
	public MaximumFindTask(long[] nums, int lowIndex, int highIndex) {
		this.highIndex = highIndex;
		this.lowIndex = lowIndex;
		this.nums = nums;
	}

	@Override
	protected Long compute() {

		if( highIndex - lowIndex <= 5 ) {
			return sequentialMaxFinding();
		} else {
			int middleIndex = (lowIndex+highIndex) / 2;
			MaximumFindTask leftSubtask = new MaximumFindTask(nums, lowIndex, middleIndex);
			MaximumFindTask rightSubtask = new MaximumFindTask(nums, middleIndex, highIndex);
			invokeAll(leftSubtask, rightSubtask);
			long a=leftSubtask.join();
			long b=rightSubtask.join();
			long value= Math.max(a, b);
			System.out.println("Thread.currentThread().getName()  in calculate :"+Thread.currentThread().getName()+" : "+value+" : "+a+" : "+b+" : "+lowIndex+" : "+middleIndex+" : "+highIndex);
			return  value;
		}
	}

	private long sequentialMaxFinding() {
		long max = nums[0];
		for(int i=lowIndex; i<highIndex;++i)
			if( nums[i] > max)
				max = nums[i];
		System.out.println("Thread.currentThread().getName() :"+Thread.currentThread().getName()+" : "+lowIndex+" : "+highIndex+" : "+max);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return max;
	}
}
