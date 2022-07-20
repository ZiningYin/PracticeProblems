package leet.dynamic;

import leet.Interfaces.ICountGoodNumbers1922;

//todo unit tests
public class CountGoodNumbersOriginal implements ICountGoodNumbers1922
{
	private static final long MOD = 1000000007;

	@Override
	public int countGoodNumbers(long n) {
		if (n < 14)
		{
			long extra = n % 2 == 1 ? 5 : 1;
			return (int) ((long) Math.pow(20, n/2) * extra);
		}

		long curN = 14;
		int curIndex = 0;
		long [] computedVals = new long [48];
		computedVals[0] = 279999993L;
		long finalVal = 1L;

		while (n >= 14)
		{
			if (n > curN * 2)
			{
				curN *= 2;
				curIndex++;
				computedVals[curIndex] = (computedVals[curIndex - 1] * computedVals[curIndex - 1]) % MOD;
			}
			else if (n >= curN)
			{
				n -= curN;
				finalVal = (finalVal * computedVals[curIndex]) % MOD;
			}
			else
			{
				curN /= 2;
				curIndex--;
			}
		}

		long extra = n % 2 == 1 ? 5 : 1;
		return (int) (((long) Math.pow(20, n/2) * extra * finalVal) % MOD);
	}
}
