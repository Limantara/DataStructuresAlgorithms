class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
		next = null;
	}
}

public class SinglyLinkedList<T> {
	public Node<T> head;
	private Node<T> tail;

	public SinglyLinkedList() {
		head = null;
		tail = null;
	}
	public void insert(T data) {
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
				Node<T> curr = head;

				while(curr.next != tail) {
					curr = curr.next;
				}

				tail = curr;
				tail.next = null;
			}
		}
	}
	public void print() {
		Node<T> curr = head;

		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}

		System.out.println();
	}
	public static void main(String[] args) {
		SinglyLinkedList<Integer> myList = new SinglyLinkedList();
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

