import java.util.Arrays;
import java.util.Scanner;
public class Game {
	//constants to represent different cell contents
	public static final char empty = '-';
	public static final char pl1 = 'x';
	public static final char pl2 = 'o';
	
	//constants for board 
	public static final int rows = 3, columns = 3;
	public static final char[][] board = new char[rows][columns];
	//setting scanner up
	public static final Scanner kb = new Scanner(System.in);
	
	public static boolean isPlayersTurn;
	public static void main (String[] args) {
		initializeGame();
		while (!gameOver()) {
			printGameState();
			isPlayersTurn = true;
			System.out.println("X pos: ");
			int positionX = kb.nextInt();
			System.out.println("Y pos: ");
			int positionY = kb.nextInt();
			insertPlayerMove(positionX, positionY);
			isPlayersTurn = false;
			randomPlayerMove();
		}
	}
	
	public static void initializeGame() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = empty;
			}
		}
	}
	
	public static void printGameState() {
		System.out.println(board[0]);
		System.out.println(board[1]);
		System.out.println(board[2]);
	}
	
	public static boolean gameOver() {
		if (board[0][1] == 'x') {
			return false;
		}
		else {
			return false;
		}
	}
	
	public static void insertPlayerMove(int positionX, int positionY) {
		board[positionX-1][positionY-1] = pl1;
	}
	
	public static void randomPlayerMove() {
		if (!isPlayersTurn) {
			for (int count = 0; count != 1; count++) {
				
			}
		}
}
