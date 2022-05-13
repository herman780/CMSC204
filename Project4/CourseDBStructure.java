import java.util.ArrayList;
import java.util.LinkedList;

/**
 * CourseDBStructure implements the CourseDBStructureInterface that is provided. The CourseDBStructure class will implement
 * a hash table of buckets and including chaining. This will consist of an array of linked lists of CourseDBElements. The different
 * CDE's will have a hash code that directly follows from the course's CRN, due to the CRN being so significant for the individual 
 * course(s). The add method of the class will take a single CourseDBElement and add it to the data structure of the hashcode and
 * hashtable. If a linked list at the similar and relevant hash does not exist than a new linked list will be created with the very 
 * beginning first element which will be the CourseDataBaseElement (CDE) and will add it to the HashTable. If the linked list already
 * is there and exists, we will add the CDE (CourseDataBaseElement) to the exisiting before list. There will be two different
 * constructors of this class, which being the first one takes in an integer that is the total estimated number of courses, and then
 * the other constructor will be used for the testing and its purposes. The class will not implement the 4k+3 code.  
 * @author Herman Mann 
 */
public class CourseDBStructure implements CourseDBStructureInterface{
	
	protected int _TableSize = 0;
	protected LinkedList<CourseDBElement> [] hashTable;
	
	/**
	 * The first constructor of the class taking in the total number of courses there is and will
	 * store it in the CourseDataBase later on. 
	 * @param size - the total number of courses that there is estimated to be. 
	 */
	public CourseDBStructure(int size) {
		this._TableSize=size;
		hashTable=new LinkedList[_TableSize];
	}
	
	/**
	 * The second constructor of the class, taking in a String and an int. The string will be for testing purposes
	 * and the int will be used for the estimated size of the hash table. Used only for testing. 
	 * @param testing - the String of the construcot will be "Testing" for testing purposes. 
	 * @param size - the estimated size of the hash table.
	 */
	public CourseDBStructure(String testing, int size) {
		this._TableSize=size;
		hashTable=new LinkedList[_TableSize];
	}

	/** 
	* Using the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable or not and if the CDE (CourseDataBaseElement) does not exist in the hashtable
	* add it to the hashtable. 
	
	* @param element - the (CourseDataBaseElement) CDE to be added
	*/
	@Override
	public void add(CourseDBElement element) {
		
		int theOverallHash = 0;
		
		int converttoHashcode = element.hashCode();
		
		theOverallHash = ((Math.abs(converttoHashcode) % getTableSize()));
		
		LinkedList<CourseDBElement> theAddingListofElements = hashTable[theOverallHash];
		
		if(theAddingListofElements != null == ((false)))
		{
			hashTable[theOverallHash] = new LinkedList<CourseDBElement>();
		}
		
		hashTable[theOverallHash].add(element);
		
	}

	
	/** 
	* Using the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable and if the CDE (CourseDataBaseElement) is in the hashtable we will return it
	* and if its not we will throw an IOException. 
	* @param crn - the CRN to be added to the course(s) in the CourseDataBase. 
	*/
	@Override
	public CourseDBElement get(int crn)  {

		int theHashusingGet = 0;
		
		while(theHashusingGet < _TableSize == (true))
		{
			if(hashTable[theHashusingGet] == null == (false))
			{
				LinkedList<CourseDBElement> theList = hashTable[theHashusingGet];
				for(CourseDBElement theElementsList : theList)
				{
					while(theElementsList.getCRN() == crn == (true))
						return theElementsList;
				}
				
			}
			
			theHashusingGet++;
		}
		
		return null;
				
		
	}
	
	/**
	* Returns the size of the ConcordanceDataStructure of the total number of estimated indexes in the array of CourseDataBase structure 
	* @return _TableSize - the size of the ConcordanceDataStructure (the total number of indexes in the array). 
	*/
	@Override
	public int getTableSize() {
		
		int thesize = _TableSize;
		return thesize;
	}
	
	/**
	 * Goes in directions of the data structure for each of the elements and returns all of the elements inside the linked list
	 * and then the arraylist. 
	 * @return theVal - an arraylist of all of the elements in the hashtable data structure. 
	 */
	public ArrayList<String> showAll() {
	
		ArrayList<String> theVal = new ArrayList<String>();
		
		String convertToString = "\n";
		
		int theHashCDB = 0;
		
		while(theHashCDB < getTableSize())
		{
			if(hashTable[theHashCDB] == null == (false))
			{
				LinkedList<CourseDBElement> theListofCBD = hashTable[theHashCDB];
				for(CourseDBElement theTotalofElements: theListofCBD)
				{
					String theCode = convertToString +theTotalofElements;
					theVal.add(theCode);
				}
				
			}
			
			theHashCDB++;
	
		}
			return theVal;
		
		}

}