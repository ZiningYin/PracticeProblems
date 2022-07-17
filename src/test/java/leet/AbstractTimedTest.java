package leet;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.fail;

public abstract class AbstractTimedTest<T>
{
	protected boolean isPrecomputeDone = false;

	public void timeRunnableMethod(T solution, Consumer<T> testMethod)
	{
		// dry run for initializing entities
		testMethod.accept(solution);

		long start = System.nanoTime();
		testMethod.accept(solution);
		System.out.println("Test class is " + solution.getClass().getSimpleName() + ". Runtime=" + (System.nanoTime() - start) + "ns");
	}

	public void compareRunnableMethods(T solution, T solution2, Consumer<T> testMethod)
	{
		long totalRuntimeFor1 = getRuntime(solution, testMethod, 5);
		long totalRuntimeFor2 = getRuntime(solution2, testMethod, 5);
		totalRuntimeFor1 += getRuntime(solution, testMethod, 5);
		totalRuntimeFor2 += getRuntime(solution2, testMethod, 5);

		totalRuntimeFor1 /= 10;
		totalRuntimeFor2 /= 10;

		String sb = "Average runtime for " + solution.getClass().getSimpleName() + " is " + totalRuntimeFor1 + "ns.\n" +
				"Average runtime for " + solution2.getClass().getSimpleName() + " is " + totalRuntimeFor2 + "ns.\n" +
				solution.getClass().getSimpleName() + " is faster by " + (totalRuntimeFor2 - totalRuntimeFor1) + "ns.\n";
		System.out.println(sb);
	}

	private long getRuntime(T solution, Consumer<T> testMethod, int numRuns)
	{
		long totalRuntime = 0;
		for (int i = 0; i < 5; i++)
		{
			precomputeForPerfTest();
			testMethod.accept(solution);
			clear();
		}

		for (int i = 0; i < numRuns; i++)
		{
			precomputeForPerfTest();
			long start = System.nanoTime();
			testMethod.accept(solution);
			totalRuntime += System.nanoTime() - start;
			clear();
		}
		return totalRuntime;
	}

	protected void precomputeForPerfTest()
	{
		if (this.isPrecomputeDone) fail("Precomputed values was not cleared");
		this.isPrecomputeDone = true;
	}

	protected void clear()
	{
		if (!this.isPrecomputeDone) fail("There are no precomputed values");
		this.isPrecomputeDone = false;
	}
}
