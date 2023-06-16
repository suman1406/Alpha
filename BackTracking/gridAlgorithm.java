package BackTracking;
public class gridAlgorithm {
    public static int gridWays(int i, int j, int n, int m){
        //base case
        if(i == n-1 && j == m-1){ //Condition for last cell
            return 1;
        } else if(i == n || j == n) { // boundary cross condition
            return 0;
        }

        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1 + w2;
    }

    // Time complexity is O(2^(n+m)); Very slow way of solving; Exponential time
    public static void main(String args[]){
        int n = 3, m = 3;
        System.out.println(gridWays(0, 0, n, m));
    }
    // Linear time math trick using permutation and combinations
    // {[(n-1)+(m-1)]!} / {(n-1)! * (m-1)!}
}
