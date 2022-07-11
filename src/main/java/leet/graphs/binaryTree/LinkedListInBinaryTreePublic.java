package leet.graphs.binaryTree;

import leet.Interfaces.ILinkedListInBinaryTree1367;
import leet.datastruct.ListNode;
import leet.datastruct.TreeNode;

/***
 * Although this solution is runs much faster in leet code's test cases, in my test cases, it is 4-6x slower than the DFS solution
 */
public class LinkedListInBinaryTreePublic implements ILinkedListInBinaryTree1367
{
	@Override
	public boolean isSubPath(ListNode head, TreeNode root)
	{
		if (head == null) return true;
		if (root == null) return false;
		if (root.val == head.val && continousPath(head, root))
		{
			return true;
		}
		return isSubPath(head, root.left) || isSubPath(head, root.right);
	}

	public boolean continousPath(ListNode head, TreeNode root)
	{
		if (head == null) return true;
		if (root == null || root.val != head.val) return false;
		return continousPath(head.next, root.left) || continousPath(head.next, root.right);
	}
}
