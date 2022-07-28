package leet.greedy;

import leet.Interfaces.INondecreasingArray665;

public class NondecreasingArrayOriginal implements INondecreasingArray665
{
	// simple greedy algo
	// test cases 1321, 312, 321, 120, 2312
	@Override
	public boolean checkPossibility(int[] nums) {
		if (nums.length <= 2) return true;

		boolean happenedBefore = false;
		if (nums[0] > nums[1])
		{
			nums[0] = -10_000;
			happenedBefore = true;
		}
		int prev = nums[1];

		for (int i=2;i<nums.length;i++)
		{
			if (prev > nums[i])
			{
				if (happenedBefore) return false;
				happenedBefore = true;
				if (nums[i-2] <= nums[i]) // lower the previous value, do not change the current
				{
					// num[i-1] = nums[i-2];
					prev = nums[i];
				}
				// else change current to previous
			}
			else
			{
				prev = nums[i];
			}
		}

		return true;
	}
}
