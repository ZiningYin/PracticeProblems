package leet.greedy;

import leet.Interfaces.IMinSumOfSquareDiff2333;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MinSumOfSquareDiff implements IMinSumOfSquareDiff2333
{
	@Override
	public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2)
	{
		long totalMoves = k1 + k2;// 2*10^9 total, no overflow
		long totalDiff = 0;

		long start = System.nanoTime();
		TreeMap<Integer, Integer> countMap = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < nums1.length; i++)
		{
			int diff = Math.abs(nums2[i] - nums1[i]);
			countMap.compute(diff, (k,v) -> v == null ? 1 : v + 1);
		}
		System.out.println("Time1=" + (System.nanoTime() - start));

		start = System.nanoTime();
		Map.Entry<Integer, Integer> firstEntry = countMap.firstEntry();
		long highestDiff = firstEntry.getKey();
		long numPairs = firstEntry.getValue();

		for (Map.Entry<Integer, Integer> entry : countMap.entrySet())
		{
			if (totalMoves > 0)
			{
				if (highestDiff == entry.getKey()) continue; // the first value, an iterator is better than this check

				long cost = numPairs * (highestDiff - entry.getKey());
				if (cost < totalMoves)
				{
					totalMoves -= cost;
					highestDiff = entry.getKey();
					numPairs += entry.getValue();
				}
				else
				{
					highestDiff -= totalMoves / numPairs;
					long secondDiff = highestDiff - 1;
					long numInSecond = totalMoves % numPairs;
					numPairs -= numInSecond;
					totalDiff = numInSecond * secondDiff * secondDiff + numPairs * highestDiff * highestDiff;
					totalMoves = 0;

					totalDiff += (long) entry.getKey() * (long) entry.getKey() * (long) entry.getValue();
				}
			}
			else
			{
				totalDiff += (long) entry.getKey() * (long) entry.getKey() * (long) entry.getValue();
			}
		}

		if (totalMoves > 0)
		{
			highestDiff -= totalMoves / numPairs;
			if (highestDiff <= 0) return 0;

			long secondDiff = highestDiff - 1;
			long numInSecond = totalMoves % numPairs;
			numPairs -= numInSecond;
			totalDiff = numInSecond * secondDiff * secondDiff + numPairs * highestDiff * highestDiff;
			totalMoves = 0;
		}

		System.out.println("Time2=" + (System.nanoTime() - start));

		return totalDiff;
	}
}
