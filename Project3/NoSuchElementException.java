
/**
 * NoSuchElementException - This exception class will be returned by the next function within the iterator
 * class where there are no more elements in the linked list. 
 * @author Herman Mann 
 *
 */
public class NoSuchElementException extends RuntimeException{
	
	public NoSuchElementException()
	{
		super("There are no more elements in the list");
	}

}
