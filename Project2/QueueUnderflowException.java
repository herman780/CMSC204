
/**
 * QueueUnderflowException class - exception is thrown and occurs when a enqueue method is called on a empty queue. 
 * @author Herman Mann
 */
public class QueueUnderflowException extends RuntimeException {
	
	public QueueUnderflowException()
	{
		super("The Queue is empty.");
	}

}
