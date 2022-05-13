import java.util.ArrayList;

import java.util.HashSet;

import java.util.Set;



/**
 * This is the Graph class that implements the GraphInterface given. For Graph<Town, Road>, Town is the vertex type
 * (a Town), Road is the edge type (a Road). You will need to decide how to store the graph, use an adjacent matrix or
 * an adjacency list. This is the class header: public class Graph implements GraphInterface<Town, Road>.
 * 
 * Within the Graph interface is a method shortestPath, which finds the shortest path from a given source Town to a destination
 * Town. Since there is a unique shortest path from every vertex to the source, there is a back-pointer to the previous vertex. 
 * The method shortestPath calls dijkstraShortestPath which finds the shortest path from the source to every other vertex in the 
 * graph. You will be coding the Dijkstra's Shortest Path algorithm. You will then be able to find the connections between two towns
 * through the roads that connect them.
 * 
 * You may use the adjacency matrix approach found in the textbook, or you may use a set of Towns and a set of Roads. The ShortestPath
 * algoritm typically uses a weighted graph which means that the edges have a weight, and this is used to determine the shortest path. 
 * For this implementation, each weight will be the distance of the road in miles. 
 * @author Herman Mann 
 */
public class Graph implements GraphInterface<Town, Road> {
	
	protected Set<Road> theDifferentRoadsofTown = new HashSet<>();
	
	protected Set<Town> theDifferentTowns = new HashSet<>();
	
	protected Town theFinalDestination;
	
	protected int _TotalTownStatus;
	
	protected ArrayList<String> _theShortestPath = new ArrayList<>();

