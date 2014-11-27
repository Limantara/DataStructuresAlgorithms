class SelectionSort {
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = arr[i];
			int minIndex = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minIndex = j;
				}
			}

			arr[minIndex] = arr[i];
			arr[i] = min;
		}
	}
	public static void main(String[] args) {
		int[] arr = {1 ,4, 2, 3, 5, 8, 7, 6, 9 ,10};

		SelectionSort.sort(arr);
		for (int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}