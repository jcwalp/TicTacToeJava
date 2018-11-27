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
	public static final char[][] positions = new char[rows][columns];
	public static final char[][] WinPlayer = {{'x','x','x'},
											 {'x','x','x'},
										     {'x','x','x'}};
	public static final char[][] WinComputer ={{'o','o','o'},
											   {'o','o','o'},
											   {'o','o','o'}};
	//setting scanner up
	public static final Scanner kb = new Scanner(System.in);
	public static boolean isPlaying = true;
	public static boolean isPlayersTurn = true;
	public static boolean isComputersTurn = false;
	public static boolean WIN = false;
	public static boolean LOSE = false;
	public static boolean DRAW = false;
	public static void main (String[] args) {
		initializeGame();


	}

	public static void initializeGame() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = empty;
				positions[i][j] = empty;
			}
		}
	}

	public static void printGameState() {
		System.out.println(board[0]);
		System.out.println(board[1]);
		System.out.println(board[2]);
	}

	public static void updatePlayerGame(int PlayerX, int PlayerY) {
		board[PlayerX][PlayerY] = pl1;
		positions[PlayerX][PlayerY] = pl1;
	}

	public static void updateComputerGame() {

	}

	public static void checkForWin() {
		//row check (x x x)
		for (int i = 0; i < rows; i++) {
			if (positions[i] == WinPlayer[0]) {
				WIN = true;
			}
		}
	}
}
