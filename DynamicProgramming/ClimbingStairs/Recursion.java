package DynamicProgramming.ClimbingStairs;

public class Recursion {
    // Notes
    // Base case: n <= 2
    // Recursive case: f(n) = f(n-1) + f(n-2)
    // Time complexity: O(2^n)
    // Space complexity: O(n)
    
    public int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion.climbStairs(3));
        System.out.println(recursion.climbStairs(4));
        System.out.println(recursion.climbStairs(5));
    }
}
