package leet.graphs.binaryTree;

import leet.Interfaces.IValidateBinaryTreeNodes1361;

public class ValidateBinaryTreeNodesPublic implements IValidateBinaryTreeNodes1361
{
	@Override
	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild)
	{
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < n; i++)
		{
			if (leftChild[i] >= 0 && !uf.union(i, leftChild[i]))
			{
				return false;
			}
			if (rightChild[i] >= 0 && !uf.union(i, rightChild[i]))
			{
				return false;
			}
		}
		return uf.components() == 1;
	}

	static class UnionFind
	{
		private final int[] roots;
		private int components;

		UnionFind(int n)
		{
			this.roots = new int[n];
			for (int i = 0; i < n; i++)
			{
				this.roots[i] = i;
			}
			this.components = n;
		}

		public boolean union(int parent, int child)
		{
			int rootParent = findRoot(parent);
			int rootChild = findRoot(child);

			if (rootParent == rootChild || rootChild != child)
			{
				return false;
			}

			this.roots[rootChild] = rootParent;
			this.components--;
			return true;
		}

		private int findRoot(int v)
		{
			while (v != this.roots[v])
			{
				this.roots[v] = this.roots[this.roots[v]];
				v = this.roots[v];
			}
			return v;
		}

		public int components()
		{
			return this.components;
		}
	}
}
