public class Recursion {
    public static void main(String[] args) {
        int[] arr = { 40, 20, 30, 10, 30 };
        int n = arr.length;
        System.out.println("Minimum number of multiplications is " + MatrixChainOrder(arr, 1, n - 1));
    }

    static int MatrixChainOrder(int[] arr, int i, int j) {
        if (i >= j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = MatrixChainOrder(arr, i, k) + MatrixChainOrder(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (count < min)
                min = count;
        }
        return min;
    }
}
