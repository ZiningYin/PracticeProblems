package leet.graphs.binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTestUtil
{
	public static int[][] genBinaryTreeChildren(int num)
	{
		int count = 1;
		int[] tree = new int[num];

		for (int i = 1; i < num; i++)
		{
			if (Math.random() * 10 > 1) tree[i] = count++;
			else tree[i] = -1;
		}

		int [] leftChildren=new int [count];
		int [] rightChildren=new int [count];
		TreeNode root = BinaryTreeTestUtil.constructBinaryTree(tree);
		BinaryTreeTestUtil.getBinaryTreeChildren(root, leftChildren, rightChildren);
		System.out.println(Arrays.toString(leftChildren));
		System.out.println(Arrays.toString(rightChildren));
		return null;
		// return new int[][]{leftChildren, rightChildren};
	}

	public static TreeNode constructBinaryTree(int[] nodes)
	{
		if (nodes.length < 1 || nodes[0] < 0) throw new IllegalArgumentException("Illegal Arguments");

		TreeNode root = new TreeNode(nodes[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		for (int i = 1; i < nodes.length; i += 2)
		{
			TreeNode node = queue.poll();
			if (node == null) throw new NullPointerException("Found an unexpected null value when processing index=" + i);

			int nodeVal = nodes[i];
			if (nodeVal != -1)
			{
				node.left = new TreeNode(nodeVal);
				queue.add(node.left);
			}

			if (i + 1 >= nodes.length) break;

			nodeVal = nodes[i + 1];
			if (nodeVal != -1)
			{
				node.right = new TreeNode(nodeVal);
				queue.add(node.right);
			}
		}

		return root;
	}

	// output the binary tree as an array of left and right children
	public static void getBinaryTreeChildren(TreeNode node, int[] leftChildren, int [] rightChildren)
	{
		if (node.left != null)
		{
			leftChildren[node.val] = node.left.val;
			getBinaryTreeChildren(node.left, leftChildren, rightChildren);
		}
		else
		{
			leftChildren[node.val] = -1;
		}

		if (node.right != null)
		{
			rightChildren[node.val] = node.right.val;
			getBinaryTreeChildren(node.right, leftChildren, rightChildren);
		}
		else
		{
			rightChildren[node.val] = -1;
		}
	}
}
