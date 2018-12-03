import java.util.*;
public class TTT {
	//rows and cols
	public static final int rows = 3;
	public static final int cols = 3;
	
	//int states
	public static final int emptyInt = 0;
	public static final int playerX = 1;
	public static final int playerY = 2;
	
	//char states
	public static final char emptyChar = '-';
	public static final char playerXChar = 'x';
	public static final char playerYChar = 'y';
	
	//board that we're going to be printing is gonna be char array
	public static final char[][] charBoard = new char[rows][cols];
	
	//need an int board to store the state of positions
	public static final int[][] stateBoard = new int[rows][cols];
	
	//copy of state board for AI to test cases on 
	public static final int[][] stateBoardCopy = new int[rows][cols];
	
	
	public static void initializeBoards() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				charBoard[r][c] = emptyChar;
				stateBoard[r][c] = emptyInt;
				stateBoardCopy[r][c] = emptyInt;
			}
		}
	}
	
	public static void printGameState() {
		System.out.println("-------------");

		for(int r = 0; r < rows; r++) {
			System.out.print("| ");
			for(int c = 0; c < cols; c++) {
				System.out.print(charBoard[r][c] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	public static void promptUserForInput() {
		
	}
}
