class QuickSort {
	private static int partition(int[] arr, int startIndex, int endIndex) {
		int pivot = arr[endIndex];
		int pivotIndex = startIndex;

		for (int i = startIndex; i < endIndex; i++) {
			if (arr[i] <= pivot) {
				int temp = arr[pivotIndex];
				arr[pivotIndex] = arr[i];
				arr[i] = temp;
				pivotIndex++;
			}
		}

		int temp = arr[endIndex];
		arr[endIndex] = arr[pivotIndex];
		arr[pivotIndex] = temp;

		return pivotIndex;
	}
	private static void quickSort(int[] arr, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int pivotIndex = partition(arr, startIndex, endIndex);
			quickSort(arr, startIndex, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, endIndex);
		}
	}
	public static void sort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	public static void main(String[] args) {
		int[] arr = {1 ,4, 2, 3, 5, 8, 7, 6, 9 ,10};

		QuickSort.sort(arr);
		for (int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}