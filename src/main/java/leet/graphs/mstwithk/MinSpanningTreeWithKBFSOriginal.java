package leet.graphs.mstwithk;

import leet.Interfaces.IMinSpanningTreeWithK787;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinSpanningTreeWithKBFSOriginal implements IMinSpanningTreeWithK787
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

		for (int[] flight : flights)
		{
			adjList.get(flight[0]).add(flight);
		}

		Queue<int[]> cityQueue = new LinkedList<>();
		cityQueue.add(new int[]{0, src});
		cityQueue.add(new int[]{0, -1});

		int stops = 0;
		while (!cityQueue.isEmpty())
		{
			int[] cur = cityQueue.poll();
			if (cur[1] == -1)
			{
				if (stops == k) break;
				stops++;
				cityQueue.add(new int[]{0, -1});
				continue;
			}

			int costAccumulated = cur[0];
			for (int[] flight : adjList.get(cur[1]))
			{
				int dest = flight[1];
				int totalCostThroughCur = flight[2] + costAccumulated;
				if (shortestPath[dest] <= totalCostThroughCur) continue;
				shortestPath[dest] = totalCostThroughCur;
				cityQueue.add(new int[]{totalCostThroughCur, dest});
			}
		}

		return shortestPath[dst] == Integer.MAX_VALUE ? -1 : shortestPath[dst];
	}
}
