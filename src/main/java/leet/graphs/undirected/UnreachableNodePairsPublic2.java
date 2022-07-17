package leet.graphs.undirected;

import leet.Interfaces.IUnreachableNodePairs2316;

// TODO understand this
public class UnreachableNodePairsPublic2 implements IUnreachableNodePairs2316
{
	@Override
	public long countPairs(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for (int[] e : edges) {
			uf.union(e[0], e[1]);
		}

		long pairs = 0;
		int left = n;

		boolean[] seen = new boolean[n];
		for (int i = 0; i < n; i++) {
			int p = uf.find(i);
			if (!seen[p]) {
				seen[p] = true;
				left -= uf.size(p);
				pairs += (long) left * uf.size(p);
			}
		}
		return pairs;
	}

	private static final class UnionFind {
		private final int[] p;
		private final int[] w;

		UnionFind(int n) {
			p = new int[n];
			w = new int[n];

			for (int i = 0; i < n; i++) {
				p[i] = i;
				w[i] = 1;
			}
		}

		int size(int i) {
			return w[i];
		}

		int find(int i) {
			while (i != p[i]) {
				i = p[i] = p[p[i]];
			}
			return i;
		}

		void union(int i, int j) {
			i = find(i);
			j = find(j);

			if (i == j) {
				return;
			}

			if (w[i] < w[j]) {
				p[i] = j;
				w[j] += w[i];
			} else {
				p[j] = i;
				w[i] += w[j];
			}
		}
	}
}
