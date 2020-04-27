
// Graph using ArrayList in Java 

import java.util.*;

class ArrayGraph {
	
	
	private int V; 
	private ArrayList<ArrayList<Integer>> arrayListGraph;

	// Constructor
	public ArrayGraph(int vertix) {
		V = vertix;
		arrayListGraph = new ArrayList<ArrayList<Integer>>(vertix);
		for (int i = 0; i < vertix; i++)
			arrayListGraph.add(new ArrayList<Integer>());
	}

	// adding to both array 
	 void addEdgeToGraph( int u, int v) {
		 arrayListGraph.get(u).add(v);
		 arrayListGraph.get(v).add(u);
	}

	// printing the Array 
	 void printGraph() {
		for (int i = 0; i < arrayListGraph.size(); i++) {
			System.out.println("\nAdjacency list of vertex = " + i);
			for (int j = 0; j < arrayListGraph.get(i).size(); j++) {
				System.out.print(" -> " + arrayListGraph.get(i).get(j));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
	
		int vertix = 5;
		ArrayGraph arrayGraph = new ArrayGraph(vertix);
		
		arrayGraph.addEdgeToGraph( 0, 1);
		arrayGraph.addEdgeToGraph( 0, 4);
		arrayGraph.addEdgeToGraph( 1, 2);
		arrayGraph.addEdgeToGraph( 1, 3);
		arrayGraph.addEdgeToGraph( 1, 4);
		arrayGraph.addEdgeToGraph( 2, 3);
		arrayGraph.addEdgeToGraph( 3, 4);

		arrayGraph.printGraph();
	}
}