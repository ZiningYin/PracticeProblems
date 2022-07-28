package leet.greedy;

import leet.AbstractTimedTest;
import leet.Interfaces.IMinSumOfSquareDiff2333;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class IMinSumOfSquareDiff2333Test extends AbstractTimedTest<IMinSumOfSquareDiff2333>
{
	private int[] staticInts;
	private int[] inputInts;
	private int[] inputInts2;

	@Override
	protected void precomputeForPerfTest()
	{
		super.precomputeForPerfTest();
		this.staticInts = new int[40000];
		this.inputInts = new int[40000];
		for (int i = 0; i < 40000; i++)
		{
			this.inputInts[i] = i % 829;
		}
		this.inputInts2 = new int[40000];
		for (int i = 0; i < 40000; i++)
		{
			this.inputInts2[i] = (i * 10) % 5573;
		}
	}

	@Override
	protected void clear()
	{
		if (!this.isPrecomputeDone) fail("There are no precomputed values");
		this.isPrecomputeDone = false;
	}

	@RepeatedTest(5)
	public void comparePerf()
	{
		compareRunnableMethods(new MinSumOfSquareDiffOriginal(), new MinSumOfSquareDiff(), this::performanceTest);
	}

	@Test
	public void testPerf()
	{
		precomputeForPerfTest();
		performanceTest(new MinSumOfSquareDiff());
		clear();
	}

	private void performanceTest(IMinSumOfSquareDiff2333 solution)
	{
		assertTrue(0 < solution.minSumSquareDiff(this.inputInts, this.staticInts, 4_000_000, 0));
		assertTrue(0 < solution.minSumSquareDiff(this.inputInts2, this.staticInts, 4_000_000, 0));
	}
}
