/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    public boolean equals(Object dest)
    {
        if (dest instanceof Location)
        {
            Location destination = (Location) dest;
            if (xCoord == destination.xCoord && yCoord == destination.yCoord)
                return true;
        }
        return false;
    }
    public int hashCode()
    {
        int result = 1;
        result = 31 * result + Integer.hashCode(xCoord);
        result = 31 * result + Integer.hashCode(yCoord);
        return result;
    }
}