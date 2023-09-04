import java.util.Scanner;

class graph {
	int n;
	int adj[][];
	int visited[];
	int d[];
	static final int inf = 999;
	public void create_graph() {
	Scanner sc= new Scanner(System.in);
	System.out.println("enter the number of nodes:");
	n= sc.nextInt(); 
	int j,i;
	adj= new int[n+1][n+1];
	
	System.out.println("enter cost of adjacency matrix: ");
	System.out.println("if two nodes are not connected then enter 999 ");
	for(i=1;i<n+1;i++)
		for(j=1;j<n+1;j++)
			adj[i][j]=sc.nextInt();
	visited= new int[n+1];
	d=new int[n+1];
	}
	public void find_path() {
		int source, i,j;
		Scanner sc= new Scanner(System.in);
		for(i=0;i<n+1;i++)
		{
			visited[i]=0;
			d[i]=inf;
			
		}
		System.out.println("enter the index of source node:");
		source =sc.nextInt();
		visited[source]=1;
		d[source]=0;
		int u=source;
		int v,min_node;
		for(i=2;i<n+1;i++)
		{
			for(v=1;v<n+1;v++)
				if(visited[v]== 0 && d[v]>d[u]+adj[u][v])
					d[v] = d[u]+adj[u][v];
				min_node = 0;
				for(j=1;j<n+1;j++)
					if(visited[j]== 0 && d[j]<d[min_node])
						min_node =j;
				    if(d[min_node] < inf)
				    	visited[min_node] =1;
				    else
				    	break;
				    u= min_node;
				    	
		}
		for(i=1;i<n+1;i++)
			System.out.println("distance from source to "+i+" is: "+d[i]);
		
	}
}

public class DijkstraAlgo{
	public static void main(String[] args) {
		graph path = new graph();
		path.create_graph();
		path.find_path();
	}
}	
