package leet;

import leet.Interfaces.IMinTimeForBuses2187;

public class MinTimeForBuses implements IMinTimeForBuses2187
{
	@Override
	public long minimumTime(int[] time, int totalTrips)
	{
		double tripsPerTime = 0;
		int maxTripTime = 0;
		for (int t : time)
		{
			if (t > maxTripTime) maxTripTime = t;
			tripsPerTime += 1.0 / (double) t;
		}
		final long minTime = (long) ((double) totalTrips / tripsPerTime);

		// just min max between the remaining trip durations??
		long left = minTime;
		long right = minTime + maxTripTime + 10; // left is inclusive, and right is exclusive. Add a bit of buffer for rounding errors
		while (left < right)
		{
			long newTime = (left + right) / 2;
			if (isEnoughTime(time, newTime, totalTrips))
			{
				right = newTime;
			}
			else
			{
				left = newTime + 1;
			}
		}
		return left;
	}

	boolean isEnoughTime(int[] time, long timeSpent, int totalTrips)
	{
		int numTrips = 0;

		for (int t : time)
		{
			numTrips += timeSpent / t;
			if (numTrips >= totalTrips) return true;
		}
		return false;
	}
}
