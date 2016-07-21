import java.io.*;
import java.util.*;
 
// This class represents a directed graph using adjacency list
// representation
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
 
    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    public void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
 
    // prints BFS traversal from a given source s
    public void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println("");
    }
}



/*public class Graph
{
	int vertices;
	AdjList[] adajacenyList;

	public Graph(int v)
	{
		vertices = v;
		adajacenyList = new AdjList[v];
		for(int i=0; i <vertices;i++)
		{
			adajacenyList[i] = new AdjList();
		}
	}
	public void depthFirstSearch()
	{
		boolean[] visited= new boolean[vertices];
		for(int i=0;i<vertices;i++)
		{
			if(visited[i] == false)
				dfs(i,visited);
		}
		
	}
	public void dfs(int r , boolean[] visited)
	{
		visited[r] = true;
		System.out.println(r+" ");
		AdjListNode tmp = adajacenyList[r].head;
		while(tmp != null)
		{
			int d = tmp.data;
			if(!visited[d])
				dfs(d,visited);
			tmp = tmp.next;
		}

	}
	public void addEdge(int src, int dest)
	{
		AdjListNode node = new AdjListNode(dest);
		node.next = adajacenyList[src].head;
		adajacenyList[src].head = node;

		//if three lines under this line are commented =>directed graph
		//AdjListNode node2 = new AdjListNode(src);
		//node2.next  = adajacenyList[dest].head;
		//adajacenyList[dest].head = node2;

	}

	public void printGraph()
	{
	    for (int v = 0; v < vertices; v++)
	    {
	         AdjListNode tmp = adajacenyList[v].head;
	        System.out.println("\n Adjacency list of vertex " + v + "\n head ");
	        while (tmp != null)
	        {
	            System.out.print("-> "+tmp.data);
	            tmp = tmp.next;
	        }
	        System.out.println();

		}
	}
	public class AdjList
	{
		public AdjList()
		{
			head = null;
		}
		public	AdjListNode head;
	}
	public class AdjListNode
	{
		int data;
		AdjListNode next;

		public AdjListNode(int d)
		{
			data = d;
			next = null;
		}
	}
}
*/