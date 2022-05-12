
/**
 * StackUnderflowException class - exception occurs and is thrown when a push method is called on an empty stack. 
 * @author Herman Mann
 */
public class StackUnderflowException extends RuntimeException{
	
	public StackUnderflowException()
	{
		super("The stack is empty.");
	}

}
