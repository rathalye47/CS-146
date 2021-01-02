package cs146F20.athalye.project2;

import java.util.ArrayList;

public class AdditionalTestCases {
	private int[] testCase1;
	private int[] testCase2;
	private int[] testCase3;
	private int[] testCase4;
	private int[] testCase5;
	private ArrayList<int[]> dataValues; // Holds all additional test cases.
	
	public AdditionalTestCases()
	{
		testCase1 = new int[]{-2, -3, 4, -1, -2, 1, 5, -3}; // Additional Test Case #1.
		testCase2 = new int[]{-3, -4, -5, -6, -7, -8, -9, -10}; // Additional Test Case #2.
		testCase3 = new int[]{7, 10, -15, 1, 20, -5, 9}; // Additional Test Case #3.
		testCase4 = new int[]{9, 6, 3, 4, 2}; // Additional Test Case #4.
		testCase5 = new int[]{5, -15, 7, -1, 20, -4}; // Additional Test Case #5.
		dataValues = new ArrayList<int[]>();
	}
	
	// Helper method to add test cases to dataValues ArrayList.
	public void addTestCases()
	{
		dataValues.add(testCase1);
		dataValues.add(testCase2);
		dataValues.add(testCase3);
		dataValues.add(testCase4);
		dataValues.add(testCase5);
	}
	
	// Solves each additional test case using the Brute Force Algorithm.
	public ArrayList<FreeLancer> solveBruteForce()
	{
		addTestCases(); // Contains test cases in dataValues.
		ArrayList<FreeLancer> results = new ArrayList<>(); // Contains solutions to all test cases.
		BruteForceAlgorithm bruteForce = new BruteForceAlgorithm();
		
		for (int index = 0; index < dataValues.size(); index++)
		{
			// Solves each test case using the Brute Force Algorithm and adds the solutions to results.
			results.add(bruteForce.findMaxSubarray(dataValues.get(index)));
		}
		
		return results;
	}
	
	// Solves each additional test case using the Divide and Conquer Algorithm.
	public ArrayList<FreeLancer> solveDivideAndConquer()
	{
		addTestCases(); // Contains test cases in dataValues.
		ArrayList<FreeLancer> results = new ArrayList<>(); // Contains solutions to all test cases.
		DivideAndConquerAlgorithm divideAndConquer = new DivideAndConquerAlgorithm();
		
		for (int index = 0; index < dataValues.size(); index++)
		{
			int low = 0; // Low is set to 0.
			int high = dataValues.get(index).length - 1; // High is set to the last element.
			// Solves each test case using the Divide and Conquer Algorithm and adds the solutions to results.
			results.add(divideAndConquer.findMaxSubarray(dataValues.get(index), low, high));
		}
		
		return results;
	}
	
	// Solves each additional test case using Kadane's Algorithm.
	public ArrayList<FreeLancer> solveKadane()
	{
		addTestCases(); // Contains test cases in dataValues.
		ArrayList<FreeLancer> results = new ArrayList<>(); // Contains solutions to all test cases.
		KadaneAlgorithm kadane = new KadaneAlgorithm();
		
		for (int index = 0; index < dataValues.size(); index++)
		{
			// Solves each test case using Kadane's Algorithm and adds the solutions to results.
			results.add(kadane.findMaxSubarray(dataValues.get(index)));
		}
		
		return results;
	}
}
