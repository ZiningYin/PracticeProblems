package leet.graphs.binaryTree;

import leet.Interfaces.IValidateBinaryTreeNodes1361;

public class ValidateBinaryTreeNodesOriginal implements IValidateBinaryTreeNodes1361
{
	@Override
	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
		// given 0-2 children
		// find root - single parent for each except root
		// traverse tree, make sure no node is visited twice - acyclic
		// validate no node is missed - fully connected
		boolean [] foundNode = new boolean [n];
		for (int child : leftChild)
		{
			if (child == -1) continue;
			if (foundNode[child]) return false;
			foundNode[child] = true;
		}
		for (int child : rightChild)
		{
			if (child == -1) continue;
			if (foundNode[child]) return false;
			foundNode[child] = true;
		}

		int root = -1;
		for (int i=0; i< n ; i++)
		{
			if (foundNode[i]) continue;

			if (root == -1) root = i;
			else return false;
		}

		if (root == -1) return false;

		foundNode = new boolean[n];
		dfsBinaryTree (root, leftChild, rightChild, foundNode);

		for (boolean nodeIsConnected : foundNode)
		{
			if (!nodeIsConnected) return false;
		}
		return true;
	}

	private void dfsBinaryTree (int cur, int[] leftChild, int[] rightChild, boolean[] foundNode)
	{
		if (cur == -1) return;

		foundNode[cur] = true;
		dfsBinaryTree(leftChild[cur], leftChild, rightChild, foundNode);
		dfsBinaryTree(rightChild[cur], leftChild, rightChild, foundNode);
	}
}
