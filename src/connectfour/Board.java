package connectfour;

/**
 *
 * @author André Max
 */
public class Board {
    char[][] gameBoard;
    
    Board(){
        gameBoard = new char[6][7];
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                gameBoard[i][j] = ' ';
            }
        }
    }
    
    
}
