
/**
 * The Notation Class - utility class will introduce some methods of infixToPostfix to convert infix notation to postfix notation
 * that will take in a string and return a string, a method postfixToInfix to convert postfix notation to infix
 * notation that will take in a string and return a string, and a method to evaluatePostfix to evaluate the postfix
 * expression. It will take in a string and return a double. 
 * @author Herman Mann
 */
public class Notation extends java.lang.Object {
	
	/**
	 * The Notation Utility class's default constructor. 
	 */
	public Notation()
	{
		
	}
	
	public static int prece_dence(char infix)
	{
		while(infix == '+' || infix == '-')
		{
			return 1;
		}
		
		while(infix == '*' || infix == '/')
		{
			return 2;
		}
		
		return -1;
	}
	
	/**
	 * The method of theOperand will take in operands of two different numbers as string representations, and also
	 * an individual character of each of the string's character representation(s) one by one. 
	 * @param firstNum - the first number to get the operand of. 
	 * @param secondNum - the second number to get the operand of. 
	 * @param individualCharacter - each individual character from left to right in the first or second number as first introduced
	 * as String representation will add the resulting character one by one. 
	 * @return - the String represented result of the numbers operanded result, depending on the operator of action. 
	 * @throws InvalidNotationFormatException - if the String represented result of the operand being added is invalid. 
	 */
	public static String theOperand(String firstNum, String secondNum, char individualCharacter) 
			throws InvalidNotationFormatException
	{
		double thReturn = 0.0;
		
		double thefirstDigit = Double.parseDouble(firstNum);
		
		double theSeconddigit = Double.parseDouble(secondNum);
		
		switch(individualCharacter) {
		
		case '*':  return Double.toString(thefirstDigit * theSeconddigit);
				   
		case '/': return Double.toString(thefirstDigit / theSeconddigit);
		           
		case '-':  return Double.toString(thefirstDigit - theSeconddigit);
		           
		case '+':  return Double.toString(theSeconddigit + thefirstDigit);
		           
		default:   break;
		
		}
		return null;
		
	}
	
	
	/**
	 * Evaluates a postfix expression from a string to a double. 
	 * @param postfixExpr - the postfix expression in String format. 
	 * @return - the evaluation of the postfix expression as a double. 
	 * @throws InvalidNotationFormatException - if the postfix expression format is invalid. 
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws 
	InvalidNotationFormatException
	{
		char individualCharacter;
		
		int theStartingElement = 0;
		
		NotationStack<String> theStack = new NotationStack<>();
		
		int k = 0;
		
		while(k < postfixExpr.length())
		{
			individualCharacter = postfixExpr.charAt(k);
			
			while(postfixExpr.charAt(k) == ' ' == true)
			{
				continue;
			}
			
			if((Character.isDigit(individualCharacter) || individualCharacter == '(' ) == true)
			{
		
				theStack.push(Character.toString(individualCharacter));
					
			}
			else if(("+-*/".indexOf(individualCharacter) >= theStartingElement) == true)
			{
				String aEvaluatingthePostFix = theStack.pop().toString();
				
				String bEvaluated = "";
				
				String theResult = "";
				
				if(theStack.isEmpty() == true)
				{
					throw new InvalidNotationFormatException();
				}
				else
				{
					bEvaluated = theStack.pop().toString();
					theResult = theOperand(bEvaluated,aEvaluatingthePostFix,individualCharacter);
					theStack.push(theResult);
					
				}

			}
			
