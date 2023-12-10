package DynamicProgramming.CatalansNumber;

public class Tabulation {
    public int catalansNumber(int n) {
        if (n <= 1) return 1;
        int[] cache = new int[n + 1];
        cache[0] = cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            int res = 0;
            for (int j = 0; j < i; j++) {
                res += cache[j] * cache[i - j - 1];
            }
            cache[i] = res;
        }
        return cache[n];
    }

    public static void main(String[] args) {
        Tabulation tabulation = new Tabulation();
        System.out.println(tabulation.catalansNumber(3));
    }
}
