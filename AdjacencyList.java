import java.util.*;

class AdjacencyList {
	private List<LinkedList<Integer>> adjList;
	private HashMap<Integer,Integer> getIndex;
	private HashMap<Integer,Integer> getVal;
	private boolean isDirected;

	public AdjacencyList() {
		adjList = new ArrayList<LinkedList<Integer>>();
		getIndex = new HashMap<>();
		getVal = new HashMap<>();
		isDirected = false;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public void addVertex(Integer v) {
		getIndex.put(v, adjList.size());
		getVal.put(adjList.size(), v);
		adjList.add(new LinkedList<Integer>());
	}

	public void addEdge(Integer v1, Integer v2) {
		Integer index1 = getIndex.get(v1);
		Integer index2 = getIndex.get(v2);
		adjList.get(index1).add(index2);

		if (!isDirected) 
			adjList.get(index2).add(index1);
	}

	public void print() {
		for (Integer i = 0; i < adjList.size(); i++) {
			Integer val = getVal.get(i);
			List<Integer> list = adjList.get(i);

			if (!list.isEmpty()) 
				System.out.print(val + " --> ");
			else
				System.out.println(val);

			for (Integer j : list) {
				val = getVal.get(j);
				if (j != list.get(list.size() - 1))
					System.out.print(val + " --> ");
				else
					System.out.println(val);
			}
		}
	}

	public static void main(String[] args) {
		AdjacencyList undirected = new AdjacencyList();
		undirected.addVertex(22);
		undirected.addVertex(17);
		undirected.addVertex(5);
		undirected.addVertex(3);
		undirected.addVertex(13);

		undirected.addEdge(22,17);
		undirected.addEdge(22,13);
		undirected.addEdge(22,5);
		undirected.addEdge(5,3);
		undirected.addEdge(17,13);

		// undirected.print();

		AdjacencyList directed = new AdjacencyList();
		directed.setDirected(true);
		
		directed.addVertex(11);
		directed.addVertex(21);
		directed.addVertex(67);
		directed.addVertex(50);

		directed.addEdge(11,21);
		directed.addEdge(67,21);
		directed.addEdge(50,67);

		directed.print();
	}
}