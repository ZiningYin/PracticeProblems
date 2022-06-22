package leet;

import leet.Interfaces.IMinTimeForBuses2187;

public class MinTimeForBusesOriginal implements IMinTimeForBuses2187
{
	@Override
	public long minimumTime(int[] time, int totalTrips)
	{
		final long minTime = getMinTime(time, totalTrips);

		int tripsDone = 0;
		int minRemaining = Integer.MAX_VALUE;
		int maxRemaining = 0;

		for (int i = 0; i < time.length; i++)
		{
			int timePerTrip = time[i];
			tripsDone += minTime / timePerTrip;
			int remaining = (int) (timePerTrip - (minTime % timePerTrip));
			if (remaining > maxRemaining) maxRemaining = remaining;
			if (remaining < minRemaining) minRemaining = remaining;
		}

		if (totalTrips <= tripsDone) return minTime;

		// just min max between the remaining trip durations??
		long left = minTime + minRemaining, right = minTime + maxRemaining; // left is inclusive, and right is exclusive
		while (left < right)
		{
			long newTime = (left + right) / 2;

			int newTripsDone = getNumTrips(time, newTime);
			if (totalTrips > newTripsDone)
			{
				left = newTime + 1;
			}
			else
			{
				right = newTime;
			}
		}
		return left;
	}

	long getMinTime(int[] time, int totalTrips)
	{
		double tripsPerTime = 0;
		for (int t : time)
		{
			tripsPerTime += 1.0 / (double) t;
		}
		return (long) ((double) totalTrips / tripsPerTime);
	}

	int getNumTrips(int[] time, long timeSpent)
	{
		int numTrips = 0;

		for (int t : time)
		{
			numTrips += timeSpent / t;
		}
		return numTrips;
	}
}
