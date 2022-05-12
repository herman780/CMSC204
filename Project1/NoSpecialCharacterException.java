/**
 * NoSpecialCharacterException class - The user-inputed password must contain one special character or more.
 * @author Herman Mann 
 *
 */
public class NoSpecialCharacterException extends Exception {
	
	public NoSpecialCharacterException()
	{
		super("The password must contain at least one special character.");
	}
	

}