	/**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		Road theReturnResult = null;
		
		Town theFirst = sourceVertex;
		
		Town theSecond = destinationVertex;
		
		if(theFirst == (null) == true || theSecond == (null) == true)
		{
			return null;
		}
		
		Set<Road> theTowns = this.theDifferentRoadsofTown;
		
		for(Road theIndividualRoad : theTowns)
		{
			boolean theFirstPlace = theIndividualRoad.contains(sourceVertex);
			boolean theSecondPlace = theIndividualRoad.contains(destinationVertex);
			
			if(theFirstPlace == false || theSecondPlace == false)
			{
				continue;
			}
			
			else
			{
			
				theReturnResult = theIndividualRoad;
				break;
			}
		}
		
		return theReturnResult;
	}

	 /**
     * Creates a new edge in this graph, going from the source vertex to the target 
     * vertex, and returns the created edge. 
     * The source and target vertices must already be contained in this graph. If they are not 
     * found in graph IllegalArgumentException is thrown.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     * @return The newly created edge if added to the graph, otherwise null.
     * @throws IllegalArgumentException if source or target vertices are not found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException,
	NullPointerException
	{
		Road theNewRoad = new Road(sourceVertex, destinationVertex, weight, description);
		
		boolean addingTheRoad = theDifferentRoadsofTown.add(theNewRoad);
		
		addingTheRoad = true;
		
		while((sourceVertex == null == false || destinationVertex == null == false) == false)
		{
			throw new NullPointerException();
			
		}
		
		while((containsVertex(sourceVertex) == true || containsVertex(destinationVertex) == true) == false)
		{
			throw new IllegalArgumentException();
		}
		
		
		return theNewRoad;
		
	}

	 /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if this graph 
     * contains no vertex u such that u.equals(v). If this graph already 
     * contains such vertex, the call leaves this graph unchanged and 
     * returns false. In combination with the restriction on 
     * constructors, this ensures that graphs never contain duplicate vertices.
     * @param v vertex to be added to this graph.
     * @return true if this graph did not already contain the specified vertex.
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) throws NullPointerException {
		
		if(v == null == (true))
		{
			throw new NullPointerException();
		}
		
		boolean theDifferentTownsMustContainTown = theDifferentTowns.contains(v);

		if((theDifferentTownsMustContainTown == false)== true)
		{
			boolean adding_OfTheTowns = theDifferentTowns.add(v);
		
			adding_OfTheTowns = true;
			
			return true;
		}
		
		return false;
	}

	 /**
     * Returns true if and only if this graph contains an edge going from the source 
     * vertex to the target vertex. In undirected graphs the same result is obtained 
     * when source and target are inverted. If any of the specified vertices does 
     * not exist in the graph, or if is null, returns false.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		
		Set<Road> theRoadContained = theDifferentRoadsofTown;
		
		boolean theFirstDestination = theRoadContained.contains(sourceVertex);
		
		boolean theFinalDestination = theRoadContained.contains(destinationVertex);
		
		if((theFirstDestination && theFinalDestination == false || 
				sourceVertex == null || destinationVertex == null) == true)
		{
			return false;
		}
		
		for(Road theIndividRoad : theRoadContained)
		{
			boolean ifFirstRoad = theIndividRoad.contains(sourceVertex);
			boolean ifFinalRoad = theIndividRoad.contains(destinationVertex);
			
			if((ifFirstRoad && ifFinalRoad) == true)
			{
				return true;
			}
		}
		return false;
	}

	 /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a vertex u such that 
     * u.equals(v). If the specified vertex is null returns false.
     * @param v vertex whose presence in this graph is to be tested.
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
	
		boolean ifContainsTownTrue = theDifferentTowns.contains(v);
		
		if(ifContainsTownTrue)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}

	 /**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet() {
		
		return theDifferentRoadsofTown;
	}

	 /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     * @param vertex the vertex for which a set of touching edges is to be returned.
     * @return a set of all edges touching the specified vertex.
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@Override
	public Set<Road> edgesOf(Town vertex) throws IllegalArgumentException, NullPointerException {
		
		Set<Road> thesingleRoadSet = new HashSet<>();
		
		while(vertex == (null) == (true))
		{
			throw new NullPointerException();
		}
		
		Set<Road> theNewRoad = theDifferentRoadsofTown;
		
		for(Road theRoad : theNewRoad)
		{
			boolean ifTheRoadHasit = theRoad.contains(vertex);
			
			if(ifTheRoadHasit)
			{
				thesingleRoadSet.add(theRoad);
			}
		}
		
		boolean ifTheRoadSetEmpty = thesingleRoadSet.isEmpty();
		
		if((ifTheRoadSetEmpty == (true) == true))
		{
			throw new IllegalArgumentException();
		}
		

		return thesingleRoadSet;
	}

	/**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * If weight >- 1 it must be checked.
     * If description != null, it must be checked.
     * Returns the edge if removed or null otherwise.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		Road theNewRoad = null;
		
		Set<Road> theDiffRoads = theDifferentRoadsofTown;
		
		for(Road theRoad : theDiffRoads)
		{
			int theDistanceInTotal = -1;
			
			boolean ifRoadSetContainsFirst = theRoad.contains(sourceVertex);
			
			boolean ifRoadSetContainsLast = theRoad.contains(destinationVertex);
			
			boolean ifDistanceGreaternegative1 = weight > theDistanceInTotal;
			
			boolean ifTheNameDescription = description != null;
			
			if((ifRoadSetContainsFirst && ifRoadSetContainsLast && ifDistanceGreaternegative1
					&& ifTheNameDescription) == true)
			{
				theNewRoad = theRoad;
			}
			
			boolean ifSuccessfullyRemoved = theDifferentRoadsofTown.remove(theNewRoad);
			
			if(ifSuccessfullyRemoved)
			{
				return theRoad;
			}
		}
		
		return null;
	}

	 /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     * If the specified vertex is null returns false.
     * @param v vertex to be removed from this graph, if present.
     * @return true if the graph contained the specified vertex; false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {
		
		while(v == (null) == (true))
		{
			return false;
		}
		
		boolean ifTheTownSetContains = theDifferentTowns.contains(v);
		
		boolean removeSuccessful = theDifferentTowns.remove(v);
		
		if(ifTheTownSetContains)
		{
			removeSuccessful = true;
		}
		
		return true;
	}

	 /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() {
		
		return theDifferentTowns;
	}

	 /**
	     * Find the shortest path from the sourceVertex to the destinationVertex
	     * call the dijkstraShortestPath with the sourceVertex
	     * @param sourceVertex starting vertex
	     * @param destinationVertex ending vertex
	     * @return An arraylist of Strings that describe the path from sourceVertex
	     * to destinationVertex
	     * They will be in the format: startVertex "via" Edge "to" endVertex weight
		 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
		 * would be in the following format(this is a hypothetical solution):
		 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
		 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
		 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
	   */   
	 @Override
	 public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		 
	 		String findingtheShortestPath = "";
	 		
		 	Town theFirstTown;
		 
		 	Town theLastTown;
		 	
		 	Road theIndividualEdge;
		 	
	        theFinalDestination = destinationVertex;
	        
	        dijkstraShortestPath(sourceVertex);
	        
	        int theTotalDistanceofDirection = 0;
	 
	        int theStart = 0;
	        
	        int theIncrementationOfTown = _theShortestPath.size() - 1;
	    
