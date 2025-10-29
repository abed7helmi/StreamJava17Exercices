package com.example;

import java.awt.*;
import java.util.*;
import java.util.List;
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

        //Count strings starting with letter using streams
        startWithStream('a');

        //Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
        asortStream();

        //Write a Java program to find the maximum and minimum values in a list of integers using streams.
        maxMinStream();

        //Write a Java program to find the second smallest and largest elements in a list of integers using streams.
        secondMaxMinStream();

    }

    private static void secondMaxMinStream() {
        List<Integer> list = List.of(4,-54,654,1,0,25,12);

        var max = list.stream().sorted().skip(1).limit(1).toList();
        var min = list.stream().sorted(Comparator.reverseOrder()).skip(1).limit(1).toList();

        // ou miex

        Integer secondSmallest = list.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);

        // Find the second largest element
        Integer secondLargest = list.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println(max.get(0));
        System.out.println(min.get(0));
    }

    private static void maxMinStream() {

         List<Integer> list = List.of(4,54,654,1,0,25,12);

         OptionalInt x = list.stream().mapToInt(Integer::intValue).max();
         var min = list.stream().mapToInt(Integer::intValue).min();

         //ou

        Integer x2 = list.stream().max(Comparator.naturalOrder()).get();
        Integer min2 = list.stream().min(Comparator.naturalOrder()).get();

        // ou

        Integer max_val = list.stream()
                .max(Integer::compareTo)
                .orElse(null);

        // Find the minimum value
        Integer min_val = list.stream()
                .min(Integer::compare)
                .orElse(null);

        System.out.println(x + " " +min);
        System.out.println(x2 + " " +min2);

    }

    private static void asortStream() {
        List<String> list = List.of("azze", "ea", "az","bb", "qa", "e","cc", "zf", "agd", "h");


        List<String> sorted1 = list.stream().sorted().toList();
        List<String> sorted2 = list.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sorted1);
        System.out.println(sorted2);
    }

    private static void startWithStream(final char a) {
        List<String> list = List.of("azze", "ea", "az", "qa", "e", "zf", "agd", "h");

        long sum = list.stream().filter(s ->
            s.startsWith(String.valueOf(a))
        ).count();
        System.out.println(sum);
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