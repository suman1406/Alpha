package DynamicProgramming.WildCardMatching;

public class Recursion {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int i, int j) {
        if (j == p.length()) return i == s.length();
        if (i == s.length()) {
            while (j < p.length() && p.charAt(j) == '*') j++;
            return j == p.length();
        }
        if (p.charAt(j) == '*') {
            while (j < p.length() && p.charAt(j) == '*') j++;
            if (j == p.length()) return true;
            while (i < s.length() && !isMatch(s, p, i, j)) i++;
            return i < s.length();
        } else if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
            return isMatch(s, p, i + 1, j + 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion.isMatch("aa", "a"));
        System.out.println(recursion.isMatch("aa", "*"));
        System.out.println(recursion.isMatch("cb", "?a"));
        System.out.println(recursion.isMatch("adceb", "*a*b"));
        System.out.println(recursion.isMatch("acdcb", "a*c?b"));
    }
}
