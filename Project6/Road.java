import java.io.FileNotFoundException;
import java.io.*;

/**
 * This is the Road class that can overall represent the specific edges of a Graph of Towns. The class must have to implement Comparable.
 * The class specifically stores the references to the two vertices (the Town endpoints), the distance between vertices, and a name, and the
 * overall traditional methods (getters/setters, constructors, toString, etc.), and a compareTo, which compares the two Road objects. Because
 * this is a undirected graph, an edge from A to B is equal to an edge from B to A. 
 * @author Herman Mann 
 */
public class Road implements Comparable<Road> {

	protected String theRoadName = "";
	protected int theDistance = 0;
	Town theSource; 
	Town theDestination;
	
	/**
	 * The first constructor of the Road class. 
	 * @param source One town on the road. 
	 * @param destination Another town on the road. 
	 * @param degrees the Weight of the edge, i.e., the distance from one town to the other. 
	 * @param name Name of the road. 
	 */
	public Road(Town source, Town destination, int degrees, String name)
	{
		this.theSource = source;
		this.theDestination = destination;
		this.theRoadName = name;
		this.theDistance = degrees;
	}
	
	/**
	 * The second constructor of the Road class. The constructor with weight preset at 1. 
	 * @param source One town on the road. 
	 * @param destination Another town on the road. 
	 * @param name Name of the road. 
	 */
	public Road(Town source, Town destination, String name)
	{
		this.theSource = source;
		this.theDestination = destination;
		this.theRoadName = name;
		theDistance = 1; // constructor which has weight preset at 1. 
		
	}
	
	/**
	 * Returns the road name. 
	 * @return The name of the road. 
	 */
	public Town getDestination()
	{
		return theDestination;
		
	}
	/**
	 * Returns true only if the edge contains the given town. 
	 * @param town a vertex of the graph. 
	 * @return true only if the edge is connected to the given vertex. 
	 */
	public boolean contains(Town town)
	{
		String town1 = theSource.getName();
		String town2 = theDestination.getName();
		String theUltimateTown = town.getName();
		
		if(town1.equalsIgnoreCase(theUltimateTown) || town2.equalsIgnoreCase(theUltimateTown))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * To String method. 
	 * Overrides toString in class java.lang.Object. 
	 * @return theReturnResult - the string representation of the town in from a multiple network of towns. 
	 */
	public String toString()
	{
		String theReturnResult = "";
		
		String throughConnection = " via ";
		
		String theFirstTown = theSource.getName();
		
		String toTheOtherTown = " to ";
		
		String theSecondTown = theDestination.getName();
		
		String theSpaceBetweenTheTowns = " ";
		
		String theDistanceBetween = " mi";
		
		theReturnResult =  
				theFirstTown 
				+ throughConnection 
				+ theRoadName 
				+ toTheOtherTown 
				+ theSecondTown 
				+ theSpaceBetweenTheTowns 
				+ theDistance 
				+ theDistanceBetween;
		
		return theReturnResult;
	}
	
	/**
	 * Returns the road name. 
	 * @return The name of the road. 
	 */
	public String getName()
	{
		return theRoadName;
		
	}
	
	/**
	 * Returns the first town on the road. 
	 * @return A town on the road. 
	 */
	public Town getSource()
	{
		return theSource;
		
	}
	
	/**
	 * Returns the distance of the road. 
	 * @return the distance of the road. 
	 */
	public int getWeight()
	{
		return theDistance;
		
	}
	
	/**
	 * Returns true if each of the ends of the road r is the same as the ends of this road. Remember that a road that goes from Point A
	 * to Point B is the same as a road that goes from Point B to Point A. 
	 * @param r - road object to compare it to. 
	 * Overrides equals in class java.lang.Object. 
	 * @return returns true if each of the ends of the road r is the same as the ends of this road. Remember that a road that goes from Point A
	 * to Point B is the same as a road that goes from Point B to Point A. 
	 */
	public boolean equals(Object r)
	{
		Road r2 = (Road) r;
		
		if (this.theSource.equals(r2.theSource) && this.theDestination.equals(r2.theDestination)
				|| this.theSource.equals(r2.theDestination) && this.theDestination.equals(r2.theSource))
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Specified by: compareTo in interface java.lang.Comparable<Road>.
	 * @return 0 if the road names are the same, a positive or negative number if the road names are not the same. 
	 */
	@Override
	public int compareTo(Road o) {
		
		String theComparedRoadName = o.theRoadName;
		return this.theRoadName.compareTo(theComparedRoadName);
	}
	
	

}
