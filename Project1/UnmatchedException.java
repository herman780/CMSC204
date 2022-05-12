/**
 * UnmatchedException class - The user-inputed password does not match to the re-typed version. 
 * @author Herman Mann
 */
public class UnmatchedException extends Exception {
	
	public UnmatchedException()
	{
		super("The passwords do not match.");
	}

}
