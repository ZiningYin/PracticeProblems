package leet.graphs.mstwithk;

import leet.Interfaces.IMinSpanningTreeWithK787;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// no improvements made
public class MinSpanningTreeWithKBFS implements IMinSpanningTreeWithK787
{
	@Override
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
	{
		int[] shortestPath = new int[n];
		List<List<int[]>> adjList = new ArrayList<>();

		for (int i = 0; i < n; i++)
		{
			shortestPath[i] = Integer.MAX_VALUE;
			adjList.add(new LinkedList<>());
		}
		shortestPath[src] = 0;

		for (int[] flight : flights) adjList.get(flight[0]).add(flight);

		// could not improve the run time after multiple different configurations... Simple is better
		Map<Integer, Integer> cityQueueCur = new HashMap<>();
		Map<Integer, Integer> cityQueueNext = new HashMap<>();
		cityQueueNext.put(src, 0);

		for (int i = 0; i <= k && !cityQueueNext.isEmpty(); i++)
		{
			Map<Integer, Integer> temp = cityQueueCur;
			cityQueueCur = cityQueueNext;
			cityQueueNext = temp;
			for (Map.Entry<Integer, Integer> entry : cityQueueCur.entrySet())
			{
				Integer city = entry.getKey();
				Integer cost = entry.getValue();
				for (int[] flight : adjList.get(city))
				{
					int dest = flight[1];
					int totalCostThroughCur = flight[2] + cost;
					if (shortestPath[dest] <= totalCostThroughCur) continue;

					shortestPath[dest] = totalCostThroughCur;
					cityQueueNext.put(dest, totalCostThroughCur);
				}
			}

			cityQueueCur.clear();
		}

		return shortestPath[dst] == Integer.MAX_VALUE ? -1 : shortestPath[dst];
	}
}
