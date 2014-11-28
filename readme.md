Data Structures & Algorithms

####Data Structures

1. LinkedList
  * Implementation: SinglyLinkedList
  * Methods: insert(int), remove(), print()
  * Time Complexity: **Insertion:** O(1), **Removal:** O(1), **Search:** O(n)
2. BinarySearchTree
  * Implementation: LinkedListBinarySearchTree
  * Methods: getNodeWithKey(int), insert(int), preOrderTraversal(), postOrderTraversal(), inOrderTraversal()
  * Time Complexity: **Insertion:** Best: O(lg n) Worst: O(n), **Search:** Best: O(lg n) Worst: O(n)
3. Graph
  * Implementation: AdjacencyMatrix
  * Method: addEdge(int), addVertex(int), query(int, int)
  * Time Complexity: **AddEdge:** O(1), **AddVertex:** O( |v|^2 ), **Query:** O(1)
  * Space Complexity: O( |v|^2 )

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


####Searching Algorithms

1. BinarySearch
  * Implementation: IterativeBinarySearch, RecursiveBinarySearch
  * Time Complexity: O(lg n)

