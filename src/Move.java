//Author: Alex Santeramo
//Description: The class that holds all of the information on what a move is.
public class Move 
{
	private Point start;
	private Point end;
	private boolean capture;
	private Board board;
	private Piece piece;
	//Constructor
	public Move(Point start, Point end, boolean capture)
	{
		this.start = start;
		this.end = end;
		this.capture = capture;
	}
	//Returns the starting point of the move
	public Point getStart()
	{
		return start;
	}
	//Returns the ending point of the move
	public Point getEnd()
	{
		return end;
	}
	//Returns if the move should result in a capture of a piece.
	public boolean getCapture()
	{
		return capture;
	}
	//Makes the move into a string that can be printed out.
	public String toString()
	{
		return "Start: " + start + " End: " + end;
	}
}
