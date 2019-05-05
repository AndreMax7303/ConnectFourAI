package connectfour;
import java.util.Scanner;

/**
 *
 * @author André Max
 */
public class ConnectFour {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        while (true){
            int[] scores = new int[7];
            System.out.println("Digite a coluna: ");
            int playerInput = scanner.nextInt();
            board.addPiece(playerInput, 1);
            
            
            for (int i = 0 ; i < 7; i++){
                int j = 0;
                while (j < 6 && board.gameBoard[j][i] == board.VAZIO){
                    j++;
                }
                Board gBoard = new Board(board.gameBoard);
                gBoard.addPiece(i, 2);
                scores[i] = ArtificialInteligence.minimax(gBoard, 10, -3000, 3000, true);
                System.out.println(scores[i]);
                
            }
            System.out.println(getMax(scores));
            board.addPiece(getMax(scores), 2);
            board.showBoard();
        }
    
    }
    public static int getMax(int[] numbers) {
        int maxValue = numbers[0];
        int pos = 0;
           for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] > maxValue) {
                    maxValue = numbers[i];
                    pos = i;
                }
            }
        return pos;
    }
    
}
