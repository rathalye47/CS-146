package cs146F20.athalye.project2;

public class BruteForceAlgorithm {
	
	// Uses the Brute Force Algorithm to find the maximum subarray sum along with its arrival day and
	// departure day.
	public FreeLancer findMaxSubarray(int[] days)
	{
		FreeLancer freeLancer = new FreeLancer(0, 0, -1); // FreeLancer object initialized to default values.
		int maxSum = days[0]; // Initializes maxSum to the 1st element.
		
		for (int arriveDay = 0; arriveDay < days.length; arriveDay++)
		{
			int value = 0; // Reset to 0 for every new arriveDay.
			
			for (int departDay = arriveDay; departDay < days.length; departDay++)
			{
				value = value + days[departDay]; // Reuses previous values and calculates the running sum by
												 // adding earnings of different departure days to value.
				
				if (value > maxSum) // Checks if value is greater than maxSum.
				{
					maxSum = value; // maxSum is set to value.
					freeLancer.setMaxSum(maxSum); // Updates the maxSum.
					freeLancer.setArrivingDay(arriveDay); // Updates the arriveDay.
					freeLancer.setDepartingDay(departDay); // Updates the departDay.
				}
			}
		}
		
		return freeLancer; // Contains the maximum subarray sum, arrival day, and departure day.
	}
}
