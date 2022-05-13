import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_STUDENT_Test {
	
	SortedDoubleLinkedList<String> theString_Two;
	SortedDoubleLinkedList<Double> theLinkedDouble_2;
	SortedDoubleLinkedList<Car> theLinkedCar_Two;
	StringComparator theComparator_Two;
	DoubleComparator comparatorD_2Two;
	CarComparator _comparatorCar_Two;
	
	public Car aA=new Car("JAVA", "COMP2", 2021);
	public Car bB=new Car("Chemistry", "CHEM131", 2019);
	public Car cC=new Car("CALCULUS3", "MATH280", 2020);
	public Car dD=new Car("Physics", "PHYS161", 2015);
	public Car eE=new Car("Biology", "BIO150", 2008);
	public Car fF=new Car("English", "ENGL102", 2007);
	//alphabetic order: e f a c b d
	
	@Before
	public void setUp() throws Exception {
		theComparator_Two = new StringComparator();
		theString_Two = new SortedDoubleLinkedList<String>(theComparator_Two);
		
		comparatorD_2Two = new DoubleComparator();
		theLinkedDouble_2 = new SortedDoubleLinkedList<Double>(comparatorD_2Two);
		
		_comparatorCar_Two = new CarComparator();
		theLinkedCar_Two = new SortedDoubleLinkedList<Car>(_comparatorCar_Two);
		
	}

	@After
	public void tearDown() throws Exception {
		theComparator_Two = null;
		comparatorD_2Two = null;
		_comparatorCar_Two = null;
		theString_Two = null;
		theLinkedDouble_2 = null;
		theLinkedCar_Two = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			theString_Two.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			theString_Two.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		theLinkedCar_Two.add(aA);
		theLinkedCar_Two.add(bB);
		theLinkedCar_Two.add(cC);
		theLinkedCar_Two.add(dD);
		ListIterator<Car> iterator = theLinkedCar_Two.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(cC, iterator.next());
		assertEquals(bB, iterator.next());
		assertEquals(aA, iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		theString_Two.add("Begin");
		theString_Two.add("World");
		theString_Two.add("Hello");
		theString_Two.add("Zebra");
		ListIterator<String> iterator = theString_Two.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulCarPrevious() {
		theLinkedCar_Two.add(eE);
		theLinkedCar_Two.add(cC);
		theLinkedCar_Two.add(bB);
		theLinkedCar_Two.add(dD);
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = theLinkedCar_Two.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(eE, iterator.next());
		assertEquals(cC, iterator.next());
		assertEquals(bB, iterator.next());
		assertEquals(dD, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(dD, iterator.previous());
		assertEquals(bB, iterator.previous());
		assertEquals(cC, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		theLinkedDouble_2.add(new Double(8));
		theLinkedDouble_2.add(new Double(6));
		theLinkedDouble_2.add(new Double(1));
		theLinkedDouble_2.add(new Double(2));
		ListIterator<Double> iterator = theLinkedDouble_2.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(1), iterator.next());
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(6), iterator.next());
		assertEquals(true, iterator.hasNext());	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		theLinkedDouble_2.add(new Double(5));
		theLinkedDouble_2.add(new Double(10));
		theLinkedDouble_2.add(new Double(8));
		theLinkedDouble_2.add(new Double(2));
		ListIterator<Double> iterator = theLinkedDouble_2.iterator();
		assertEquals(new Double(2), iterator.next());
		assertEquals(new Double(5), iterator.next());
		assertEquals(new Double(8), iterator.next());
		assertEquals(true, iterator.hasPrevious());
		//assertEquals(new Double(10), iterator.previous());
		assertEquals(new Double(8), iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		theLinkedCar_Two.add(eE);
		theLinkedCar_Two.add(cC);
		theLinkedCar_Two.add(bB);
		theLinkedCar_Two.add(dD);
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = theLinkedCar_Two.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(eE, iterator.next());
		assertEquals(cC, iterator.next());
		assertEquals(bB, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(dD, iterator.next());
		try{
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		theLinkedCar_Two.add(eE);
		theLinkedCar_Two.add(cC);
		theLinkedCar_Two.add(bB);
		theLinkedCar_Two.add(dD);
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = theLinkedCar_Two.iterator();
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddCar() {
		//alphabetic order: e f a c b d
		theLinkedCar_Two.add(aA);
		theLinkedCar_Two.add(bB);
		theLinkedCar_Two.add(cC);
		assertEquals(cC, theLinkedCar_Two.getFirst());
		assertEquals(aA, theLinkedCar_Two.getLast());
		theLinkedCar_Two.add(dD);
		theLinkedCar_Two.add(eE);
		assertEquals(eE, theLinkedCar_Two.getFirst());
		assertEquals(dD, theLinkedCar_Two.getLast());
		//deletes Elephant from linked list
		assertEquals(dD,theLinkedCar_Two.retrieveLastElement());
	}

	@Test
	public void testRemoveFirstCar() {
		//alphabetic order: e f a c b d
		theLinkedCar_Two.add(bB);
		theLinkedCar_Two.add(cC);
		assertEquals(cC, theLinkedCar_Two.getFirst());
		assertEquals(bB, theLinkedCar_Two.getLast());
		theLinkedCar_Two.add(aA);
		assertEquals(cC, theLinkedCar_Two.getFirst());
		// remove the first
		theLinkedCar_Two.remove(aA, _comparatorCar_Two);
		assertEquals(cC, theLinkedCar_Two.getFirst());
	}
	
	@Test
	public void testRemoveEndCar() {
		//alphabetic order: e f a c b d
		theLinkedCar_Two.add(bB);
		theLinkedCar_Two.add(fF);
		assertEquals(bB, theLinkedCar_Two.getFirst());
		assertEquals(fF, theLinkedCar_Two.getLast());
		theLinkedCar_Two.add(dD);
		assertEquals(dD, theLinkedCar_Two.getLast());
		//remove from the end of the list
		theLinkedCar_Two.remove(dD, _comparatorCar_Two);
		assertEquals(fF, theLinkedCar_Two.getLast());
	}

	@Test
	public void testRemoveMiddleCar() {
		//alphabetic order: e f a c b d
		theLinkedCar_Two.add(aA);
		theLinkedCar_Two.add(bB);
		assertEquals(bB, theLinkedCar_Two.getFirst());
		assertEquals(aA, theLinkedCar_Two.getLast());
		theLinkedCar_Two.add(fF);
		assertEquals(bB, theLinkedCar_Two.getFirst());
		assertEquals(aA, theLinkedCar_Two.getLast());
		assertEquals(4,theLinkedCar_Two.getSize());
		//remove from middle of list
		theLinkedCar_Two.remove(aA, _comparatorCar_Two);
		assertEquals(bB, theLinkedCar_Two.getFirst());
		assertEquals(fF, theLinkedCar_Two.getLast());
		assertEquals(4,theLinkedCar_Two.getSize());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class CarComparator implements Comparator<Car>
	{

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.getMake().compareTo(arg1.getMake());
		}		
	}
	
	private class Car{
		String make;
		String model;
		int year;
		
		public Car(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}
