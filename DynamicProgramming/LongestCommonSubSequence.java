package DynamicProgramming;

public class LongestCommonSubSequence {
    // Given two sequences, find the length of longest subsequence present in both of them.
    // A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
    // For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
    // So, the length of the longest common subsequence of “abc” and “ab
    // is 4.
    // Approach:    
    // 1. If last characters of both sequences match (or X[m-1] == Y[n-1]) then
    //    L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])
    // 2. If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
    //    L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2]) )
    // Time complexity: O(2^n)
    // Space complexity: O(1)
    public static int lcs(String X, String Y) {
        return lcs(X, Y, X.length(), Y.length());
    }
    
    public static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return 1 + lcs(s1, s2, m-1, n-1);
        } else {
            return Math.max(lcs(s1, s2, m-1, n), lcs(s1, s2, m, n-1));
        }
    }

    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";

        System.out.println(lcs(s1, s2, s1.length(), s2.length()));
    }
}
