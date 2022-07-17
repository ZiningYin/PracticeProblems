package leet.graphs.undirected;

import leet.Interfaces.IUnreachableNodePairs2316;

import java.util.Arrays;

// TODO understand this
public class UnreachableNodePairsPublic1 implements IUnreachableNodePairs2316
{
	@Override
	public long countPairs(int n, int[][] edges) {
		Uf uf = new Uf(n);
		for(int i = 0;i< edges.length;i++){
			uf.union(edges[i][0],edges[i][1]);
		}
		return uf.total;
	}

	class Uf{
		int[] size;
		int[] ids;
		long total;
		public Uf(int n){
			size = new int[n];
			ids = new int[n];

			Arrays.fill(size,1);

			for(int i = 0;i< n;i++){
				ids[i] = i;
			}

			total = (long)n *(n-1)/2;
		}

		public int find(int p){
			while(p != ids[p]){
				p = ids[p];
			}
			return p;
		}
		public long total(){
			return this.total;
		}

		public void union(int x, int y){
			int rootX = find(x);
			int rootY = find(y);
			if(rootX == rootY){
				return;
			}

			total -= (long)size[rootX] *size[rootY];
			if(size[rootX] < size[rootY]){
				ids[rootX] = rootY;
				size[rootY] += size[rootX];
			}else{
				ids[rootY] = rootX;
				size[rootX] += size[rootY];
			}


		}

	}
}
