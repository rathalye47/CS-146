package cs146F20.athalye.project2;

import java.util.Random;

public class RunningTimes {
	
	// Finds the average running time for the Brute Force Algorithm.
	public long bruteForceRunTime(int num)
	{
		BruteForceAlgorithm bruteForce = new BruteForceAlgorithm();
		long startTime = 0; // Start time for the algorithm.
		long endTime = 0; // End time for the algorithm.
		long totalTime = 0; // Total time for the algorithm is endTime - startTime.
		long runTime = 0; // Runtime for the algorithm adds all the totalTimes.
		long averageRunTime = 0; // Average run time for the algorithm.
		
		for (int index = 1; index <= 10; index++)
		{
			int[] randomValues = createRandomArray(num); // Creates a random array of integers of size num.
			startTime = System.nanoTime(); // Starts clock.
			bruteForce.findMaxSubarray(randomValues); // Runs Brute Force Algorithm.
			endTime = System.nanoTime(); // Ends clock.
			totalTime = endTime - startTime; // Calculates elapsed time.
			runTime = runTime + totalTime; // Adds to elapsed time.
		}
		
		averageRunTime = runTime / 10; // Calculates average run time.
		return averageRunTime;
	}
	
	// Finds the average running time for the Divide and Conquer Algorithm.
	public long divideAndConquerRunTime(int num)
	{
		DivideAndConquerAlgorithm divideAndConquer = new DivideAndConquerAlgorithm();
		long startTime = 0; // Start time for the algorithm.
		long endTime = 0; // End time for the algorithm.
		long totalTime = 0; // Total time for the algorithm is endTime - startTime.
		long runTime = 0; // Runtime for the algorithm adds all the totalTimes.
		long averageRunTime = 0; // Average run time for the algorithm.
		
		for (int index = 1; index <= 10; index++)
		{
			int[] randomValues = createRandomArray(num); // Creates a random array of integers of size num.
			startTime = System.nanoTime(); // Starts clock.
			divideAndConquer.findMaxSubarray(randomValues, 0, randomValues.length - 1); // Runs Divide and Conquer Algorithm.
			endTime = System.nanoTime(); // Ends clock.
			totalTime = endTime - startTime; // Calculates elapsed time.
			runTime = runTime + totalTime; // Adds to elapsed time.
		}
		
		averageRunTime = runTime / 10; // Calculates average run time.
		return averageRunTime;
	}
	
	// Finds the average running time for Kadane's Algorithm.
	public long kadaneRunTime(int num)
	{
		KadaneAlgorithm kadane = new KadaneAlgorithm();
		long startTime = 0; // Start time for the algorithm.
		long endTime = 0; // End time for the algorithm.
		long totalTime = 0; // Total time for the algorithm is endTime - startTime.
		long runTime = 0; // Runtime for the algorithm adds all the totalTimes.
		long averageRunTime = 0; // Average run time for the algorithm.
		
		for (int index = 1; index <= 10; index++)
		{
			int[] randomValues = createRandomArray(num); // Creates a random array of integers of size num.
			startTime = System.nanoTime(); // Starts clock.
			kadane.findMaxSubarray(randomValues); // Runs Kadane's Algorithm.
			endTime = System.nanoTime(); // Ends clock.
			totalTime = endTime - startTime; // Calculates elapsed time.
			runTime = runTime + totalTime; // Adds to elapsed time.
		}
		
		averageRunTime = runTime / 10; // Calculates average run time.
		return averageRunTime;
	}
	
	// Creates a random array of integers of size num.
	public int[] createRandomArray(int num)
	{
		int[] values = new int[num]; // Contains random integers generated.
		Random random = new Random(); // Random object initialized.
		
		for (int index = 0; index < num; index++)
		{
			values[index] = random.nextInt(101) - 50; // Generates a random integer from -50 to 50 and stores
													  // it in the values array.
		}
		
		return values;
	}
	
	// Prints the running times for the Brute Force Algorithm for input sizes specified.
	public void printBruteForceRunningTimes()
	{
		// Prints the running times for the Brute Force Algorithm for input sizes 100, 200, 500, 1000, 2000, 5000, and 10000 respectively.
		System.out.println("Running Times for Brute Force Algorithm:");
		System.out.println(bruteForceRunTime(100));
		System.out.println(bruteForceRunTime(200));
		System.out.println(bruteForceRunTime(500));
		System.out.println(bruteForceRunTime(1000));
		System.out.println(bruteForceRunTime(2000));
		System.out.println(bruteForceRunTime(5000));
		System.out.println(bruteForceRunTime(10000));
		
		System.out.println();
	}
	
	// Prints the running times for the Divide and Conquer Algorithm for input sizes specified.
	public void printDivideAndConquerRunningTimes()
	{
		// Prints the running times for the Divide and Conquer Algorithm for input sizes 100, 200, 500, 1000, 2000, 5000, and 10000 respectively.
		System.out.println("Running Times for Divide and Conquer Algorithm:");
		System.out.println(divideAndConquerRunTime(100));
		System.out.println(divideAndConquerRunTime(200));
		System.out.println(divideAndConquerRunTime(500));
		System.out.println(divideAndConquerRunTime(1000));
		System.out.println(divideAndConquerRunTime(2000));
		System.out.println(divideAndConquerRunTime(5000));
		System.out.println(divideAndConquerRunTime(10000));
				
		System.out.println();
	}
	
	// Prints the running times for Kadane's Algorithm for input sizes specified.
	public void printKadaneRunningTimes()
	{
		// Prints the running times for Kadane's Algorithm for input sizes 100, 200, 500, 1000, 2000, 5000, and 10000 respectively.
		System.out.println("Running Times for Kadane's Algorithm:");
		System.out.println(kadaneRunTime(100));
		System.out.println(kadaneRunTime(200));
		System.out.println(kadaneRunTime(500));
		System.out.println(kadaneRunTime(1000));
		System.out.println(kadaneRunTime(2000));
		System.out.println(kadaneRunTime(5000));
		System.out.println(kadaneRunTime(10000));
	}
}
