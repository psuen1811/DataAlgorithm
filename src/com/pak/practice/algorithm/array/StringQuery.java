package com.pak.practice.algorithm.array;

public class StringQuery {

    static int[] matchingStrings(String[] strings, String[] queries) {
        int count;
        int[] result = new int[queries.length];
        for( int j = 0; j < queries.length; j++ ) {
            count = 0;
            for (String string : strings) {
                if (queries[j].equals(string)) {
                    count++;
                }
            }
            result[j] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] strings = {"abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn",
                "sdaklfj", "asdjf"};

        String[] queries = {"abcde", "sdaklfj", "asdjf", "na", "basdn"};
        int[] result = matchingStrings(strings, queries);
        for (int count : result)
            System.out.println(count);
    }
}
