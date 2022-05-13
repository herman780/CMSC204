import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CourseDBManager implements the CourseDBManagerInterface. The data manager class lets the user to read the individual
 * courses from a single file or to really enter the specific data by physical use and uses an Alert to print out the database
 * elements that are in the CourseDataBase. The input by user is read from a file or read by from the attributes/text fields and added
 * to the course database structure through the add method. The add method utilizes the CourseDataBaseStructure (CDS) add method.
 * The class, the CourseDataBaseManager is also referred to as a CDM. 
 * @author Herman Mann 
 */
public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure retrievedCDSInfo = new CourseDBStructure(1020);


	/**
	 * The CourseDataBaseManager (CDM) utilizes the CourseDataBaseStructure (CDS) add method to add the textfield
	 * information of the course(s). The course id, the crn of the course, the credits of the course, the room number
	 * of the course, and the instructor of the course will be sent in to the add method to be added and called by the 
	 * CourseDataBaseStructure add method. 
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement theCourseDataBaseElement=new CourseDBElement(id,crn,credits,roomNum,instructor);
		retrievedCDSInfo.add(theCourseDataBaseElement);
		
	}
	
	/**
	 * Returns the individual course's crn number of the course(s) and strictly utilizes the CourseDataBaseStructure get method
	 * to successfully complete the process. 
	 * @return retrievedCDSInfo - returns the crn information of the course(s) while utilizing the CourseDataBaseStructure get method
	 * to do so properly. 
	 */
	@Override
	public CourseDBElement get(int crn) {
		return retrievedCDSInfo.get(crn);

	}
	
	/**
	 * Reads the individual course(s) input files with all of the textfield information of the course(s). 
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner theInput;
		theInput = new Scanner(input);
		String[] theID = null;
		String theCRN = null;
		CourseDBElement theTotal;
		int the_CRN = 0;
		int credits = 0;
		int theTotalCRNofCourse = 1;
		int theTotalCreditsofCourse = 2;
		int theCRN_ = 0;
		int _instructor = 3;
		int r_oom = 4;
		String roomNumber = null;
		String theLine;
		int thetotalTextFields = 5;
		String theSpaceBetween = " ";
		
		while((theInput.hasNextLine() == (true)))
		{
			theLine = theInput.nextLine();
	
			theID = theLine.split(theSpaceBetween,thetotalTextFields);
			
			if(((theID[1] != null == (true))))
			{
				the_CRN = Integer.parseInt(theID[theTotalCRNofCourse]);
			}
			
			if(((theID[2] != null == (true))))
			{
				credits = Integer.parseInt(theID[theTotalCreditsofCourse]);
			}
			
			String element1ofCourseDataBase = theID[theCRN_];
			String element3ofCourseDataBase = theID[_instructor];
			String element5ofCourseDataBase = theID[r_oom];
			theTotal = new CourseDBElement(element1ofCourseDataBase, the_CRN, credits, 
					element3ofCourseDataBase, element5ofCourseDataBase);
					retrievedCDSInfo.add(theTotal);
		}
		
	}

	/**
	 * Utilizes the CourseDataBaseStructure (CDS) showAll method to properly print out every data structure
	 * element of from the arraylist used in the CDS's showAll method. 
	 * @return retrievedCDSInfo - returns the CourseDataBaseStructure (CDS) data base element of the arrayList by utilizing the 
	 * CDS method of showAll successfully. 
	 */
	@Override
	public ArrayList<String> showAll() {
		return retrievedCDSInfo.showAll();
	}
	
}
