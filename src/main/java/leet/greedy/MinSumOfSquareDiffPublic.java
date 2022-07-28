package leet.greedy;

import leet.Interfaces.IMinSumOfSquareDiff2333;

public class MinSumOfSquareDiffPublic implements IMinSumOfSquareDiff2333
{
	@Override
	public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
		int n = 100000;
		int[] count = new int[n + 1];
		for(int i = 0 ; i < nums1.length ; i++){
			count[Math.abs(nums1[i] - nums2[i])]++;
		}
		int operations = k1 + k2;
		for(int diff = n ; diff > 0 ; diff--){
			if(count[diff] == 0) continue;
			else if(count[diff] <= operations){
				count[diff - 1] += count[diff];
				operations -= count[diff];
				count[diff] = 0;
			}else{
				count[diff - 1] += operations;
				count[diff] -= operations;
				operations = 0;
				break;
			}
		}
		long ans = 0;
		for(int i = 0 ; i < count.length ; i++){
			if(count[i] != 0) ans += (long) i * i * count[i];
		}
		return ans;
	}
}
