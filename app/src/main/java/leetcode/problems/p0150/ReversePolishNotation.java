package leetcode.problems.p0150;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

class ReversePolishNotation {

    private static final Set<String> operators = Set.of("+", "-", "*", "/");

    int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Deque<Integer> operandStack = new ArrayDeque<>();

        for (String token : tokens) {
            processToken(token, operandStack);
        }
        return operandStack.pop();
    }

    void processToken(String token, Deque<Integer> stack) {
        if (!operators.contains(token)) {
            stack.addFirst(Integer.parseInt(token));
        } else {
            int b = stack.pop();
            int a = stack.pop();

            int result = switch (token) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;
                default -> throw new IllegalArgumentException("Not a valid operator");
            };
            stack.push(result);
        }
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();

        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        var answer = rpn.evalRPN(tokens);

        System.out.println(answer);
    }
}
