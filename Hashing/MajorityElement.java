package Hashing;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = { 2, 2, 2, 2, 5, 5, 2, 3, 3 };
        System.out.println(majorityElement(arr));
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int majorityElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            if (map.containsKey(key)) {
                int of = map.get(key);
                int nf = of + 1;
                map.put(key, nf);
            } else {
                map.put(key, 1);
            }
        }

        int maxFreq = 0;
        int ans = -1;
        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            if (freq > maxFreq) {
                maxFreq = freq;
                ans = key;
            }
        }

        return ans;
    }
}
