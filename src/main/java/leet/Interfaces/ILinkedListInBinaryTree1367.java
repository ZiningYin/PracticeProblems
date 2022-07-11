package leet.Interfaces;

import leet.datastruct.ListNode;
import leet.datastruct.TreeNode;

/***
 * reconsidering the particulars of the question, the length of the list is actually significantly limited by the tree's number of nodes (2500).
 * This means, the worse case is a balanced tree. The original algo's runtime for that is O(Math.min(nodesInTree, 2^lenOfList) * heightOfTree)
 */
public interface ILinkedListInBinaryTree1367
{
	boolean isSubPath(ListNode head, TreeNode root);
}
