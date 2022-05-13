import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedList_STUDENT_Test {

	BasicDoubleLinkedList<String> theString_One;
	BasicDoubleLinkedList<Double> theDouble_One;
	BasicDoubleLinkedList<Car> theCarLink;
	StringComparator comparator_One;
	DoubleComparator comparatorDouble;
	CarComparator comparatorCar_One;
	
	public Car aA=new Car("Ferrari", "F8", 2012);
	public Car bB=new Car("Mercedes", "AMZ500", 2014);
	public Car cC=new Car("Toyota", "Camry", 2011);
	public Car dD=new Car("BMW", "A3", 2021);
	public Car eE=new Car("LEXUS", "F-Series", 2016);
	public Car fF=new Car("AUDI", "AMG-400", 2017);

	public ArrayList<Car> theFill = new ArrayList<Car>();
	

	@Before
	public void setUp() throws Exception {
		theString_One = new BasicDoubleLinkedList<String>();
		theString_One.addToEnd("Hello");
		theString_One.addToEnd("World");
		theString_One.addToEnd("CMSC204");
		comparator_One = new StringComparator();
		
		theDouble_One = new BasicDoubleLinkedList<Double>();
		theDouble_One.addToEnd(45.0);
		theDouble_One.addToEnd(110.0);
		theDouble_One.addToEnd(76.5);
		theDouble_One.addToEnd(89.5);
		comparatorDouble = new DoubleComparator();
		
		theCarLink= new BasicDoubleLinkedList<Car>();
		theCarLink.addToEnd(bB);
		theCarLink.addToEnd(cC);
		theCarLink.addToEnd(dD);
		comparatorCar_One = new CarComparator();
	}

	@After
	public void tearDown() throws Exception {
		theString_One = null;
		theDouble_One = null;
		theCarLink = null;
		comparatorDouble = null;
		comparator_One = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(3,theString_One.getSize());
		assertEquals(4,theDouble_One.getSize());
		assertEquals(3,theCarLink.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals("CMSC204", theString_One.getLast());
		theString_One.addToEnd("End");
		assertEquals("End", theString_One.getLast());
		
		assertEquals(dD,theCarLink.getLast());
		theCarLink.addToEnd(dD);
		assertEquals(dD,theCarLink.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Hello", theString_One.getFirst());
		theString_One.addToFront("Begin");
		assertEquals("Begin", theString_One.getFirst());
		
		assertEquals(bB,theCarLink.getFirst());
		theCarLink.addToFront(aA);
		assertEquals(aA,theCarLink.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Hello", theString_One.getFirst());
		theString_One.addToFront("New");
		assertEquals("New", theString_One.getFirst());
		
		assertEquals(bB,theCarLink.getFirst());
		theCarLink.addToFront(aA);
		assertEquals(aA,theCarLink.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("CMSC204", theString_One.getLast());
		theString_One.addToEnd("New");
		assertEquals("New", theString_One.getLast());
		
		assertEquals(dD,theCarLink.getLast());
		theCarLink.addToEnd(dD);
		assertEquals(dD,theCarLink.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Car> list;
		theCarLink.addToFront(aA);
		theCarLink.addToEnd(dD);
		list = theCarLink.toArrayList();
		assertEquals(aA,list.get(0));
		assertEquals(bB,list.get(1));
		assertEquals(cC,list.get(2));
		assertEquals(dD,list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		theString_One.addToFront("Begin");
		theString_One.addToEnd("End");
		ListIterator<String> iterator = theString_One.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("CMSC204", iterator.next());
		
		theCarLink.addToFront(aA);
		theCarLink.addToEnd(dD);
		ListIterator<Car> iteratorCar = theCarLink.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(aA, iteratorCar.next());
		assertEquals(bB, iteratorCar.next());
		assertEquals(cC, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(dD, iteratorCar.next());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		theCarLink.addToFront(aA);
		theCarLink.addToEnd(dD);
		ListIterator<Car> iteratorCar = theCarLink.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(aA, iteratorCar.next());
		assertEquals(bB, iteratorCar.next());
		assertEquals(cC, iteratorCar.next());
		assertEquals(dD, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(dD, iteratorCar.previous());
		assertEquals(cC, iteratorCar.previous());
		assertEquals(bB, iteratorCar.previous());
		assertEquals(aA, iteratorCar.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		theCarLink.addToFront(aA);
		theCarLink.addToEnd(dD);
		ListIterator<Car> iteratorCar = theCarLink.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(aA, iteratorCar.next());
		assertEquals(bB, iteratorCar.next());
		assertEquals(cC, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(dD, iteratorCar.next());
		
		try{
			//no more elements in list
			iteratorCar.next();
			assertTrue("Did not throw a NoSuchElementException",true);
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
	public void testIteratorNoSuchElementExceptionPrevious() {
		theCarLink.addToFront(aA);
		theCarLink.addToEnd(dD);
		ListIterator<Car> iteratorCar = theCarLink.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(aA, iteratorCar.next());
		assertEquals(bB, iteratorCar.next());
		assertEquals(cC, iteratorCar.next());
		assertEquals(dD, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(dD, iteratorCar.previous());
		assertEquals(cC, iteratorCar.previous());
		assertEquals(bB, iteratorCar.previous());
		assertEquals(aA, iteratorCar.previous());
		
		try{
			//no more elements in list
			iteratorCar.previous();
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
	public void testIteratorUnsupportedOperationException() {
		theCarLink.addToFront(aA);
		theCarLink.addToEnd(dD);
		ListIterator<Car> iteratorCar = theCarLink.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(aA, iteratorCar.next());
		assertEquals(bB, iteratorCar.next());
		assertEquals(cC, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(dD, iteratorCar.next());
		
		try{
			//remove is not supported for the iterator
			iteratorCar.remove();
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
	public void testRemove() {
		// remove the first
		assertEquals(bB, theCarLink.getFirst());
		assertEquals(dD, theCarLink.getLast());
		theCarLink.addToFront(aA);
		assertEquals(aA, theCarLink.getFirst());
		theCarLink.remove(aA, comparatorCar_One);
		assertEquals(bB, theCarLink.getFirst());
		//remove from the end of the list
		theCarLink.addToEnd(dD);
		assertEquals(dD, theCarLink.getLast());
		theCarLink.remove(dD, comparatorCar_One);
		//remove from middle of list
		theCarLink.addToFront(aA);
		assertEquals(aA, theCarLink.getFirst());
		theCarLink.remove(bB, comparatorCar_One);
		assertEquals(aA, theCarLink.getFirst());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals(bB, theCarLink.getFirst());
		theCarLink.addToFront(aA);
		assertEquals(aA, theCarLink.getFirst());
		assertEquals(aA, theCarLink.retrieveFirstElement());
		assertEquals(bB,theCarLink.getFirst());
		assertEquals(bB, theCarLink.retrieveFirstElement());
		assertEquals(cC,theCarLink.getFirst());
		
		assertEquals("Hello", theString_One.getFirst());
		theString_One.addToFront("New");
		assertEquals("New", theString_One.getFirst());
		assertEquals("New", theString_One.retrieveFirstElement());
		assertEquals("Hello",theString_One.getFirst());
		assertEquals("Hello", theString_One.retrieveFirstElement());
		assertEquals("World",theString_One.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(dD, theCarLink.getLast());
		theCarLink.addToEnd(dD);
		assertEquals(dD, theCarLink.getLast());
		assertEquals(dD, theCarLink.retrieveLastElement());
		assertEquals(cC,theCarLink.getLast());
		
		assertEquals("CMSC204", theString_One.getLast());
		theString_One.addToEnd("New");
		assertEquals("New", theString_One.getLast());
		assertEquals("New", theString_One.retrieveLastElement());
		assertEquals("World",theString_One.getLast());
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
			return arg0.toString().compareTo(arg1.toString());
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
