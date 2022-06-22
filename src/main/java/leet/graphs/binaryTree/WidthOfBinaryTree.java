package leet.graphs.binaryTree;

import leet.Interfaces.IWidthOfBinaryTree662;

import java.util.LinkedList;

public class WidthOfBinaryTree implements IWidthOfBinaryTree662
{
	@Override
	public int widthOfBinaryTree(TreeNode root) {
		int maxWidth = 1;
		LinkedList<TreeNode> curList;
		LinkedList<TreeNode> nextList = new LinkedList<>();
		nextList.add(root);
		root.val = 0;

		while (!nextList.isEmpty())
		{
			curList = nextList;
			nextList = new LinkedList<>();

			int width = curList.getLast().val - curList.getFirst().val + 1;
			if (width > maxWidth) maxWidth = width;

			while (!curList.isEmpty())
			{
				TreeNode cur = curList.poll();
				if (cur.left != null)
				{
					cur.left.val = cur.val << 2;
					nextList.add(cur.left);
				}
				if (cur.right != null)
				{
					cur.right.val = (cur.val << 2) + 1;
					nextList.add(cur.right);
				}
			}
		}
		return maxWidth;
	}
}
