
//DFS using ArrayList  

import java.io.*;
import java.util.*;


class DFSGraph {
	
	private int V; 
	private ArrayList<ArrayList<Integer>> adj;

	
	public DFSGraph(int vertix) {
		V = vertix;
		adj = new ArrayList<ArrayList<Integer>>(vertix);
		for (int i = 0; i < vertix; i++)
			adj.add(new ArrayList<Integer>());
	}

	// Add edge to graph with directions 
	void addEdge(int v, int w) {
		adj.get(v).add(w);
	}
	
	// A function used by DFS
	void DFSPrint(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj.get(v).listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSPrint(n, visited);
		}
	}

	
	
	public static void main(String args[]) {
		
		
		int totalvertix =4;
		int dfsStartingVertix = 2;
				
		DFSGraph dFSGraph = new DFSGraph(totalvertix);
		dFSGraph.addEdge(0, 1);
		dFSGraph.addEdge(0, 2);
		dFSGraph.addEdge(1, 2);
		dFSGraph.addEdge(2, 0);
		dFSGraph.addEdge(2, 3);
		dFSGraph.addEdge(3, 3);
		
		
		System.out.println(" DFT starting from vertex " + dfsStartingVertix);
		boolean visited[] = new boolean[totalvertix];

		//  print DFS traversal
		dFSGraph.DFSPrint(dfsStartingVertix, visited);
	}
}