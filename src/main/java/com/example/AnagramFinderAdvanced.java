package com.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnagramFinderAdvanced {

    public static void findAnagrams(String[] input) {
        // Группировка индексов строк по отсортированным символам строки
        Map<String, List<Integer>> anagrams = IntStream.range(0, input.length)
                .boxed()
                .collect(Collectors.groupingBy(i ->
                        input[i].chars().sorted()
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()));

        anagrams.forEach((key, value) -> {
            // Печать только тех строк, у которых есть анаграммы
            if (value.size() > 1) {
                System.out.println(key + " = " + value.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }
        });
    }

    public static void main(String[] args) {
        String[] input = {"qwe", "wqe", "qwee", "a", "a"};
        findAnagrams(input);
    }
}
