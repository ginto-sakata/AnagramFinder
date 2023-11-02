package com.example;

import java.util.*;

public class AnagramFinderSimple {

    public static void findAnagrams(String[] input) {
        // Создаем карту для хранения анаграмм.
        // Ключ - отсортированные символы строки, значение - список индексов строк в исходном массиве.
        Map<String, List<Integer>> anagrams = new HashMap<>();

        // Проходим по всем строкам входного массива.
        for (int i = 0; i < input.length; i++) {
            String word = input[i];

            // Сортируем символы строки.
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // Добавляем индекс строки в карту анаграмм.
            if (!anagrams.containsKey(sorted)) {
                anagrams.put(sorted, new ArrayList<>());
            }
            anagrams.get(sorted).add(i);
        }

        // Проходим по карте анаграмм и выводим те, которые имеют больше одной строки.
        for (Map.Entry<String, List<Integer>> entry : anagrams.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.print(entry.getKey() + " = ");
                for (int i = 0; i < entry.getValue().size(); i++) {
                    System.out.print(entry.getValue().get(i));
                    if (i < entry.getValue().size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        String[] input = {"qwe", "wqe", "qwee", "a", "a"};
        findAnagrams(input);
    }
}
