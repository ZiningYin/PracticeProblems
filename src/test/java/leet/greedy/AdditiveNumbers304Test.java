package leet.greedy;

import leet.AbstractTimedTest;
import leet.Interfaces.IAdditiveNumbers304;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdditiveNumbers304Test extends AbstractTimedTest<IAdditiveNumbers304>
{
	//todo make this a parameterized test
	@Test
	public void isAdditiveNumber_AdditiveNumbers()
	{
		AdditiveNumbers304 sol = new AdditiveNumbers304();
		isAdditiveNumber(sol);
		sol.setInnerLoopTime(0L);
		long start = System.nanoTime();
		isAdditiveNumber(sol);
		System.out.println("TotalTime="+(System.nanoTime() - start));
		// timeRunnableMethod(sol, this::isAdditiveNumber);
		System.out.println("AdditiveNumbers Inner Loop Runtime=" + sol.getInnerLoopTime() + "ns");
	}

	@Test
	public void isAdditiveNumber_ZeroHandling_AdditiveNumbers()
	{
		this.isAdditiveNumber_ZeroHandling(new AdditiveNumbers304());
	}

	public void isAdditiveNumber(IAdditiveNumbers304 solution)
	{
		assertFalse(solution.isAdditiveNumber("0"));
		assertFalse(solution.isAdditiveNumber("12"));
		assertTrue(solution.isAdditiveNumber("123"));
		assertTrue(solution.isAdditiveNumber("10212"));
		assertTrue(solution.isAdditiveNumber("199100"));

		assertTrue(solution.isAdditiveNumber("12358"));
		assertTrue(solution.isAdditiveNumber("199100199"));
		assertFalse(solution.isAdditiveNumber("199100199299499"));
		assertTrue(solution.isAdditiveNumber("1111222233335555888814443"));
	}

	public void isAdditiveNumber_ZeroHandling(IAdditiveNumbers304 solution)
	{
		assertFalse(solution.isAdditiveNumber("0235"));
		assertFalse(solution.isAdditiveNumber("2024"));
		assertFalse(solution.isAdditiveNumber("2035"));
		assertFalse(solution.isAdditiveNumber("2305"));
		assertTrue(solution.isAdditiveNumber("0224"));
	}
}
