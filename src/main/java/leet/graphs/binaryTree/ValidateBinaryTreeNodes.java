package leet.graphs.binaryTree;

import leet.Interfaces.IValidateBinaryTreeNodes1361;

public class ValidateBinaryTreeNodes implements IValidateBinaryTreeNodes1361
{
	@Override
	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild)
	{
		int[] parentNodes = new int[n];
		for (int i = 0; i < n; i++)
		{
			parentNodes[i] = -1;
		}

		int [] count = new int[1];
		for (int i = 0; i < n; i++)
		{
			if (parentNodes[i] != -1) continue;
			boolean isValid = validateBinaryTree(leftChild[i], i, leftChild, rightChild, parentNodes, count);
			isValid &= validateBinaryTree(rightChild[i], i, leftChild, rightChild, parentNodes, count);
			if (!isValid || parentNodes[i] != -1) return false; // check for loops
		}

		return count[0] == n-1;
	}

	private boolean validateBinaryTree(int cur, int parent, int[] leftChild, int[] rightChild, int[] parentNode, int[] count)
	{
		if (cur == -1) return true;
		if (parentNode[cur] != -1) return parentNode[cur] == parent;

		parentNode[cur] = parent;
		count[0]++;
		boolean isValid = validateBinaryTree(leftChild[cur], cur, leftChild, rightChild, parentNode, count);
		return isValid && validateBinaryTree(rightChild[cur], cur, leftChild, rightChild, parentNode, count);
	}
}
