/**
 * NoDigitException class - The user-inputed password must contain at least a single digit 
 * @author Herman Mann
 *
 */
public class NoDigitException extends Exception {
	
	public NoDigitException()
	{
		super("The password must contain at least one digit.");
	}
	

}
