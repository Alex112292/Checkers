//Author: Alex Santeramo
//Description: This class holds the information of a point that is on the checkerboard. Such as if it is inbounds and
//where to get points that are surrounding a selected point.

//This class creates an object that is a point in the maze.
public class Point
{
	public final int x, y;

	//Constructor
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	//Finds the point that is between a start and end point to determine if a capture happened.
	public Point getBetweenPoint(Point p)
	{
		int xAvg = (x + p.x)/2;
		int yAvg = (y + p.y)/2;
		return new Point(xAvg, yAvg);
	}

	//Return all of the points that are diagonal from the original point.
	public Point getDiagAdjacentPoint(String dir)
	{
		Point point = new Point(0, 0);
		if(dir.equals("NE"))
		{
			point = new Point(x + 1, y + 1);
		}
		else if(dir.equals("NW"))
		{
			point = new Point(x - 1, y + 1);
		}
		else if(dir.equals("SE"))
		{
			point = new Point(x + 1, y - 1);
		}
		else if(dir.equals("SW"))
		{
			point = new Point(x - 1, y - 1);
		}
		return point;
	}	
	//Converts the point into a string that can be printed out.
	@Override
	public String toString()
	{
		return String.format("(%d, %d)", x, y);
	}
}
