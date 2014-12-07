class MaxHeap {
	int[] array;
	int largest_element_index;
	int last_index; 

	int left_child_index(int i) {
		return (2 * i) + 1;
	}

	int right_child_index(int i) {
		return (2 * i) + 2;
	}

	int parent_index(int i) {
		return (i - 1) / 2;
	}

	void build(int[] arr) {
		last_index = arr.length - 1;
		build_max_heap(arr);
		array = arr;
	}

	void build_max_heap(int[] arr) {

		for(int i = last_index / 2; i >= 0; i--) {
			heapify(arr,i);
		}
	}

	void heapify(int[] arr, int i) {
		if(left_child_index(i) <= last_index && arr[i] > arr[left_child_index(i)]) {
			largest_element_index = i;
		} else if(left_child_index(i) <= last_index && arr[left_child_index(i)] > arr[largest_element_index]) {
			largest_element_index = left_child_index(i);
		}

		if(right_child_index(i) <= last_index && arr[right_child_index(i)] > arr[largest_element_index]) {
			largest_element_index = right_child_index(i);
		}

		if(largest_element_index != i) {
			exchange_elements_of(arr,largest_element_index,i);
			heapify(arr,largest_element_index);
		}
	}

	void exchange_elements_of(int[] arr, int largest_element_index, int i) {
		int temp = arr[largest_element_index];
		arr[largest_element_index] = arr[i];
		arr[i] = temp;
	}

	int max() {
		return (array == null) ? -1 : array[0];
	}

	void print_array() {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MaxHeap myHeap = new MaxHeap();

		int arr[] = {4,1,3,2,16,9,10,14,8,7};
		myHeap.build(arr);

		myHeap.print_array();
	}
}