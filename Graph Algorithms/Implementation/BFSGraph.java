
//BFS using ArrayList  



import java.io.*;
import java.util.*;


class BFSGraph {
	private int V; 
	private ArrayList<ArrayList<Integer>> adj;

	
	public BFSGraph(int vertix) {
		V = vertix;
		adj = new ArrayList<ArrayList<Integer>>(vertix);
		for (int i = 0; i < vertix; i++)
			adj.add(new ArrayList<Integer>());
	}

	// Add edge to graph with directions 
	void addEdge(int v, int w) {
		adj.get(v).add(w);
	}

	// prints BFS traversal from a given source s
	void BFSPrint(int s) {
		
		boolean visited[] = new boolean[V];

		// Create a blank Queue
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");

			// get vertex of dequeued and if the next to vertex are not visted then enqueue it.
			
			Iterator<Integer> i = adj.get(s).listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}


	public static void main(String args[]) {
		
		int totalvertix =4;
		int bfsStartingVertix = 2;
		
		BFSGraph g = new BFSGraph(totalvertix);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
		
		
		System.out.println(" BFT starting from vertex " + bfsStartingVertix);
		g.BFSPrint(bfsStartingVertix);
	}
}