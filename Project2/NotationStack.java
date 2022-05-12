
import java.util.ArrayList;

/**
 * Notation Stack Class - designed to implement the given NotationStack interface in order to utilize the 
 * generic Stack data structure for the methods given in the NotationStack interface. 
 * @author Herman Mann
 * @param <T> data type. 
 */
public class NotationStack<T> implements StackInterface<T>
{
	
	protected int theStackSize;
	protected ArrayList<T>theStack;
	protected int theCapacity = 0;
	
	/**
	 * The default constructor for the NotationStack class, will use a default value type
	 * as the size of the stack. 
	 */
	public NotationStack()
	{
		theStackSize = 3200;
		theStack = new ArrayList<T>(theStackSize);
	}
	
	/**
	 * The second default constructor of the NotationStack class. 
	 * @param theSize - Takes in an int as the size of the stack. 
	 */
	public NotationStack(int theSize)
	{
		theStackSize = theSize;
		theStack = new ArrayList<T>(theStackSize);
	}

	/**
	 * Determines if Stack is empty.
	 * @return true if Stack is empty, false if not.
	 */
	@Override
	public boolean isEmpty() {
		
		return theStack.isEmpty();
	}

	/**
	 * Determines if Stack is full.
	 * @return true if Stack is full, false if not.
	 */
	@Override
	public boolean isFull() {
		
		if(theCapacity == theStackSize)
		{
			return true; //the stack being full. 
		}
		else
		{
			return false; //if the stack is not full. 
		}
	}

	/**
	 * Deletes and returns the element at the top of the Stack.
	 * @return the element at the top of the Stack.
	 */
	@Override
	public T pop() throws StackUnderflowException {
		
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		else
		{
			T thePopElement = null;
			
			thePopElement = theStack.get(theCapacity-1);
			
			theStack.remove(theCapacity-1);
			
			theCapacity--;
			
			return thePopElement;
		}
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack.
	 * @return the element at the top of the Stack.
	 */
	@Override
	public T top() throws StackUnderflowException {
		
		T _data = theStack.get(theCapacity-1);
		
		int dataEmpty = 0;
		
		if(theCapacity == dataEmpty)
		{
			throw new StackUnderflowException();
		}
		else
		{
			return _data;
		}
	}

	/**
	 * Number of elements in the Stack.
	 * @return the number of elements in the Stack.
	 */
	@Override
	public int size() {
		
		return theCapacity;
	}

	/**
	 * Adds an element to the top of the Stack.
	 * @param e the element to add to the top of the Stack.
	 * @return true if the add was successful, false if not.
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		
		if(theCapacity >= theStackSize)
		{
			throw new StackOverflowException();
		}
		else
		{
			theStack.add(e);
			theCapacity++;
			return true;
		}
	}

	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack.
	 * Place the delimiter between all elements of the Stack.
	 * @return string representation of the Stack from bottom to top with elements.
	 * separated with the delimiter.
	 */
	@Override
	public String toString(String delimiter) {
		
		String result = "";
		int theres2 = delimiter.toString().length();
		
		for(T stack: theStack)
		{
			
			result += (stack.toString() + delimiter.toString());
		}
		
		int theResultFinalized = result.length();
		result = result.substring(0, theResultFinalized - theres2);
		return result;
		
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack.
	 * @return an string which represent the Objects in the Stack from bottom to top.
	 */
	@Override
	public String toString()
	{
		String theCorrectString = "";
		
		for(T toStringStack : theStack)
		{
			theCorrectString += toStringStack.toString();
		}
		return theCorrectString;
		
	}

	/**
	 * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	 * is the first bottom element of the Stack.
	 * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	 * list reference within your Stack, you will be allowing direct access to the data of
	 * your Stack causing a possible security breech.
	 * @param list elements to be added to the Stack from bottom to top.
	 */
	@Override
	public void fill(ArrayList<T> list) {
		
		for(T theList : list)
		{
			if(theCapacity == theCapacity-1)
			{
				throw new StackOverflowException();
			}
			else if(theCapacity != theCapacity-1)
			{
				theCapacity = theCapacity+1;
				theStack.add(theList);
			}
		}
		
	}
	
	
}