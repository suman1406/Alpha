// Find if any pair in a sorted and rotated araylist has a target sum

public class PairSumFinder2 {
    // Function to check if there is a pair with the given sum in the rotated array.
    public static boolean hasPairWithSum(int[] arr, int targetSum) {
        int n = arr.length;
        
        // Find the pivot element using binary search.
        int pivot = findPivot(arr, 0, n - 1);
        
        // Initialize left and right pointers.
        int left = (pivot + 1) % n;
        int right = pivot;
        
        while (left != right) {
            int currentSum = arr[left] + arr[right];
            
            if (currentSum == targetSum) {
                return true; // Found a pair with the target sum.
            }
            
            if (currentSum < targetSum) {
                left = (left + 1) % n; // Move the left pointer to the right.
            } else {
                right = (n + right - 1) % n; // Move the right pointer to the left.
            }
        }
        
        return false; // No pair found with the target sum.
    }
    
    // Function to find the pivot element using binary search.
    private static int findPivot(int[] arr, int low, int high) {
        if (low > high) {
            return -1; // No pivot found.
        }
        
        if (low == high) {
            return low; // Single element array.
        }
        
        int mid = (low + high) / 2;
        
        if (mid < high && arr[mid] > arr[mid + 1]) {
            return mid; // Pivot found at mid.
        }
        
        if (mid > low && arr[mid] < arr[mid - 1]) {
            return (mid - 1); // Pivot found at mid-1.
        }
        
        if (arr[low] >= arr[mid]) {
            return findPivot(arr, low, mid - 1); // Search in the left half.
        }
        
        return findPivot(arr, mid + 1, high); // Search in the right half.
    }
    
    public static void main(String[] args) {
        int[] arr = {11, 15, 26, 38, 9, 10};
        int targetSum = 35;
        
        boolean hasPair = hasPairWithSum(arr, targetSum);
        
        if (hasPair) {
            System.out.println("A pair with the target sum exists.");
        } else {
            System.out.println("No pair with the target sum found.");
        }
    }
}
