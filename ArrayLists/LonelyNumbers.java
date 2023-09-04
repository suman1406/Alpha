// Lonely Numbers in ArrayList (MEDIUM)

// You are given an integer ArrayList nums. A number x is lonely when it appears only once, and no adjacent numbers (i.e., x + 1 and x - 1) appear in the ArrayList. Your task is to find and return all the lonely numbers in nums. You may return the answer in any order.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LonelyNumbers {
    public static List<Integer> findLonelyNumbers(ArrayList<Integer> nums) {
        List<Integer> lonelyNumbers = new ArrayList<>();

        // Step 1: Sort the input ArrayList
        Collections.sort(nums);

        int n = nums.size();

        // Step 2: Check if each number is lonely
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            
            // Check if the current number has no adjacent numbers
            if ((i == 0 || num != nums.get(i - 1)) && (i == n - 1 || num != nums.get(i + 1))) {
                lonelyNumbers.add(num);
            }
        }

        return lonelyNumbers;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(3);
        nums.add(7);
        nums.add(6);
        nums.add(5);
        nums.add(8);

        List<Integer> result = findLonelyNumbers(nums);
        System.out.println(result); // Should print [7, 8]
    }
}
