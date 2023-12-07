package Hashing;
import java.util.*;

public class CountDistinctElements {
    public static void main(String[] args) {
        // Use HashSets
        HashSet<Integer> set = new HashSet<>();
        int n = 10;
        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        System.out.println("Count using HashSet: " + set.size());

        // Use HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], 1);
        }
        System.out.println("Count using HashMap: " + map.size());

        // count distinct elements manually (not recommended, just for comparison)
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count++;
            }
        }

        System.out.println("Count using manual check: " + count);
    }
}
