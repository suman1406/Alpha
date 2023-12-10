package DynamicProgramming.CatalansNumber;

public class Memoization {
    public int catalansNumber(int n) {
        if (n <= 1) return 1;
        int[] cache = new int[n + 1];
        cache[0] = cache[1] = 1;
        return catalansNumber(n, cache);
    }

    private int catalansNumber(int n, int[] cache) {
        if (cache[n] != 0) return cache[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += catalansNumber(i, cache) * catalansNumber(n - i - 1, cache);
        }
        cache[n] = res;
        return res;
    }

    public static void main(String[] args) {
        Memoization memoization = new Memoization();
        System.out.println(memoization.catalansNumber(3));
    }
}
