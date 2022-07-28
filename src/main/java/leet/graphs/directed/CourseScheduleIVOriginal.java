package leet.graphs.directed;

import leet.Interfaces.ICourseScheduleIV1462;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleIVOriginal implements ICourseScheduleIV1462
{
	/***
	 * This solution has a O(V*V + E*V) runtime (num queries is less than V*V, so it is ignored)
	 *
	 * There are solutions with a better runtime complexity using adjLists and sets which has a O(E*V) runtime.
	 * However, they require more sophisticated data structs which has much slower access times and require more memory
	 * With a small V (<100), this is a better solution
 	 */

	@Override
	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		boolean [][] adjMatrix = new boolean [numCourses][numCourses];

		for (int [] edge : prerequisites)
		{
			adjMatrix[edge[0]][edge[1]] = true;
		}

		List<Boolean> retBool = new ArrayList<>();

		for (int i=0;i<queries.length;i++)
		{
			int [] query  = queries [i];

			int node = query[0];
			// special mark indicating if this node recorded all its indirect prereqs
			if (!adjMatrix[node][node])
			{
				dfs(adjMatrix, node, numCourses);
			}
			retBool.add(adjMatrix[node][query[1]]);
		}
		return retBool;
	}

	public void dfs(boolean [][] adjMatrix, int node, int numCourses)
	{
		if (adjMatrix[node][node]) return;

		boolean [] deps = adjMatrix[node];
		for (int i=0;i< numCourses; i++)
		{
			if (!deps[i]) continue;

			dfs(adjMatrix, i, numCourses);
			boolean[] childDeps = adjMatrix[i];
			for (int j=0;j< numCourses; j++) deps[j] |= childDeps[j];
		}

		adjMatrix[node][node] = true;
	}
}
