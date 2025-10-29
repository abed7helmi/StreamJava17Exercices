package com.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //Write a Java program to calculate the average of a list of integers using streams.
        averageStream();

        //Convert strings to upper/lowercase using streams
        convertStream();

        //Write a Java program to calculate the sum of all even, odd numbers in a list using streams
        pairImpairStream();
        pairImpairStream2();

        //Remove duplicates from list using streams
        removeDuplicate();

    }

    private static void removeDuplicate() {
        List<String> list = List.of("a", "e", "a", "a", "e", "f", "g", "h");

        List<String> withoutDuplicate = list.stream().distinct().toList();

        System.out.println(withoutDuplicate);

    }

    private static void pairImpairStream2() {
        List < Integer > numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Sum of even numbers
        int sumOfEvens = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of even numbers: " + sumOfEvens);

        // Sum of odd numbers
        int sumOfOdds = numbers.stream()
                .filter(num -> num % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static void pairImpairStream() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Function<Integer,String> maFunction = x -> {
            return ( x % 2 ==0) ? "Pair" : "Impair";
        };
        var maListe =  list.stream().collect(Collectors.groupingBy(maFunction,Collectors.summingInt(Integer::intValue)));
        System.out.println(maListe.get("Impair"));
        System.out.println(maListe.get("Pair"));
    }

    private static void convertStream() {
        List<String> list = new ArrayList<>(List.of("ad", "bA", "cs"));

        List<String> lower = list.stream().map(String::toLowerCase).collect(Collectors.toList());
        List<String> uper = list.stream().map(String::toUpperCase).collect(Collectors.toList());


        System.out.println(lower + "////" + uper);
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