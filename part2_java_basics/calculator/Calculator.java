/* Task Description:
Complete the calculator coding question.

Give a string, and implement a calculator to evaluate a simple expression string. 
The expression string contains only non-negative integers, +, -, * operators.

Example1: input “1+2”, output:3

Example2: input “1+2*5”, output:11
*/

import java.util.Stack;

public class Calculator {

    public static int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int ans = 0;
        for (int i : stack) {
            ans += i;
        }
        return ans;
    }
}
