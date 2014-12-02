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

public class LinkedListBinarySearchTree {
	public Node root;

	public LinkedListBinarySearchTree() {
		root = null;
	}

	public void insert(String data, int key) {
		if (root == null) {
			root = new Node(data, key);
		}
		else {
			Node focusNode = root;
			Node parent = null;

			while(focusNode != null) {
				parent = focusNode;

				if(key < focusNode.key) 
					focusNode = focusNode.leftChild;
				else if(key > focusNode.key)
					focusNode = focusNode.rightChild;
			}

			if(key < parent.key)
				parent.leftChild = new Node(data,key);
			else if(key > parent.key)
				parent.rightChild = new Node(data,key);
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

