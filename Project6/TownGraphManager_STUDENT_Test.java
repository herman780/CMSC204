
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManager_STUDENT_Test {
	
	private TownGraphManagerInterface _MajorGraphData;
	
	private String[] _TheTownData_;
	  
	@Before
	public void setUp() throws Exception {
		
		  _MajorGraphData = new TownGraphManager();
		  _TheTownData_ = new String[14];
		  
		  for (int theInitial = 1; theInitial < 14; theInitial++) {
			  _TheTownData_[theInitial] = "Town_" + theInitial;
			  _MajorGraphData.addTown(_TheTownData_[theInitial]);
		  }
		  
		  _MajorGraphData.addRoad(_TheTownData_[1], _TheTownData_[2], 2, "Road_1");
		  _MajorGraphData.addRoad(_TheTownData_[1], _TheTownData_[3], 4, "Road_2");
		  _MajorGraphData.addRoad(_TheTownData_[1], _TheTownData_[5], 6, "Road_3");
		  _MajorGraphData.addRoad(_TheTownData_[3], _TheTownData_[7], 1, "Road_4");
		  _MajorGraphData.addRoad(_TheTownData_[3], _TheTownData_[8], 2, "Road_5");
		  _MajorGraphData.addRoad(_TheTownData_[4], _TheTownData_[8], 3, "Road_6");
		  _MajorGraphData.addRoad(_TheTownData_[6], _TheTownData_[9], 3, "Road_7");
		  _MajorGraphData.addRoad(_TheTownData_[9], _TheTownData_[10], 4, "Road_8");
		  _MajorGraphData.addRoad(_TheTownData_[8], _TheTownData_[10], 2, "Road_9");
		  _MajorGraphData.addRoad(_TheTownData_[5], _TheTownData_[10], 5, "Road_10");
		  _MajorGraphData.addRoad(_TheTownData_[10], _TheTownData_[11], 3, "Road_11");
		  _MajorGraphData.addRoad(_TheTownData_[2], _TheTownData_[11], 6, "Road_12");
		  _MajorGraphData.addRoad(_TheTownData_[2], _TheTownData_[11], 6, "Road_13");
		  _MajorGraphData.addRoad(_TheTownData_[2], _TheTownData_[11], 6, "Road_14");
		 
	}

	@After
	public void tearDown() throws Exception {
		
		_MajorGraphData = null;
	}

	@Test
	public void testAddRoad() {
		
		ArrayList<String> _theRoads_Data_Offical = _MajorGraphData.allRoads();
		assertEquals("Road_1", _theRoads_Data_Offical.get(0));
		assertEquals("Road_10", _theRoads_Data_Offical.get(1));
		assertEquals("Road_11", _theRoads_Data_Offical.get(2));
		assertEquals("Road_12", _theRoads_Data_Offical.get(3));
		_MajorGraphData.addRoad(_TheTownData_[2], _TheTownData_[9], 1,"Road_14");
		_theRoads_Data_Offical = _MajorGraphData.allRoads();
		assertEquals("Road_1", _theRoads_Data_Offical.get(0));
		assertEquals("Road_10", _theRoads_Data_Offical.get(1));
		assertEquals("Road_11", _theRoads_Data_Offical.get(2));
		assertEquals("Road_12", _theRoads_Data_Offical.get(3));
		assertEquals("Road_13", _theRoads_Data_Offical.get(4));
		
	}

	@Test
	public void testGetRoad() {
		
		assertEquals("Road_13", _MajorGraphData.getRoad(_TheTownData_[2], _TheTownData_[11]));
		assertEquals("Road_4", _MajorGraphData.getRoad(_TheTownData_[3], _TheTownData_[7]));
	}

	@Test
	public void testAddTown() {
		assertEquals(true, _MajorGraphData.containsTown("Town_12"));
		_MajorGraphData.addTown("Town_12");
		assertEquals(true, _MajorGraphData.containsTown("Town_12"));
	}
	

	@Test
	public void testContainsTown() {
		assertEquals(true, _MajorGraphData.containsTown("Town_2"));
		assertEquals(true, _MajorGraphData.containsTown("Town_12"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, _MajorGraphData.containsRoadConnection(_TheTownData_[2], _TheTownData_[11]));
		assertEquals(false, _MajorGraphData.containsRoadConnection(_TheTownData_[3], _TheTownData_[5]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = _MajorGraphData.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_10", roads.get(1));
		assertEquals("Road_11", roads.get(2));
		assertEquals("Road_6", roads.get(10));
		assertEquals("Road_7", roads.get(11));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, _MajorGraphData.containsTown("Town_2"));
		_MajorGraphData.deleteTown(_TheTownData_[2]);
		assertEquals(false, _MajorGraphData.containsTown("Town_2"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = _MajorGraphData.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_10", roads.get(1));
		assertEquals("Town_11", roads.get(2));
		assertEquals("Town_12", roads.get(3));
		assertEquals("Town_6", roads.get(9));
	}

	
	


}