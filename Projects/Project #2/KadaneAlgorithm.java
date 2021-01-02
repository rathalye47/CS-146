package cs146F20.athalye.project2;

public class KadaneAlgorithm {
	
	// Uses Kadane's Algorithm to find the maximum subarray sum along with its arrival day and
	// departure day.
	public FreeLancer findMaxSubarray(int[] days)
	{
		int maxSum = 0; // Keeps the best positive contiguous summations.
		int maxTempSum = 0; // Keeps only positive contiguous summations that we compute by adding one element at a time.
		int arriveDay = -1; // Keeps track of the arrival day.
		int departDay = -1; // Keeps track of the departure day.
		int tempArriveDay = 0; // Keeps track of the temporary arrival day.
		
		for (int i = 0; i < days.length; i++)
		{
			maxTempSum = maxTempSum + days[i]; // Adds values in the array to maxTempSum.
			
			if (maxTempSum < 0) // Checks if maxTempSum is less than 0.
			{
				maxTempSum = 0; // Resets maxTempSum to 0.
				arriveDay = i + 1;  // Next day is the arrival since i-th day is not included.
			}
			
			if (maxSum < maxTempSum) // Checks if maxSum is less than maxTempSum.
			{
				maxSum = maxTempSum; // Sets maxSum to maxTempSum.
				departDay = i; // Sets departDay to the current index.
				tempArriveDay = arriveDay; // Sets tempArriveDay to arriveDay.
			}
		}
		
		arriveDay = tempArriveDay; // Sets arriveDay to tempArriveDay.
		
		if (arriveDay < 0)
		{
			arriveDay = 0; // If arriveDay is less than 0, set arriveDay to 0.
		}
		
		FreeLancer freeLancer = new FreeLancer(maxSum, arriveDay, departDay);
		return freeLancer;
	}
}
