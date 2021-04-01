//Author: Alex Santeramo
//Description: A class that creates a list of moves that contains all moves made during the game.
public class MoveHistory 
{
	private Move[] moves;
	private int length;
	//Constructor
	public MoveHistory()
	{
		length = 0;
		moves = new Move[100];
	}
	//Adds a move to the list, if the list is full then a new list is created and copied to the old list.
	public void add(Move move)
	{
		if(length < 100)
		{
			moves[length] = move;
			length++;
		}
		else
		{
			Move[] newMoves = new Move[length + 100];
			for(int i = 0; i < length; i++)
			{
				newMoves[i] = moves[i];
			}
			moves = newMoves;
			newMoves[length] = move;
			length++;
		}
	}
	//Returns the length of the list
	public int getLength()
	{
		return length;
	}
	//Returns the move at a specific index
	public Move getMove(int index)
	{
		return moves[index];
	}
	//Turns the history into a string that can be printed out
	public String toString()
	{
		StringBuilder moveHistory = new StringBuilder();
		for(int i = 0; i < length; i++)
		{
			moveHistory.append((i + 1) + ") " + "A piece moved from: " + moves[i].getStart() + " to: " + moves[i].getEnd()+ ",\n");
		}
		return moveHistory.toString();
	}
}
