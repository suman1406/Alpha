package Hashing;
import java.util.*;

public class SubArrayWithSumK {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int k = 10;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == k) {
                count++;
            }
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            }
            else {
                map.put(sum, 1);
            }
        }
        System.out.println("Count of subarrays with sum " + k + ": " + count);
    }
}
