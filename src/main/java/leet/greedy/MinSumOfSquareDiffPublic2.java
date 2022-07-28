package leet.greedy;

import leet.Interfaces.IMinSumOfSquareDiff2333;

public class MinSumOfSquareDiffPublic2 implements IMinSumOfSquareDiff2333
{
	@Override
	public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
		int n = nums1.length;
		int diff[] = new int[n];

		int max = -1;
		for(int i=0; i<n; i++){
			diff[i] = Math.abs(nums1[i]-nums2[i]);
			max = Math.max(max,diff[i]);
		}
		int freq[]= new int[max+1];
		for(int i=0; i<n; i++){
			freq[diff[i]]++;
		}
		int k = k1+k2;
		for(int i=max; i>0; i--){
			if(freq[i]>0){
				int t = Math.min(k,freq[i]);
				freq[i]-=t;
				freq[i-1]+=t;
				k-=t;
			}
		}



		long sum = 0;
		for(int p=1; p<=max; p++){
			long a = freq[p];
			sum+=a*p*p;
		}

		return sum;
	}
}
