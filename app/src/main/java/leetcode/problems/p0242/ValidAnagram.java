package leetcode.problems.p0242;

import java.util.HashMap;
import java.util.Map;

class ValidAnagram {
    boolean solve(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sFrequency = new HashMap<>();
        Map<Character, Integer> tFrequency = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sFrequency.put(s.charAt(i), sFrequency.getOrDefault(s.charAt(i), 0) + 1);
            tFrequency.put(t.charAt(i), tFrequency.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sFrequency.equals(tFrequency);
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();

        var answer = validAnagram.solve("cat", "act");
        System.out.println(answer);
    }
}
