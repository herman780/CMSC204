
/**
 * LengthException class - The user-inputed password must be at least 6 characters long. 
 * @author Herman Mann 
 */
public class LengthException extends Exception {
	
	public LengthException()
	{
		super("The password must be at least 6 characters long");
	}
	
}
