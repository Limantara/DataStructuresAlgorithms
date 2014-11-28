import java.util.*;

class AdjacencyMatrix {
	private int[][] matrix;
	private boolean isDirected;

	public AdjacencyMatrix(boolean isDirected, int matrixSize) {
		matrix = new int[matrixSize][matrixSize];
		this.isDirected = isDirected;
	}
	public void addEdge(int v1, int v2) {
		if(isDirected) {
			matrix[v1][v2] = 1;
		} else {
			matrix[v1][v2] = 1;
			matrix[v2][v1] = 1;
		}
	}
	public void addVertex() {
		int currentLength = matrix.length;

		int temp[][] = matrix;
		matrix = new int[currentLength+1][currentLength+1];

		for (int row = 0; row < temp.length; row++) {
			for (int col = 0; col < temp.length; col++) {
				matrix[row][col] = temp[row][col];
			}
		}
		
	}
	public void printMatrix() {
		if(isDirected) {
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix.length; col++) {
					if (matrix[row][col] == 1)
						System.out.println(row + " --> " + col);
				}
			}
		}
		else {
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col <= row; col++) {
					if (matrix[row][col] == 1) 
						System.out.println(row + " <--> " + col);
				}
			}
		}
	}
	public boolean query(int v1, int v2) {
		System.out.print(v1 + " and " + v2);
		if (matrix[v1][v2] == 1) {
			System.out.println(" are connected.");
			return true;
		}
		else {
			System.out.println(" are not connected.");
			return false;
		}
	}
	public static void main(String[] args) {
		AdjacencyMatrix undirectedGraph = new AdjacencyMatrix(false, 5);
		undirectedGraph.addEdge(0,0);
		undirectedGraph.addEdge(1,1);
		undirectedGraph.addEdge(2,2);
		undirectedGraph.addEdge(3,0);
		undirectedGraph.addEdge(3,1);
		undirectedGraph.addEdge(3,2);
		undirectedGraph.addVertex();
		undirectedGraph.addVertex();
		undirectedGraph.printMatrix();

		undirectedGraph.query(0,3);
		undirectedGraph.query(2,3);
		undirectedGraph.query(4,5);
		undirectedGraph.query(4,4);
		undirectedGraph.query(5,5);
		
		System.out.println();

		AdjacencyMatrix directedGraph = new AdjacencyMatrix(true,5);
		directedGraph.addEdge(0,0);
		directedGraph.addEdge(1,1);
		directedGraph.addEdge(2,2);
		directedGraph.addEdge(3,0);
		directedGraph.addEdge(3,1);
		directedGraph.addEdge(3,2);
		directedGraph.printMatrix();

		directedGraph.query(0,3);
		directedGraph.query(2,3);
	}	
}