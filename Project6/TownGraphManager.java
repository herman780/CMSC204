
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * This is the TownGraphManager class. The TownGraphManager class will hold an object of the graph. Implement the
 * TownGraphManagerInterface. There are methods to populate the graph (reading from a text file), add a town (vertices),
 * add a road (edge), list all towns and all roads, and list towns adjacent to a given town.
 * 
 * Your solution will find the shortest path from a start town to a destination town. It will account for the possibility of a 
 * disjoint graph (i.e., not all vertices can be reached from all other vertices.)
 * 
 * You may add any methods as needed for your design. 
 * @author Herman Mann 
 */
public class TownGraphManager implements TownGraphManagerInterface {

	protected Graph theGraphData = new Graph();
	
	/**
	 * Adds a road with 2 towns and a road name.
	 * @param town1 name of town 1 (lastname, firstname).
	 * @param town2 name of town 2 (lastname, firstname).
	 * @param roadName name of road.
	 * @return true if the road was added successfully.
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		
		if((theGraphData.addEdge(new Town(town1), new Town(town2), weight, roadName) != null) == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Returns the name of the road that both towns are connected through.
	 * @param town1 name of town 1 (lastname, firstname).
	 * @param town2 name of town 2 (lastname, firstname).
	 * @return name of road if town 1 and town2 are in the same road, returns null if not.
	 */
	@Override
	public String getRoad(String town1, String town2) {
		
		if((theGraphData.getEdge(new Town(town1), new Town(town2)).getName() != null))
		{
			String theRoadNameOfBothTownsConnected = theGraphData.getEdge(new Town(town1), new Town(town2)).getName();
		
			return theRoadNameOfBothTownsConnected;
			
		}
		else
		{
			return null;
		}
		
	}

	/**
	 * Adds a town to the graph.
	 * @param v the town's name  (lastname, firstname).
	 * @return true if the town was successfully added, false if not.
	 */
	@Override
	public boolean addTown(String v) {
	
		boolean ifSuccessAdded = theGraphData.addVertex(new Town(v));
		
		if(ifSuccessAdded)
		{
			return ifSuccessAdded;
			
		}
		else
		{
			return false;
		}
	}

	/**
	 * Gets a town with a given name.
	 * @param name the town's name.
	 * @return the Town specified by the name, or null if town does not exist.
	 */
	@Override
	public Town getTown(String name) {
		
		Set<Town> theSetofTowns = theGraphData.vertexSet();
		
		Set<Town> theTownsofSetData = new HashSet<Town> (theSetofTowns);
		
		Iterator<Town> theTown = theTownsofSetData.iterator();
		
		boolean ifNextisTrue = theTown.hasNext();
		
		while(ifNextisTrue == (true))
		{
			Town eachTownIndividualized = theTown.next();
			
			String theNameofTown = eachTownIndividualized.getName();
			
			boolean ifEqualstheGivenName = theNameofTown.equalsIgnoreCase(name);
			
			if(ifEqualstheGivenName)
			{
				return eachTownIndividualized;
			}
			else
			{
				break;
			}
		}
		
		return null;
	}

	/**
	 * Determines if a town is already in the graph.
	 * @param v the town's name.
	 * @return true if the town is in the graph, false if not.
	 */
	@Override
	public boolean containsTown(String v) {
	
		boolean ifContainsTheVertex = theGraphData.containsVertex(new Town(v));
		
		if((ifContainsTheVertex == false) == false)
		{
			return theGraphData.containsVertex(new Town(v));
		}
		else
		{
			return false;
		}
		
		
	}

