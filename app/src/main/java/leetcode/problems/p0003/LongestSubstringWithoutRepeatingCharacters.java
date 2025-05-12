package leetcode.problems.p0003;

import java.util.HashMap;
import java.util.Map;

/**
 * The intuition behind this solution is to use a sliding window and keep track
 * of how big this gets throughout each iteration.
 *
 * As the right pointer of the sliding window moves across, we update a simple
 * hash table with each character that has been seen. If a repeating character
 * occurs, we move the left pointer across until we reach the position of the
 * repeated character. For each iteration of moving the left pointer, we update
 * the hash table of all the characters we move past until we reach the repeated
 * character.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    int solve(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int greatestLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;  // move left past the last seen duplicate
            }

            map.put(c, right);  // update last seen index
            greatestLength = Math.max(greatestLength, right - left + 1);
        }
        return greatestLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longest = new LongestSubstringWithoutRepeatingCharacters();
        var answer = longest.solve("abcabcbb");

        System.out.println(answer);
    }
}
