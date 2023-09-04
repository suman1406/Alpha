import java.util.ArrayList;

public class MostWaterBF {
    public static int maxArea(ArrayList<Integer> height) {
        int maxWater = 0;
        int n = height.size();
        
        // Brute force approach: Try all possible pairs of lines
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int h1 = height.get(i);
                int h2 = height.get(j);
                int width = j - i;
                int currentWater = Math.min(h1, h2) * width;
                maxWater = Math.max(maxWater, currentWater);
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
