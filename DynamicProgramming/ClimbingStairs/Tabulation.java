package DynamicProgramming.ClimbingStairs;

public class Tabulation {

    // Notes
    // 1. The number of ways to reach the nth stair is the sum of the number of ways to reach the (n-1)th stair and the (n-2)th stair.
    // 2. The number of ways to reach the 0th stair is 1.
    // 3. The number of ways to reach the 1st stair is 1.
    // 4. The number of ways to reach the 2nd stair is 2.
    // 5. The number of ways to reach the 3rd stair is 3.
    // 6. The number of ways to reach the 4th stair is 5.
    // 7. The number of ways to reach the 5th stair is 8.
    // 8. The number of ways to reach the 6th stair is 13.
    // 9. The number of ways to reach the 7th stair is 21.
    // 10. The number of ways to reach the 8th stair is 34.
    // 11. The number of ways to reach the 9th stair is 55.

    public static int countWays (int n) {
        int ways[] = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;

        for (int i=2; i<=n; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }

        return ways[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countWays(n));
    }
}
