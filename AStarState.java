import java.util.HashMap;
/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map.  This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints."  In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;


    private HashMap<Location, Waypoint> openWayPoint;
    private HashMap<Location, Waypoint> closedWayPoint;
    

    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
        //инициализация новых пустых коллекций
        openWayPoint = new HashMap<Location,Waypoint>();
        closedWayPoint = new HashMap<Location,Waypoint>();
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost.  If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        // TODO:  Implement.

        if (openWayPoint.isEmpty())
            return null;

        float min = Float.MAX_VALUE;
        Waypoint minWP = null;
        
        for(Waypoint i : openWayPoint.values())
        {
            if(i.getTotalCost() < min)
            {
                minWP = i;
                min = i.getTotalCost();
            }
        }
        return minWP;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection.  If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection.  However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
        if(!openWayPoint.containsKey(newWP.getLocation()))
        {   
            openWayPoint.put(newWP.getLocation(),newWP);
            return true;
        }
        else if(newWP.getPreviousCost() < openWayPoint.get(newWP.getLocation()).getPreviousCost())
        {
            openWayPoint.put(newWP.getLocation(),newWP);
            return true;
        }
        return false;
    }


    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints()
    {
        // TODO: Implement.
        // int count = 0;
        // for(HashMap<Location,Waypoint> i : openWayPoint.entrySet())
        // {
        //     count++;
        // } 
        return openWayPoint.size();
    }


    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc)
    {
        // TODO:  Implement.
        if(openWayPoint.containsKey(loc))
        {
            Waypoint waypToClose = openWayPoint.get(loc);
            openWayPoint.remove(loc);
            closedWayPoint.put(loc,waypToClose);
        }
        // for(Location i : openWayPoint.keySet())
        // {
        //     if (i.equals(loc))
        //     {
        //         closedWayPoint.put();
        //         openWayPoint.
        //         openWayPoint.remove(loc);
                
        //     }
                
        // }
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc)
    {
        // TODO:  Implement.
        
        // for(Location l : closedWayPoint.keySet())
        // {
        //     if (l.equals(loc))
        //         return true;
        // }
        if(closedWayPoint.containsKey(loc))
            return true;
        return false;
    }
}