	        while(theStart <  theIncrementationOfTown) 
	        {
	    	  
	    	  	String throughConnection = " via ";
	    	  	String toWhatTownorRoad = " to ";
	    	  	String theSpaceNeeded = " ";
	    	  	String theMiles = " mi;";
	    	  
	    	  	String theFirstTown_ =  _theShortestPath.get(theStart);
	    	  			
	    	  	int afterFirstTown_Iteration = theStart + 1;
	    	  	
	    	  	String afterFirstTown = _theShortestPath.get(afterFirstTown_Iteration);
	    	  	
	            theFirstTown = new Town(theFirstTown_);
	            
	            theLastTown = new Town(afterFirstTown);
	            
	            Road theFirstandLast = getEdge(theFirstTown, theLastTown);
	            
	            theIndividualEdge = theFirstandLast;
	            
	            int theRetrievedSingleRoadData = theIndividualEdge.getWeight();
	            
	            theTotalDistanceofDirection = theTotalDistanceofDirection + theRetrievedSingleRoadData;	                      
	            
	            String retrivedTheSingleRoadName = theIndividualEdge.getName();
	            
	            findingtheShortestPath = 
	            			findingtheShortestPath 
	            			+ theFirstTown 
	            			+ throughConnection 
	            			+ retrivedTheSingleRoadName 
	            			+ toWhatTownorRoad 
	            			+ theLastTown 
	            			+ theSpaceNeeded 
	            			+ theRetrievedSingleRoadData 
	            			+ theMiles;
	            
	            theStart++;
	        }
	      
	        _theShortestPath.clear();
	        
	        String theSplitCharacter = ";";
	        
	        String[] theDelimition = findingtheShortestPath.split(theSplitCharacter);
	        	       	   
	        for (String addingIndividualItem : theDelimition) 
	        {
	          
	        	 boolean addingEachForShortPath = _theShortestPath.add(addingIndividualItem);
	        			
	        	 addingEachForShortPath = true;
	        }
	     
