package cs146F20.athalye.project1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShufflerTester {
	Shuffler shuffler1; // Declares a Shuffler.
	
	@BeforeEach
	void setUp()
	{
		shuffler1 = new Shuffler(); // Initializes the Shuffler.
	}
	
	// Compares two text files: one that I generated and one I was provided to see if they have matching
	// output.
	@Test
	void testOutputFile() throws IOException
	{
		String expectedLine = "";
		shuffler1.readFileData();
		shuffler1.shuffleElements();
		shuffler1.writeOutputFile();
		BufferedReader out = new BufferedReader(new FileReader("data/AthalyeRohanShuffled.txt"));
		BufferedReader in = new BufferedReader(new FileReader("data/Target3.txt"));
		
		while ((expectedLine = in.readLine()) != null)
		{
			String actualLine = out.readLine(); // Reads the lines from the output file I generated.
			assertEquals(expectedLine, actualLine); // Compares the output file I generated with the output
													// file provided.
		}
		
		out.close();
		in.close();
	}
}
