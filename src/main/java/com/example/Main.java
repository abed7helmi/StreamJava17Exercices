package com.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //Write a Java program to calculate the average of a list of integers using streams.
        averageStream();

    }


    private static void averageStream(){
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // solution avec stream
        var average = list.stream().collect(Collectors.averagingInt(Integer::intValue));

        // solution avec IntStream
        IntStream maList = list.stream().mapToInt(Integer::intValue);
        OptionalDouble averge2 = maList.average();

        System.out.println(average +"," + averge2.getAsDouble());
    }
}