package leet.dynamic;

import leet.AbstractTimedTest;
import leet.Interfaces.INumRectForPoint2250;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class INumRectForPoint2250Test extends AbstractTimedTest<INumRectForPoint2250>
{
	@Test
	public void correctnessTest_Original()
	{
		correctnessTest(new NumRectForPointOriginal());
	}
	private void correctnessTest (INumRectForPoint2250 solution)
	{
		Assertions.assertArrayEquals(new int []{2,1}, solution.countRectangles(new int [][]{{1,2},{2,3},{2,5}}, new int [][] {{2,1},{1,4}}));
		Assertions.assertArrayEquals(new int []{6,0,1,0,1,5,4,6,0}, solution.countRectangles(new int [][] {{6,4},{10,2},{5,5},{1,6},{3,2},{9,5},{7,6}},
				new int [][] {{2,1},{2,8},{8,4},{10,8},{5,6},{1,4},{2,4},{2,2},{6,10}}));
	}
}
