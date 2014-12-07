class HeapSort {
	public void sort(int[] arr) {
		last_index = arr.length - 1;

		build_max_heap(arr);

		for(int i = arr.length-1; i >= 1; i--) {
			exchange_elements_of(arr,0,i);
			last_index--;
			max_heapify(arr,0);
		}
	}

	private int last_index;

	private int left_child_index(int i) {
		return (2 * i) + 1;
	}

	private int right_child_index(int i) {
		return (2 * i) + 2;
	}

	private int parent_index(int i) {
		return (i - 1) / 2;
	}

	private void build_max_heap(int[] arr) {
		for(int i = (arr.length-1) / 2; i >= 0; i--) {
			max_heapify(arr,i);
		}
	}

	private void max_heapify(int[] arr, int i) {
		int largest_element_index = -1;

		if(left_child_index(i) <= last_index && arr[i] > arr[left_child_index(i)]) {
			largest_element_index = i;
		} else if(left_child_index(i) <= last_index && arr[left_child_index(i)] > arr[i]) {
			largest_element_index = left_child_index(i);
		}

		if(right_child_index(i) <= last_index && arr[right_child_index(i)] > arr[largest_element_index]) {
			largest_element_index = right_child_index(i);
		}

		if(largest_element_index != -1 && largest_element_index != i) {
			exchange_elements_of(arr,largest_element_index,i);
			max_heapify(arr,largest_element_index);
		}
	}

	private void exchange_elements_of(int[] arr, int largest_element_index, int i) {
		int temp = arr[largest_element_index];
		arr[largest_element_index] = arr[i];
		arr[i] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {1 ,4, 2, 3, 5, 8, 7, 6, 9 ,10};
		HeapSort heap = new HeapSort();

		heap.sort(arr);

		for (int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
