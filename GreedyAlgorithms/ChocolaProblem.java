package GreedyAlgorithms;
import java.util.*;

public class ChocolaProblem {
    public static void main(String[] args) {
        // Chocola Problem
        int[] horizontalCuts = { 2, 1, 2, 1, 3 };
        int[] verticalCuts = { 100, 19, 27, 25, 15 };
        int h = horizontalCuts.length;
        int v = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxHorizontalCut = 0;
        int maxVerticalCut = 0;

        for (int i = 1; i < h; i++) { // Start from 1 instead of 0
            maxHorizontalCut = Math.max(maxHorizontalCut, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        for (int i = 1; i < v; i++) { // Start from 1 instead of 0
            maxVerticalCut = Math.max(maxVerticalCut, verticalCuts[i] - verticalCuts[i - 1]);
        }

        System.out.println(maxHorizontalCut * maxVerticalCut);
    }
}
