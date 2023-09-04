import java.util.Scanner;

class Graphk{

	int n,nEdges;
	int[][] adj;
	int[][] edges;
	static final int inf = 999;
	public void create_graph() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of nodes in the graph:");
		n = sc.nextInt();
		int i,j,k = 0;
		adj = new int[n][n];
		edges = new int[n*n][n];
		
		for(i = 0; i < n; i++) {
			for(j = 0; j < n; j++) {
				adj[i][j] = sc.nextInt();
				edges[k][0] = i;
				edges[k][1] = j;
				edges[k++][2] = adj[i][j];
			}
		}
	}

	public int find(int x,int[] parent) {
		while(parent[x] >= 0) {
			x = parent[x];
		}
		return x;
	}
	
	public void setUnion(int x, int y, int[] parent) {
		parent[x] = y;
	}
	
	public void find_mst() {
		java.util.Arrays.sort(edges, new java.util.Comparator<int[]>()
		{
			  public int compare(int[] a,int[] b) {
			      return Integer.compare(a[2],b[2]);
				 }
		 });
		
		int x,y,cost=0,ecount=0;
		int[] parent = new int[n];
		
		for(int i=0; i<n; i++)
			parent[i] = -1;
		 
		int[][] mst = new int[n*n][3];
		int i = 0;
		while(i < n*n && ecount < n-1) {
			if(edges[i][2] == 999)
				break;
			x = find(edges[i][0], parent);
			y = find(edges[i][1], parent);
			if(x != y) {
				cost = cost + edges[i][2];
				mst[ecount][0] = edges[i][0];
				mst[ecount++][1] = edges[i][1];
				setUnion(x,y,parent);
			}
			i++;
		}
		
		if(ecount < n-1) {
			System.out.println("Cannot find the minimum spanning tree.");
		}
		else {
			System.out.println("The cost of minimum spanning tree is: " + cost);
			System.out.println("The minimum spanning tree is: ");
			for(int k = 0; k < n-1; k++) {
				System.out.println(mst[k][0] + " - " + mst[k][1]);
			}
		}
	}
}

public class KruskalMST {
	public static void main(String[] args) {
		Graphk graph = new Graphk();
		graph.create_graph();
		graph.find_mst();
	}
}