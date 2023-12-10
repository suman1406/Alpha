package DynamicProgramming.LongestIncreasingSubsequence;

public class Recursion {
    public static int longestIncreasingSubsequence(int arr[], int n) {
        if (n == 1) {
            return 1;
        }

        int res, max = 1;

        for (int i = 1; i < n; i++) {
            res = longestIncreasingSubsequence(arr, i);

            if (arr[i-1] < arr[n-1] && res + 1 > max) {
                max = res + 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        int n = arr.length;

        System.out.println(longestIncreasingSubsequence(arr, n));
    }
}
