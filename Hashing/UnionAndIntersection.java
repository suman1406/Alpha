package Hashing;
import java.util.*;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int n = 5, m = 6;
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            set.add(arr2[i]);
        }
        System.out.println("Union: " + set.size());

        set.clear();
        for (int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (set.contains(arr2[i])) {
                count++;
            }
        }
        System.out.println("Intersection: " + count);
    }
}
