import java.util.ArrayList;
// Find if any pair in a sorted araylist has a target sum
public class PairSumFinderBF {

    // Function to check if any pair in the ArrayList has a target sum of -1
    public static boolean hasPairWithSum(ArrayList<Integer> sortedList, int targetSum) {
        int left = 0; // Initialize left pointer
        int right = sortedList.size() - 1; // Initialize right pointer

        while (left < right) {
            int sum = sortedList.get(left) + sortedList.get(right); // Calculate the sum of current pair

            if (sum == targetSum) {
                // Pair found with the target sum of -1
                return true;
            } else if (sum < targetSum) {
                // If the sum is less than the target, move the left pointer to the right
                left++;
            } else {
                // If the sum is greater than the target, move the right pointer to the left
                right--;
            }
        }

        // No pair with the target sum found
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        // Add sorted integers to the ArrayList
        sortedList.add(-4);
        sortedList.add(-3);
        sortedList.add(-2);
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(4);
        
        int targetSum = -1;

        if (hasPairWithSum(sortedList, targetSum)) {
            System.out.println("There is a pair with the sum of -1.");
        } else {
            System.out.println("No pair with the sum of -1 found.");
        }
    }
}
