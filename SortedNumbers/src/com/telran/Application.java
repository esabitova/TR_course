package com.telran;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {

        int[] javaArray = new int[]{1,2,-8,3};
        int[]anotherArray = new int[]{1, 4, 3};

//        SortedNumbersList sortedArray = new SortedNumbersList(javaArray);
//        System.out.println(Arrays.toString(new SortedNumbersList[]{sortedArray}));

//            System.out.println(Arrays.toString(SortedNumbersListUtils.removeRepeated(javaArray)));

        System.out.println(Arrays.toString(SortedNumbersListUtils.intersection(javaArray,anotherArray)));

    }
}
