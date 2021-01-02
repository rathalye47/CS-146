package cs146F20.athalye.project2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolveAllAlgorithmsTester {
	
	ArrayList<FreeLancer> results; // Declares an ArrayList<FreeLancer>.
	AlgorithmsSolver solver; // Declares an AlgorithmsSolver.
	AdditionalTestCases moreTests; // Declares an AdditionalTestCases.
	RunningTimes runningTimes; // Declares a RunningTimes.
	
	@BeforeEach
	void setUp() throws Exception {
		results = new ArrayList<>(); // Initializes the ArrayList<FreeLancer>.
		solver = new AlgorithmsSolver(); // Initializes the AlgorithmsSolver.
		moreTests = new AdditionalTestCases(); // Initializes the AdditionalTestCases.
		runningTimes = new RunningTimes(); // Initializes the RunningTimes.
	}

	// Tests the Brute Force Algorithm on various test cases from maxSumtest.txt.
	@Test
	void testBruteForceAlgorithmFromDataFile() throws IOException {
		results = solver.solveBruteForce();
		testCasesSolutionsFromDataFile();
	}
	
	// Tests the Divide and Conquer Algorithm on various test cases from maxSumtest.txt.
	@Test
	void testDivideAndConquerAlgorithmFromDataFile() throws IOException {
		results = solver.solveDivideAndConquer();
		testCasesSolutionsFromDataFile();
	}
	
	// Tests Kadane's Algorithm on various test cases from maxSumtest.txt.
	@Test
	void testKadaneAlgorithmFromDataFile() throws IOException {
		results = solver.solveKadane();
		testCasesSolutionsFromDataFile();
	}
	
	// Tests the Brute Force Algorithm on various additional test cases.
	@Test
	void testBruteForceAlgorithmAdditionalCases()
	{
		results = moreTests.solveBruteForce();
		testAdditionalCasesSolutions();
	}
	
	// Tests the Divide and Conquer Algorithm on various additional test cases.
	@Test
	void testDivideAndConquerAlgorithmAdditionalCases()
	{
		results = moreTests.solveDivideAndConquer();
		testAdditionalCasesSolutions();
	}
	
	// Tests Kadane's Algorithm on various additional test cases.
	@Test
	void testKadaneAlgorithmAdditionalCases()
	{
		results = moreTests.solveKadane();
		testAdditionalCasesSolutions();
	}
	
	// Prints the running times for all 3 algorithms for various input sizes.
	@Test
	void printRunningTimes()
	{
		runningTimes.printBruteForceRunningTimes();
		runningTimes.printDivideAndConquerRunningTimes();
		runningTimes.printKadaneRunningTimes();
	}
	
	// Lists solutions for all test cases from maxSumtest.txt.
	void testCasesSolutionsFromDataFile()
	{
		// Solution for Test Case #1 from maxSumtest.txt.
		assertEquals(239, results.get(0).getMaxSum());
		assertEquals(77, results.get(0).getArrivingDay());
		assertEquals(97, results.get(0).getDepartingDay());
		
		// Solution for Test Case #2 from maxSumtest.txt.
		assertEquals(322, results.get(1).getMaxSum());
		assertEquals(50, results.get(1).getArrivingDay());
		assertEquals(99, results.get(1).getDepartingDay());
		
		// Solution for Test Case #3 from maxSumtest.txt.
		assertEquals(305, results.get(2).getMaxSum());
		assertEquals(17, results.get(2).getArrivingDay());
		assertEquals(39, results.get(2).getDepartingDay());
		
		// Solution for Test Case #4 from maxSumtest.txt.
		assertEquals(271, results.get(3).getMaxSum());
		assertEquals(60, results.get(3).getArrivingDay());
		assertEquals(98, results.get(3).getDepartingDay());
		
		// Solution for Test Case #5 from maxSumtest.txt.
		assertEquals(281, results.get(4).getMaxSum());
		assertEquals(54, results.get(4).getArrivingDay());
		assertEquals(77, results.get(4).getDepartingDay());
		
		// Solution for Test Case #6 from maxSumtest.txt.
		assertEquals(215, results.get(5).getMaxSum());
		assertEquals(64, results.get(5).getArrivingDay());
		assertEquals(99, results.get(5).getDepartingDay());
		
		// Solution for Test Case #7 from maxSumtest.txt.
		assertEquals(207, results.get(6).getMaxSum());
		assertEquals(38, results.get(6).getArrivingDay());
		assertEquals(86, results.get(6).getDepartingDay());
		
		// Solution for Test Case #8 from maxSumtest.txt.
		assertEquals(309, results.get(7).getMaxSum());
		assertEquals(3, results.get(7).getArrivingDay());
		assertEquals(48, results.get(7).getDepartingDay());
		
		// Solution for Test Case #9 from maxSumtest.txt.
		assertEquals(195, results.get(8).getMaxSum());
		assertEquals(34, results.get(8).getArrivingDay());
		assertEquals(58, results.get(8).getDepartingDay());
		
		// Solution for Test Case #10 from maxSumtest.txt.
		assertEquals(390, results.get(9).getMaxSum());
		assertEquals(4, results.get(9).getArrivingDay());
		assertEquals(45, results.get(9).getDepartingDay());
	}
	
	// Lists solutions for all additional test cases.
	void testAdditionalCasesSolutions()
	{
		// Solution for additional Test Case #1.
		assertEquals(7, results.get(0).getMaxSum());
		assertEquals(2, results.get(0).getArrivingDay());
		assertEquals(6, results.get(0).getDepartingDay());
		
		// Solution for additional Test Case #2.
		assertEquals(0, results.get(1).getMaxSum());
		assertEquals(0, results.get(1).getArrivingDay());
		assertEquals(-1, results.get(1).getDepartingDay());
		
		// Solution for additional Test Case #3.
		assertEquals(27, results.get(2).getMaxSum());
		assertEquals(0, results.get(2).getArrivingDay());
		assertEquals(6, results.get(2).getDepartingDay());
		
		// Solution for additional Test Case #4.
		assertEquals(24, results.get(3).getMaxSum());
		assertEquals(0, results.get(3).getArrivingDay());
		assertEquals(4, results.get(3).getDepartingDay());
		
		// Solution for additional Test Case #5.
		assertEquals(26, results.get(4).getMaxSum());
		assertEquals(2, results.get(4).getArrivingDay());
		assertEquals(4, results.get(4).getDepartingDay());
	}
}
