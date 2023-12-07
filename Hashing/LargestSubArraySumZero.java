package Hashing;
import java.util.*;

public class LargestSubArraySumZero {
    public static void main(String[] args) {
        int n = 8;
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLen = i + 1;
            }
            else {
                if (map.containsKey(sum)) {
                    maxLen = Math.max(maxLen, i - map.get(sum));
                }
                else {
                    map.put(sum, i);
                }
            }
        }
        System.out.println("Largest subarray with sum 0: " + maxLen);
    }
}
