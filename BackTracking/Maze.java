package BackTracking;

public class Maze {
    private static boolean solveMaze(int maze[][]) {
        int N = maze.length;
        int sol[][] = new int[N][N];
        if(solveMazeUntil(maze, 0, 0, sol) == false) {
            System.err.print("Solution does'nt exist");
            return false;
        }
        printSolution(sol);
        return true;
    }

    public static void printSolution(int sol[][]) {
        for(int i=0; i<sol.length; i++) {
            for(int j=0; j<sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int x, int y) {
        //if (x,y) is outside the maze then return false
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }

    public static boolean solveMazeUntil(int maze[][], int x, int y, int sol[][]) {
        if(x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if(isSafe(maze, x, y) == true) {
            if(sol[x][y] == 1) {
                return false;
            }
            sol[x][y] = 1;
            if(solveMazeUntil(maze, x + 1, y, sol)) {
                return true;
            }
            if(solveMazeUntil(maze, x, y + 1, sol)) {
                return true;
            }
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String args[]) {
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };

        solveMaze(maze);
    }
}
