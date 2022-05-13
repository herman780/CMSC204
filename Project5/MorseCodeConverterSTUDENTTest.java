import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeConverterSTUDENTTest {

	File theCodeFiletoBeTested;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testConvertToEnglishString() {	
		String theFirstConversion =
		MorseCodeConverter.convertToEnglish(".-.. . -... .-. --- -. / .--- .- -- . ... / - .... . / --. --- .- - ");
		assertEquals("lebron james the goat",theFirstConversion);
				
		String theSecondConversion = 
		MorseCodeConverter.convertToEnglish(".-- . / ..-. .-.. -.-- / .-- . / ..-. .-.. -.-- ");
		assertEquals("we fly we fly", theSecondConversion);
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {	
		
		String theFirstTest = "love looks not with the eyes but with the mind";
		getFile("LoveLooksNot.txt");
		String firstFiletoConvertToEnglish = MorseCodeConverter.convertToEnglish(theCodeFiletoBeTested);
		assertEquals(theFirstTest,firstFiletoConvertToEnglish);
		
		String theSecondTest = "how do i love thee let me count the ways";		
		getFile("howDoILoveThee.txt");
		String secondFiletoConvertToEnglish = MorseCodeConverter.convertToEnglish(theCodeFiletoBeTested);
		assertEquals(theSecondTest,secondFiletoConvertToEnglish);

	}

	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser theSecondChooser = new JFileChooser();
		int status_Student_Official;

		theSecondChooser.setDialogTitle("Select Input File - " + in);
		status_Student_Official = theSecondChooser.showOpenDialog(null);

		if(status_Student_Official == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				theCodeFiletoBeTested = theSecondChooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}

