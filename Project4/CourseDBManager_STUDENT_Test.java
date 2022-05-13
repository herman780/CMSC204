import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the Student test file for the CourseDBManager
 * which is being implemented from the CourseDBManagerInterface
 * 
 * @author Herman Mann 
 *
 */

public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface _studentDataManager = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		_studentDataManager = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		_studentDataManager = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		
		try {
			_studentDataManager.add("CHEM131",22348,4,"SC225","Samuel Carlson");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		_studentDataManager.add("CHEM131",22348,4,"SC225","Samuel Carlson");
		_studentDataManager.add("MATH280",42906,4,"HU342","Ben theWallace");
		_studentDataManager.add("PHYS262",33917,4,"SC426","theGreat MagicKing");
		ArrayList<String> theOveralllist = _studentDataManager.showAll();
		
		assertEquals(theOveralllist.get(1),"\nCourse:CHEM131 CRN:22348 Credits:4 Instructor:Samuel Carlson Room:SC225");
		assertEquals(theOveralllist.get(0),"\nCourse:MATH280 CRN:42906 Credits:4 Instructor:Ben theWallace Room:HU342");
		assertEquals(theOveralllist.get(2),"\nCourse:PHYS262 CRN:33917 Credits:4 Instructor:theGreat MagicKing Room:SC426");
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("realTest1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CHEM131 22348 4 SC225 Samuel Carlson");
			inFile.print("PHYS262 33917 4 SC426 theGreat MagicKing");
			
			inFile.close();
			_studentDataManager.readFile(inputFile);
			//System.out.println(dataMgr.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
