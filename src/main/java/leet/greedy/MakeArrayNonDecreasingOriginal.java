package leet.greedy;

import leet.Interfaces.IMakeArrayNonDecreasing2289;

// todo consider improvements
public class MakeArrayNonDecreasingOriginal implements IMakeArrayNonDecreasing2289
{
	@Override
	public int totalSteps(int[] nums) {
		if (nums.length == 1) return 0;

		int maxCount = 0;
		int index = 0;
		while (index != -1)
		{
			int[] output = getNumSteps(nums, index);
			index = output[0];
			maxCount = Math.max (maxCount, output[1]);
		}

		return maxCount;
	}

	// int[] is the return values of nextIndex Count
	public int[] getNumSteps (int[] nums, int index)
	{
		if (index + 1 >= nums.length) return new int [] {-1, 0};
		if (nums[index + 1] >= nums[index]) return new int [] {index + 1, 0};

		int count = 1;
		int prev = nums[index + 1];
		int localMax = nums[index];

		for (index += 2; index< nums.length; index++)
		{
			int cur = nums[index];
			if (prev <= cur)
			{
				if (localMax <= cur) return new int [] {index, count};

				count++;
				int [] ret = getNumSteps (nums, index);
				count = Math.max(ret[1], count);

				if (ret[0] == -1) break;
				index = ret[0] - 1;
				cur = nums[index];
			}
			prev = cur;
		}

		return  new int [] {-1, count};
	}
}
