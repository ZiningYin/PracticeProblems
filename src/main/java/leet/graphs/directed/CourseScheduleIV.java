package leet.graphs.directed;

import leet.Interfaces.ICourseScheduleIV1462;

import java.util.List;

// todo complete this class
public class CourseScheduleIV implements ICourseScheduleIV1462
{
	/***
	 * run time complexity is O(E*V). This is because each edge will cause an update about the prereqs of the node
	 */
	@Override
	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries)
	{
		// create adj list of Set<>[]
		// dfs the nodes adj to the node in the query and update them, finally update the node with all courses that it is a prereq of (direct or indirect)
		// mark the node
		// do a lookup for each query
		return null;
	}
}
