public class queen {
    public static void nQueens(char board[][], int row) {

        for(int j = 0; j<board.length; j++){
            board[row][j] = 'Q';
            nQueens(board, row+1);
        }
    }

    public static void main(String args[]){
        int n = 2;
        char board[][] = new char[n][n];
        //initialize
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
    }
}