	/**
	 * Determines if a road is in the graph.
	 * @param town1 name of town 1 (lastname, firstname).
	 * @param town2 name of town 2 (lastname, firstname).
	 * @return true if the road is in the graph, false if not.
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		
		Town theTownsTotaled = new Town(town1);
		
		Town theTownsReallyTotaled = new Town(town2);
		
		boolean ifContainedEdge = theGraphData.containsEdge(theTownsTotaled, theTownsReallyTotaled);
		
		if(ifContainedEdge == (true) == (true))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name.
	 * @return an arraylist of all road titles in sorted order by road name.
	 */
	@Override
	public ArrayList<String> allRoads() {
	
		Set<Road> theTotalofAllRoads = theGraphData.edgeSet();
		
		ArrayList<String> everySingleRoad = new ArrayList<>();
		
		for(Road the_Road : theTotalofAllRoads)
		{
			String theNameoFtheRoad = the_Road.getName();
			
			boolean ifAllRoadTitlesareInSortedOrder = everySingleRoad.add(theNameoFtheRoad);
			
			ifAllRoadTitlesareInSortedOrder = true;
		}
		
		Collections.sort(everySingleRoad);
		return everySingleRoad;
	}

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		
		int theInitial = 0;
		
		Road theRoadTobERemoved = theGraphData.removeEdge(new Town(town1), new Town(town2), theInitial, road);
		
