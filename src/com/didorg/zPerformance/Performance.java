package com.didorg.zPerformance;

import java.util.*;

public class Performance {
    public static void main(String[] args) {
        int mll = 1000000;
        Random random = new Random();

        int[] arr = new int[mll];
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < mll; i++) {
            arr[i] = random.nextInt(mll);
            integerList.add(random.nextInt(mll));
        }

        // Comparing performance
        doPerformanceArrForLoop(arr);
        doPerformanceInJavaUtilCollection(integerList);
        doPerformanceForEachWithLambda(integerList);
        doPerformanceWithStream(integerList);
    }

    // Array, for loop, and primitive data type.
    public static void doPerformanceArrForLoop(int[] arr) {
        long startTime = System.currentTimeMillis();
        int maxNumber = 0;
        // Enhanced 'for': for (int n : arr) { if (n > maxNumber) { maxNumber = n; }
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            if (n > maxNumber) {
                maxNumber = n;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Method: doPerformanceArrForLoop >>> EXECUTED IN: " + (endTime - startTime) +
                " ms finding the Maximum number:(" + maxNumber + ") in 1 Million");
    }

    // List and java util collection
    public static void doPerformanceInJavaUtilCollection(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        Integer max = Collections.max(integerList);
        long endTime = System.currentTimeMillis();
        System.out.println("Method: doPerformanceInJavaUtilCollection >>> EXECUTED IN: " + (endTime - startTime) +
                " ms finding the Maximum number:(" + max + ") in 1 Million");
    }

    // forEach with lambda
    public static void doPerformanceForEachWithLambda(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        final Integer[] maxNumber = {0};
        integerList.forEach(n -> {
            if (n > maxNumber[0]) maxNumber[0] = n;
        });
        long endTime = System.currentTimeMillis();
        System.out.println("Method: doPerformanceForEachWithLambda >>> EXECUTED IN: " + (endTime - startTime) +
                " ms finding the Maximum number:(" + maxNumber[0] + ") in 1 Million");
    }

    // Using stream
    public static void doPerformanceWithStream(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();
        Integer maxNumber = integerList.stream().max(Integer::compare).get();
        long endTime = System.currentTimeMillis();
        System.out.println("Method: doPerformanceWithStream >>> EXECUTED IN: " + (endTime - startTime) +
                " ms finding the Maximum number:(" + maxNumber + ") in 1 Million");
    }

}
