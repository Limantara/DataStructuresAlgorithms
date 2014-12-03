class Stack {
	private Node top;

	public Stack() {
		top = null;
	}

	public void push(int data) {
		if(top == null) {
			top = new Node(data);
		} else {
			Node newNode = new Node(data);
			newNode.setNext(top);
			top = newNode;
		}
	}

	public int pop() {
		int data = top.getData();
		top = top.getNext();

		return data;
	}

	public int peek() {
		return top.getData();
	}

	public static void main(String[] args) {
		Stack myStack = new Stack();

		myStack.push(2);
		System.out.println("peek(): " + myStack.peek());

		myStack.push(9);
		System.out.println("peek(): " + myStack.peek());
		
		myStack.push(5);
		System.out.println("peek(): " + myStack.peek());
		
		myStack.push(1);
		System.out.println("peek(): " + myStack.peek());
	}
}

class Node {
	private int data;
	private Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}

	public void setNext(Node n) {
		next = n;
	}

	public Node getNext() {
		return next;
	}

	public int getData() {
		return data;
	}
}
