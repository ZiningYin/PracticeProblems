package leet;

import leet.Interfaces.IMaxProfit1648;

import java.util.Arrays;

class MaxProfit1648 implements IMaxProfit1648
{
	private final static int MOD_VAL = 1000000007;

	@Override
	public int maxProfit(int[] inventory, int orders)
	{
		long nanoStart = System.nanoTime();
		Arrays.parallelSort(inventory);
		long nanoEnd = System.nanoTime();
		long diff1 = nanoEnd - nanoStart;

		nanoStart = System.nanoTime();
		final int minSellPrice = getMinSellPriceForAll(inventory, orders);
		nanoEnd = System.nanoTime();
		long diff2 = nanoEnd - nanoStart;

		final int minSellPriceMinusOne = minSellPrice - 1;
		int remainingOrders = orders;
		final int arrLen = inventory.length;
		long profit = 0;

		nanoStart = System.nanoTime();
		for (int i = arrLen - 1; i >= 0; i--)
		{
			int numToSell = inventory[i] - minSellPriceMinusOne;
			if (numToSell <= 0) break;

			profit += getTrapezoid(minSellPrice, inventory[i], numToSell);
			profit %= MOD_VAL;
			remainingOrders -= numToSell;
		}
		nanoEnd = System.nanoTime();
		long diff3 = nanoEnd - nanoStart;
		System.out.println("diff1=" + diff1 + " diff2=" + diff2 + " diff3=" + diff3);
		return (int) ((profit + (long) minSellPriceMinusOne * (long) remainingOrders) % MOD_VAL);
	}

	public int getMinSellPriceForAll(int[] inventory, int orders)
	{
		final int arrLen = inventory.length;
		int numColorsAtCurPrice = 0;
		int remainingOrders = orders;
		int prevMaxPrice = inventory[arrLen - 1];

		for (int i = arrLen - 1; i >= -1; i--)
		{
			int numToSellPerColour = prevMaxPrice - (i == -1 ? 0 : inventory[i]);
			if (numToSellPerColour > 0)
			{
				int totalCanBuyForEachColor = remainingOrders / numColorsAtCurPrice;
				if (numToSellPerColour >= totalCanBuyForEachColor)
				{
					return prevMaxPrice - totalCanBuyForEachColor + 1;
				}
				remainingOrders -= numToSellPerColour * numColorsAtCurPrice;
				prevMaxPrice = inventory[i];
			}
			numColorsAtCurPrice++;
		}
		return 0;
	}

	public long getTrapezoid(int top, int bottom, long height)
	{
		return ((long) (top + bottom) * height) / 2L;
	}
}