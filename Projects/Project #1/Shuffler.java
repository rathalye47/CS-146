package cs146F20.athalye.project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Shuffler {
	private String[] numbers;
	
	public Shuffler()
	{
		numbers = new String[7515];
	}
	
	// Reads the ErdosCA.txt file and stores each line in the String array 'numbers'.
	public String[] readFileData() throws IOException
	{
		long startTime = System.nanoTime();
		
		FileReader fr = new FileReader("data/ErdosCA.txt");
		BufferedReader br = new BufferedReader(fr);
		br.readLine(); // Reads the first line of the file.
		String line = null;
		int index = 0;
		
		while((line = br.readLine()) != null) // Skips the first line, which is metadata, and starts reading
											  // from the second line of the file.
		{
			numbers[index] = line; // Puts each line in the String array 'numbers'.
			index++;
		}
		
		fr.close();
		br.close();
		
		long endTime = System.nanoTime();
		long result = endTime - startTime; // Calculates the time to read from the file.
		System.out.println("Time in nanoseconds to read from the file: " + result );
		
		return numbers;
	}
	
	// Uses the Fisher-Yates shuffle algorithm to shuffle the elements in the array.
	public void shuffleElements()
	{
		long startTime = System.nanoTime();
		
		Random r = new Random();
		r.setSeed(20); // Seed value is set to 20.
		
		for (int i = numbers.length - 1; i >= 1; i--)
		{
			int j = r.nextInt(i + 1); // Gets a random integer within 1 <= j <= i.
			
			// The two elements are swapped here.
			String temp = numbers[j]; // Temporary variable used to swap the two elements.
			numbers[j] = numbers[i];
			numbers[i] = temp;
		}
		
		long endTime = System.nanoTime();
		long result = endTime - startTime; // Calculates the time to shuffle the lines.
		System.out.println("Time in nanoseconds to shuffle the lines: " + result );
	}
	
	// Outputs the shuffled array in a file named AthalyeRohanShuffled.txt.
	public void writeOutputFile() throws IOException
	{
		long startTime = System.nanoTime();
		
		FileWriter fw = new FileWriter("data/AthalyeRohanShuffled.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		// Goes through the array and writes each value to the file.
		for (String value : numbers)
		{
			bw.write(value);
			bw.newLine();
		}
		
		bw.close();
		
		long endTime = System.nanoTime();
		long result = endTime - startTime; // Calculates the time to create the output file.
		System.out.println("Time in nanoseconds to create the output file: " + result );
	}
}
