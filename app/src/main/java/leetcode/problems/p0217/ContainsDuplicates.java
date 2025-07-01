package leetcode.problems.p0217;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    boolean containsDuplicate(int[] nums) {
        Set<Integer> seenElements = new HashSet<>();
        for (int num : nums) {
            if (!seenElements.add(num)) {
                return true;
            }
        }
        return false;
    }
}
