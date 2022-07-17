package leet.graphs.directed;

import leet.AbstractTimedTest;
import leet.Interfaces.ICourseSchedule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ICourseScheduleTest extends AbstractTimedTest<ICourseSchedule>
{
	@Test
	public void test()
	{
		correctnessTest(new CourseScheduleOriginal());
	}

	public void correctnessTest(ICourseSchedule solution)
	{
		assertFalse(solution.canFinish(4, new int[][]{{0,1},{3,1},{1,3}, {3,2}}));
		assertFalse(solution.canFinish(4, new int[][]{{0,1},{1,2},{2,0}, {3,2}}));
		assertTrue(solution.canFinish(4, new int[][]{{0,1},{1,2},{2,3}, {0,2}}));
	}
}
