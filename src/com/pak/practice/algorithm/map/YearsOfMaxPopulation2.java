package com.pak.practice.algorithm.map;

import java.util.Arrays;

public class YearsOfMaxPopulation2 {
    static final int MAX_SIZE = 3000;
    public static int[] allYears;

    public static void main(String[] args) {
        allYears = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++)
            allYears[i] = 0;

        int[] birthDeathYears = {1894, 1803, 1803, 2000, 1840, 1750, 1975, 1975, 1921, 1809, 1921, 2010, 1935, 1869,
                2005, 2003};
        int[] birthYears = {1894, 1803, 1803, 2000, 1840, 1750, 1975, 1975};
        int[] deathYears = {1921, 1809, 1921, 2010, 1935, 1869, 2005, 2003};

        Arrays.sort(birthDeathYears);
        Arrays.sort(deathYears);
        for(int birthYear : birthYears) allYears[birthYear] += 1;
        for (int deathYear : deathYears) allYears[deathYear] = -1;
        /*for (int i = 0; i < birthDeathYears.length; i++) {
            if( allYears[i] == -1 )
                allYears[]
        }

         */

        System.out.println(Arrays.toString(birthDeathYears));
        System.out.println(allYears[1803]);

    }
}
