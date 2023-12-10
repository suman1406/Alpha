package DynamicProgramming.WildCardMatching;

public class Memoization {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0, memo);
    }

    private boolean isMatch(String s, String p, int i, int j, Boolean[][] memo) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (i == s.length()) {
            while (j < p.length() && p.charAt(j) == '*') {
                j++;
            }
            return j == p.length();
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (p.charAt(j) == '*') {
            while (j < p.length() && p.charAt(j) == '*') {
                j++;
            }
            if (j == p.length()) {
                return memo[i][j] = true;
            }
            while (i < s.length() && !isMatch(s, p, i, j, memo)) {
                i++;
            }
            return memo[i][j] = i < s.length();
        } else if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
            return memo[i][j] = isMatch(s, p, i + 1, j + 1, memo);
        } else {
            return memo[i][j] = false;
        }
    }

    public static void main(String[] args) {
        Memoization memoization = new Memoization();
        System.out.println(memoization.isMatch("aa", "a"));
        System.out.println(memoization.isMatch("aa", "*"));
        System.out.println(memoization.isMatch("cb", "?a"));
        System.out.println(memoization.isMatch("adceb", "*a*b"));
        System.out.println(memoization.isMatch("acdcb", "a*c?b"));
    }
}
