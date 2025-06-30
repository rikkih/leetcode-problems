package leetcode.problems.p0647;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicSubstringTest {

    PalindromicSubstring palindromicSubstring = new PalindromicSubstring();

    @Test
    public void givenString_shouldReturnPalindromeCount() {
        // Given
        String s = "fdsklf";

        // When
        var result = palindromicSubstring.countSubstrings(s);

        // Then
        assertEquals(6, result);
    }

}