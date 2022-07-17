package leet.graphs.undirected;

import leet.Interfaces.IUnreachableNodePairs2316;

import java.util.Arrays;

// TODO understand this
public class UnreachableNodePairsPublic3 implements IUnreachableNodePairs2316
{
	@Override
	public long countPairs(int n, int[][] edges) {
		int [] par = new int[n];
		Arrays.fill(par,-1);

		for(int [] edge: edges){
			int u = edge[0];
			int v = edge[1];
			if(find(par,u) == find(par,v))
				continue;
			else
				union(par,u,v);
		}

		long ans = 0;
		long count = n;

		for(int i = 0;i < n;i++){
			if(par[i] < 0){
				long g1 = -par[i];
				long g2 = count - g1;
				count -= g1;
				ans += g1 * g2;
			}
		}

		return ans;

	}
	int find(int [] par,int u){
		if(par[u] < 0) return u;
		return par[u] = find(par,par[u]);
	}

	void union(int [] par,int u,int v){
		int pu = find(par,u);
		int pv = find(par,v);
		par[pu] += par[pv];
		par[pv] = pu;
	}
}
