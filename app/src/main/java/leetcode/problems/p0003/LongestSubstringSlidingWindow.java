package leetcode.problems.p0003;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringSlidingWindow {
    int lengthOfLongestSubstring(String s) {
        int left = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= left) {
                left = charIndexMap.get(currentChar) + 1;
            }

            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
