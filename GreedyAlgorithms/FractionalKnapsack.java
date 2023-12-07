package GreedyAlgorithms;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String args[]) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;

        double ratio[][] = new double[val.length][2];

        // Calculate value-to-weight ratio and store the index
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = (double) val[i] / weight[i];
            ratio[i][1] = i;
        }

        // Sort items based on value-to-weight ratio in descending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[0]));
        reverseArray(ratio);

        int capacity = 0;
        double finalVal = 0.0;

        // Fill the knapsack
        for (int i = 0; i < val.length; i++) {
            if (capacity + weight[(int) ratio[i][1]] <= W) {
                capacity += weight[(int) ratio[i][1]];
                finalVal += val[(int) ratio[i][1]];
            } else {
                // Take a fraction of the current item to fill the knapsack
                int remainingCapacity = W - capacity;
                finalVal += ratio[i][0] * remainingCapacity;
                break;
            }
        }

        System.out.println("Maximum value in Knapsack = " + finalVal);
    }

    // Function to reverse the array
    private static void reverseArray(double[][] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            double[] temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
