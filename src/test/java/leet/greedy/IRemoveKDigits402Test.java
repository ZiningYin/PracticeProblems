package leet.greedy;

import leet.AbstractTimedTest;
import leet.Interfaces.IRemoveKDigits402;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class IRemoveKDigits402Test extends AbstractTimedTest<IRemoveKDigits402>
{
	@RepeatedTest(10)
	public void RemoveKDigits402()
	{
		timeRunnableMethod(new RemoveKDigitsOriginal(), this::unitTest);
	}

	protected void unitTest(IRemoveKDigits402 solution)
	{
		Assertions.assertEquals("1219", solution.removeKDigits("1432219", 3));
		Assertions.assertEquals("200", solution.removeKDigits("10200", 1));
		Assertions.assertEquals("0", solution.removeKDigits("10", 2));
		Assertions.assertEquals("0", solution.removeKDigits("101", 2));

		Assertions.assertEquals("1", solution.removeKDigits("10011", 2));
		Assertions.assertEquals("11", solution.removeKDigits("1321", 2));
		Assertions.assertEquals("11", solution.removeKDigits("1231", 2));
		Assertions.assertEquals("11", solution.removeKDigits("12321", 3));
	}
}