			k++;
		}
		
		while(theStack.size() == 1 == false)
		{
			throw new InvalidNotationFormatException();
		}
	
		return Double.parseDouble(theStack.pop());
	
	}
	
	/**
	 * Evaluates a infix expression from a string to a double. 
	 * @param infixExpr - the infix expression in String format. 
	 * @return - the evaluation of the infix expression as a double. 
	 * @throws InvalidNotationFormatException - if the infix expression format is invalid. 
	 */
	public static double evaluateInfixExpression(String infixExpr) throws
	InvalidNotationFormatException
	{
		String easyFlow = convertInfixToPostfix(infixExpr);
		return evaluatePostfixExpression(easyFlow);
	}
	
	/**
	 * Convert the Postfix expression to the Infix expression. 
	 * @param postfix - the postfix expression in string format. 
	 * @return - the infix expression in string format. 
	 * @throws InvalidNotationFormatException - if the postfix expression format is invalid. 
	 */
	public static String convertPostfixToInfix(String postfix) throws 
	InvalidNotationFormatException
	{
		
		char leftParantheses = '(';
		
		char rightParantheses = ')';
		
		NotationStack <String> bestStack = new NotationStack<String>();
		
		int k = 0; 
		
		while(k < postfix.length())
		{
			char postToIn = postfix.charAt(k);
			
			while(postToIn == ' ')
			{
				continue;
			}
			
		
			if(Character.isDigit(postToIn))
		
			{	
				bestStack.push(Character.toString(postToIn));
			}
			
			else if("+-*/".indexOf(postToIn) >= 0)
			{
				String thePosttoIn = bestStack.pop().toString();
				String d = ""; 
				String addedString = "";
					
				if(bestStack.isEmpty() == true)
				{
					throw new InvalidNotationFormatException();
				}
				else if(bestStack.isEmpty() == false)
				{
			
					d = bestStack.pop().toString();
						
					addedString = leftParantheses + d + postToIn + thePosttoIn + rightParantheses;
				
					bestStack.push(addedString);
					
				}
				
			}
			
			k++;
		}
		  
			if(bestStack.size() == 1 == false)
			{
				throw new InvalidNotationFormatException();
			}
		
		
		return bestStack.pop();
		
		}
	
	/**
	 * Convert an infix expression into a postfix expression. 
	 * @param infix - the infix expression in string format. 
	 * @return - the postfix expression in string format. 
	 * @throws InvalidNotationFormatException - if the infix expression format is invalid. 
	 */
	public static String convertInfixToPostfix(String infix) throws 
	InvalidNotationFormatException
	{

		NotationQueue <String> theQueueList = new NotationQueue<String>();
		
	    NotationStack<String> thStack = new NotationStack<String>();
	    
	    int i = 0;
	    
	    while(i < infix.length())
	    {
	    	char infixToPostFix = infix.charAt(i);
	      
	    	if (infixToPostFix == ' ') 
	    	{
	    		continue;
	    	} 
	    	
	      if (Character.isDigit(infixToPostFix)) 
	      {
	    	  
	        theQueueList.enqueue(Character.toString(infixToPostFix));
	        
	      } 
	      else if (infixToPostFix == '(') 
	      {
	    	  
	        thStack.push(Character.toString(infixToPostFix));
	        
	      } 
	      else if ("+-*/".indexOf(infixToPostFix) >= 0) 
	      {
	    	  
	        while (thStack.isEmpty() == false && (prece_dence(thStack.top().charAt(0)) >= prece_dence(infixToPostFix) == true)) 
	        {
	        	
	          theQueueList.enqueue(thStack.pop());
	          
	        }
	        
	        
	        thStack.push(Character.toString(infixToPostFix));
	        
	      } 
	      
	      else if (infixToPostFix == ')') 
	      {
	    	  
	        char top = thStack.pop().charAt(0);
	        
	       do
	        {
	    	   
	          theQueueList.enqueue(Character.toString(top));
	          
	          if (thStack.isEmpty() == true) 
	          {
	        	  
	            throw new InvalidNotationFormatException();
	            
	          } 
	          else if(thStack.isEmpty() == false)
	          {
	        	  
	            top = thStack.pop().charAt(0);
	            
	          }
	          
	        }while (top == '(' == false);
	        
	       
	      }
	      
	    	 i++;
	    	 
	    }
	    
	    
	    while (!thStack.isEmpty()) 
	    {
	 
	    	String theStackPop = thStack.pop();
	    	theQueueList.enqueue(theStackPop);
	    	
	    }
	    
	    
	    return theQueueList.toString();
		
	}
	
}
