package leet.graphs.binaryTree;

import leet.Interfaces.ILinkedListInBinaryTree1367;
import leet.datastruct.ListNode;
import leet.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedTreeInBinaryTreeOriginal implements ILinkedListInBinaryTree1367
{
	private static final int FOUND = 0;

	@Override
	public boolean isSubPath(ListNode head, TreeNode root)
	{
		int totalLen = 0;
		ListNode cur = head;
		while (cur != null)
		{
			totalLen++;
			cur = cur.next;
		}
		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		while (!queue.isEmpty())
		{
			TreeNode curT = queue.poll();
			int status = getSubDepth(head, curT, totalLen);
			if (status == FOUND) return true;
			if (status == 1)
			{
				if (curT.left != null) queue.add(curT.left);
				if (curT.right != null) queue.add(curT.right);
			}
		}
		return false;
	}

	private int getSubDepth(ListNode listNode, TreeNode treeNode, int len)
	{
		if (listNode == null) return FOUND;
		if (treeNode == null) return 2;
		if (listNode.val != treeNode.val) return 1;

		int leftDepth = getSubDepth(listNode.next, treeNode.left, len - 1);
		if (leftDepth == FOUND) return FOUND;
		if (leftDepth == 2)
		{
			treeNode.left = null;
		}

		int rightDepth = getSubDepth(listNode.next, treeNode.right, len - 1);
		if (rightDepth == FOUND) return FOUND;
		if (rightDepth == 2)
		{
			treeNode.right = null;
		}

		return Math.min(rightDepth, leftDepth);
	}
}
