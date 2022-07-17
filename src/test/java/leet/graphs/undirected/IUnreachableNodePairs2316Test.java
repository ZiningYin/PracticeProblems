package leet.graphs.undirected;

import leet.AbstractTimedTest;
import leet.Interfaces.IUnreachableNodePairs2316;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IUnreachableNodePairs2316Test extends AbstractTimedTest<IUnreachableNodePairs2316>
{
	private static final int PERF_NUM_NODES = 100_000;
	private int[][] perfEdges1;

	@Test
	public void correctnessTest_New()
	{
		correctnessTest(new UnreachableNodePairs());
	}

	@Test
	public void correctnessTest(IUnreachableNodePairs2316 solution)
	{
		assertEquals (0, solution.countPairs(3, new int [][]{{0,1},{0,2},{1,2}}));
	}

	@Test
	public void perfTest()
	{
		compareRunnableMethods(new UnreachableNodePairsOriginal(), new UnreachableNodePairs(), this::testPerformance);
	}

	public void testPerformance(IUnreachableNodePairs2316 solution)
	{
		assertEquals(2_500_000_000L, solution.countPairs(PERF_NUM_NODES, this.perfEdges1));
	}

	@Override
	protected void precomputeForPerfTest()
	{
		super.precomputeForPerfTest();
		this.perfEdges1 = new int[PERF_NUM_NODES][2];
		for (int i = 0; i < PERF_NUM_NODES - 2; i++)
		{
			this.perfEdges1[i] = new int[]{i, i + 2};
		}
	}

	@Override
	protected  void clear()
	{
		super.clear();
		this.perfEdges1 = null;
	}
}
