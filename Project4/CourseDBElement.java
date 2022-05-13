/**
 * CourseDBElement implements Comparable, and will consist of 5 separate attributes: the
 * Course ID (a String), the CRN (an int), the number of credits (an int), the room number (a String), and
 * the instructor name (a String). This will be referred to as a CDE. 
 * The CourseDBElement class will have its mutators/setters and accessors/getters for 5 of the individual attributes
 * (The CourseID, CRN, the credits, the room number, and the name of the instructor). 
 * @author Herman Mann 
 */
public class CourseDBElement implements Comparable {

	private String course_ID;
	private int _CRN;
	private int _Credits;
	private String _RoomNumber;
	private String _InstructorName;
	
	/**
	 * No-Arg default constructor of the CourseDBElement class, listing the 5 different attributes and assigning
	 * them either with an empty string if the attribute is a string data type or an integer of 0 if the attribute is of an int
	 * data type. 
	 */
	public CourseDBElement()
	{
		course_ID = "";
		_CRN = 0;
		_Credits = 0;
		_RoomNumber = "";
		_InstructorName = "";
	}
	
	/**
	 * The second No-Arg default constructor of the CourseDBElement class setting the 5 parameters to the initialized
	 * and or instantiated variables as defined previously in of the CourseDBElement class. 
	 * @param courseID - the course id as a String data type of the course(s) in the CourseDataBase.  
	 * @param cRN  - the crn of the course(s) declared as a int data type defined in the CourseDataBase.  
	 * @param theCredits - the number of credits of the course(s) declared as a int data type defined in the CourseDataBase. 
	 * @param room_Number - the room number of the course(s) declared as a String data type defined in the CourseDataBase.  
	 * @param the_instructor - the instructor name of the course(s) declared as a String data type defined in the CourseDataBase. 
	 */
	public CourseDBElement(String courseID, int cRN, int theCredits, String room_Number, String the_instructor)
	{
		this.course_ID = courseID;
		this._CRN = cRN;
		this._Credits = theCredits;
		this._RoomNumber = room_Number;
		this._InstructorName = the_instructor;
	}
	
	/**
	 * Setting the course id of the course(s) in the CourseDataBase 
	 * @param cID - the course id of the course(s) in and out of the CourseDataBase. 
	 */
	public void setCourseId(String cID)
	{
		this.course_ID = cID;
	}
	
	/**
	 * Returning the course id of the course(s) as listed in and out of the CourseDataBase. 
	 * @return course_ID - of the course(s) of in the CourseDataBase. 
	 */
	public String getCourseID()
	{
		return course_ID;
	}
	
	/**
	 * Setting the course CRN number of the course(s) as listed in and out of the CourseDataBase. 
	 * @param crn - the CRN number of the course(s). 
	 */
	public void setCRN(int crn)
	{
		this._CRN = crn;
	}
	
	/**
	 * Returning the crn of the course(s) as listed in and out of the CourseDataBase. 
	 * @return _CRN - the crn of the course(s) of in the CourseDataBase. 
	 */
	public int getCRN()
	{
		return _CRN;
	}
	
	/**
	 * Setting the amount of credits of the course(s) as listed in and out of the CourseDataBase. 
	 * @param credits - the amount of credits of the course(s). 
	 */
	public void setCredits(int credits)
	{
		this._Credits = credits;
	}
	
	/**
	 * Returning the amount of credits of the course(s) in the CourseDataBase. 
	 * @return _Credits - the total credits of the given course(s) in and out of the CourseDataBase. 
	 */
	public int getCredits()
	{
		return _Credits;
	}
	
	/**
	 * Setting the room number of the course(s) in the CourseDataBase. 
	 * @param roomNumber - the room number of the course(s) in and out of the CourseDataBase. 
	 */
	public void setRoomNumber(String roomNumber)
	{
		this._RoomNumber = roomNumber;
	}
	
	/**
	 * Returning the room number of the course(s) in the CourseDataBase 
	 * @return _RoomNumber - the room number of the course(s). 
	 */
	public String getRoomNumber()
	{
		return _RoomNumber;
	}
	
	/**
	 * Setting the name of the instructor of the course(s) in and out of the CourseDataBase.
	 * @param instructorName - the name of the instructor of the course(s). 
	 */
	public void setInstructorName(String instructorName)
	{
		this._InstructorName = instructorName;
	}
	
	/**
	 * Returning the instructor name of the course(s). 
	 * @return _InstructorName - the name of the instructor of the course(s). 
	 */
	public String getInstructorName()
	{
		return _InstructorName;
	}
	
	/**
	 * Returning the comparison between two CRN's of the same course (the element and of the object). 
	 * @return comparethe2Crns - the comparison containing the CRN of the element and the object's CRN's. 
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		
		int currentCRN = this.getCRN();
		int theElementsCRN = element.getCRN();
		int comparethe2Crns = Integer.compare(currentCRN, theElementsCRN);
		return comparethe2Crns;
	
	}
	
	/**
	 * Return the empty string with the CRN of the course and converting it into a hashcode conversion of the CRN. 
	 * @return returnValue - the empty string with the crn of the course(s) and converted into a hashcode conversion. 
	 */
	public int hashCode()
	{
		String returnValue = "";
		return (returnValue+_CRN).hashCode();
		
	}
	
	/**
	 * Returning the toString of the information of the Course(s) with their attributes in and out of the CourseDataBase
	 * which will be the Course id, the crn of the course, the credits of the course, the instructor of the course and the
	 * room number of the course. 
	 * @return theReturn - returns the information of the 5 attributes of the course of in the CourseDataBase. 
	 */
	public String toString()
	{
		String theReturn = "";
		String theCourse = "Course:";
		String theCRN = " CRN:";
		String theCredits_ = " Credits:";
		String theInstructor_ = " Instructor:";
		String theRoom_ = " Room:";
		
		
		
		theReturn = theCourse +course_ID +theCRN+_CRN + theCredits_+_Credits +
				theInstructor_ +_InstructorName + theRoom_ +_RoomNumber;
		
		return theReturn;
		
	}


	


}
