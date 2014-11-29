import java.util.*;

class AdjacencyList {
	private ArrayList<LinkedList<Integer>> list;
	private boolean isDirected;

	public AdjacencyList(boolean isDirected) {
		this.isDirected = isDirected;
		list = new ArrayList<>();
	}
	public void addVertex(int n) {
		if(!list.contains(n)) {
			LinkedList<Integer> newVertex = new LinkedList<Integer>();
			newVertex.add(n);
			list.add(newVertex);
		}
		else {
			System.out.println("Error: duplicate value!");
		}
	}
	public void addEdge(int v1, int v2) {
		if (!list.isEmpty()) {
			if (v1 != v2) {
				for (LinkedList<Integer> i : list) {
					if (i.peek() == v1) {
						i.add(v2);
					}
				}
				if (!isDirected) {
					for (LinkedList<Integer> i : list) {
						if (i.peek() == v2) {
							i.add(v1);
						}
					}
				}
			}
			else {
				System.out.println("Error: can't add Edge to itself!");
			}			
		}
	}
	public void query(int v1, int v2) {
		if (!list.isEmpty()) {
			for (LinkedList<Integer> i : list) {
				if (i.peek() == v1) {
					System.out.print(v1 + " and " + v2);
					if (i.contains(v2)) 
						System.out.println(" are connected.");
					else 
						System.out.println(" are not connected.");
				}
			}
		}
	}
	public void printList() {
		for (LinkedList<Integer> i : list) {
			for (Integer k = 0; k < i.size(); k++) {
				if (k == i.size()-1) 
					System.out.print(i.get(k));
				else
					System.out.print(i.get(k) + " --> ");
			}
			
			System.out.println();
		}
	}
	public static void main(String[] args) {
		AdjacencyList undirectedGraph = new AdjacencyList(false);
		undirectedGraph.addVertex(0);
		undirectedGraph.addVertex(1);
		undirectedGraph.addVertex(2);
		undirectedGraph.addVertex(3);
		undirectedGraph.addEdge(3,0);
		undirectedGraph.addEdge(3,1);
		undirectedGraph.addEdge(3,2);
		
		undirectedGraph.printList();

		undirectedGraph.query(0,3);
		undirectedGraph.query(2,3);
		
		System.out.println();

		AdjacencyList directedGraph = new AdjacencyList(true);
		directedGraph.addVertex(0);
		directedGraph.addVertex(1);
		directedGraph.addVertex(2);
		directedGraph.addEdge(3,0);
		directedGraph.addEdge(3,1);
		directedGraph.addEdge(3,2);

		directedGraph.printList();

		directedGraph.query(0,3);
		directedGraph.query(2,3);
	}
}