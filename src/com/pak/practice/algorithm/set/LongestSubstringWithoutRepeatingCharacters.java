package com.pak.practice.algorithm.set;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int i = 0, max = 0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            while (seen.contains(c)) {
                seen.remove(s.charAt(i++));
            }

            seen.add(c);
            max = Math.max(max, j - i + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        String input2 = "pwwkew";
        String input3 = "bbbbb";
        String input4 = "";
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring(input));
    }
}
