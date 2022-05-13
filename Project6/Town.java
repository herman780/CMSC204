import java.util.HashSet;
import java.util.Set;

/**
 * The Town class represents an town as a node of a graph. The Town class holds the name of the town and a list of adjacent
 * towns, and other fields as desired, and the traditional methods (getters/setters, constructors, toString, etc.). It will
 * implement the Comparable interface. These are the minimum methods that are needed. Please feel free to add as many methods as you need. 
 * @author Herman Mann
 */
public class Town implements Comparable<Town> {
	
	protected String theName = "";
	protected Set<Town> _theAdjacentTowns = new HashSet<>();

	/**
	 * The first constructor of the Town class. Requires town's name. 
	 * @param name the Name of the town. 
	 */
	public Town(String name)
	{
		this.theName = name;
	}
	
	/**
	 * The second constructor of the Town class. The copy constructor. 
	 * @param templateTown an instance of Town. 
	 */
	public Town(Town templateTown)
	{
		this.theName = templateTown.theName;
	}
	
	/**
	 * The To String method of the Town class. 
	 * Overrides the toString in class java.lang.Object.
	 * @return theName - the town name. 
	 */
	public String toString()
	{
		return theName;
	}
	
	/**
	 * Overrides hashCode in class java.lang.Object.
	 * @return the hashcode for the name of the town. 
	 */
	public int hashCode()
	{
		return theName.hashCode();
		
	}
	
	/**
	 * Overrides the equals in class java.lang.Object.
	 * @return true if the town names are equal, false if not. 
	 */
	public boolean equals(Object obj)
	{
		Town theOther_Town = (Town) obj;
		
		if(this.theName.equals(theOther_Town.theName))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * The Compare to method of the Town class.
	 * @return 0 if the names are equal, a positive or negative number if the names are not equal. 
	 */
	@Override
	public int compareTo(Town o) {
		
		String theCompareofSecondTown = o.theName;
		String firstTown_ = this.theName;
		
		return firstTown_.compareTo(theCompareofSecondTown);
	}

	/**
	 * Returns the town's name.
	 * @return the town's name. 
	 */
	public String getName() {
		
		return theName;
	}
	
	

}
