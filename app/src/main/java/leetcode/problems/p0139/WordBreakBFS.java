package leetcode.problems.p0139;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * We're going to do BFS over the index of S.
 * at index I,
 *   try each index I+j until I+j > S.length()
 *   if wordDict.contains(s.substring(I, I+j)), add I+j to queue
 */
class WordBreakBFS {

    boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            Integer start = queue.poll();
            if (visited.contains(start)) {
                continue;
            }
            visited.add(start);

            for (int end = start + 1; end <= s.length(); end++) {
                String substring = s.substring(start, end);
                if (wordSet.contains(substring)) {
                    if (end == s.length()) {
                        return true;
                    }
                    queue.offer(end);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        WordBreakBFS wordBreak = new WordBreakBFS();

        var result = wordBreak.wordBreak("catsandog", List.of("cats","dog","sand","and","cat"));

        System.out.println(result);
    }
}
