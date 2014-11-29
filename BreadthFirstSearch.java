import java.util.*;
class BreadthFirstSearch {
	private AdjacencyList graph;
	private List<LinkedList<Integer>> adjList;
	private HashMap<Integer,Integer> getIndex;
	private HashMap<Integer,Integer> getVal;
	private HashMap<Integer,Boolean> isVisited;

	public BreadthFirstSearch(AdjacencyList undirected) {
		graph = undirected;
		adjList = undirected.getAdjList();
		getIndex = undirected.getIndexHash();
		getVal = undirected.getValHash();
		isVisited = undirected.getVisitedHash();
	}

	public void search(Integer target) {
		Integer startFrom = getVal.get(0);
		this.search(startFrom, target);
	}

	public void search(Integer startFrom, Integer target) {
		if(!getIndex.containsKey(startFrom)) {
			System.out.println(target + " can't start from " + startFrom
				 + "! " + startFrom + " is not in the graph");
			return;
		}

		Queue<Integer> q = new LinkedList<>();
		Integer index = getIndex.get(startFrom);
		Integer val = getVal.get(index);
		isVisited.put(index, true);
		q.add(index);

		if(val == target) {
			System.out.println(val + " is visited");
			System.out.println("Found it!");
			return;
		}

		while (!q.isEmpty()) {
			index = q.poll();
			val = getVal.get(index);
			List<Integer> list = adjList.get(index);

			if(val == target) {
				System.out.println("Found it!");
				return;
			}

			for(Integer j : list) {
				if(isVisited.get(j) == false) {
					isVisited.put(j, true);
					q.add(j);
					System.out.println(val + " is visited");

					val = getVal.get(j);
					if(val == target) {
						System.out.println(val + " is visited");
						System.out.println("Found it!");
						return;
					}
				}
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

		BreadthFirstSearch BFS = new BreadthFirstSearch(undirected);
		BFS.search(22);
	}
}

class AdjacencyList {
	private List<LinkedList<Integer>> adjList;
	private HashMap<Integer,Integer> getIndex;
	private HashMap<Integer,Integer> getVal;
	private HashMap<Integer,Boolean> isVisited;
	private boolean isDirected;

	public AdjacencyList() {
		adjList = new ArrayList<LinkedList<Integer>>();
		getIndex = new HashMap<>();
		getVal = new HashMap<>();
		isVisited = new HashMap<>();
		isDirected = false;
	}

	public List<LinkedList<Integer>> getAdjList() {
		return adjList;
	}

	public HashMap<Integer,Integer> getIndexHash() {
		return getIndex;
	}

	public HashMap<Integer,Integer> getValHash() {
		return getVal;
	}

	public HashMap<Integer,Boolean> getVisitedHash() {
		return isVisited;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public void addVertex(Integer v) {
		getIndex.put(v, adjList.size());
		getVal.put(adjList.size(), v);
		isVisited.put(adjList.size(), false);
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
}



