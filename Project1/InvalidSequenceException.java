/**
 * InvalidSequenceException class - The password cannot contain more than two of the same character in sequence
 * of a user-inputed password. 
 * @author Herman Mann 
 */
public class InvalidSequenceException extends Exception {
	
	public InvalidSequenceException()
	{
		super("The password cannot contain more than two of the same character in sequence. ");
	}
	

}
