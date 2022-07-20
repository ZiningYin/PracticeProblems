package leet.graphs.undirected;

import leet.Interfaces.IUnreachableNodePairs2316;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// todo fix this class so the unit tests pass and fix unit tests
public class UnreachableNodePairs implements IUnreachableNodePairs2316
{
	@Override
	public long countPairs(int n, int[][] edges)
	{
		Collection<Integer>[] adjList = createAdjListFromUndirectedEdges(n, edges);
		List<Integer> countPerCluster = new ArrayList<>();
		boolean[] seen = new boolean[n];
		for (int i = 0; i < n; i++)
		{
			if (seen[i]) continue;
			countPerCluster.add(getCountInNewCluster(i, adjList, seen));
		}

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

	public static int getCountInNewCluster(int firstNode, Collection<Integer>[] adjList, boolean[] seen)
	{
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(firstNode);
		seen[firstNode] = true;

		while (!queue.isEmpty())
		{
			int curNode = queue.poll();
			count++;

			Collection<Integer> nodeEdges = adjList[curNode];
			for (Integer edgeNode : nodeEdges)
			{
				if (seen[edgeNode]) continue;
				seen[edgeNode] = true;
				queue.add(edgeNode);
			}
		}
		return count;
	}

	public static Collection<Integer>[] createAdjListFromUndirectedEdges(int n, int[][] edges)
	{
		LinkedList<Integer>[] adjList = new LinkedList[n];
		for (int i = 0; i < n; i++) adjList[i] = new LinkedList<>();
		for (int[] edge : edges)
		{
			adjList[edge[0]].add(edge[1]);
			adjList[edge[1]].add(edge[0]);
		}

		return adjList;
	}
}
