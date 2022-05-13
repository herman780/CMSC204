
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Graph_STUDENT_Test {
	
	private GraphInterface<Town,Road> _Dataofgraph;
	private Town[] _Dataoftown;

	@Before
	public void setUp() throws Exception {
		
		 _Dataofgraph = new Graph();
		  _Dataoftown = new Town[15];
		  
		  for (int j = 1; j < 15; j++) {
			  
			  _Dataoftown[j] = new Town("Town_" + j);
			  _Dataofgraph.addVertex(_Dataoftown[j]);
		  }
		  
		  _Dataofgraph.addEdge(_Dataoftown[1], _Dataoftown[2], 2, "Road_1");
		  _Dataofgraph.addEdge(_Dataoftown[1], _Dataoftown[3], 4, "Road_2");
		  _Dataofgraph.addEdge(_Dataoftown[1], _Dataoftown[5], 6, "Road_3");
		  _Dataofgraph.addEdge(_Dataoftown[3], _Dataoftown[7], 1, "Road_4");
		  _Dataofgraph.addEdge(_Dataoftown[3], _Dataoftown[8], 2, "Road_5");
		  _Dataofgraph.addEdge(_Dataoftown[4], _Dataoftown[8], 3, "Road_6");
		  _Dataofgraph.addEdge(_Dataoftown[6], _Dataoftown[9], 3, "Road_7");
		  _Dataofgraph.addEdge(_Dataoftown[9], _Dataoftown[10], 4, "Road_8");
		  _Dataofgraph.addEdge(_Dataoftown[8], _Dataoftown[10], 2, "Road_9");
		  _Dataofgraph.addEdge(_Dataoftown[5], _Dataoftown[10], 5, "Road_10");
		  _Dataofgraph.addEdge(_Dataoftown[10], _Dataoftown[11], 3, "Road_11");
		  _Dataofgraph.addEdge(_Dataoftown[2], _Dataoftown[11], 6, "Road_12");
		  _Dataofgraph.addEdge(_Dataoftown[12], _Dataoftown[11], 9, "Road_13");
		  _Dataofgraph.addEdge(_Dataoftown[13], _Dataoftown[12], 8, "Road_14");
		  _Dataofgraph.addEdge(_Dataoftown[14], _Dataoftown[13], 6, "Road_15");
	}

	@After
	public void tearDown() throws Exception {
		_Dataofgraph = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(_Dataoftown[2], _Dataoftown[11],6, "Road_12"), _Dataofgraph.getEdge(_Dataoftown[2], _Dataoftown[11]));
		assertEquals(new Road(_Dataoftown[3], _Dataoftown[7],1, "Road_4"), _Dataofgraph.getEdge(_Dataoftown[3], _Dataoftown[7]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, _Dataofgraph.containsEdge(_Dataoftown[3], _Dataoftown[5]));
		_Dataofgraph.addEdge(_Dataoftown[3], _Dataoftown[5], 1, "Road_13");
		assertEquals(true, _Dataofgraph.containsEdge(_Dataoftown[3], _Dataoftown[5]));
	}

	@Test
	public void testAddVertex() {
		
		Town theBrandNewTown = new Town("Town_8");
		
		assertEquals(true, _Dataofgraph.containsVertex(theBrandNewTown));
		_Dataofgraph.addVertex(theBrandNewTown);
		
		assertEquals(true, _Dataofgraph.containsVertex(theBrandNewTown));
	}

	@Test
	public void testContainsEdge() {
		
		assertEquals(true, _Dataofgraph.containsEdge(_Dataoftown[8], _Dataoftown[10]));
		assertEquals(false, _Dataofgraph.containsEdge(_Dataoftown[5], _Dataoftown[7]));
	}

	@Test
	public void testContainsVertex() {
		
		assertEquals(true, _Dataofgraph.containsVertex(new Town("Town_2")));
		assertEquals(true, _Dataofgraph.containsVertex(new Town("Town_6")));
	}

	@Test
	public void testEdgeSet() {
		
		Set<Road> theSetofRoads = _Dataofgraph.edgeSet();
		ArrayList<String> theRoadArrayList__ = new ArrayList<String>();
		
		for(Road road : theSetofRoads)
			theRoadArrayList__.add(road.getName());
		
		Collections.sort(theRoadArrayList__);
		assertEquals("Road_1", theRoadArrayList__.get(0));
		assertEquals("Road_10", theRoadArrayList__.get(1));
		assertEquals("Road_11", theRoadArrayList__.get(2));
		assertEquals("Road_12", theRoadArrayList__.get(3));
		assertEquals("Road_13", theRoadArrayList__.get(4));
		assertEquals("Road_5", theRoadArrayList__.get(10));
	}

	@Test
	public void testEdgesOf() {
		
		Set<Road> theRoadsData_ = _Dataofgraph.edgesOf(_Dataoftown[14]);
		ArrayList<String> _OfficialRoadArrayList = new ArrayList<String>();
		
		for(Road road : theRoadsData_)
			_OfficialRoadArrayList.add(road.getName());
		
		Collections.sort(_OfficialRoadArrayList);
		assertEquals("Road_15", _OfficialRoadArrayList.get(0));
	}
	
	@Test
	public void testRemoveEdge() {
		
		assertEquals(true, _Dataofgraph.containsEdge(_Dataoftown[2], _Dataoftown[11]));
		
		_Dataofgraph.removeEdge(_Dataoftown[2], _Dataoftown[11], 6, "Road_12");
		assertEquals(false, _Dataofgraph.containsEdge(_Dataoftown[2], _Dataoftown[11]));
	}
	
	@Test
	public void testRemoveVertex() {
		
		assertEquals(true, _Dataofgraph.containsVertex(_Dataoftown[5]));
		_Dataofgraph.removeVertex(_Dataoftown[5]);
		assertEquals(true, _Dataofgraph.containsVertex(_Dataoftown[8]));
	}

	@Test
	public void testVertexSet() {
		
		Set<Town> _TheOverallroads = _Dataofgraph.vertexSet();
		
		assertEquals(true,_TheOverallroads.contains(_Dataoftown[1]));
		assertEquals(true, _TheOverallroads.contains(_Dataoftown[11]));
		assertEquals(true, _TheOverallroads.contains(_Dataoftown[14]));
		assertEquals(true, _TheOverallroads.contains(_Dataoftown[3]));
		assertEquals(true,_TheOverallroads.contains(_Dataoftown[9]));
	}

	  
	  

}