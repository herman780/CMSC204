import java.util.Comparator;

import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;
import java.util.ListIterator;

/**
 * A generic sorted double linked list will be constructed using a provided Comparator to determine how the list is to
 * be sorted. It extends BasicDoubleLinkedList class. The addToFront and the addToEnd methods will not be supported and an
 * add method will be added that inserts to the double linked list in sorted order dependent on the Comparator. 
 * @author Herman Mann
 * @param <T> - generic data element type. 
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	protected Comparator<T> compare;
	
	/**
	 * Sorted double linked list default constructor. Creates an empty list that is associated with the 
	 * specified comparator. 
	 * @param comparator2 - Comparator to compare data elements. 
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator2)
	{
		this.compare = comparator2;
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list. Notice that we can insert the same element
	 * several times. Your implementation must traverse the list only once in order to perform the insertion. Do not implement 
	 * this method using iterators. Notice that you don't need to call any of the super class methods in order to implement this 
	 * method. 
	 * @param data - the data to be added to the list. 
	 * @return - a reference to the current object. 
	 */
	public SortedDoubleLinkedList<T> add(T data)
	{
		boolean ifAddisDone = false;
		
		Node theSorted = new Node(data);
		
		Node theFrontOfList = theFront_;
		
		Node theAddingElement = null;
		
		if(theFront_ != null == (false))
		{
			theFront_ = theSorted;
			theBack = theFront_;
		}
		else
		{
			while(theFrontOfList == null == (false) && (ifAddisDone == false))
			{
				if(compare.compare(data, theFrontOfList._data) >= 0)
				{
					theAddingElement = theFrontOfList;
					theFrontOfList = theFrontOfList.theNext;
				}
				else
				{
					ifAddisDone = true;
				}
			}
			if(theFrontOfList != null == (false))
			{
				theBack.theNext = theSorted;
				theSorted.thePrev = theBack;
				theBack = theSorted;
			}
			else if(theAddingElement != null == (false))
			{
				theSorted.theNext = theFront_;
				theSorted.theNext.thePrev = theSorted;
				theFront_ = theSorted;
			}
			else if(theSize > 0)
			{
				theSize++;
				theSorted.theNext = theFrontOfList;
				theFrontOfList.thePrev = theSorted;
				theSorted.thePrev = theAddingElement;
				theAddingElement.theNext = theSorted;
			}
		}

		theSize++;
		return this;
		
	}
	
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message
	 * "Invalid operation for sorted list."
	 * Overrides: addToEnd in class BasicDoubleLinkedList<T>. 
	 * @param data - the data for the Node within the linked list. 
	 * @return - reference to the current object. 
	 * @throws: java.lang.UnsupportedOperationException - if method is called. 
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) throws 
	java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
		
	}
	
	/**
	 * This operation is invalid for a sorted list. An UnsupportedOperationException will be generated using the message
	 * "Invalid operation for sorted list."
	 * Overrides: addToFront in class BasicDoubleLinkedList<T>. 
	 * @param data - the data for the Node within the linked list. 
	 * @return - reference to the current object. 
	 * @throws: java.lang.UnsupportedOperationException - if method is called. 
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) throws
	java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list.");
		
		
	}
	
	/**
	 * Implements the iterator by calling the super class iterator method.
	 * Specified by: iterator in interface java.lang.Iterable<T>.
	 * Overrides: iterator in class BasicDoubleLinkedList<T>.
	 * @return - an iterator positioned at the head of the list. 
	 */
	@Override
	public ListIterator<T> iterator()
	{
		return super.iterator();
		
	}
	
	/**
	 * Implements the remove operation by calling the super class remove method. 
	 * Overrides: remove in class BasicDoubleLinkedList<T>. 
	 * @param data - the data element to be removed. 
	 * @param comparator - the comparator to determine equality of data elements. 
	 * @return - data element or null. 
	 */
	@Override
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator)
	{
		return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
		
		
	}
	
	

}
