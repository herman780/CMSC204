/**
 * This is a generic class specifically used in the MorseCodeTree classes overall. This specific class
 * consists of a reference to the data and a reference to the left and right child. This is also the
 * external Tree Node for the Linked Trees as a whole. 
 * @author Herman Mann 
 * @param <T> - data type of TreeNode. 
 */
public class TreeNode<T> extends java.lang.Object {
	
	protected TreeNode<T> _theleftChild;
	protected TreeNode<T> _therightChild;
	protected T _Data;
	protected TreeNode<T> theNode;
	
	/**
	 * Creates a new TreeNode with the left and right child being set to null and the overall data
	 * set to the dataNode. 
	 * @param dataNode - the data to be stored in the TreeNode. 
	 */
	public TreeNode(T dataNode)
	{
		_theleftChild = null;
		_therightChild = null;
		_Data = dataNode;
	}
	
	/**
	 * This is used directly for making deep copies.
	 * @param node - the node to make a copy of. 
	 */
	public TreeNode(TreeNode<T> node)
	{
		_theleftChild = node._theleftChild;
		_therightChild = node._therightChild;
		_Data = node._Data;
	}
	
	/**
	 * Returns the data within this TreeNode.
	 * @return - the data within the TreeNode. 
	 */
	public T getData()
	{
		return _Data;
	}

}
