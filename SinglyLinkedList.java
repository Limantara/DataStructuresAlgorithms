class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}
}

public class SinglyLinkedList {
	public Node head;
	private Node tail;

	public SinglyLinkedList() {
		head = null;
		tail = null;
	}
	public void insert(int data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
		} else {
			tail.next = new Node(data);
			tail = tail.next;
		}
	}
	public void removeFirst() {
		if(head != null) {
			if(head == tail) {
				head = null;
				tail = null;
			} else {
				head = head.next;
			}
		}
	}
	public void removeLast() {
		if(head != null) {
			if(head == tail) {
				head = null;
				tail = null;
			} else {
				Node curr = head;

				while(curr.next != tail) {
					curr = curr.next;
				}

				tail = curr;
				tail.next = null;
			}
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
		myList.removeLast();
		myList.print();
		myList.removeLast();
		myList.print();
		myList.removeLast();
		myList.print();
		myList.removeLast();
		myList.print();
		myList.removeLast();
		myList.print();

	}
}

