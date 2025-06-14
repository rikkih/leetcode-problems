package leetcode.problems.p0049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 *
 * For each string, sort it -> O(n logn)
 * Insert it into a HashMap O(1)
 *
 * Total Time Complexity -> O(n logn)
 */
public class GroupAnagramsSorted {

    List<List<String>> group(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();

        for (String str : strs) {
            String sortedStr = getSortedString(str);
            groupMap
                    .computeIfAbsent(sortedStr, k -> new ArrayList<>())
                    .add(str);
        }

        return new ArrayList<>(groupMap.values());
    }

    private String getSortedString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {

    }
}
