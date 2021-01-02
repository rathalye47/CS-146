package cs146F20.athalye.project2;

public class FreeLancer {
	
	private int maxSum; // Maximum subarray sum.
	private int arrivingDay; // Day of arrival.
	private int departingDay; // Day of departure.
	
	public FreeLancer(int maximumSum, int arriveDay, int departDay)
	{
		this.maxSum = maximumSum;
		this.arrivingDay = arriveDay;
		this.departingDay = departDay;
	}
	
	// Returns the maximum sum.
	public int getMaxSum()
	{
		return this.maxSum;
	}
	
	// Sets the maximum sum to a new maximum sum.
	public void setMaxSum(int max)
	{
		this.maxSum = max;
	}
	
	// Returns the day of arrival.
	public int getArrivingDay()
	{
		return this.arrivingDay;
	}
	
	// Sets the day of arrival to a new day of arrival.
	public void setArrivingDay(int arrive)
	{
		this.arrivingDay = arrive;
	}
	
	// Returns the day of departure.
	public int getDepartingDay()
	{
		return this.departingDay;
	}
	
	// Sets the day of departure to a new day of departure.
	public void setDepartingDay(int depart)
	{
		this.departingDay = depart;
	}
	
	// A toString() method for anyone to easily read the maximum subarray sum, arrival day, and departure day.
	public String toString()
	{
		return "The maximum subarray sum is " + this.maxSum + " that arrives on day " + this.arrivingDay + " and departs on day " + this.departingDay + ".";
	}
}
