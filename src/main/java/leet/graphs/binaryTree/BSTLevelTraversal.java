package leet.graphs.binaryTree;

import leet.Interfaces.IBSTLevelTraversal;
import leet.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTLevelTraversal implements IBSTLevelTraversal
{
	@Override
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> outputByLevel = new ArrayList<>();
		List<Integer> curList = new ArrayList<>();
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);
		nodes.add(null);

		outputByLevel.add(curList);
		for (int i=0; i<2000; i++)
		{
			TreeNode node = nodes.poll();
			if (node == null)
			{
				// indicates next level
				if (nodes.isEmpty()) return outputByLevel;
				curList = new ArrayList<>();
				outputByLevel.add(curList);
				nodes.add(null);
			}
			else
			{
				curList.add(node.val);
				if (node.left != null) nodes.add(node.left);
				if (node.right != null) nodes.add(node.right);
			}
		}
		return new ArrayList<>();
	}
}
