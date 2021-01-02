package cs146F20.athalye.project1;

public class CircularLinkedList {
	private Node head;
	private Node tail;
	private int listLength; // Keeps track of the size of the list as we perform list operations.
	
	public CircularLinkedList()
	{
		head = null;
		tail = null;
		listLength = 0;
	}
	
	// Inserts a node with the given data at the end of the list.
	public void insert(int data)
	{
		Node nodeToInsert = new Node(data);

		if (head != null) // The list is not empty.
		{
			tail.setNext(nodeToInsert);
		}
		
		else // The list is empty.
		{
			head = nodeToInsert;
		}
		
		nodeToInsert.setNext(head); // Points back to the head since we have a circular linked list.
		tail = nodeToInsert; 
		listLength++;
	}
	
	// Deletes a node with the given data.
	public void delete(int data)
	{
		long startTime = System.nanoTime();
		
		Node currentNode = head;
		Node previousNode = currentNode; // Keeps track of the previous node in the list.
	
		if (head.getData() == data) // The node we want to delete is at the head.
		{
			while (currentNode.getNext() != head)
			{
				currentNode = currentNode.getNext(); // Updates the current node.
			}
			
			currentNode.setNext(head.getNext());
			head = currentNode.getNext(); // Updates the head.
		}
		
		else
		{
			while (currentNode.getData() != data)
			{
				previousNode = currentNode; // Updates the previous node.
				currentNode = currentNode.getNext(); // Updates the current node.
			}
			
			if (currentNode == tail) // The node we want to delete is at the tail.
			{
				tail = previousNode; // Updates the tail.
			} 
			
			previousNode.setNext(currentNode.getNext());
		}
		
		listLength--;
		
		long endTime = System.nanoTime();
		long result = endTime - startTime; // Calculates the time to delete one single node.
		System.out.println("Time in nanoseconds to delete one single node: " + result );
	}
	
	// Returns the head of the list.
	public Node getHead()
	{
		return head;
	}
	
	// Returns the size of the list.
	public int getListLength() {
		return listLength;
	}
	
	// Determines if the list is empty or not.
	public boolean isEmpty()
	{
		if (listLength == 0)
		{
			return true;
		}
		
		return false;
	}
}
