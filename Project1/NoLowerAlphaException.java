/**
 * NoLowerAlphaException class - The user-inputed password must contain at least one lowercase alphabetic based character.
 * @author Herman Mann 
 *
 */
public class NoLowerAlphaException extends Exception {
	
	public NoLowerAlphaException()
	{
		super("The password must contain at least one lowercase alphabetic character");
	}
	
	
}
