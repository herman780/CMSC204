import java.util.ArrayList;

/**
 * This is the MorseCodeTree class which is specifically used for the direct conversion of the morse code to english.
 * This class directly relies on a root (the reference to the root of the tree overall). The root is set to null when the 
 * tree is empty. The class uses an external generic based TreeNode class which consists of a reference to the data and a 
 * reference to the left and right child. The overall TreeNode is specifically parameterized as a String, TreeNode as a 
 * result. This class directly uses a direct private member root (the reference to a TreeNode). The MorseCodeTree constructor
 * will call the buildTree method. 
 * @author Herman Mann
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> theRoot; //defining a new root variable of the tree. 
	
	/**
	 * This is a no-arg default constructor for the MorseCodeTree class and calls the buildTree method.
	 * The private member root will be set to null in the constructor since the tree is currently empty. 
	 */
	public MorseCodeTree()
	{
		// The root is set to null when the tree is empty. 
		theRoot = null; 
		
		buildTree();
		
	}

	/**
	 * The method will return a reference to the root.
	 * @return - the reference to root. 
	 */
	public TreeNode<String> getRoot() {
		
		//returning the reference to the root of the tree. 
		return theRoot; 
	}

	/**
	 * Sets the root of the MorseCodeTree.
	 * @param newNode - a TreeNode<T> that will directly be the new root. 
	 */
	public void setRoot(TreeNode<String> newNode) {
		
		// sets the root of the overall MorseCodeTree. 
		theRoot = new TreeNode<String>(newNode); 	
	}


	/**
	 * Adds the element to the correct position in the tree based directly on the code.
	 * This method will call the recursive method addNode.
	 * @param code - the code for the new node to be added, as an example ".-.".
	 * @param letter - the letter for the corresponding code, as an example "r". 
	 * @return - the MorseCodeTree with the brand new directly added. 
	 */
	public MorseCodeTree insert(String code, String letter) {
		
		// adding the element to the right position in the tree specifically based on the code.
		//The method will call the recursive method of addNode. 
		if(theRoot == null == true)
		{
			this.setRoot(new TreeNode<String>(letter));
		}
		else
		{
			addNode(theRoot, code, letter);
		}
		
		return this;
	}

	/**
	 * This method is a recursive method that adds an element to the direct correct position in the tree directly based
	 * on the code. A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. The code ".-" would be stored
	 * as the right child of the left child of the root Algorithm for the recursive method:
	 * 1. if there is only one character.
	 * a. if the character is '.' (dot) store to the left of the current root. 
	 * b. if the character is "-" (dash) store to the right of the current root.
	 * c. return the result.
	 * 2. if there is more than one character.
	 * a. if the first character is '.' (dot) new root becomes the left child.
	 * b. if the first character is "-" (dash) new root becomes the right child.
	 * c. the new node becomes all the remaining characters in the direct code (beyond the first character). 
	 * d. calling the addNode(new root, new code, letter). 
	 * @param TreeNode<String> root - the root of the tree for this specific particular recursive instance of addNode.
	 * @param code - the code for this specific particular recursive instance of addNode.
	 * @param letter - the data of the new TreeNode to be directly added. 
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		String theFirstCharacter = ".";
		String theSecondCharacter = "-";
		char theSingleCharacter = '.';
		int theAfter_Character = 1;
		
		// recursive method, adding each element to the specific correct position in the tree based on the code.
		// A '.' means traverse to the left. A "-" means traverse to the right. 
		if(code.length() == theAfter_Character == true)
		{
			if(code.equals(theFirstCharacter))
			{
				root._theleftChild = new TreeNode<String>(letter);
			}
			else if(code.equals(theSecondCharacter))
			{
				root._therightChild = new TreeNode<String>(letter);
			}
		}
		else if(code.length() > theAfter_Character == true)
		{
			if(code.charAt(0) == theSingleCharacter)
			{
				addNode(root._theleftChild, code.substring(1), letter);
			}
			else
			{
				addNode(root._therightChild, code.substring(1), letter);
			}
		}
		
	}

	/**
	 * The method will fetch the data in the tree directly based on the code.
	 * This method will call the recursive method fetchNode. 
	 * @param code - the code that directly describes the traversals to retrieve the string (letter). 
	 * @return theFetching - the String (letter) that directly corresponds to the code. 
	 */
	public String fetch(String code) {
		
		// fetching the data in the tree based specifically on the code.
		// This method will call the recursive method fetchNode. 
		TreeNode<String> theRoot = getRoot();
		
		String theFetching = fetchNode(theRoot, code);
		
		return theFetching;
		
		
	}

	/**
	 * This is the recursive method that directly fetches the data of the TreeNode that directly corresponds with 
	 * the code. A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. The code ".-" would
	 * fetch the data of the TreeNode stored as the right child of the left child of the root. 
	 * @param TreeNode<String> root - the root of the tree for this specific particular recursive instance of addNode.
	 * @param code - the code for this particular recursive instance of addNode.
	 * @return - the String (letter) corresponding to the code. 
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		
		// this is the recursive method that fetches the data of the TreeNode that specifically corresponds with the code.
		// A '.' means traverse to the left. A "-" means traverse to the right. data will be fetched of the TreeNode stored as
		// the right child of the left child of the root. 
		String theFirstLetter = ".";
		char theFirstCharacter = '.';
		int theAfterCharacter = 1;
		
		if(code.length() == theAfterCharacter == true)
		{
			if(code.equals(theFirstLetter))
			{
				return root._theleftChild._Data;
			}
			else
			{
				return root._therightChild._Data;
			}
		}
		else
		{
			if(code.charAt(0) == theFirstCharacter == true)
			{
				return fetchNode(root._theleftChild, code.substring(1));
			}
			else
			{
				return fetchNode(root._therightChild, code.substring(1));
			}
		}
		
	}

	/**
	 * This operation is not supported in the MorseCodeTree class. 
	 * @param data - the data of node to be deleted. 
	 * @return - the reference to the current tree.
	 * @throws UnsupportedOperationException. 
	 */
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		
		// this operation is not supported in the MorseCodeTree. 
		// must throw a new UnsupportedOperationException. 
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported in the MorseCodeTree class. 
	 * @return - the reference to the current tree.
	 * @throws UnsupportedOperationException. 
	 */
	public MorseCodeTree update() throws UnsupportedOperationException {
		
		// this operation is not supported in the MorseCodeTree.
		// must throw a new UnsupportedOperationException. 
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the MorseCodeTree by directly inserting the nodes of the tree level by level
	 * based on the code. The root will have a value of "" (empty string) level one: insert(".", "e");
	 * insert("-", "t"); level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m");
	 * etc. Look at the tree and the table of codes to letters in the assignment description. 
	 */
	public void buildTree() {
		
		String theEmptyString = "";
		// this method builds the MorseCodeTree by directly inserting the nodes of the tree level by level based on the code.
		// total of 4 levels. Each level contains a set of letters to be converted of the MorseCodeTree. 
		theRoot = new TreeNode<String>(theEmptyString);
		//Level 1
		insert(".", "e");
		insert("-", "t");
		//Level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		//Level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		//Level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order.
	 * Used directly for testing to make sure the tree is built correctly. 
	 * @return correctData - an ArrayList of the items in the linked Tree. 
	 */
	public ArrayList<String> toArrayList() {
		
		// returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order used for testing
		// to make sure the tree is built successfully. 
		ArrayList<String> correctData = new ArrayList<String>();
		LNRoutputTraversal(theRoot, correctData);
		return correctData;
	}

	/**
	 * This is a recursive method to put the contents of the tree in an ArrayList in LNR (Inorder).
	 * @param TreeNode<String> root - the root of the tree for this specific particular recursive instance. 
	 * @param ArrayList<String> list - the ArrayList that will hold the contents of the tree in LNR order. 
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		// this is the recursive method to put the individual elements of the tree in an ArrayList in LNR (Inorder). 
		if(root._theleftChild == null == false)
		{
			LNRoutputTraversal(root._theleftChild, list);
		}
		
		list.add(root._Data);
		
		if(root._therightChild == null == false)
		{
			LNRoutputTraversal(root._therightChild, list);
		}
		
	}
	
	
	

}
