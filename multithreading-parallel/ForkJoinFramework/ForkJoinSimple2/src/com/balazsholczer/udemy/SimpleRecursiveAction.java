package com.balazsholczer.udemy;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveAction extends RecursiveTask<Integer> {

	private int simulatedWork;
	
	public SimpleRecursiveAction(int simulatedWork) {
		this.simulatedWork = simulatedWork;
	}
	
	@Override
	protected Integer compute() {
	//	System.out.println("Thread split the tasks..." + Thread.currentThread().getName() );

		if( simulatedWork > 100 ) {
			SimpleRecursiveAction simpleRecursiveAction1 = new SimpleRecursiveAction(simulatedWork/2);
			SimpleRecursiveAction simpleRecursiveAction2 = new SimpleRecursiveAction(simulatedWork/2);
			simpleRecursiveAction1.fork();
			simpleRecursiveAction2.fork();
			int solution = 0;
			solution = solution + simpleRecursiveAction1.join();
			solution = solution + simpleRecursiveAction2.join();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return solution;
			
		} else {

			System.out.println("No need for parallel execution, sequential is OK for this task..."+Thread.currentThread().getName() );
			return 2 * simulatedWork;
		}
	}
}
