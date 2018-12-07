import java.util.*;
public class TTT {
	public static final int rows = 3, cols = 3;
	public static char[][] board = new char[rows][cols];
	public static Scanner kb = new Scanner(System.in);
	public static char currentPlayer;
	
	public static void main(String[] args) {
		currentPlayer = 'o';
		initBoard();
		
		while (!checkForWin()) {
			userMovePrompt();
			printBoard();
			
			if (checkForWin() == true) {
				System.out.println("O WINS");
				break;
			}
			else if (isBoardFull() == true) {
				System.out.println("DRAW");
				break;
			}
			else {
				changePlayer();
				computerMove();
				printBoard();
				
				if (checkForWin() == true) {
					System.out.println("X WINS");
					break;
				}
				else if (isBoardFull() == true) {
					System.out.println("DRAW");
					break;
				}
				else {
					changePlayer();
				}
			}
		}
	}
	
	public static void initBoard() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				board[r][c] = '-';
			}
		}
	}
	
	public static void printBoard() {
		System.out.println("-------------");
		for(int r = 0; r < rows; r++) {
			System.out.print("| ");
			for(int c = 0; c < cols; c++) {
				System.out.print(board[r][c] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	public static void userMovePrompt() {
		int posX, posY;
		System.out.println("Enter X and Y coordinates to place your mark(indexed)");
		System.out.println("X: ");
		posX = kb.nextInt();
		while (posX >= 3 || posX < 0) {
			System.out.println("Invalid input please enter X again");
			posX = kb.nextInt();
		}
		System.out.println("Y: ");
		posY = kb.nextInt();
		while (posY >= 3 || posY < 0) {
			System.out.println("Invalid input");
			posY = kb.nextInt();
		}
		
		if (placeUserMove(posX, posY) == false) {
			userMovePrompt();
		}
		else {
			placeUserMove(posX, posY);
		}
	}
	
	public static boolean placeUserMove(int posX, int posY) {
		if (board[posX][posY] == '-' &&  board[posX][posY] != 'x' && board[posX][posY] != 'o') {
			board[posX][posY] = 'o';
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void changePlayer() {
		if (currentPlayer == 'x') {
			currentPlayer = 'o';
		}
		else {
			currentPlayer = 'x';
		}
	}
	
	public static void computerMove() {
		int rX = (int)(3 * Math.random());
		int rY = (int)(3 * Math.random());
		while (board[rX][rY] != '-') {
			rX = (int)(3 * Math.random());
			rY = (int)(3 * Math.random());
		}
		board[rX][rY] = 'x';
	}
	
	
	public static boolean isBoardFull() {
		boolean isFull = true;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (board[r][c] == '-') {
					isFull = false;
				}
			}
		}
		return isFull;
	}

	public static boolean checkForWin() {
		return (checkRowsForWin() || checkColsForWin() || checkDiagForWin());
	}
	
	public static boolean checkRowsForWin() {
		for (int r = 0; r < rows; r++) {
			if (checkRowCol(board[r][0], board[r][1], board[r][2]) == true) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkColsForWin() {
		for (int c = 0; c < cols; c++) {
			if (checkRowCol(board[0][c], board[1][c], board[2][c]) == true) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkDiagForWin() {
		return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
	}
	
	
	
	
	public static boolean checkRowCol(char c1, char c2, char c3) {
		return ((c1 != '-') && (c1 == c2) && (c2 == c3));
	}
	
	public static boolean gameOver() {
		if (!checkForWin() || !isBoardFull()) {
			return false;
		}
		else {
			return true;
		}
	}
}
