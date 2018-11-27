import java.util.Arrays;
import java.util.Scanner;
public class Game {
	public static final int rows = 3, cols = 3;
	public static final char[][] board = new char[rows][cols];
	public static char currentPlayer;
	public static final Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		currentPlayer = 'x';
		initializeBoard();
		while (!checkForWin()) {
			prompt();
			printBoard();
			checkForWin();
			changePlayer();
			AI();
			printBoard();
			changePlayer();
		}
		if (checkForWin()) {
			System.out.println("win");
		}
		else if (isBoardFull()) {
			System.out.println("draw");
		}

	}

	public static void initializeBoard() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				board[r][c] = '-';
			}
		}
	}

	public static void printBoard() {
		System.out.println("------------");

		for(int r = 0; r < rows; r++) {
			System.out.print("| ");
			for(int c = 0; c < cols; c++) {
				System.out.print(board[r][c] + " | ");
			}
			System.out.println();
			System.out.println("------------");
		}
	}

	public static boolean isBoardFull() {
		boolean isFull = true;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if(board[r][c] == '-') {
					isFull = false;
				}
				else {
					isFull = true;
				}
			}
		}
		return isFull;
	}

	public static void changePlayer() {
		if (currentPlayer == 'x') {
			currentPlayer = 'o';
		}
		else {
			currentPlayer = 'x';
		}
	}

	public static boolean placePosition(int posX, int posY) {
		if ((posX >= 0) && (posX <= 3)) {
			if ((posY >= 0) && (posY <= 3)) {
				if (board[posX-1][posY-1] == '-') {
					board[posX-1][posY-1] = currentPlayer;
					return true;
				}
			}
		}
		return false;
	}

	public static void prompt() {
		System.out.println("Welcome to Tic Tac Toe");
		System.out.println("To place your mark enter your X and Y coordinates");
		System.out.println("X: ");
		int posX = kb.nextInt();
		System.out.println("Y: ");
		int posY = kb.nextInt();
		placePosition(posX, posY);

	}

	public static boolean checkForWin() {
		return (checkRowsForWin() || checkColsForWin() || checkDiaForWin());
	}

	public static boolean checkRowsForWin() {
		for(int r = 0; r < 3; r++) {
			if (checkRowCol(board[r][0], board[r][1], board[r][2]) == true) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkColsForWin() {
		for(int c = 0; c < 3; c++) {
			if (checkRowCol(board[0][c], board[1][c], board[2][c]) == true) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkDiaForWin() {
		return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
	}

	public static boolean checkRowCol(char c1, char c2, char c3) {
		return ((c1 != '-') && (c1 == c2) && (c2 == c3));
	}

	public static void AI() {
		if (currentPlayer == 'o') {
			int posX = (int)(3 * Math.random() + 1);
			int posY = (int)(3 * Math.random() + 1);
			placePosition(posX, posY);
		}
	}
}
