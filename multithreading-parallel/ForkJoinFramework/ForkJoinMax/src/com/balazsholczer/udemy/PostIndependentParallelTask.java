package com.balazsholczer.udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PostIndependentParallelTask extends RecursiveTask<Integer> {

    List<Integer> listOfcpeRouterInfo;


    public PostIndependentParallelTask(List<Integer> listOfcpeRouterInfo) {
        this.listOfcpeRouterInfo = listOfcpeRouterInfo;
    }

    @Override
    protected Integer compute() {
        Set<Integer> setofUniqueValues = listOfcpeRouterInfo.stream().filter(u -> u != null)
                .collect(Collectors.toSet());
        if (setofUniqueValues.size() == 1) {
         return   processtheValues(listOfcpeRouterInfo);
        } else {
            List<PostIndependentParallelTask> listOfTask = new ArrayList<>();
            for (Integer i : setofUniqueValues
                    ) {
                List<Integer> listOfValues = listOfcpeRouterInfo.stream()
                        .filter(u -> u == i).collect(Collectors.toList());
                PostIndependentParallelTask postIndependentParallelTask = new PostIndependentParallelTask(listOfValues);
                listOfTask.add(postIndependentParallelTask);
            }
            invokeAll(listOfTask);
            listOfTask.forEach(u -> {
                System.out.println("isCompletedNormally :" + u.isCompletedNormally() + " : " + "Sum :" + u.join());
            });
            return 2;

        }
    }

    private int processtheValues(List<Integer> listOfValues) {
        System.out.println(Thread.currentThread().getName() + " : " + listOfValues);

        int sum = 0;
        try {
            Thread.sleep(3000);
            for (Integer i : listOfValues
                    ) {
                sum = sum + i;
                if(sum ==16 || sum ==10){
                    throw new RuntimeException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+" : "+sum);
        return sum;
    }


}