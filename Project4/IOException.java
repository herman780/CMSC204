
public class IOException extends Exception {
	
	public IOException()
	{
		super("File cannot be read, or attempting to retrieve a CDE failed because it does not exist in the DB.");
	}

}
