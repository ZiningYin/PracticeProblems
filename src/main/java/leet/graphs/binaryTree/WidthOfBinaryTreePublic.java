package leet.graphs.binaryTree;

import leet.Interfaces.IWidthOfBinaryTree662;
import leet.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class WidthOfBinaryTreePublic implements IWidthOfBinaryTree662
{
	@Override
	public int widthOfBinaryTree(TreeNode root)
	{
		int[] result = new int[1];
		getWidth(root, new ArrayList<>(), 1, 0, result);
		return result[0];
	}

	// TODO note they used a DFS approach that I didn't think of
	private void getWidth(TreeNode root, List<Integer> leftMostNodes, int id, int level, int[] result)
	{
		if (root == null) return;
		if (level >= leftMostNodes.size()) leftMostNodes.add(id);
		result[0] = Math.max(result[0], id - leftMostNodes.get(level) + 1);//leftMostNodes.get(level) returns the id of the lest most node on level
		getWidth(root.left, leftMostNodes, id * 2, level + 1, result);
		getWidth(root.right, leftMostNodes, (id * 2) + 1, level + 1, result);
	}
}
