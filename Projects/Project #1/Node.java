package cs146F20.athalye.project1;

public class Node {
	private int data;
	private Node next;
	
	public Node(int data)
	{
		this.data = data;
		next = null;
	}
	
	// Returns the next node in the list.
	public Node getNext()
	{
		return next;
	}
	
	// Sets the next node in the list to the node given in the parameter.
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	// Returns the data contained in a node.
	public int getData()
	{
		return data;
	}
}
