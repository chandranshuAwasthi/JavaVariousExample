package com.balazsholczer.udemy;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortTask extends RecursiveAction {

	private int[] nums;

	public MergeSortTask(int[] nums) {
		this.nums = nums;
	}

	@Override
	protected void compute() {
		if (nums.length <= 10) {
			mergeSort(nums);
			return;
		}

		int middleIndex = nums.length / 2;
		int[] leftSubarray = Arrays.copyOfRange(nums, 0, middleIndex);
		int[] rightSubarray = Arrays.copyOfRange(nums, middleIndex, nums.length);
		MergeSortTask leftSorter = new MergeSortTask(leftSubarray);
		MergeSortTask rightSorter = new MergeSortTask(rightSubarray);
		invokeAll(leftSorter, rightSorter);
	//	leftSorter.join();
	  //  rightSorter.join();
		System.out.println("Thread.currentThread().getName()  in calculate :"+Thread.currentThread().getName()+" : "+middleIndex+" : "+nums.length);
		merge(leftSubarray, rightSubarray, nums);
		System.out.println("Before Counting");
		for (int i:nums
			 ) {
			System.out.println(i);

		}
		System.out.println("After Counting");
	}

	public void mergeSort(int[] nums) {

		System.out.println(Thread.currentThread().getName()+" : "+nums.length);
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		if (nums.length <= 1)
			return;

		int mid = nums.length / 2;

		int[] left = Arrays.copyOfRange(nums, 0, mid);
		int[] right = Arrays.copyOfRange(nums, mid, nums.length);

		mergeSort(left);
		mergeSort(right);

		merge(left, right, nums);
	}

	private void merge(int[] leftSubarray, int[] rightSubarray, int[] originalArray) {

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < leftSubarray.length && j < rightSubarray.length) {
			if (leftSubarray[i] < rightSubarray[j])
				originalArray[k++] = leftSubarray[i++];
			else
				originalArray[k++] = rightSubarray[j++];
		}

		while (i < leftSubarray.length)
			originalArray[k++] = leftSubarray[i++];

		while (j < rightSubarray.length)
			originalArray[k++] = rightSubarray[j++];
	}

}
