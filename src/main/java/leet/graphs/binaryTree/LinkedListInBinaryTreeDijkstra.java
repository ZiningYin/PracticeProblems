package leet.graphs.binaryTree;

import leet.Interfaces.ILinkedListInBinaryTree1367;
import leet.datastruct.ListNode;
import leet.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/***
 * This ended up performing much worse than the original, but it helped me gain insight into the problem itself and come up with the DFS solution.
 */
public class LinkedListInBinaryTreeDijkstra implements ILinkedListInBinaryTree1367
{
	@Override
	public boolean isSubPath(ListNode head, TreeNode root)
	{
		Queue<TreeNode> nodesToCheck = new LinkedList<>();
		Queue<TreeNode> nextToCheck = new LinkedList<>();
		Queue<TreeNode> temp;

		checkTree(root, head.val, nextToCheck);

		ListNode cur = head.getNext();
		while (!nextToCheck.isEmpty() && cur != null)
		{
			temp = nodesToCheck;
			nodesToCheck = nextToCheck;
			nextToCheck = temp;

			boolean found = false;

			while (!nodesToCheck.isEmpty())
			{
				TreeNode node = nodesToCheck.poll();
				found |= addChildrenToQueue(node, cur.val, nextToCheck);
			}
			if (!found) return false;
			cur = cur.next;
		}

		// here there are 2 cases, the entire list was found, or there are no nodes to check for the next value;
		return cur == null;
	}

	private void checkTree(TreeNode treeNode, int value, Queue<TreeNode> queueToUpdate)
	{
		if (treeNode == null) return;
		addChildrenToQueue(treeNode, value, queueToUpdate);

		checkTree(treeNode.left, value, queueToUpdate);
		checkTree(treeNode.right, value, queueToUpdate);
	}

	private static boolean addChildrenToQueue(TreeNode node, int value, Queue<TreeNode> queueToUpdate)
	{
		if (node == null) return false;
		if (node.val != value) return false;
		if (node.left != null) queueToUpdate.add(node.left);
		if (node.right != null) queueToUpdate.add(node.right);
		return true;
	}
}
