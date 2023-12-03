package Stack;
import java.util.*;

public class StackQA {

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int temp = s.pop();
        pushAtBottom(s, data);
        s.push(temp);
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            result.append(s.pop());
        }

        System.out.println(result.toString());
        return str;
    }

    // reverse a stack
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int temp = s.pop();
        reverseStack(s);
        pushAtBottom(s, temp);
    }

    // stock span problem
    public static int[] stockSpan(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (s.isEmpty()) {
                result[i] = -1;
            } else if (arr[s.peek()] > arr[i]) {
                result[i] = s.peek();
            } else {
                while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = s.peek();
                }
            }
            s.push(i);
        }
        return result;
    }

    // Next Greater Element
    public static int[] nextGreaterElement(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                result[i] = -1;
            } else if (s.peek() > arr[i]) {
                result[i] = s.peek();
            } else {
                while (!s.isEmpty() && s.peek() <= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = s.peek();
                }
            }
            s.push(arr[i]);
        }
        return result;
    }

    // Valid Parenthesis
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else if (ch == ')') {
                if (s.isEmpty() || s.peek() != '(') {
                    return false;
                }
                s.pop();
            } else if (ch == '}') {
                if (s.isEmpty() || s.peek() != '{') {
                    return false;
                }
                s.pop();
            } else if (ch == ']') {
                if (s.isEmpty() || s.peek() != '[') {
                    return false;
                }
                s.pop();
            }
        }
        return s.isEmpty();
    }

    // Duplicate Parenthesis
    public static boolean duplicateParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != ')') {
                s.push(ch);
            } else {
                if (s.peek() == '(') {
                    return true;
                } else {
                    while (s.peek() != '(') {
                        s.pop();
                    }
                    s.pop();
                }
            }
        }
        return false;
    }

    // Maximum Area in Histogram
    public static int maxArea(int[] arr) {
        int maxArea = 0;

        // Next Smaller Element to the Right (NSR)
        int[] nsr = new int[arr.length];
        Stack<Integer> stackNSR = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stackNSR.isEmpty() && arr[i] < arr[stackNSR.peek()]) {
                stackNSR.pop();
            }

            nsr[i] = stackNSR.isEmpty() ? arr.length : stackNSR.peek();
            stackNSR.push(i);
        }

        // Next Smaller Element to the Left (NSL)
        int[] nsl = new int[arr.length];
        Stack<Integer> stackNSL = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stackNSL.isEmpty() && arr[i] < arr[stackNSL.peek()]) {
                stackNSL.pop();
            }

            nsl[i] = stackNSL.isEmpty() ? -1 : stackNSL.peek();
            stackNSL.push(i);
        }

        // Calculate maximum area
        for (int i = 0; i < arr.length; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int area = width * arr[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);

        pushAtBottom(s, 4);

        String str = "abc";
        String result = reverseString(str);
        System.out.println(result);

        reverseStack(s);
        System.out.println(s);

        int[] arr = { 100, 80, 60, 70, 60, 75, 85 };
        int[] result1 = stockSpan(arr);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }

        int[] arr1 = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] result2 = nextGreaterElement(arr1);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }

        String str1 = "{[()]}";
        boolean result3 = isValid(str1);
        System.out.println(result3);

        String str2 = "((a+b)+(c+d))";
        boolean result4 = duplicateParenthesis(str2);
        System.out.println(result4);

        int[] arr2 = { 6, 2, 5, 4, 5, 1, 6 };
        int result5 = maxArea(arr2);
        System.out.println(result5);
    }
}
