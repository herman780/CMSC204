import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MorseCodeConverter extends java.lang.Object{
	
	private static MorseCodeTree theBuiltTree = new MorseCodeTree();
	
	/**
	 * The no-arg default constructor of the MorseCodeConverter class. 
	 */
	public MorseCodeConverter()
	{
		
	}
	
	/**
	 * Returns a string with all the data in the tree in LNR order with a space in between them. Uses the
	 * toArrayList method in MorseCodeTree. It should return the data in this order:
	 * 
	 * "h s v i f u e l r a p w j b d x n c k y t z g q m o". 
	 * Have to note the extra space between j and b - that is because there is an empty string that is the root, and in
	 * the LNR traversal, the root would come between the right most child of the left tree (j) and the left most child of
	 * the right tree (b). This is used for testing purposes to make sure the MorseCodeTree has been built properly. 
	 * @return theResultTobePrinted - the data in the tree in LNR order separated by a space. 
	 */
	public static String printTree()
	{
		String theSpacebetween_ = " ";
		String theResultTobePrinted = "";
		ArrayList<String> theListofTree = theBuiltTree.toArrayList();
		for(String eachIndividElement: theListofTree)
		{
			theResultTobePrinted += eachIndividElement + theSpacebetween_;
		}
		
		return theResultTobePrinted;
		
	}
	
	/**
	 * Converts the Morse code into English. Each letter is delimited by a space (' '). Each word is delimited by a '/'. 
	 * Example:
	 * code = ".... . .-.. .-.. --- / .-- --- .-. .-. .-..". 
	 * string returned = "Hello World". 
	 * @param code - the morse code. 
	 * @return - the English translation. 
	 */
	public static String convertToEnglish(String code)
	{
		String theText = "";
		
		String theSplitation = " / ";
		
		String theTermorWord[] = code.split(theSplitation);
		
		String neededForCodeFile = " ";
		
		String[] theTexttobeAdded;
	    
	    for(String individCharacter : theTermorWord)
	    {
	    	theTexttobeAdded = individCharacter.split(neededForCodeFile);
	   
	    	for(String theCurrent : theTexttobeAdded)
	    	{
	    		theText += theBuiltTree.fetch(theCurrent);
	    	}
	    	
	    	theText += (neededForCodeFile);
	    	
	    }
		

		return theText.trim();
	}
	
	/**
	 * Converts a file of Morse code into English. Each letter is delimited by a space (' '). Each word is delimited by a '/'.
	 * Example:
	 * a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -..".
	 * string returned: "Hello World". 
	 * @param codeFile - the name of the File that contains Morse Code. 
	 * @return - the English translation of the file. 
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException
	{
		
		while(codeFile == null == (true))
		{
			throw new FileNotFoundException();
		}
	
		Scanner theFile = new Scanner(codeFile);
		
		String theInput = "";
		
		ArrayList<String> eachLinetoConvert = new ArrayList<String>();
		
		while(theFile.hasNext())
		{
			eachLinetoConvert.add(theFile.nextLine());
		}
		
		int theCode = 0;
		
		while(theCode < eachLinetoConvert.size())
		{
		
			theInput += MorseCodeConverter.convertToEnglish(eachLinetoConvert.get(theCode));
			
			theCode++;
		}
		
	
		theFile.close();
		return theInput.trim();
		
	}

}
