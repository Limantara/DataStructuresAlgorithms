Data Structures & Algorithms

####Data Structures

1. LinkedList
  * Implementation: SinglyLinkedList
  * Methods: insert(data), removeFirst(), removeLast(), print()
  * Time Complexity: **Insertion:** O(1), **Removal:** O(1), **Search:** O(n)
  * Algorithms:
    1. insert(data)
      1. Case 1: `head == null` (empty list)
        * `head = new Node(data)`
        * `tail = head`
      2. Case 2: (list is not empty)
        * `tail.next = new Node(data)`
        * `tail = tail.next`
    2. removeFirst(): 
      1. Case 1: `head == null` (empty list)
        * return
      2. Case 2: `head != null` (list is not empty)
        1. Case a: `head == tail` (only one node)
          * set `head` and `tail` to `null`
        2. Case b: (more than one node)
          * `head` = `head.next`
    3. removeLast():
      1. Case 1: `head == null` (empty list)
        * return
      2. Case 2: (list is not empty)
        1. Case a: `head == tail` (only one node)
          * set `head` and `tail` to `null` 
        2. Case b: (more than one node)
          * create new Node pointer and set it equal to `head`
          * traverse the list with the new pointer until one node before tail
          * set tail equal to this new pointer and tail's next to `null`

2. BinarySearchTree
  * Implementation: LinkedListBinarySearchTree
  * Methods: insert(data), preOrderTraversal(), postOrderTraversal(), inOrderTraversal()
  * Time Complexity: **Insertion:** Best: O(lg n) Worst: O(n)
  * Algorithms:
    1. insert(data,key)
      1. Case 1: `root == null` (empty tree)
        * `root = new Node(data,key)`
      2. Case 2: (tree is not empty)
        * Create a Node pointer `focusNode`, set it equal to `head`
        * Create another Node pointer `parent`, set it equal to `null`
        * `while(focusNode != null)`: traverse the list such that if the new Node's key is less than `focusNode`'s key, go to the left child, but if the new Node's key is greater than `focusNode`'s key, go to the right child. Assume no duplicate keys are allowed
        * At the end of the loop, `focusNode` is pointing to `null`, and `parent` is pointing to the Node that soon will become the parent of the new Node. Then, insert the new Node to the left of `parent` if its key is less than `parent`'s key or to the right of `parent` if its key is greater than `parent`'s key
    2. preOrderTraversal() - This is a wrapper function that makes a call to a recursive function `preOrderFunc(root)`
      * preOrderFunc(root)
        * Base Case: `if(root == null) return;`
        * Otherwise, 1. Print `root`, 2. call `preOrderFunc(root.left)`, 3. call `preOrderFunc(root.right)`
    3. postOrderTraversal() - This is a wrapper function that makes a call to a recursive function `postOrderFunc(root)`
      * postOrderFunc(root)
        * Base Case: `if(root == null) return;`
        * Otherwise, 1. call `postOrderFunc(root.left)`, 2. call `postOrderFunc(root.right)`, 3. Print `root`
    2. inOrderTraversal() - This is a wrapper function that makes a call to a recursive function `inOrderFunc(root)`
      * inOrderFunc(root)
        * Base Case: `if(root == null) return;`
        * Otherwise, 1. call `inOrderFunc(root.left)`, 2. Print `root`, 3. call `inOrderFunc(root.right)`

3. Graph
  * Implementation: AdjacencyMatrix, AdjacencyList
  * Method: addEdge(data), addVertex(data)
  * Time Complexity: 
    -  AdjacencyMatrix: **AddVertex:** O( |v|^2 ), **AddEdge:** O(1)
    -  AdjacencyList: **AddVertex:** O(1), **AddEdge:** O(1)
  * Space Complexity: 
    -  AdjacencyMatrix: O( |v|^2 )
    -  AdjacencyList: O( |v| + |e| )

4. Heap
  * Implementation: MaxHeap
  * Method: build(array), heapify(arr,i)
  * Time Complexity:
    - **Heapify:** O(n), **Build:** O(n)

####Sorting Algorithms

1. BubbleSort
  * Time Complexity: 
    **Worst:** O(n^2), **Average:** O(n^2), **Best:** O(n)
  * Space Complexity: O(1)
2. InsertionSort
  * Time Complexity:
    **Worst:** O(n^2), **Average:** O(n^2), **Best:** O(n)
  * Space Complexity: O(1)
3. SelectionSort
  * Time Complexity:
    **Worst:** O(n^2), **Average:** O(n^2), **Best:** O(n^2)
  * Space Complexity: O(1)
4. MergeSort
  * Time Complexity: **Worst:** O(nlg n), **Average:** O(nlg n), **Best:** O(nlg n)
  * Space Complexity: O(n)
5. QuickSort
  * Time Complexity: **Worst:** O(n^2), **Average:** O(nlg n), **Best:** O(nlg n)
  * Space Complexity: O(1)
6. HeapSort
  * Time Complexity: O(nlg n)
  * Space Complexity: O(1)


####Searching Algorithms

1. BinarySearch
  * Implementation: IterativeBinarySearch, RecursiveBinarySearch
  * Time Complexity: O(lg n)
2. BreadthFirstSearch
  * Time Complexity: **Worst:** O( |v| + |e| )
  * Space Complexity: **Worst:** O( |v| )
3. DepthFirstSearch
  * Implementation: Recusive
  * Time Complexity: **Worst:** O( |v| + |e| )
  * Space Complexity: **Worst:** O( |v| )

