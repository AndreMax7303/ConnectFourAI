package connectfour;

/**
 *
 * @author André Max
 */

public class ArtificialInteligence {
    private static final int[][] EVALUATIONTABLE = {{3, 4, 5, 7, 5, 4, 3}, 
                                          {4, 6, 8, 10, 8, 6, 4},
                                          {5, 8, 11, 13, 11, 8, 5}, 
                                          {5, 8, 11, 13, 11, 8, 5},
                                          {4, 6, 8, 10, 8, 6, 4},
                                          {3, 4, 5, 7, 5, 4, 3}};
    
    public static int evaluateContent(Board gBoard) {
        int utility = 138;
        int sum = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j <7; j++)
                if (gBoard.gameBoard[i][j] == gBoard.PLAYER1)
                    sum += EVALUATIONTABLE[i][j];
                else if (gBoard.gameBoard[i][j] == gBoard.PLAYER2)
                    sum -= EVALUATIONTABLE[i][j];
        return utility + sum;
    }
    
    public static boolean checkWin(char badge, Board board) {
        return checkHorizontalStreaks(board.gameBoard, badge)
            || checkVerticalStreaks(board.gameBoard, badge);
    }

    private static boolean checkHorizontalStreaks(char[][] board, char badge) {
        for (int row = 0; row < board.length; row++) {
            // loop throught each row
            int currentStreak = 0;
            for (int col = 0; col < board[row].length; col++) {
                // loop through each column in the row
                if (board[row][col] == badge) {
                    // keep the streak of 'badge' going
                    currentStreak++;
                    if (currentStreak == 4) {
                        // winner
                        return true;
                    }
                } else {
                    // restart the streak
                    currentStreak = 0;
                }
            }
        }
        return false;
    }
    
    private static boolean checkVerticalStreaks(char[][] board, char badge) {
        for (int row = 0; row < 7; row++) {
            // loop throught each row
            int currentStreak = 0;
            for (int col = 0; col < 6; col++) {
                // loop through each column in the row
                if (board[col][row] == badge) {
                    // keep the streak of 'badge' going
                    currentStreak++;
                    if (currentStreak == 4) {
                        // winner
                        return true;
                    }
                } else {
                    // restart the streak
                    currentStreak = 0;
                }
            }
        }
        return false;
    }
    
    static int minimax(Board gBoard, int depth, int alpha, int beta, boolean maximazingPlayer){
        if (checkWin(maximazingPlayer? gBoard.PLAYER2:gBoard.PLAYER1, gBoard) || depth == 0){
            return evaluateContent(gBoard);
        }
        if (maximazingPlayer){
            for (int i = 0; i < 7; i++){
                Board board = new Board(gBoard.gameBoard);
                board.addPiece(i, 2);
                board.showBoard();
                alpha = Math.max(alpha, minimax(board, depth - 1, alpha, beta, false));
                if (beta <= alpha){
                    return alpha;
                }
            }
            return alpha;
        }
        else{
            for (int i = 0; i < 7; i++){
                Board board = new Board(gBoard.gameBoard);
                board.addPiece(i, 1);
                beta = Math.min(beta, minimax(board, depth - 1, alpha, beta, true));
                if (beta <= alpha){
                    return beta;
                }     
            }
            return beta;
        }
    }
}
