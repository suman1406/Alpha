// Beautiful ArrayList (MEDIUM): An ArrayList nums of size n is beautiful if:

// nums is a permutation of the integers in the range [1, n].
// For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums.get(k) == nums.get(i) + nums.get(j).
// Given the integer n, return any beautiful ArrayList nums of size n. There will be at least one valid answer for the given n."

import java.util.*;

public class BeautifulArrayList {
    public static ArrayList<Integer> constructBeautifulArray(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        // Start by adding the largest number first.
        result.add(n);

        // Loop from n - 1 down to 1, adding numbers to the result ArrayList.
        for (int i = n - 1; i >= 1; i--) {
            // Insert the number i at the beginning of the result ArrayList.
            result.add(0, i);
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Integer> beautifulArray = constructBeautifulArray(n);
        System.out.println("Beautiful Array: " + beautifulArray);
    }
}
