package DynamicProgramming;

public class MinArrayJumps {
    // minimum jumps to reach end of array
    static int minJumps(int[] arr, int n) {
        int[] jumps = new int[n];
        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;
        jumps[0] = 0;
        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }

    // memoization
    static int minJumpsMemo(int[] arr, int n) {
        int[] jumps = new int[n];
        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;
        jumps[0] = 0;
        for (int i = 1; i < n; i++)
            jumps[i] = Integer.MAX_VALUE;
        return minJumpsMemoUtil(arr, n, jumps);
    }

    static int minJumpsMemoUtil(int[] arr, int n, int[] jumps) {
        if (n == 1)
            return 0;
        if (jumps[n - 1] != Integer.MAX_VALUE)
            return jumps[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (i + arr[i] >= n - 1) {
                int sub_res = minJumpsMemoUtil(arr, i + 1, jumps);
                if (sub_res != Integer.MAX_VALUE)
                    jumps[n - 1] = Math.min(jumps[n - 1], sub_res + 1);
            }
        }
        return jumps[n - 1];
    }

    // tabulation
    static int minJumpsTab(int[] arr, int n) {
        int[] jumps = new int[n];
        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;
        jumps[0] = 0;
        for (int i = 1; i < n; i++)
            jumps[i] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
        }
        return jumps[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 6, 1, 0, 9 };
        int n = arr.length;
        System.out.println("Minimum number of jumps to reach end is " + minJumps(arr, n));
    }
}
