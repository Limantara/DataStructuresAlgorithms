public class SinglyLinkedList {
	public Node head;
	private Node tail;

	public SinglyLinkedList() {
		head = null;
		tail = null;
	}
	public void insert(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = head;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}
	}
	public void remove() {
		if (head != null) {
			Node curr = head;

			while (curr.next.next != null) {
				curr = curr.next;
			}
			curr.next = null;
			tail = curr;
		}
	}
	public void print() {
		Node curr = head;

		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}

		System.out.println();
	}
	public static void main(String[] args) {
		SinglyLinkedList myList = new SinglyLinkedList();
		myList.insert(1);
		myList.print();
		myList.insert(2);
		myList.print();
		myList.insert(3);
		myList.print();
		myList.insert(4);
		myList.print();
		myList.insert(5);
		myList.print();
		myList.remove();
		myList.print();
		myList.remove();
		myList.print();
		myList.remove();
		myList.print();
		myList.remove();
		myList.print();
		myList.remove();
		myList.print();
	}
}

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}
}