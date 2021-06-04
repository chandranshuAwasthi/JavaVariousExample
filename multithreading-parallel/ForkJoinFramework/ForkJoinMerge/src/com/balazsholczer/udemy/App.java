package com.balazsholczer.udemy;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {

	public static void main(String[] args) {

		int[] nums = initializeNumsShortRange();
		SequentialMergesort mergesort = new SequentialMergesort(nums);

		long start = System.currentTimeMillis();
		//mergesort.mergeSort(nums);
		System.out.println("Time taken with sequential sort: " + (System.currentTimeMillis() - start) + "ms");

		MergeSortTask rootTask = new MergeSortTask(nums);
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors()*2);
		start = System.currentTimeMillis();
		pool.invoke(rootTask);
		System.out.println("Time taken with parallel sort: " + (System.currentTimeMillis() - start) + "ms");


	}

	private static int[] initializeNums() {

		Random random = new Random();

		int[] nums = new int[100000000];

		for (int i = 0; i < 100000000; ++i)
			nums[i] = random.nextInt(100);

		return nums;
	}

	private static int[] initializeNumsShortRange() {

		Random random = new Random();

		int[] nums = new int[100];

		for (int i = 0; i < 100; ++i)
			nums[i] = random.nextInt(100);

		return nums;
	}
}
