package Graph;

public class FloodFillAlgorithm {
    // Flood fill, also called seed fill, is an algorithm that determines the area
    // connected to a given node in a multi-dimensional array.
    // It is used in the "bucket" fill tool of paint programs to fill connected,
    // similarly-colored areas with a different color, and in games such as Go and
    // Minesweeper for determining which pieces are cleared.
    // When applied on an image to fill a particular bounded area with color, it is
    // also known as boundary fill.
    // When applied to a node in a multi-dimensional array, it is also known as the
    // seed fill.
    // The algorithm takes three parameters: a start node, a target color, and a
    // replacement color.
    // The algorithm looks for all nodes in the array connected to the start node by
    // some path and changes their color to the replacement color.
    // The algorithm can be implemented using recursion or a queue.
    // The following implementation uses recursion.

    static void floodFill(int screen[][], int x, int y, int prevColor, int newColor) {
        int M = screen.length;
        int N = screen[0].length;

        if (x < 0 || x >= M || y < 0 || y >= N) {
            return;
        }

        if (screen[x][y] != prevColor) {
            return;
        }

        screen[x][y] = newColor;

        floodFill(screen, x + 1, y, prevColor, newColor);
        floodFill(screen, x - 1, y, prevColor, newColor);
        floodFill(screen, x, y + 1, prevColor, newColor);
        floodFill(screen, x, y - 1, prevColor, newColor);
    }

    public static void main(String args[]) {
        int screen[][] = {
                { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 2, 2, 2, 2, 2, 0, 0 },
                { 1, 2, 2, 2, 2, 2, 0, 1 },
                { 1, 0, 2, 2, 2, 2, 2, 1 },
                { 1, 1, 2, 2, 2, 2, 2, 1 },
                { 1, 0, 2, 2, 1, 2, 2, 1 },
                { 1, 0, 0, 0, 0, 2, 2, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        floodFill(screen, 4, 4, 2, 3);
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[0].length; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }
}
