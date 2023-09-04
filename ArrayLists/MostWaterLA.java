import java.util.ArrayList;

public class MostWaterLA {
    public static int maxArea(ArrayList<Integer> height) {
        int maxWater = 0;
        int left = 0;
        int right = height.size() - 1;

        // Use two-pointer approach to find maximum water container
        while (left < right) {
            int h1 = height.get(left);
            int h2 = height.get(right);
            int width = right - left;
            int currentWater = Math.min(h1, h2) * width;
            maxWater = Math.max(maxWater, currentWater);

            // Move the pointer with the smaller height towards the other pointer
            if (h1 < h2) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        int maxWater = maxArea(height);
        System.out.println("Maximum water container: " + maxWater);
    }
}
