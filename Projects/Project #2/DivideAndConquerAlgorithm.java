package cs146F20.athalye.project2;

public class DivideAndConquerAlgorithm {
	
	// Uses the Divide and Conquer Algorithm to find the maximum subarray sum along with its arrival day and
	// departure day.
	public FreeLancer findMaxSubarray(int[] days, int low, int high)
	{
		FreeLancer maxLeft = new FreeLancer(0, 0, 0); // Maximum subarray for values in only left half of the array.
		FreeLancer maxRight = new FreeLancer(0, 0, 0); // Maximum subarray for values in only right half of the array.
		FreeLancer maxCross = new FreeLancer(0, 0, 0); // Maximum subarray for values in both halves of the array.
		
		if (high == low) // Base case: only 1 element in the array.
		{
			return new FreeLancer(days[low], low, high);
		}
		
		else
		{
			int mid = (low + high) / 2; // Finds the midpoint of the array.
			maxLeft = findMaxSubarray(days, low, mid); // Case 1: entirely in days[low, mid] which is completely in the left half of the array.
			maxRight = findMaxSubarray(days, mid + 1, high); // Case 2: entirely in days[mid+1, high] which is completely in the right half of the array.
			maxCross = findMaxCrossingSubarray(days, low, mid, high); // Case 3: in both halves where the midpoint is crossed.
		}
		
		// Checks if maxLeft sum is greater than or equal to maxRight sum and maxCross sum.
		if (maxLeft.getMaxSum() >= maxRight.getMaxSum() && maxLeft.getMaxSum() >= maxCross.getMaxSum())
		{
			if (maxLeft.getMaxSum() < 0)
			{
				return new FreeLancer(0, 0, -1); // If maxLeft sum is less than 0, the array has all negative
											     // numbers and no days are selected. The maximum subarray sum
											     // is 0, arrival day is 0, and departure day is -1.
			}
			
			return maxLeft;
		}
		
		// Checks if maxRight sum is greater than or equal to maxLeft sum and maxCross sum.
		else if (maxRight.getMaxSum() >= maxLeft.getMaxSum() && maxRight.getMaxSum() >= maxCross.getMaxSum())
		{
			if (maxRight.getMaxSum() < 0)
			{
				return new FreeLancer(0, 0, -1); // If maxRight sum is less than 0, the array has all negative
			     								 // numbers and no days are selected. The maximum subarray sum
			     								 // is 0, arrival day is 0, and departure day is -1. 
			}
			
			return maxRight;
		}
		
		// maxCross sum is greater than or equal to maxLeft sum and maxRight sum.
		else
		{
			if (maxCross.getMaxSum() < 0)
			{
				return new FreeLancer(0, 0, -1); // If maxCross sum is less than 0, the array has all negative
			     							     // numbers and no days are selected. The maximum subarray sum
			     							     // is 0, arrival day is 0, and departure day is -1.
			}
			
			return maxCross;
		}
	}
	
	// Finds the maximum crossing subarray sum along with its arrival day and departure day.
	public FreeLancer findMaxCrossingSubarray(int[] days, int low, int mid, int high)
	{
		int leftSum = Integer.MIN_VALUE; // Keeps track of the maximum sum on the left side of the array.
		int sum = 0; // Keeps track of the running sum on the left side of the array.
		int maxLeftIndex = -1; // Used to keep track of the arrival day.
		
		for (int i = mid; i >= low; i--) // Left side of mid.
		{
			sum = sum + days[i]; // Adds the values to the sum.
			
			if (sum > leftSum) // Checks if sum is greater than leftSum.
			{
				leftSum = sum; // Sets leftSum to sum.
				maxLeftIndex = i; // Updates arrival day.
			}
		}
		
		int rightSum = Integer.MIN_VALUE; // Keeps track of the maximum sum on the right side of the array.
		sum = 0; // Resets sum to 0 and will keep track of the running sum on the right side of the array.
		int maxRightIndex = -1; // Used to keep track of the departure day.
		
		for (int j = mid + 1; j <= high; j++) // Right side of mid.
		{
			sum = sum + days[j]; // Adds the values to the sum.
			
			if (sum > rightSum) // Checks if sum is greater than rightSum.
			{
				rightSum = sum; // Sets rightSum to sum.
				maxRightIndex = j; // Updates departure day.
			}
		}
		
		// We can add the leftSum and rightSum together to get the maximum crossing subarray sum.
		FreeLancer freeLancer = new FreeLancer((leftSum + rightSum), maxLeftIndex, maxRightIndex);
		return freeLancer;
	}
}
