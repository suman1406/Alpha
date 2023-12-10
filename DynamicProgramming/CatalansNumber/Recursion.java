package DynamicProgramming.CatalansNumber;

public class Recursion {
    public int catalansNumber(int n) {
        if (n <= 1) return 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += catalansNumber(i) * catalansNumber(n - i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion.catalansNumber(3));
    }
}
