//Author: Alex Santeramo
//Description: The class with the main method that runs the program. It creates the board and allows the game to be played.
import java.util.Scanner;

import javax.swing.JFrame;

public class Game
{
	public static void main(String[] args)
	{
		//Creates the board and other variables that are used later.
		System.out.println("Welcome to Checkers by Alex Santeramo! To play you will first be asked to enter a coordinate of the piece that you would like to move. \nWhenever you are asked to enter a coordinate please enter the x-value first and then the y-value seperated by a space. \nTry and collect all of the opposing side's pieces and have fun!");
		Board board;
		Point choice;
		Piece chosenPiece;
		board = new Board(8, 8);
		MoveHistory moveHistory = new MoveHistory();
		do
		{
			boolean isValid = false;
			boolean correctEntry = false;
			Scanner scanner = new Scanner(System.in);
			//Prints out the board and how many pieces of each color remain in the game
			System.out.println(board.toString());
			System.out.println("Red Pieces Remaining: " + board.getRedPieces() + ", Black Pieces Remaining: " + board.getBlackPieces());
			do
			{
				//Allows the player to choose to move a piece or view the move history of the game.
				System.out.println("Please select to move a piece by typing \"Move Piece\". Or type \"Move History\" to view the move history of the game.");
				//Loops asking them to input a correct choice until they enter a valid answer.
				do
				{
					String moveChoice = scanner.nextLine();
					if(moveChoice.equalsIgnoreCase("move history"))
					{
						System.out.println("Moves: " + moveHistory.toString());
						correctEntry = true;
					}
					else if(moveChoice.equalsIgnoreCase("move piece"))
					{
						System.out.println("You selected to move a piece.");
						correctEntry = true;
					}
					else
					{
						System.out.println("That is not a valid input. Please select to move a piece by typing \"Move Piece\". Or type \"Move History\" to view the move history of the game.");
					}
				} while (correctEntry == false);
				//Asks the user to enter corrdiantes on the board to select a piece.
				System.out.println("Please select a piece to move by typing in the coordinates.");
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				choice = new Point(x, y);
				chosenPiece = board.get(choice);
				if(chosenPiece.getChar() != ' ')
				{
					isValid = true;
				}
			} while (isValid == false);
			//Gets the piece that is associated with the coordinates they entered.
			System.out.println("You selected the piece: " + chosenPiece.getChar());
			Move[] moves = board.getAllMoves(chosenPiece, choice);
			//Checks all of the possible moves that the chosen piece can make and prints out valid moves.
			System.out.println("Possible moves: ");
			for(int i = 0; i < moves.length; i++)
			{
				if(moves[i] != null)
				{
					System.out.println(i + ") " + moves[i]);
				}
			}
			//THas the user select a move to make.
			System.out.println("Please enter an move choice to move to.");
			int choose = scanner.nextInt();
			//Moves the piece to the specified move and adds the move to the move history.
			board.movePiece(moves[choose]);
			moveHistory.add(moves[choose]);
			//Loops until one side runs out of pieces ending the game.
		} while(board.getRedPieces() > 0 && board.getBlackPieces() > 0);
		//Checks which side ran out of pieces and prints out corresponding winning message.
		if(board.getRedPieces() == 0)
		{
			System.out.println("Black Wins!");
		}
		else if(board.getBlackPieces() == 0)
		{
			System.out.println("Red Wins!");
		}
	}
}
