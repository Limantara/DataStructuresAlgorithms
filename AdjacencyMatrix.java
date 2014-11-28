/*
  Suppose we have Sarah, James, Henry, and Susan such that 
  	* Sarah friends with James and Henry
  	* James friends with Sarah and Susan
  	* Susan friends with James and Henry, and 
    * Henry friends with Sarah and Susan

    In this program, the simple undirected graph will be represented with 2D Array, where `1` represents friend and `0` represents not friend.
			Sarah		James		Henry		Susan
	Sarah	  0           1           1           0

	James     1           0           0           1

	Henry     1           0           0           1
 
	Susan     0           1           1           0

*/
import java.util.*;

class Vertex {
	private String name;
	private ArrayList<Vertex> friends;

	public Vertex(String name) {
		this.name = name;
		friends = new ArrayList<Vertex>();
	}
	public String getName() {
		return name;
	}
	public void friendsWith(Vertex a, Vertex b, Vertex c) {
		friends.add(a);
		friends.add(b);
		friends.add(c);
	}
	public void friendsWith(Vertex a, Vertex b) {
		friends.add(a);
		friends.add(b);
	}	
	public void friendsWith(Vertex a) {
		friends.add(a);
	}
	public boolean isFriendWith(Vertex a) {
		Iterator i = friends.iterator();
		while (i.hasNext()) {
			if (a.name.equals(((Vertex)i.next()).name))
				return true;
		}
		return false;
	}
}
class AdjacencyMatrix {
	private int[][] matrix;
	private Vertex[] copy; // store the array Vertex[] people, so that printMatrix() doesn't have to take argument

	public void createMatrix(Vertex[] people) {
		if (people.length == 0) {
			System.out.println ("Error: empty list of people!");
			return;
		}
		copy = people;
		matrix = new int[people.length][people.length];
		for (int r = 0; r < people.length; r++) {
			for (int c = 0; c < people.length; c++) {
				if (people[r].isFriendWith(people[c])) 
					matrix[r][c] = 1;
				else 
					matrix[r][c] = 0;
			}
		}
		System.out.println("The friendship matrix has been created.");
	}
	public void printMatrix() {
		System.out.format("%-10s", " ");

		for (Vertex v : copy) {
			System.out.format("%-8s", v.getName());
		}

		System.out.println();

		for (int r = 0; r < matrix.length; r++) {
			System.out.format("%-12s", copy[r].getName());
			for (int c = 0; c < matrix.length; c++) {
				System.out.format("%-8d", matrix[r][c]);
			}
			System.out.println();
		}

		System.out.println();
	}

	public static void main(String[] args) {
		Vertex Sarah = new Vertex("Sarah");
		Vertex James = new Vertex("James");
		Vertex Henry = new Vertex("Henry");
		Vertex Susan = new Vertex("Susan");

		Sarah.friendsWith(James, Henry);
		James.friendsWith(Sarah, Susan);
		Susan.friendsWith(James, Henry);
		Henry.friendsWith(Sarah, Susan);

		Vertex[] people = {Sarah, James, Henry, Susan};

		AdjacencyMatrix friendship = new AdjacencyMatrix();
		friendship.createMatrix(people);

		System.out.println();
		friendship.printMatrix();
	}
}