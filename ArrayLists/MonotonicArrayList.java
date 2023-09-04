import java.util.ArrayList;

// An ArrayList is considered monotonic if it is either monotonically increasing or monotonically decreasing. An ArrayList nums is monotonically increasing if, for all indices i <= j, nums.get(i) is less than or equal to nums.get(j). Conversely, nums is monotonically decreasing if, for all indices i <= j, nums.get(i) is greater than or equal to nums.get(j).

// Your task is to implement a function that takes an ArrayList of integers, nums, as input and returns true if the list is monotonic, and false otherwise.

public class MonotonicArrayList {
    public static boolean isMonotonic(ArrayList<Integer> nums) {
        boolean increasing = true;
        boolean decreasing = true;
        
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                increasing = false;
            }
            if (nums.get(i - 1) < nums.get(i)) {
                decreasing = false;
            }
        }
        
        return increasing || decreasing;
    }
    
    public static void main(String[] args) {
        // Example usage:
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(1);
        nums1.add(2);
        nums1.add(2);
        nums1.add(3);
        System.out.println(isMonotonic(nums1)); // Should print true
        
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(6);
        nums2.add(5);
        nums2.add(4);
        nums2.add(4);
        System.out.println(isMonotonic(nums2)); // Should print true
        
        ArrayList<Integer> nums3 = new ArrayList<>();
        nums3.add(1);
        nums3.add(3);
        nums3.add(2);
        System.out.println(isMonotonic(nums3)); // Should print false
    }
}
