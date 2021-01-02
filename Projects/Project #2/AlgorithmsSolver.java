package cs146F20.athalye.project2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AlgorithmsSolver {
	
	private ArrayList<int[]> allTestCases; // Contains all the test cases from maxSumtest.txt.
	
	public AlgorithmsSolver() throws IOException
	{
		allTestCases = readFileData(); 
	}
	
	// Reads the data from maxSumtest.txt into an ArrayList<int[]> where the first 100 integers on a line 
	// are put into an array of integers. Each array of integers corresponds to an element in the ArrayList.
	public ArrayList<int[]> readFileData() throws IOException
	{
		ArrayList<int[]> dataValues = new ArrayList<>(); // Stores data from the file.
		BufferedReader bReader = new BufferedReader(new FileReader("data/maxSumtest.txt")); // Creation of BufferedReader to read the file data.
		String currentLine; // Current line in the file.
		
		while ((currentLine = bReader.readLine()) != null) // Reads each line from maxSumtest.txt.
		{
			int[] numbers = new int[100]; // Creates an array of integers with size 100.
			String[] values = new String[100]; // Creates an array of Strings with size 100.
			
			values = currentLine.trim().split("\\s+"); // Stores each integer in the line in a String array
													   // with any white space removed.
			
			int index = 0;
			while (index < numbers.length)
			{
				int result = Integer.parseInt(values[index]); // Converts each String element in the values array to an integer.
				numbers[index] = result; // Stores each integer result in the numbers array.
				index++; // Increments the index.
			}
			
			dataValues.add(numbers); // Adds each integer array of size 100 to the dataValues ArrayList.
			bReader.readLine(); // Skips over the empty lines in maxSumtest.txt.
		}
		
		bReader.close();
		
		return dataValues;
	}
	
	// Solves each test case in maxSumtest.txt using the Brute Force Algorithm.
	public ArrayList<FreeLancer> solveBruteForce() throws IOException
	{
		ArrayList<FreeLancer> allResults = new ArrayList<>(); // Holds solutions to all test cases.
		BruteForceAlgorithm bruteForce = new BruteForceAlgorithm();
		
		for (int index = 0; index < allTestCases.size(); index++)
		{
			// Solves each test case using the Brute Force Algorithm and adds the solutions to allResults.
			allResults.add(bruteForce.findMaxSubarray(allTestCases.get(index)));
		}
		
		return allResults;
	}
	
	// Solves each test case in maxSumtest.txt using the Divide and Conquer Algorithm.
	public ArrayList<FreeLancer> solveDivideAndConquer() throws IOException
	{
		ArrayList<FreeLancer> allResults = new ArrayList<>(); // Holds solutions to all test cases.
		DivideAndConquerAlgorithm divideAndConquer = new DivideAndConquerAlgorithm();
		
		for (int index = 0; index < allTestCases.size(); index++)
		{
			int low = 0; // Low is set to 0.
			int high = allTestCases.get(index).length - 1; // High is set to the last element.
			// Solves each test case using the Divide and Conquer Algorithm and adds the solutions to allResults.
			allResults.add(divideAndConquer.findMaxSubarray(allTestCases.get(index), low, high));
		}
		
		return allResults;
	}
	
	// Solves each test case in maxSumtest.txt using Kadane's Algorithm.
	public ArrayList<FreeLancer> solveKadane() throws IOException
	{
		ArrayList<FreeLancer> allResults = new ArrayList<>(); // Holds solutions to all test cases.
		KadaneAlgorithm kadane = new KadaneAlgorithm();
		
		for (int index = 0; index < allTestCases.size(); index++)
		{
			// Solves each test case using Kadane's Algorithm and adds the solutions to allResults.
			allResults.add(kadane.findMaxSubarray(allTestCases.get(index)));
		}
		
		return allResults;
	}
}
