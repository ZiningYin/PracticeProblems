package leet.graphs.binaryTree;

import leet.Interfaces.IWidthOfBinaryTree662;

import java.util.ArrayList;

public class WidthOfBinaryTreeDFS implements IWidthOfBinaryTree662
{
	@Override
	public int widthOfBinaryTree(TreeNode root)
	{
		int [] result= new int[]{1};
		dfs (root, 0, 0, new ArrayList<>(), result);
		return result[0];
	}

	// pretty much copied the public version with 1 minor improvement....
	private void dfs (TreeNode root, int depth, int index, ArrayList<Integer> depthIndex, int [] result)
	{
		if(root == null) return;

		if (depth == depthIndex.size())
		{
			depthIndex.add(index);
		}
		else
		{
			int width = index - depthIndex.get(depth) + 1;
			if (result[0] < width) result[0] = width;
		}

		dfs(root.left, depth + 1, index << 1, depthIndex, result);
		dfs(root.right, depth + 1, (index << 1) + 1, depthIndex, result);
	}
}
