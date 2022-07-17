package leet.graphs.undirected;

import leet.Interfaces.IUnreachableNodePairs2316;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class UnreachableNodePairsOriginal implements IUnreachableNodePairs2316
{
	@Override
	public long countPairs(int n, int[][] edges)
	{
		List<List<Integer>> adjList = createAdjListFromUndirectedEdges(n, edges);

		List<Integer> countPerCluster = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		long start = System.nanoTime();

		for (int i = 0; i < n; i++)
		{
			int count = getCountInNewCluster(i, adjList, visited);
			if (count > 0) countPerCluster.add(count);
		}
		System.out.println("Original T2="+(System.nanoTime() - start));
		// final step calculate total
		long remainingNum = n;
		long totalPairs = 0;
		for (Integer count : countPerCluster)
		{
			remainingNum -= count;
			totalPairs += remainingNum * count;
		}
		return totalPairs;
	}

	public static int getCountInNewCluster(int firstNode, List<List<Integer>> adjList, Set<Integer> visited)
	{
		if(visited.contains(firstNode)) return 0;
		visited.add(firstNode);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(firstNode);

		int count = 0;
		while (!queue.isEmpty())
		{
			Integer curNode = queue.poll();
			count++;

			List<Integer> nodeEdges = adjList.get(curNode);
			for (Integer edgeNode : nodeEdges)
			{
				if (visited.contains(edgeNode)) continue;
				visited.add(edgeNode);
				queue.add(edgeNode);
			}
		}
		return count;
	}

	public static List<List<Integer>> createAdjListFromUndirectedEdges(int n, int[][] edges)
	{
		long start = System.nanoTime();
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
		for (int[] edge : edges)
		{
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}
		System.out.println("Original T1="+(System.nanoTime() - start));
		return adjList;
	}
}
