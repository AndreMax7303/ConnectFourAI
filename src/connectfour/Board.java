package connectfour;

/**
 *
 * @author André Max
 */
public class Board {
    char[][] gameBoard;
    final char VAZIO = 'X';
    final char PLAYER1 = '1';
    final char PLAYER2 = '2';
    int last = 0;
    
    Board(char[][] gameBoard){
        this.gameBoard = new char[6][7];
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                this.gameBoard[i][j] = gameBoard[i][j];
            }
        }
    }
    
    Board(){
        gameBoard = new char[6][7];
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                gameBoard[i][j] = VAZIO;
            }
        }
    }
    
    public char chooseSymbol(int player){
        return player  == 1 ? '1' : '2'; 
    }
    
    public boolean addable(char[][] gameBoard, int col){
        int i = 0;
        while (i < 6 && gameBoard[i][col] == VAZIO ){
            i++;
        }
        this.last = i;
        if (i != 0){
            return true;
        }
        return false;
        
    }
    
    public void addPiece(int col, int player){
        if (addable(this.gameBoard, col)){
            this.gameBoard[last-1][col] = chooseSymbol(player);
        }
        
        
    }
    
    public void showBoard(){
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                System.out.printf("%c ", gameBoard[i][j]);  
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
