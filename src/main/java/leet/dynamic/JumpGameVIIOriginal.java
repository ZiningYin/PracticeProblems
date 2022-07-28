package leet.dynamic;

import leet.Interfaces.IJumpGameVII1871;

public class JumpGameVIIOriginal implements IJumpGameVII1871
{
	@Override
	public boolean canReach(String s, int minJump, int maxJump) {
		// initial thoughts, this is a dynamic programming directed acyclic graph problem
		// worst solution, recursively check every possible path until the end is reached
		// to improve, record which nodes were checked
		// to improve further, understand that the nodes and their connections are cascading,
		// a next node will not have access to a previous node

		char[] ch = s.toCharArray();
		if (ch[ch.length - 1] == '1') return false;

		boolean[] reachable = new boolean[ch.length];
		reachable[0] = true;

		int nextToCheck = 0;
		int lastReachable = 0;

		for (int i=0;i<ch.length;i++)
		{
			if (i > lastReachable) return false;
			if (!reachable[i]) continue;

			int minIndex = Math.max(i+minJump, nextToCheck);
			if (minIndex >= ch.length) return false;

			int maxIndex = i + maxJump + 1;
			if (maxIndex >= ch.length) return true;

			for (int j=minIndex; j<maxIndex;j++)
			{
				if (ch[j] == '0')
				{
					reachable[j] = true;
					lastReachable = j;
				}
			}
			nextToCheck = maxIndex;
		}
		return false;
	}
}
