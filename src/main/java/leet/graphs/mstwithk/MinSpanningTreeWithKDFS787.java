package leet.graphs.mstwithk;

import leet.Interfaces.IMinSpanningTreeWithK787;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinSpanningTreeWithKDFS787 implements IMinSpanningTreeWithK787
{
	@Override
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
	{
		List<List<int[]>> adjList = new ArrayList<>();

		for (int i = 0; i < n; i++)
		{
			adjList.add(new LinkedList<>());
		}
		for (int[] flight : flights) adjList.get(flight[0]).add(flight);

		boolean [] visitedCities = new boolean [n];
		visitedCities[src] = true;
		int cheapestPrice = findCheapestPriceInner(adjList, src, dst, k, visitedCities);
		return cheapestPrice == Integer.MAX_VALUE ? -1 : cheapestPrice;
	}

	// need to pass in a set that gets updated as it navigates the tree
	// don't know how to do it properly, run time is too long, up to n ^ k
	private int findCheapestPriceInner(List<List<int[]>> adjList, int src, int dst, int k, boolean [] visitedCities)
	{
		// TODO current run time is n! for a fully connected graph. This is a greedy algo for a dynamic programming problem
		// how to use a dijkstra to solve this?
		if (k == -1) return Integer.MAX_VALUE;

		int minPrice = Integer.MAX_VALUE;
		for (int[] flight : adjList.get(src))
		{
			int flightDest = flight[1];
			if (visitedCities[flightDest]) continue; // don't loop back

			int curMinPrice = 0;
			if (flightDest != dst)
			{
				visitedCities[flightDest] = true;
				curMinPrice = findCheapestPriceInner(adjList, flightDest, dst, k - 1, visitedCities);
				visitedCities[flightDest] = false;
			}
			if (curMinPrice != Integer.MAX_VALUE) curMinPrice += flight[2]; // overflow issue, and flight cost had bugs initially
			if (minPrice > curMinPrice) minPrice = curMinPrice;
		}
		return minPrice;
	}
}
