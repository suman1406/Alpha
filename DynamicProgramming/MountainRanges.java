package DynamicProgramming;

public class MountainRanges {
    public int countPeaks(int[] heights) {
        int count = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
                count++;
            }
        }
        if (heights[0] > heights[1]) {
            count++;
        }
        if (heights[heights.length - 1] > heights[heights.length - 2]) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        MountainRanges mr = new MountainRanges();
        int[] heights = {5, 6, 2, 4};
        System.out.println(mr.countPeaks(heights));
    }
}
