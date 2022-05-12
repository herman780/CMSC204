import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {

	private GradeBook gTH1;
	private GradeBook f1;

	@Before
	public void setUp() throws Exception {
		
	/*Creating two objects of the GradeBook class to hold 5 scores */
		gTH1 = new GradeBook(5);
		f1 = new GradeBook(5);
		
	/*Calling the addScore method for each of the GradeBook objects at least twice,
	 * to add some random scores of the user's choice. */
		gTH1.addScore(43);
		gTH1.addScore(87);
		
		f1.addScore(95);
		f1.addScore(32);
		f1.addScore(64);
		
	}

	@After
	public void tearDown() throws Exception {
		
		gTH1 = null;
		f1 = null;
	}

	@Test
	public void testAddScore() {
		
		assertTrue(gTH1.toString().equals("43.0 87.0 "));
		assertTrue(f1.toString().equals("95.0 32.0 64.0 "));
		
	}

	@Test
	public void testSum() {
		
		assertEquals(130, gTH1.sum(), .0001);
		assertEquals(191, f1.sum(), .0001);
	}

	@Test
	public void testMinimum() {
		
		assertEquals(43, gTH1.minimum(), .001);
		assertEquals(32, f1.minimum(), .001);
	}

	@Test
	public void testFinalScore() {
		
		assertEquals(87.0, gTH1.finalScore(), .0001);
		assertEquals(159.0, f1.finalScore(), .0001);
	}

	@Test
	public void testGetScoreSize() {
		
		assertEquals(2, gTH1.getScoreSize(), .0001);
		assertEquals(3, f1.getScoreSize(), .0001);
	}

	@Test
	public void testToString() {
		
		assertTrue(gTH1.toString().equals("43.0 87.0 "));
		assertTrue(f1.toString().equals("95.0 32.0 64.0 "));
		
	}

}
