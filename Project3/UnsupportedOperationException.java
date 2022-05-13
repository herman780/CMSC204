
/**
 * UnsupportedOperationException - This class will thrown an exception in regards to the addFront and addToEnd
 * implementations of the SortedDoubleLinkedClass and by the remove method of the iterator. 
 * @author Herman Mann
 *
 */
public class UnsupportedOperationException extends RuntimeException {
	
	public UnsupportedOperationException()
	{
		super("This operation is not supported");
	}

}
