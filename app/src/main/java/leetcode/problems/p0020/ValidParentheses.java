package leetcode.problems.p0020;

import java.util.Map;
import java.util.Stack;

/**
 * For each character in S:
 *  - If opening bracket, push it to our stack.
 *  - If closing bracket, pop the last element from the stack and check it
 *    corresponds to its opening bracket.
 *      - If it does not correspond or the stack is empty. This is invalid.
 *  - If we reach the end of the string and the stack is empty -> valid.
 */
class ValidParentheses {

    Map<Character, Character> bracketMap = Map.of(')', '(', ']', '[', '}', '{');

    boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (bracketMap.containsValue(c)) {
                stack.push(c);
            } else if (bracketMap.containsKey(c) && !stack.isEmpty()) {
                if (stack.pop() != bracketMap.get(c)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "]";

        var result = validParentheses.isValid(s);

        System.out.println(result);
    }
}
