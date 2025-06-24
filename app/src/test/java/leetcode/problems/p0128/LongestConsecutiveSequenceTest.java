package leetcode.problems.p0128;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {

    private LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

    @Test
    public void givenArrayWithConsecutiveSequence_shouldReturnItsLength() {
        int[] array = new int[]{ 100, 4, 200, 1, 3, 2 };

        var result = longestConsecutiveSequence.longestConsecutive2(array);

        assertEquals(4, result);
    }

}