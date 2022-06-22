package leet.graphs.mstwithk;

import leet.AbstractTimedTest;
import leet.Interfaces.IMinSpanningTreeWithK787;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IMinSpanningTreeWithK787Test extends AbstractTimedTest<IMinSpanningTreeWithK787>
{
	@ParameterizedTest
	@MethodSource("findCheapestPriceSource")
	public void findCheapestPrice(int expected, IMinSpanningTreeWithK787 solution, int n, int[][] arr, int k)
	{
		assertEquals(expected, solution.findCheapestPrice(n, arr, 0, n - 1, k));
	}

	private static Stream<Arguments> findCheapestPriceSource()
	{
		return Stream.of(new MinSpanningTreeWithKBFSOriginal787(), new MinSpanningTreeWithKBFS787(), new MinSpanningTreeWithKDFS787()).flatMap(sol ->
				Stream.of(
						Arguments.of(100, sol, 2, new int[][]{{0, 1, 100}}, 0), // single flight
						Arguments.of(500, sol, 4, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 400}, {2, 3, 100}}, 1), // more expensive path is only option
						Arguments.of(200, sol, 4, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 100}, {2, 3, 100}}, 2), // cheaper path is shorter option
						Arguments.of(300, sol, 4, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 400}, {2, 3, 100}}, 2), // cheaper path is longer
						Arguments.of(300, sol, 4, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 400}, {2, 1, 100}, {2, 0, 100}, {3, 0, 100}, {3, 1, 100}, {3, 2, 100}, {2, 3, 100}}, 3),
						Arguments.of(400, sol, 5, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 3, 100}, {3, 4, 100}, {0, 3, 600}}, 4),

						// no possible path
						Arguments.of(-1, sol, 2, new int[0][0], 1), // no flights at all
						Arguments.of(-1, sol, 4, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 400}, {2, 3, 100}}, 0), // no path with correct number of hops
						Arguments.of(-1, sol, 4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 1, 100}, {2, 0, 100}, {3, 0, 100}, {3, 1, 100}, {3, 2, 100}, {2, 3, 100}}, 1) //
				));
	}

	@RepeatedTest(20)
	public void findCheapestPriceLoadTest2()
	{
		int numCities = 20;
		int[][] flights1 = createLoadTestPaths(System.nanoTime(), numCities, 200);
		IMinSpanningTreeWithK787 sol = new MinSpanningTreeWithKBFS787();
		sol.findCheapestPrice(numCities, flights1, 0, numCities-1, numCities-1);
	}

	@RepeatedTest(10)
	public void findCheapestPriceLoadTest()
	{
		int n = 100;
		int numPaths = 1000;
		int k = 99;
		int[][] flights1 = createLoadTestPaths(10, n, numPaths);
		int[][] flights2 = createLoadTestPaths(35243534L, n, numPaths);
		int[][] flights3 = createLoadTestPaths(748593L, n, numPaths / 2);
		int[][] flights4 = createLoadTestPaths(674893L, n, numPaths / 2);
		int[][] flights5 = createLoadTestPaths(57389423L, n, numPaths * 2);
		int[][] flights6 = createLoadTestPaths(574931L, n, numPaths * 2);

		compareRunnableMethods(new MinSpanningTreeWithKBFS787(), new MinSpanningTreeWithKBFSOriginal787(), sol -> {
			sol.findCheapestPrice(n, flights1, 0, n - 1, k);
			sol.findCheapestPrice(n, flights2, 0, n - 1, k);
			sol.findCheapestPrice(n, flights3, 0, n - 1, k);
			sol.findCheapestPrice(n, flights4, 0, n - 1, k);
			sol.findCheapestPrice(n, flights5, 0, n - 1, k);
			sol.findCheapestPrice(n, flights6, 0, n - 1, k);
		});
	}

	public static void main(String[] args)
	{
		System.exit(0);
	}

	// not designed to build fully connected or almost fully connected graphs
	// designed for semi connected graphs with at most 1/3 max connections.
	private static int[][] createLoadTestPaths(long seed, int numCities, int numPaths)
	{
		int[][] paths = new int[numPaths][3];
		Random generator = new Random(seed);
		int numPathsRemaining = numPaths;

		while (numPathsRemaining > 0)
		{
			for (int i = 0; i < numCities; i++)
			{
				int numPathsForCity = Math.min(numPathsRemaining, generator.nextInt(1 + (2 * numPathsRemaining) / (numCities - i)));
				numPathsForCity = Math.min(numPathsForCity, numCities - 1);

				// todo improve generation for nodes with more than 1/2 possible connections
				boolean[] cities = new boolean[numCities];
				for (int j = 0; j < numPathsForCity; j++)
				{
					int dest = generator.nextInt(numCities);
					if (i == dest || cities[dest])
					{
						j--;
						continue;
					}
					cities[dest] = true;
					paths[numPaths - numPathsRemaining] = new int[]{i, dest, generator.nextInt(1000)};
					numPathsRemaining--;
				}
				if (numPathsRemaining <= 0) break;
			}
		}
		return paths;
	}
}
