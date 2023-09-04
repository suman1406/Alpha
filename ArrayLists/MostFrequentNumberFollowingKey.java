import java.util.*;

// Most Frequent Number following Key (EASY)

// You are given an integer ArrayList nums. You are also given an integer key, which is present in nums. For every unique integer target in nums, count the number of times target immediately follows an occurrence of key in nums. In other words, count the number of indices i such that:

// 0 <= i <= nums.size() - 2
// nums.get(i) == key
// nums.get(i+1) == target
// Return the target with the maximum count. (Assumption: the target with the maximum count is unique.)

public class MostFrequentNumberFollowingKey {
    public static int mostFrequentNumberFollowingKey(ArrayList<Integer> nums, int key) {
        // Initialize an array to keep track of counts for each possible target value.
        int[] targetCounts = new int[101]; // Assuming the values in nums are between 0 and 100.

        int maxCount = 0;
        int mostFrequentTarget = -1;

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                int target = nums.get(i + 1);
                targetCounts[target]++; // Increment the count for the target.

                if (targetCounts[target] > maxCount) {
                    maxCount = targetCounts[target];
                    mostFrequentTarget = target;
                }
            }
        }

        return mostFrequentTarget;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 2, 5, 6, 2, 7));
        int key = 2;
        int result = mostFrequentNumberFollowingKey(nums, key);
        System.out.println("The target with the maximum count is: " + result);
    }
}
