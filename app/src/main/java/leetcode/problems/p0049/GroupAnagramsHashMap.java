package leetcode.problems.p0049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * One way we can answer this is to generate a frequency table for each string.
 *
 * We can slot each string into a bucket whose key is the frequency table.
 */
public class GroupAnagramsHashMap {

    List<List<String>> getGroupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> bloodyThing = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> frequencyMap = getFrequencyMap(str);
            bloodyThing
                    .computeIfAbsent(frequencyMap, k -> new ArrayList<>())
                    .add(str);
        }

        return new ArrayList<>(bloodyThing.values());
    }

    private Map<Character, Integer> getFrequencyMap(String str) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        return frequencies;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{ "eat", "tea", "tan", "ate", "nat", "bat" };

        GroupAnagramsHashMap groupAnagrams = new GroupAnagramsHashMap();
        var answer = groupAnagrams.getGroupAnagrams(strs);

        System.out.println(answer);
    }
}
