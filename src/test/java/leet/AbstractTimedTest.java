package leet;

import java.util.function.Consumer;

public abstract class AbstractTimedTest<T>
{
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
		long averageRuntimeFor1 = 0;
		long averageRuntimeFor2 = 0;

		// dry run for initializing entities
		for (int i = 0; i < 10; i++)
		{
			testMethod.accept(solution);
			testMethod.accept(solution2);
		}

		for (int i = 0; i < 10; i++)
		{
			long start = System.nanoTime();
			testMethod.accept(solution);
			averageRuntimeFor1 += System.nanoTime() - start;

			start = System.nanoTime();
			testMethod.accept(solution2);
			averageRuntimeFor2 += System.nanoTime() - start;
		}

		averageRuntimeFor1 /= 10;
		averageRuntimeFor2 /= 10;

		String sb = "Average runtime for " + solution.getClass().getSimpleName() + " is " + averageRuntimeFor1 + "ns.\n" +
				"Average runtime for " + solution2.getClass().getSimpleName() + " is " + averageRuntimeFor2 + "ns.\n" +
				solution.getClass().getSimpleName() + " is faster by " + (averageRuntimeFor2 - averageRuntimeFor1) + "ns.\n";
		System.out.println(sb);
	}

	private long getAverageRuntime(Runnable testMethod, int numIterations)
	{
		// dry run for initializing entities
		testMethod.run();

		long start = System.nanoTime();
		for (int i = 0; i < numIterations; i++)
		{
			testMethod.run();
		}
		return (System.nanoTime() - start) / numIterations;
	}
}
