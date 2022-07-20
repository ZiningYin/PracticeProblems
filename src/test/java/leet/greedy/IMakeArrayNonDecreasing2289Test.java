package leet.greedy;

import leet.AbstractTimedTest;
import leet.Interfaces.IMakeArrayNonDecreasing2289;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IMakeArrayNonDecreasing2289Test extends AbstractTimedTest<IMakeArrayNonDecreasing2289>
{
	@Test
	public void correctnessTest_Original()
	{
		correctnessTest(new MakeArrayNonDecreasingOriginal());
	}

	private void correctnessTest(IMakeArrayNonDecreasing2289 solution)
	{
		assertEquals(0, solution.totalSteps(new int[]{1, 2, 3}));
		assertEquals(1, solution.totalSteps(new int[]{5, 4, 3}));
		assertEquals(3, solution.totalSteps(new int[]{6, 1, 3, 1, 2, 1, 1, 1}));
		assertEquals(5, solution.totalSteps(new int[]{5, 1, 6, 1, 3, 2, 1, 1, 1, 2, 3, 1}));
	}
}
