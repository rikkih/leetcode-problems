package leetcode.problems.p0349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArraysSets {

    int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
