//Author: Alex Santeramo
//Description: A class that stores all of the information of the piece. Such as it's character and its location on the board.
import java.awt.Color;

public class Piece 
{
	public final int x, y;
	public Color alliance;
	public char ally;
	private boolean _isKing;
	//Constructor
	public Piece(int x, int y, char c, boolean isKing)
	{
		this.x = x;
		this.y = y;
		ally = c;
		_isKing = isKing;
	}
	//Returns the char(alliance) that the piece is
	public char getChar()
	{
		return ally;
	}
	//not implemented yet
	public Piece setKing(boolean isKing)
	{
		Piece p = null;
		if(this.getChar() == 'r')
		{
			p = new Piece(x, y, 'R', true);
		}
		else if(this.getChar() == 'b')
		{
			p = new Piece(x, y, 'B', true);
		}
		return p;
	}
	//Turns the piece into a string that can be shown on the board.
	public String toString()
	{
		String c = " ";
		if(this.getChar() == 'r')
		{
			c = "r";
		}
		else if(this.getChar() == 'b')
		{
			c = "b";
		}
		return c;	
	}
	//Returns if the piece can move in a certain direction.
	public boolean canMove(String dir)
	{
		if(this.getChar() == 'r' && (dir.equalsIgnoreCase("NE") || dir.equalsIgnoreCase("NW")))
		{
			return true;
		}
		else if(this.getChar() == 'b' && (dir.equalsIgnoreCase("SW") || dir.equalsIgnoreCase("SE")))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
