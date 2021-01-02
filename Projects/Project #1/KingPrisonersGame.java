package cs146F20.athalye.project1;

public class KingPrisonersGame {
	private CircularLinkedList prisonersList;
	
	public KingPrisonersGame()
	{
		prisonersList = new CircularLinkedList();
	}
	
	// Adds the given number of prisoners to the list.
	public void addPrisoners(int numOfPrisoners)
	{
		long startTime = System.nanoTime();
		
		for (int i = 1; i <= numOfPrisoners; i++)
		{
			prisonersList.insert(i);
		}
		
		long endTime = System.nanoTime();
		long result = endTime - startTime; // Calculates the time to create the list.
		System.out.println("Time in nanoseconds to create a list of " + numOfPrisoners + " prisoners: " + result );
	}
	
	// Counts k prisoners down the line, removes the kth prisoner from the list, continues counting k more
	// prisoners and removing every kth prisoner until one prisoner is left. 
	// Returns the data of the last prisoner remaining: this prisoner is granted freedom.
	public int findWinner(int k)
	{
		long startTime = System.nanoTime();
		
		Node currentPrisoner = prisonersList.getHead();
		int count = 0; // A counter to keep track of each increment.
		
		while (prisonersList.getListLength() > 1 && currentPrisoner != null)
		{
			if (count == k) // Signals we have counted k prisoners, meaning we have to remove the kth prisoner.
			{
				prisonersList.delete(currentPrisoner.getData()); // Removes the prisoner from the list.
				currentPrisoner = currentPrisoner.getNext(); // Updates the current prisoner.
				count = 0; // Resets the count back to 0 after we remove the prisoner.
			}
			
			currentPrisoner = currentPrisoner.getNext(); // Updates the current prisoner.
			count++; // Increments the count.
		}
		
		long endTime = System.nanoTime();
		long result = endTime - startTime; // Calculates the time to find the winner.
		System.out.println("Time in nanoseconds to find the winner: " + result );
			
		return currentPrisoner.getData();
	}
}
