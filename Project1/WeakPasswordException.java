/**
 * WeakPasswordException class - The user-inputed password is OK but it is weak, because the password is less than 10 characters. 
 * @author Herman Mann
 */
public class WeakPasswordException extends Exception {
	
	public WeakPasswordException()
	{
		super("The password is OK but weak - it contains fewer than 10 characters.");
	}
	

}
