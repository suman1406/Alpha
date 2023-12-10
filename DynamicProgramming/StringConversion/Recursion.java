package DynamicProgramming.StringConversion;

public class Recursion {
    public static int stringConversionRecursion(String s1, String s2, int n, int m) {
        if (n == 0) {
            return m;
        }

        if (m == 0) {
            return n;
        }

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return stringConversionRecursion(s1, s2, n-1, m-1);
        }

        return 1 + Math.min(stringConversionRecursion(s1, s2, n-1, m-1), Math.min(stringConversionRecursion(s1, s2, n-1, m), stringConversionRecursion(s1, s2, n, m-1)));
    }

    public static void main(String args[]) {
        String s1 = "sunday";
        String s2 = "saturday";

        System.out.println(stringConversionRecursion(s1, s2, s1.length(), s2.length()));
    }
}