		if(theRoadTobERemoved == null == (false))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}

	/**
	 * Deletes a road from the graph.
	 * @param town1 name of town 1 (lastname, firstname).
	 * @param town2 name of town 2 (lastname, firstname).
	 * @param roadName the road name.
	 * @return true if the road was successfully deleted, false if not.
	 */
	@Override
	public boolean deleteTown(String v) {
		
		boolean theRoadtobeDeletedOF = theGraphData.removeVertex(new Town(v));
		
		if((theRoadtobeDeletedOF == false) == false)
		{
			return theRoadtobeDeletedOF;
		}
		
		return false;
		
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name).
	 * @return an arraylist of all towns in alphabetical order (last name, first name).
	 */
	@Override
	public ArrayList<String> allTowns() {
		
		Set<Town> theTotalofAllTowns = theGraphData.vertexSet();
		
		ArrayList<String> everySingleTown = new ArrayList<>();
		
		for(Town the_TownDatatoStore : theTotalofAllTowns)
		{
			String theTownNameIndividually = the_TownDatatoStore.getName();
			boolean iFAddAlphaSuccessful = everySingleTown.add(theTownNameIndividually);
			iFAddAlphaSuccessful = true;
			
		}
		
		Collections.sort(everySingleTown);
		
		return everySingleTown;
	}

	/**
	 * Returns the shortest path from town 1 to town 2.
	 * @param town1 name of town 1 (lastname, firstname).
	 * @param town2 name of town 2 (lastname, firstname).
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		
		Set<Town> theOverallTowns_TotaledUp = theGraphData.vertexSet();
		
		Set<Road> theOverallRoads_TotaledUp = theGraphData.edgeSet();
		
		boolean theFirstTown__ = false;
		
		boolean theEndTown__ = false;
		
		Town theFirstTown_Inital = null;
		
		Town theAfterFirstTown = null;
		
		ArrayList<String> theShortestPath_Finalized = new ArrayList<String>();
		
		try
		{
			for(Town theFirstTownInitially : theOverallTowns_TotaledUp)
			{
				String theFirstTown_ = theFirstTownInitially.getName();
				
				boolean ifNameEqualsFirstTown_True = theFirstTown_.equalsIgnoreCase(town1);
				
				boolean ifNameEqualsFirstTownAfter_True = theFirstTown_.equalsIgnoreCase(town2);
				
				if((ifNameEqualsFirstTown_True) == (true))
				{
					theFirstTown_Inital = theFirstTownInitially;
					break;
				}
				else if((ifNameEqualsFirstTownAfter_True) == true)
				{
					theAfterFirstTown = theFirstTownInitially;
				}
				else if(theFirstTown_Inital == null == (false) && (theAfterFirstTown == null == (false) == true))
				{
					break;
				}
			}
			
			for(Road theRoadData : theOverallRoads_TotaledUp)
			{
				Town theFirstPlace = theRoadData.getSource();
				
				int makingComparisonOfTheRoads = theFirstPlace.compareTo(theFirstTown_Inital);
				
				Town theFinalPlace = theRoadData.getDestination();
				
				int makingComparisonOfTheRoadsContinued = theRoadData.getDestination().compareTo(theFirstTown_Inital);
				
				int ifSuccessFulDataComparison = 0;
				
				boolean onlySuccessfulIfTrue = (makingComparisonOfTheRoads == ifSuccessFulDataComparison);
				
				boolean andIfThisIsSuccessfulAsWell = (makingComparisonOfTheRoadsContinued == ifSuccessFulDataComparison);
				
				Town theFinalPlace_Road = theRoadData.getSource();
				
				int makingComparisonOfTheRoadsFinal = theFinalPlace_Road.compareTo(theAfterFirstTown);
				
				int theTownSuccessFulComparision = theFinalPlace.compareTo(theAfterFirstTown);
				
				boolean ifTrueForFinalData = (makingComparisonOfTheRoadsFinal == ifSuccessFulDataComparison);
				
				boolean finalSuccessofDataGraph = (theTownSuccessFulComparision == ifSuccessFulDataComparison);
				
				boolean ifFirstTownisGood = (theFirstTown__ == true);
				
				boolean ifFinalTownisGood = (theEndTown__ == true);
				
				if((onlySuccessfulIfTrue == true || andIfThisIsSuccessfulAsWell == true) == true)
				{
					theFirstTown__ = true;
				}
				else if((ifTrueForFinalData == true || finalSuccessofDataGraph == true) == true)
				{
					theEndTown__ = true;
				}
				
				else if((ifFirstTownisGood && ifFinalTownisGood) == (true))
				{
					ArrayList<String> theFirstAndAfterDataStoredIn = theGraphData.shortestPath(theFirstTown_Inital, theAfterFirstTown);
					theShortestPath_Finalized = theFirstAndAfterDataStoredIn;
				}
			}
		}
		
		catch(NullPointerException ifNullPointerIsFound) {
			
		}
		
		return theShortestPath_Finalized;
	}

	/**
	 * This will populate the Graph with towns of 1 or more depending on the user's input.
	 * @param selectedFile - the file containing the town(s) to get the data and poplate data of. 
	 * @throws IOException - is thrown if an error occurs within the opening of file or populating
	 * of the graph with the town(s) in the graph itself. 
	 * @throws FileNotFoundException - is thrown when attempting to open the file cannot happen, or if the file that is being
	 * opened is not working. 
	 */
	public void populateTownGraph(File selectedFile) throws IOException, 
	FileNotFoundException 
	{
		String theLineofInput = "";
		
		Scanner theInputofTownFileData = new Scanner(selectedFile);
		
		Town theFirstTownToPopulate = null;
		
		Town theSecondTownToPopulate = null;
		
		String [] theLineofDelimition;
		
		String theFirstTownAfter; 
		
		String theVeryFirstTown_1;
		
		boolean ifTheInputFileDataIsValid = theInputofTownFileData.hasNext();
		
		while(ifTheInputFileDataIsValid == (true))
		{
			int theTownAfter = 3;
			
			int theTownToBeginWith = 2;
			
			int _TheTownAfter = 1;
			
			int _TheBeginningTown = 0;
			
			theLineofInput = theInputofTownFileData.nextLine();
			
			String theCharactersToEliminate = "[,;]";
			
			String[] theSplitting = theLineofInput.split(theCharactersToEliminate);
			
			theLineofDelimition = theSplitting;
			
			theFirstTownAfter = theLineofDelimition[theTownAfter];
			
			theSecondTownToPopulate = new Town(theFirstTownAfter);
			
			theVeryFirstTown_1 = theLineofDelimition[theTownToBeginWith];
			
			theFirstTownToPopulate = new Town(theVeryFirstTown_1);
			
			boolean ifFirstTown = theGraphData.addVertex(theFirstTownToPopulate);
			boolean ifSecondTown = theGraphData.addVertex(theSecondTownToPopulate);
			
			String theAfterFirstTownFinalized_ = theLineofDelimition[_TheTownAfter];
			String theFirstAndForemostTownFinalized_ = theLineofDelimition[_TheBeginningTown];
			
			ifFirstTown = true;
			ifSecondTown = true;
			int theTownIndextoBePresented = Integer.parseInt(theAfterFirstTownFinalized_);
			
			theGraphData.addEdge(theFirstTownToPopulate, theSecondTownToPopulate, theTownIndextoBePresented, theFirstAndForemostTownFinalized_); 
			
		}
		
		theInputofTownFileData.close();
	}
	
	

}
