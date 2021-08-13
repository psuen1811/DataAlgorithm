package com.pak.practice.algorithm.map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Return years of max population by a set of birth and death years of individuals
public class YearsOfMaxPopulation {

    // Get a max value from map entries
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    static <K, V extends Comparable<V>> V maxUsingStreamAndMethodReference(ArrayListMultimap<K, V> map) {
        Optional<Map.Entry<K, V>> maxEntry = map.entries()
                .stream()
                .max(Map.Entry.comparingByValue());
        return maxEntry.get()
                .getValue();
    }

    // Get key streams by values
    static <K, V> Stream<K> keys(ArrayListMultimap<K, V> map, V value) {
        return map
                .entries()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey);
    }

    // Compare both lists
    // incrementing or decrementing by 1 for birth and death, respectively,
    // then store the answer in Multi-Map
    static <K, V> ArrayListMultimap<K, V> solve(ArrayListMultimap<K, V> peopleBirthDeath,
                                                ArrayList<Integer> birthYearList, ArrayList<Integer> deathYearList) {
        int birthCount = 0;
        int nextDeathYear = 0;
        ArrayListMultimap<Integer, Integer> answer = ArrayListMultimap.create();
        for (int index = 0; index < birthYearList.size(); index++) {
            if (birthYearList.get(index) <= deathYearList.get(nextDeathYear)) {
                birthCount++;
                answer.put(birthYearList.get(index), birthCount);
            } else {
                nextDeathYear++;
                index--; // backtrack the last person
                birthCount--;
            }
        }
        //noinspection unchecked
        return (ArrayListMultimap<K, V>) answer;
    }

    public static void main(String[] args) {

        // Use Multimap to store duplicate keys (non-unique)
        // ArrayListMultimap<Integer, Integer> peopleBirthDeath = ArrayListMultimap.create();

        // Birth, Death years
        /*
        peopleBirthDeath.put(2000, 2010);
        peopleBirthDeath.put(1975, 2005);
        peopleBirthDeath.put(1975, 2003);
        peopleBirthDeath.put(1803, 1809);
        peopleBirthDeath.put(1750, 1869);
        peopleBirthDeath.put(1840, 1935);
        peopleBirthDeath.put(1803, 1921);
        peopleBirthDeath.put(1894, 1921);


         */
        // Create lists to store birth and death years individually
        ArrayList<Integer> birthYearList = Lists.newArrayList(2000,1975,1975,1803,1750,1840,1803,1894);
        ArrayList<Integer> deathYearList = Lists.newArrayList(2010,2005,2003,1809,1869,1935,1921,1921);
        /*
        for (Map.Entry<Integer, Integer> year : peopleBirthDeath.entries()) {
            birthYearList.add(year.getKey());
            deathYearList.add(year.getValue());
        }

         */

        System.out.println(birthYearList);
        System.out.println(deathYearList);

        // Sort birth and death years separately
        Collections.sort(birthYearList);
        Collections.sort(deathYearList);

        ArrayListMultimap<Integer, Integer> answer = solve(null, birthYearList, deathYearList);

        int highest = maxUsingStreamAndMethodReference(answer);
        System.out.println("Population: " + highest + "\nYears: " + keys(answer, highest)
                .collect(Collectors.toSet()));
    }
}
