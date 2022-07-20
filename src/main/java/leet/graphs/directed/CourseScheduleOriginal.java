package leet.graphs.directed;

import leet.Interfaces.ICourseSchedule207;

import java.util.LinkedList;
import java.util.List;

//todo implement better solution and check against others
public class CourseScheduleOriginal implements ICourseSchedule207
{
	// cycles on the starting node, cycles on a later node, sharded dependencies between nodes
	// no real edge cases
	@Override
	public boolean canFinish(int numCourses, int[][] prerequisites)
	{
		List<Integer>[] adjList = createAdjList(numCourses, prerequisites);

		boolean[] completableCourses = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++)
		{
			if (!canCompleteCourses(i, adjList, completableCourses, numCourses)) return false;
		}
		return true;
	}

	private boolean canCompleteCourses(int course, List<Integer>[] adjList, boolean[] completableCourses, int height)
	{
		if (completableCourses[course]) return true;
		if (height < 0) return false;
		for (int dep : adjList[course])
		{
			if (!canCompleteCourses(dep, adjList, completableCourses, height - 1)) return false;
		}
		completableCourses[course] = true;
		return true;
	}

	private List<Integer>[] createAdjList(int numCourses, int[][] prerequisites)
	{
		List<Integer>[] adjList = new List[numCourses];
		for (int i = 0; i < numCourses; i++) adjList[i] = new LinkedList<>();

		for (int[] edge : prerequisites)
		{
			adjList[edge[0]].add(edge[1]);
		}
		return adjList;
	}
}
