package cs146F20.athalye.project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KingPrisonersGameTester {
	KingPrisonersGame game; // Declares a KingPrisonersGame.

	@BeforeEach
	void setUp() throws Exception {
		game = new KingPrisonersGame(); // Initializes the KingPrisonersGame.
	}

	// Tests upon creation of the linked list to see if the size is initialized and being updated properly
	// and sees if the list is empty or not accordingly.
	@Test
	void testLinkedListCreation() {
		CircularLinkedList prisoners = new CircularLinkedList();
		assertTrue(prisoners.isEmpty()); // Before insertion, the list is empty.
		assertEquals(0, prisoners.getListLength()); // Size of the list is 0.
		prisoners.insert(5);
		assertFalse(prisoners.isEmpty()); // After inserting an element, the list is not empty.
		assertEquals(1,prisoners.getListLength()); // Size of the list is 1.
	}
	
	// All of the below test cases will also print out the time to create the list of prisoners, to delete a 
	// single node, and to find the winner. Since my method to find the winner calls my method to delete a 
	// single node, the time to delete a single node can be printed out multiple times or none at all 
	// depending on the test case.
	
	// Tests for deleting a prisoner every 2 prisoners out of total 6 prisoners.
	@Test
	void testGame1()
	{
		game.addPrisoners(6);
		assertEquals(1, game.findWinner(2));
	}
	
	// Tests for deleting a prisoner every 9 prisoners out of total 1 prisoner.
	@Test
	void testGame2()
	{
		game.addPrisoners(1);
		assertEquals(1, game.findWinner(9));
	}
	
	// Tests for deleting a prisoner every 7 prisoners out of total 7 prisoners.
	@Test
	void testGame3()
	{
		game.addPrisoners(7);
		assertEquals(4, game.findWinner(7));
	}
	
	// Tests for deleting a prisoner every 8 prisoners out of total 12 prisoners.
	@Test
	void testGame4()
	{
		game.addPrisoners(12);
		assertEquals(2, game.findWinner(8));
	}
	
	// Tests for deleting a prisoner every 1 prisoner out of total 5 prisoners.
	@Test
	void testGame5()
	{
		game.addPrisoners(5);
		assertEquals(3, game.findWinner(1));
	}
}
