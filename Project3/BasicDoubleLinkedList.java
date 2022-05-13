import java.util.ArrayList;



import java.lang.Iterable;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;


/**
 * This generic double-linked list relies on a head (reference to first element of the list) and tail
 * (reference to the last element of the list). Both are set to null when the list is empty. Both point to the
 * same element where there is only one element in the list. A node structure has only three fields: data and the
 * prev and next references. The class must only define the following entities: an inner class Node, an inner class that
 * implements ListIterator (for the iterator method), head and tail references and an integer representing the list size. 
 * However only the hasNext(), next(), hasPrevious(), and previous() methods of ListIterator need to be implemented, all other
 * methods can throw the UnsupportedOperationException: 
 * 
 * public void remove() throws UnsupportedOperationException{
 * 
 * throw new UnsupportedOperationException();}
 * 
 * All the entities are defined as protected so they can be accessed by the subclasses. 
 * 
 * @author Herman Mann
 * @param <T> - Generic type parameter used for the implementing of Iterable generic type parameter. 
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {
	
	protected Node theFront_;
	protected Node theBack;
	protected Node theNext;
	protected Node thePrevious;
	protected int theSize;
	
	/**
	 * The no-argument default constructor setting an individual size of the double linked list to 0. 
	 */
	public BasicDoubleLinkedList()
	{
		this.theSize = 0;
	}
	
	/**
	 * The inner-class, the Node class which is one of the entities needed for implementation of the 
	 * Basic Double Linked List class. 
	 * @author Herman Mann 
	 *
	 */
	public class Node {
		
		protected Node the_Front;
		
		protected Node theEnd;
		
		protected Node theNext;
		
		protected T theIterator;
		
		protected T _data;
		
		protected Node thePrev;

		
		
		/**
		 * The inner-class's default constructor, Node used for the implementation of the Basic Double Linked class. 
		 * @param theIterator - The iterator for the double linked list to go to the next, previous, back, and front reference
		 * positions of the list. 
		 * @param theFront - the reference to the first element of the list. 
		 * @param theEnd - the reference to the last element of the list. 
		 */
		public Node(T theIterator, Node theFront, Node theEnd)
		{
			this.theIterator = theIterator;
			this.the_Front = theFront;
			this.theEnd = theEnd;
			
		}
		
		/**
		 * The inner class's second default constructor, Node taking in the data of the double linked list and assigning 
		 * it to the data of the implementing one as of the current status of the double linked list. 
		 * @param data - the data being sent in and stored in from the double linked list. 
		 */
		public Node(T data)
		{
			this._data = data;
		}
		

	}
	
	/**
	 * This method must be implemented using an inner class that implements ListIterator and defines the methods
	 * of hasNext(), next(), hasPrevious(), and previous(). Remember that we should be able to call the hasNext()
	 * method as many times as we want without changing what is considered the next element. 
	 * 
	 * Specified by: iterator in interface java.lang.Iterable<T>.
	 * 
	 * Throws: 
	 *     java.util.NoSuchElementException - Your next() method should throw NoSuchElementException if there are no more
	 *     elements (at the end of the list and calling next() or at the beginning of the list and calling previous()). 
	 *     java.lang.UnsupportedOperationException - You don't need to implement the ListIterator's remove(), add(), nextIndex(),
	 *     and previousIndex(), and set() methods, throw UnsupportedOperationException if called. 
	 */
	public ListIterator<T> iterator() throws java.lang.UnsupportedOperationException, 
	java.util.NoSuchElementException
	{
		ListIterator <T> thePreviousImplemented = new BasicDoubleLinkedListIterator();
		
		return thePreviousImplemented;
	
		
	}

	/**
	 * An inner-class that implements ListIterator (for the iterator method), and the methods hasNext(), next(), previous(),
	 * and hasPrevious() will be implemented. Will implement the ListIterator<T> generic type class. Will throw
	 * UnsupportedOperationException - for the remove(), set(), add(), nextIndex(), previousIndex() methods will be thrown if
	 * called. 
	 * @author Herman Mann
	 */
	protected class BasicDoubleLinkedListIterator implements ListIterator<T>
	{

		protected Node theIteration = theFront_;
		
		protected Node thePreviousIteration = null;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			while(theIteration != null)
			{
				return true;
			}
			
			return false;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			while(thePreviousIteration != null)
			{
				return true;
			}
			
			return false;
			
		}

		@Override
		public T previous() 
		{
	
			while(thePreviousIteration == null)
			{
				throw new NoSuchElementException();
			}
			
				theIteration = thePreviousIteration;
				thePreviousIteration = thePreviousIteration.thePrev;
				theSize--;
				T returnPrevious = theIteration._data;
				return returnPrevious;
		}

		@Override
		public T next() {
			
			while(theIteration == null)
			{
				throw new NoSuchElementException();
			}
			
			T theData = theIteration._data;
			thePreviousIteration = theIteration;
			theIteration = theIteration.theNext;
			theSize++;
			return theData;
			
			
		}

		@Override
		public void set(T e) throws UnsupportedOperationException{
			
			throw new UnsupportedOperationException();
			
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void add(T e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	/**
	 * Adds an element to the end of the list. Do not use iterators to implement this method. 
	 * @param data - the data for the Node within the linked list. 
	 * @return - reference to the current object. 
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data)
	{
		Node e = new Node(data);
		if(theFront_ != null == (false))
		{
			theFront_ = e;
		}
		else if(theSize > 0)
		{
			theBack.theNext = e;
			e.thePrev = theBack;
		}
		theBack = e;
		theSize++;
		return this;
		
	}
	
	/**
	 * Notice you must not traverse the list to compute the size. This method just returns the value of the instance
	 * variable you use to keep track of size. 
	 * @return - the size of the linked list. 
	 */
	public int getSize()
	{
		return theSize;
		
	}
	
	/**
	 * Adds element to the front of the list. Do not use iterators to implement this method. 
	 * @param data - the data for the Node within the linked list. 
	 * @return - reference to the current object. 
	 */
	public BasicDoubleLinkedList<T> addToFront(T data)
	{
		Node f = new Node(data);
		if(theFront_ != null == (false))
		{
			theBack = f;
		}
		else if(theSize > 0)
		{
			f.theNext = theFront_;
			theFront_.thePrev = f;
		}
		
		theFront_ = f;
		theSize++;
		return this;
		
		
	}
	
	/**
	 * Returns but does not remove the first element from the list. If there are no elements the method returns 
	 * null. Do not implement this method using iterators. 
	 * @return - the data element or null. 
	 */
	public T getFirst()
	{
		
		if(theFront_ == null)
		{
			return null;
		}
			
		return theFront_._data;
		
	}
	
	/**
	 * Returns but does not remove the last element from the list. If there are no elements the method returns 
	 * null. Do not implement this method using iterators. 
	 * @return - the data element or null. 
	 */
	public T getLast()
	{
		if(theBack == null)
		{
			return null;
		}
		
		return theBack._data;	
	}
	
	/**
	 * Removes the first instance of the targetData from the list. Notice that you must remove the elements by performing
	 * a single traversal over the list. You may not use any of the other retrieval methods associated with the class in order
	 * to complete the removal process. You must use the provided comparator (do not use equals) to find those elements that match
	 * the target. Do not implement this method using iterators. 
	 * @param targetData - the data element to be removed. 
	 * @param comparator - the comparator to determine equality of data elements. 
	 * @return - data element or null. 
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator)
	{
		Node theRemoveElement = theFront_;
		
		while(theSize != 0)
		{
			while(comparator.compare(targetData, theRemoveElement._data) < 1)
			{
				if(theRemoveElement != theFront_ == (false))
				{
					theFront_ = theFront_.theNext;
					theSize++;
				}
				
				else if(theRemoveElement != theBack == (false))
				{
			
					theBack = theBack.thePrev;
					theSize++;
				}
				
				else
				{
					theRemoveElement.thePrev.theNext = theRemoveElement.theNext;
				}
				
				theSize--;
		
				return this;
			}
			
			theRemoveElement = theRemoveElement.theNext;
		}
		theSize--;
		return this;
		
	}
	
	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null. Do not
	 * implement this method using iterators.
	 * @return - data element or null. 
	 */
	public T retrieveFirstElement()
	{
		Node theFirst = theFront_;
		
		theFront_ = theFront_.theNext;
		
		if(theFront_ == null == (false))
		{
			theFront_.thePrev = null;
		}
		else if(theFront_ != null == (false))
		{
			theBack = null;
		}
		
		else
		{
			theFirst.theNext = null;	
		}
		
		theSize--;
		
		return theFirst._data;
		
	}
	
	/**
	 * Removes and returns the last element from the list. If there are no elements the method returns null.
	 * Do not implement this method using iterators. 
	 * @return - data element or null. 
	 */
	public T retrieveLastElement()
	{
		Node theLast = theBack;
		
		theBack = theFront_.theNext;
		
		if(theBack == null == (false))
		{
			theFront_.thePrev = null;
		}
		else if(theBack != null == (false))
		{
			theBack = null;
		}
		
		theSize--;
		
		theLast.theNext = null;
		
		return theLast._data;
		
	}
	/**
	 * Returns an arraylist of the items in the list from head of list to tail of list. 
	 * @return - an arraylist of the items in the list. 
	 */
	public ArrayList<T> toArrayList()
	{
	
		Node theList = theFront_;
		
		ArrayList<T> totaledUp = new ArrayList<T>();
		
		while(theList == null == (false))
		{
			totaledUp.add(theList._data);
			theList = theList.theNext;
		}
		
		return totaledUp;
		
	}

}
