
/**
 * QueueOverflowException class - exception is thrown and occurs when a dequeue method is called on a full queue. 
 * @author Herman Mann
 */
public class QueueOverflowException extends RuntimeException {
	
	public QueueOverflowException()
	{
		super("The Queue is full.");
	}

}
