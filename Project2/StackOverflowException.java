
/**
 * StackOverflowException class - the exception occurs and is thrown when a top or pop method is called on a full stack.
 * @author Herman Mann
 */
public class StackOverflowException extends RuntimeException{
	
	public StackOverflowException()
	{
		super("The stack is full");
	}

}
