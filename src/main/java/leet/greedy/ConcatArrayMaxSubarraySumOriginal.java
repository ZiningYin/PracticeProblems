package leet.greedy;

import leet.Interfaces.IConcatArrayMaxSubarraySum1191;

public class ConcatArrayMaxSubarraySumOriginal implements IConcatArrayMaxSubarraySum1191
{
	// Possible scenarios:
	// 1. max sub arr is in the single array
	// 2. the max from left and right could compose the max subarray,
	// 3. the max sub array is a sandwich of all the arrays in the middle plus the max from left and max from right
	@Override
	public int kConcatenationMaxSum(int[] arr, int k) {
		// max from left, max from right, array total (don't use if less than 0)
		int maxFromLeft = -1_000_000;
		int maxFromRight = -1_000_000;
		int maxSubArrSum = 0;

		int sum = 0;
		int subArrSum = 0;
		for (int j : arr)
		{
			sum += j;
			if (sum > maxFromLeft) maxFromLeft = sum;

			subArrSum += j;
			if (subArrSum < 0) subArrSum = 0;
			else if (subArrSum > maxSubArrSum) maxSubArrSum = subArrSum;
		}

		if (k == 1 || maxFromLeft <= 0) return maxSubArrSum;

		sum = 0;
		for (int i=arr.length-1; i>=0; i-- )
		{
			sum += arr[i];
			if (sum > maxFromRight) maxFromRight = sum;
		}

		// if this is true, the sum is <= 0 also
		if (maxFromRight <= 0) return maxSubArrSum;

		long maxConSubArray = maxFromLeft + maxFromRight;
		if (sum > 0) maxConSubArray +=(long)sum * (long)(k-2);
		if (maxConSubArray > maxSubArrSum) return (int)(maxConSubArray%MOD);
		else return maxSubArrSum;
	}
}
