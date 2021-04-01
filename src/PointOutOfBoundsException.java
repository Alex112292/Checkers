//Author: Alex Santeramo
//Description: Creates an exception for when a point is out of bounds of the checkerboard.

public class PointOutOfBoundsException extends IndexOutOfBoundsException
{
    public PointOutOfBoundsException(String s)
    {
        super(s);
    }
}
