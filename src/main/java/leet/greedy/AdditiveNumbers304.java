package leet.greedy;

import leet.Interfaces.IAdditiveNumbers304;

public class AdditiveNumbers304 implements IAdditiveNumbers304
{
	private long innerLoopTime = 0;
	@Override
	public boolean isAdditiveNumber(String num)
	{
		if (num.length() < 3) return false;

		int numMaxLen = num.length() / 2 + 1;
		int firstNumMaxLen = num.charAt(0) == '0' ? 1 : numMaxLen;
		int secondNumMaxEndIndex = (num.length() * 2) / 3 + 1;
		long firstLong = 0;

		for (int i = 0; i < firstNumMaxLen; i++)
		{
			int c = num.charAt(i) - '0';
			firstLong = firstLong * 10 + c;

			long secondLong = 0;
			int endOfJ = (num.charAt(i + 1) == '0') ? i + 2 : Math.min(i + numMaxLen + 1, secondNumMaxEndIndex);
			for (int j = i + 1; j < endOfJ; j++)
			{
				int c2 = num.charAt(j) - '0';
				secondLong = secondLong * 10 + c2;
				if (isAdditiveSeq(firstLong, secondLong, j + 1, num)) return true;
			}
		}
		return false;
	}

	private boolean isAdditiveSeq(long firstLong, long secondLong, int startIndex, String numSeq)
	{
		long start = System.nanoTime();

		try
		{
			int len = numSeq.length();
			int i = startIndex;
			while (i < len)
			{
				long nextLong = firstLong + secondLong;
				char[] nextLongChars = String.valueOf(nextLong).toCharArray();
				for (int j = 0; j < nextLongChars.length; j++, i++)
				{
					if (i == len) return false;
					if (nextLongChars[j] != numSeq.charAt(i)) return false;
				}
				if (i == len) return true;

				firstLong = secondLong;
				secondLong = nextLong;
			}
			return false;
		}
		finally
		{
			this.innerLoopTime += System.nanoTime() - start;
		}
	}

	public long getInnerLoopTime()
	{
		return this.innerLoopTime;
	}

	public void setInnerLoopTime(long innerLoopTime)
	{
		this.innerLoopTime = innerLoopTime;
	}
}
