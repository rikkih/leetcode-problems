package leetcode.problems.p0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Let n = |strs|
 * Let k = str length (greatest)
 *
 * Then
 * loop over strs = O(n)
 *   - sort string = O(k*log(k))
 *   - Get from HashMap = O(1)
 *   - Add to HashMap = O(1)
 *
 * So
 * O(n * (klog(k) + 1 + 1)) = O(n * k * log(k))
 */
public class GroupAnagramsAgain {
    List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedToUnsortedMap = new HashMap<>();

        for (String string : strs) {
            String sorted = sortString(string);
            sortedToUnsortedMap.computeIfAbsent(sorted, k -> new ArrayList<>()).add(string);
        }
        return new ArrayList<>(sortedToUnsortedMap.values());
    }

    // O ( nlog(n) )
    private String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