	        return _theShortestPath;
	    }

	 	/**
	     * Dijkstra's Shortest Path Method.  Internal structures are built which
	     * hold the ability to retrieve the path, shortest distance from the
	     * sourceVertex to all the other vertices in the graph, etc.
	     * @param sourceVertex the vertex to find shortest path from
	     */
	    @Override
	    public void dijkstraShortestPath(Town sourceVertex) {
	      
	    	int theInitalStart = theDifferentTowns.size();
	   
	        Town[] townsAndRoads = new Town[theInitalStart];
	       
	        int theInitialization = 0;
	        
	        for (Town theSingleTown : theDifferentTowns) 
	        {
	        	
	        	townsAndRoads[theInitialization] = new Town(theSingleTown);
	            
	            theInitialization++;
	        }   
	        
	        int theRoad = theDifferentTowns.size();
	        int theTown = theDifferentTowns.size();
	        
	        int[][] theMatrixtoMatch = new int[theRoad][theTown]; 
	        
	        int theFirst = 0;
	        
	        int theRoadsAndTownsLength = theMatrixtoMatch.length;
	        
	        while(theFirst < theRoadsAndTownsLength)
	        {
	            int theInitialization2 = 0;
	            
	            int theTowns_Roads = theMatrixtoMatch[theFirst].length;
	            
	            while(theInitialization2 < theTowns_Roads)
	            {
	            	Town theABMatrix = townsAndRoads[theFirst];
	            	Town theABMatrix2 = townsAndRoads[theInitialization2];
	            	
	            	boolean theTruthStatus = containsEdge(theABMatrix, theABMatrix2);
	            	
	            	boolean theEqualofTownsandRoads = (theFirst == theInitialization2);
	            	
	            	int noRemainderAndTrue = 0;
	            	
	                if (theEqualofTownsandRoads == ((true)) || theTruthStatus == ((false)))
	                {
	                	theMatrixtoMatch[theFirst][theInitialization2] = noRemainderAndTrue;
	                } 
	                
	                else
	                {
	                	Town theFirstMatrix = townsAndRoads[theFirst];
	                	Town theSecondandFinalMatrix = townsAndRoads[theInitialization2];
	                	Road theFinalRoad = getEdge(theFirstMatrix, theSecondandFinalMatrix);
	                	
	                    int distanceBetween = theFinalRoad.getWeight();
	                    
	                    int theA = theFirst;
	                    int theB = theInitialization2;
	                    
	                    theMatrixtoMatch[theA][theB] = theMatrixtoMatch[theB][theA] = distanceBetween;
	                }
	                
	                
	                theInitialization2++;
	            }
	            
	            theFirst++; 
	        }
	        
	        int theInitialTown = 0;
	        
	        for (Town theInitial_Town : townsAndRoads) 
	        {
	        	boolean theInitialTownStatus = theInitial_Town.equals(sourceVertex);
	        	
	            if((theInitialTownStatus == (false) == true))
	            {
	                theInitialTown++;
	            } 
	            else
	            {
	            	theInitialTownStatus = (true);
	            	break;
	            }
	            
	        }
	        
	        _TotalTownStatus = 0;
	        
	        
	        for (Town theSecondTown : townsAndRoads) 
	        {
	        	boolean theSecondTownStatus = theSecondTown.equals(theFinalDestination);
	        	
	            if (theSecondTownStatus == (false)) 
	            {
	                _TotalTownStatus++;
	            } 
	            else 
	            {
	            	theSecondTownStatus = (true);
	                break;
	            }
	        }
	        
	        int theStartingRoadandTown = 0;
	        
	        int theLengthofTownsandRoads = theMatrixtoMatch[theStartingRoadandTown].length;
	        
	        int theTotalNumberofTownsListed = theLengthofTownsandRoads;
	        
	        boolean[] eachAdditionOfPerfectConnection = new boolean[theTotalNumberofTownsListed];
	        
	        int[] theShortestDistancesofTravel = new int[theTotalNumberofTownsListed];
	        	
	        int theInitialTownStart = 0;
	        		
	        while(theInitialTownStart < theTotalNumberofTownsListed)
	        {
	        	@SuppressWarnings("unused")
				boolean theTownsStatus_ = eachAdditionOfPerfectConnection[theInitialTownStart];
	        	theShortestDistancesofTravel[theInitialTownStart] = 500;
	            theTownsStatus_  = false;
	            
	            theInitialTownStart++;
	        }
	        		
	        theShortestDistancesofTravel[theInitialTown] = 0;
	        
	        int[] theHeadoftheConnection = new int[theTotalNumberofTownsListed];
	        
	        theHeadoftheConnection[theInitialTown] = -1;
	        
	        int theInitial_TownStart = 1;
	        
	        while(theInitial_TownStart < theTotalNumberofTownsListed)
	        {
	            int theshort_DistTown_ = -1;
	            
	            int theShortestTownDistance = 500;
	            
	            int theInitial__TownIndex = 0;
	            
	            while(theInitial__TownIndex < theTotalNumberofTownsListed)
	            {
	            	boolean mustBeFalse = eachAdditionOfPerfectConnection[theInitial__TownIndex];
	            	
	            	int theTruthofTravelDistances_ = theShortestDistancesofTravel[theInitial__TownIndex];
	            		            	
	                while ((mustBeFalse == false && (theTruthofTravelDistances_ < theShortestTownDistance) == true))
	                {
	                    theshort_DistTown_ = theInitial__TownIndex;
	                    theShortestTownDistance = theShortestDistancesofTravel[theInitial__TownIndex];	                    	        
	                }
	                
	                theInitial__TownIndex++;
	            }
	            
	            theInitial_TownStart++;            
	            
	            eachAdditionOfPerfectConnection[theshort_DistTown_] = true;
	           
	            int theRoadIndex = 0;
	            
	            while(theRoadIndex < theTotalNumberofTownsListed)
	            {
	                int theShortestRoadDistance = theMatrixtoMatch[theshort_DistTown_][theRoadIndex]; 
	                
	                int theTotalofRoadsAndTheTowns = (theShortestTownDistance + theShortestRoadDistance);
	                
	                int theValidation = theShortestDistancesofTravel[theRoadIndex];
	                
	                int morethanOneElement = 0;
	                
	                if ((theShortestRoadDistance > morethanOneElement && (theTotalofRoadsAndTheTowns < theValidation) == true))
	                {
	                    theHeadoftheConnection[theRoadIndex] = theshort_DistTown_;
	                    theShortestDistancesofTravel[theRoadIndex] = theShortestTownDistance + theShortestRoadDistance;
	                    	                  
	                }	       
	                
	                theRoadIndex++;
	            }     
	            
	            
	        }
	        
	        theConnectionBuiltofRoadsAndTowns(_TotalTownStatus, theHeadoftheConnection); 
	    }
	    
	  
	    /**
	     * Populating the individual town with the direct order of the towns
	     * to go from the first place to the final place, the source to the ultimate destination. 
	     * @param theVertexNow - the index of the final destination. 
	     * @param theHead - the index of the specific towns and their shortest distances/paths. 
	     */
	    protected void theConnectionBuiltofRoadsAndTowns(int theVertexNow, int [] theHead) 
	    {
	        
	    	int theIfIndex = -1;
	    	
	    	int theBeginningofTownInitialization;
	    	
	        while (theVertexNow == (theIfIndex) == (true)) 
	        { 
	        	return;
	        } 
	        
	        theBeginningofTownInitialization = 0;
	        
	        theConnectionBuiltofRoadsAndTowns(theHead[theVertexNow], theHead); 
	        
	        Set<Town> theTotalConsistedTowns = theDifferentTowns;
	        
	        for (Town theTownsandRoads : theTotalConsistedTowns) 
	        {
	        	
	            if ((theBeginningofTownInitialization == theVertexNow == (true) == true))
	            {
	                
	            	String retrievedData = theTownsandRoads.getName();
	            	
	            	boolean addingTheTotaledUpData = _theShortestPath.add(retrievedData);
	            	
	            	addingTheTotaledUpData = true;
	            }
	            
	            theBeginningofTownInitialization++;
	        }
	    }
}
