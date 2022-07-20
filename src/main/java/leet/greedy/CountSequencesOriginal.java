package leet.greedy;

import leet.Interfaces.ICountSequences2145;

//todo implement tests
public class CountSequencesOriginal implements ICountSequences2145
{
	@Override
	public int numberOfArrays(int[] differences, int lower, int upper) {
		// find max and min
		// find  to account for 1 solution when equal
		// return Math.max(val, 0);
		//
		final int maxDiff = upper - lower;
		int max = 0;
		int min = 0;
		int cur = 0;
		for (int x : differences)
		{
			cur += x;
			if (cur > max)
			{
				max= cur;
				if (max - min > maxDiff) return 0; // this early exist covers possible overflow
			}
			else if (cur < min)
			{
				min = cur;
				if (max - min > maxDiff) return 0;
			}
		}

		return Math.max(maxDiff - max + min + 1, 0);
	}
}
