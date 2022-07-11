package leet.graphs.binaryTree;


import leet.Interfaces.IWidthOfBinaryTree662;
import leet.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class WidthOfBinaryTreeOriginal implements IWidthOfBinaryTree662
{
	public static class Holder
	{
		int index;
		TreeNode node;

		public Holder(int index, TreeNode node)
		{
			this.index = index;
			this.node = node;
		}
	}

	@Override
	public int widthOfBinaryTree(TreeNode root)
	{
		int maxWidth = 1;
		List<Holder> curList;
		List<Holder> nextList = new ArrayList<>();
		nextList.add(new Holder(0, root));

		while (!nextList.isEmpty())
		{
			curList = nextList;
			nextList = new ArrayList<>();

			for (Holder holder : curList)
			{
				TreeNode cur = holder.node;
				if (cur.left != null)
				{
					nextList.add(new Holder(holder.index * 2, cur.left));
				}
				if (cur.right != null)
				{
					nextList.add(new Holder(holder.index * 2 + 1, cur.right));
				}
			}
			int width = curList.get(curList.size() - 1).index - curList.get(0).index + 1;
			if (width > maxWidth) maxWidth = width;
		}
		return maxWidth;
	}


}
