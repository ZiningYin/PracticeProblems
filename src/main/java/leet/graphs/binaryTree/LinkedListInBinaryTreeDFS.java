package leet.graphs.binaryTree;

import leet.Interfaces.ILinkedListInBinaryTree1367;
import leet.datastruct.ListNode;
import leet.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListInBinaryTreeDFS implements ILinkedListInBinaryTree1367
{
	@Override
	public boolean isSubPath(ListNode head, TreeNode root)
	{
		int listLen = 1;
		ListNode cur = head.next;
		while (cur != null)
		{
			listLen++;
			cur = cur.next;
		}

		Queue<TreeNode> nodesToCheck = new LinkedList<>();
		checkTreeNext(root, head.val, nodesToCheck, listLen);

		while (!nodesToCheck.isEmpty())
		{
			TreeNode node = nodesToCheck.poll();
			if (checkNode(head.next, node)) return true;
		}
		return false;
	}

	/**
	 * The new tree node filter increased performance significantly
	 */
	private int checkTreeNext(TreeNode treeNode, int value, Queue<TreeNode> queueToUpdate, int len)
	{
		if (treeNode == null) return 0;

		int leftHeight = checkTreeNext(treeNode.left, value, queueToUpdate, len);
		int rightHeight = checkTreeNext(treeNode.right, value, queueToUpdate, len);

		int curHeight = Math.max(leftHeight, rightHeight) + 1;
		if (curHeight >= len && treeNode.val == value)
		{
			if (treeNode.left != null) queueToUpdate.add(treeNode.left);
			if (treeNode.right != null) queueToUpdate.add(treeNode.right);
		}
		return curHeight;
	}

	private boolean checkNode(ListNode listNode, TreeNode treeNode)
	{
		if (listNode == null) return true;
		if (treeNode == null) return false;
		if (listNode.val != treeNode.val) return false;

		if (checkNode(listNode.next, treeNode.left)) return true;
		return checkNode(listNode.next, treeNode.right);
	}
}
