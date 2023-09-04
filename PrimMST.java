import java.util.Scanner;

class Prim{
	public static void myPrim(int[][] adj, int N) {
		int i,j,vnodes,min,min_cost=0,u=0,v=0;
		int[] visit = new int[N];
		for(i=0;i<N;i++) {
			visit[i] = 0;
		}
		visit[0] = 1;
		vnodes = 1;
		while(vnodes<N) {
			min = 999;
			for(i=0;i<N;i++) {
				if(visit[i]==1) {
					for(j=0;j<N;j++) {
						if(adj[i][j]<min && visit[j]==0) {
							min = adj[i][j];
							u = i;
							v = j;
						}
					}
				}
			}
			visit[v] = 1;
			min_cost += min;
			vnodes++;
			System.out.printf("Edge %d - %d : (%d)\n", u,v,min);
			
		}
		System.out.println("Cost:" + min_cost);
	}
}

public class PrimMST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		System.out.println("Enter the no of nodes:");
		N = sc.nextInt();
		int[][] adj = new int[N][N]; 
		System.out.println("Enter the adjancency matrix:");
		System.out.println("Enter 999 if not connected, else enter the weight:");
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				adj[i][j] = sc.nextInt();
			}
		}
		Prim.myPrim(adj, N);
		sc.close();
	}
}