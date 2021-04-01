//Author: Alex Santeramo
//Description: creates a 2D array to represent a checkerboard. It will assign pieces to every other tile on the board until there are 12 of each color.
//This class will also check the location of the pieces on the board and will make the pieces move based on where the user wants to move the pieces.
import java.awt.Color;
//A class the holds the information of an object board.
public class Board
{
	private Piece[][] board;
	private int _height;
	private int _width;
	private int redPieces = 12;
	private int blackPieces = 12;
	//Constructor
	public Board(int width, int height)
	{
		_height = height;
		_width = width;
		board = new Piece[width][height];
		for(int i = 0; i < 12; i++)
		{
			int y = i/4;
			int x = (i % 4) * 2 + (y % 2);
			board[x][y] = new Piece(x, y, 'r', false);
			y = y + 5;
			x = (i % 4) * 2 + (y % 2);
			board[x][y] = new Piece(x, y, 'b', false);
		}
	}
	//Determines if a selected point is in the bounds of the checkerboard.
	public boolean inBounds(Point p)
	{
		if ((p.x >= 0 && p.x < _width) && (p.y >= 0 && p.y < _height))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Determines if a selected point in the board is currently occupied by another piece.
	public boolean isEmpty(Point p)
	{
		if(board[p.x][p.y] == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Sets a point on the board to a specific piece that is assigned to it.
	public void set(Point p, Piece piece)
	{
		if(inBounds(p) == true)
		{
			board[p.x][p.y] = piece;
		}
		else
		{
			throw new PointOutOfBoundsException(p.toString());
		}
	}
	//Returns the piece at a selected point on the board.
	public Piece get(Point p)
	{
		if(inBounds(p) == true)
		{
			return board[p.x][p.y];
		}
		else
		{
			throw new PointOutOfBoundsException(p.toString());
		}
	}
	//Returns the number of red pieces left in the game.
	public int getRedPieces()
	{
		return redPieces;
	}
	//Returns the number of black pieces left in the game
	public int getBlackPieces()
	{
		return blackPieces;
	}
	//Moves a piece a specified move on the board
	public void movePiece(Move move)
	{
		set(move.getEnd(), get(move.getStart()));
		set(move.getStart(), null);
		if(move.getCapture())
		{
			Point capture = move.getEnd().getBetweenPoint(move.getStart());
			if(get(capture).getChar() == 'r')
			{
				redPieces--;
			}
			else if(get(capture).getChar() == 'b')
			{
				blackPieces--;
			}
			set(move.getEnd().getBetweenPoint(move.getStart()), null);
		}
	}
	//makes and array of all directions and then calls another method to see what are valid moves and the returns an array of valid moves.
	public Move[] getAllMoves(Piece piece, Point start)
	{
		Move[] moves = new Move[4];
		String[] directions = {"NE", "NW", "SE", "SW"};
		for(int i = 0; i < directions.length; i++)
		{
			if(piece.canMove(directions[i]))
			{
				moves[i] = getMove(start, directions[i]);
			}
		}
		return moves;
	}
	//Cheks what moves are valid in each direction that a peice can move.
	public Move getMove(Point start, String dir)
	{
		if(!this.inBounds(start))
		{
			return null;
		}
		else
		{
			Piece p = this.get(start);
			Point target = start.getDiagAdjacentPoint(dir);
			Point jumpTarget = target.getDiagAdjacentPoint(dir);
			if(inBounds(target) == false || (!isEmpty(target) && get(target).getChar() == p.getChar()))
			{
				return null;
			}
			else if(inBounds(jumpTarget) && isEmpty(jumpTarget) == true && !isEmpty(target))
			{
				if(get(target).getChar() != p.getChar())
				{
					return new Move(start, jumpTarget, true);
				}
				else
				{
					return null;
				}
			}
			else if(isEmpty(target) == true)
			{
				return new Move(start, target, false);
			}
			else
			{
				return null;
			}
		}
	}
	//Returns the board as a string that can be printed out to the terminal.
	public String toString()
	{
		StringBuilder coordinate = new StringBuilder();
		for(int y = _height - 1; y >= 0; y--)
		{
			for (int x = 0; x < _width; x++)
			{
				if(board[x][y] == null)
				{
					coordinate.append(' ');
				}
				else
				{
					coordinate.append(board[x][y]);
				}
			}
			coordinate.append("\n");
		}
		return coordinate.toString();
	}
}
