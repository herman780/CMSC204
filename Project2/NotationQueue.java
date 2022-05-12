
import java.util.ArrayList;

/**
 * NotationQueue - This is designed to implement the queue interface to able to utilize the queue interface
 * methods. 
 * @author Herman Mann 
 * @param <T> data type.
 */
public class NotationQueue<T> implements QueueInterface<T> 
{
	
	private int theCapacityofQueue, thetotalNumberOfNodes;
	private ArrayList<T> theQueue;
	
	/**
	 * The default constructor of NotationQueue - uses a default value type
	 *  as the size of the queue. 
	 */
	public NotationQueue()
	{
		theQueue = new ArrayList<>();
		thetotalNumberOfNodes = 925;
	}
	/**
	 * The second default constructor of NotationQueue. 
	 * @param theCapacity - takes an int as the size of the queue. 
	 */
	public NotationQueue(int theCapacity)
	{
		theQueue = new ArrayList<>(theCapacity);
		this.thetotalNumberOfNodes = theCapacity;
	}

	/**
	 * Determines if Queue is empty.
	 * @return true if Queue is empty, false if not.
	 */
	@Override
	public boolean isEmpty() {
		
		boolean ifEmptyorNot = theQueue.isEmpty();
		
		return ifEmptyorNot;
	}

	/**
	 * Determines of the Queue is full.
	 * @return true if Queue is full, false if not. 
	 */
	@Override
	public boolean isFull() {
		
		if(theCapacityofQueue == thetotalNumberOfNodes)
		{
			return true; //* if the queue is full. 
		}
		else
		{
			return false; //* if the queue is empty. 
		}
	
		
	}

	/**
	 * Deletes and returns the element at the front of the Queue.
	 * @return the element at the front of the Queue.
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
			
		if(isEmpty())
		{
			throw new QueueUnderflowException();
		}
		else
		{
			theCapacityofQueue--; /* Will keep going down until the element
			is at the front of the Queue. */
	
			int remove_TheResult = theCapacityofQueue - 1;
			
			return theQueue.remove((remove_TheResult) - theCapacityofQueue + 1);
			
		}
	
		
	}

	/**
	 * Number of elements in the Queue.
	 * @return the number of elements in the Queue. 
	 */
	@Override
	public int size() {
		
		return theQueue.size();
		
	}

	/**
	 * Adds an element to the end of the Queue.
	 * @param e the element to add to the end of the Queue.
	 * @return true if the add was successful, false if not.
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		
		if(theCapacityofQueue >= thetotalNumberOfNodes)
		{
			throw new QueueOverflowException();
		}
		else
		{
			theQueue.add(e);
			theCapacityofQueue++;
			return true;
		}
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue.
	 * Place the delimiter between all elements of the Queue.
	 * @return string representation of the Queue with elements separated with the delimiter.
	 */
	@Override
	public String toString(String delimiter) {
	
		int queueResult = delimiter.toString().length();
		
		String theQueueresult = "";
		
		for(T theQueue: theQueue)
		{
			
			theQueueresult += theQueue.toString() + delimiter.toString();
		}
	
		int theResultFinalizedOfQueue = theQueueresult.length();
		theQueueresult = theQueueresult.substring(0, theResultFinalizedOfQueue - queueResult);
		return theQueueresult;
	}

	/**
	 * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	 * is the first element in the Queue.
	 * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	 * list reference within your Queue, you will be allowing direct access to the data of
	 * your Queue causing a possible security breech.
	 * @param list elements to be added to the Queue.
	 */
	@Override
	public void fill(ArrayList<T> list) {
		

		for(T theQueueList : list)
		{
			if(theCapacityofQueue == theCapacityofQueue-1)
			{
				throw new QueueOverflowException();
			}
			else if(theCapacityofQueue != theCapacityofQueue-1)
			{
				theCapacityofQueue = theCapacityofQueue+1;
				theQueue.add(theQueueList);
			}
		}
		
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue.
	 * @return string representation of the Queue with elements.
	 */
	@Override
	public String toString()
	{
		
		String theCorrectString = "";
		
		for(T toStringStack : theQueue)
		{
			theCorrectString += toStringStack.toString();
		}
		return theCorrectString;
		
	}
	
}
