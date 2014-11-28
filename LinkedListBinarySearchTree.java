public class LinkedListBinarySearchTree {
	public Node root;

	public Node getNodeWithKey(int key) {
		if (root == null) {
			return null;
		} 

		Node n = root;
		while (true) {
			if (key == n.key){
				return n;
			}
			else if (key < n.key) {
				if (n.leftChild == null) 
					return null;
				else 
					n = n.leftChild;
			} else if (key > n.key) {
				if (n.rightChild == null) 
					return null;
				else 
					n = n.rightChild;
			}
		}
	}
	public void insert(String data, int key) {
		Node newNode = new Node(data, key);

		if (root == null) {
			root = newNode;
		}
		else {
			Node parent = root;

			while (true) {
				if (newNode.key < parent.key) {
					if (parent.leftChild != null) {
						parent = parent.leftChild;
					}
					else {
						parent.leftChild = newNode;
						break;
					} 
				} else if (newNode.key > parent.key) {
					if (parent.rightChild != null) {
						parent = parent.rightChild;
					}
					else {
						parent.rightChild = newNode;
						break;
					} 
				}
			}
		}
	}
	private void preOrderFunc(Node root) {
		if (root != null) {
			System.out.format("%-4s", root);
			preOrderFunc(root.leftChild);
			preOrderFunc(root.rightChild);
		}
	}
	public void preOrderTraversal() {
		preOrderFunc(root);
	}

	private void postOrderFunc(Node root) {
		if (root != null) {
			postOrderFunc(root.leftChild);
			postOrderFunc(root.rightChild);
			System.out.format("%-4s", root);
		}
	}
	public void postOrderTraversal() {
		postOrderFunc(root);
	}

	private void inOrderFunc(Node root) {
		if (root != null) {
			inOrderFunc(root.leftChild);
			System.out.format("%-4s", root);
			inOrderFunc(root.rightChild);
		}
	}
	public void inOrderTraversal() {
		inOrderFunc(root);
	}
	public LinkedListBinarySearchTree() {
		root = null;
	}
	public static void main(String[] args) {
		LinkedListBinarySearchTree myTree = new LinkedListBinarySearchTree();
		myTree.insert("Five", 5);
		myTree.insert("Four", 4);
		myTree.insert("Ten", 10);
		myTree.insert("Six", 6);
		myTree.insert("Eleven", 11);

		System.out.print("Pre-order   : ");
		myTree.preOrderTraversal();

		System.out.print("\nPost-order  : ");
		myTree.postOrderTraversal();

		System.out.print("\nIn-order    : ");
		myTree.inOrderTraversal();
	}
}

class Node {
	String data;
	int key;
	Node leftChild;
	Node rightChild;

	public Node(String data, int key) {
		this.data = data;
		this.key = key;
		leftChild = null;
		rightChild = null;
	}
	public String toString() {
		return key + " ";
	}
}