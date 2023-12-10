package DynamicProgramming.LongestSubSequence;

public class Recursion {
    public static int longestSubSequence(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return 1 + longestSubSequence(s1, s2, n-1, m-1);
        } else {
            return Math.max(longestSubSequence(s1, s2, n-1, m), longestSubSequence(s1, s2, n, m-1));
        }
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";

        System.out.println(longestSubSequence(s1, s2, s1.length(), s2.length()));
    }
}
