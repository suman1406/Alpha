package BackTracking;
public class queen {

    public static boolean isSafe(char board[][], int row, int col){
        // vertical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //diagonally left up
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //diagonallu right up
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static boolean nQueens(char board[][], int row) {
        //base
        if(row == board.length){
            //print chessboard
            printBoard(board);

            //count number of solutions
            count++;
            
            return true;
        }
        //column loop
        for(int j = 0; j<board.length; j++){
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if(nQueens(board, row+1)){
                    return true;
                } //function call
                board[row][j] = 'x'; //backtracking step
            }
        }

        return false;
    }

    public static void printBoard(char board[][]){
        System.out.println("----------chess-board-------------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Count and printing the solutions will have the same time complexity
    // O(n) * T(n-1) + isSafe()
    static int count = 0;

    public static void main(String args[]){
        int n = 5;
        char board[][] = new char[n][n];
        //initialize
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = 'x';
            }
        }

        if(nQueens(board, 0)){
            System.out.println("Solution is possible");
        } else {
            System.out.println("Solution is not possible");
        }
        // System.out.println("Total ways to solve nQueens is " + count);
    }
}
