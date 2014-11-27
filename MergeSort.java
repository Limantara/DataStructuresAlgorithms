class MergeSort {
	public static void Merge(int[] arr, int startIndex, int midIndex, int endIndex) {
		int[] tempArr = new int[arr.length];

		for (int index = startIndex; index <= endIndex; index++) {
			tempArr[index] = arr[index];
		}

		int i = startIndex;
		int j = midIndex + 1;
		int k = startIndex;

		while ((i <= midIndex) && (j <= endIndex)) {
			if (tempArr[j] < tempArr[i]) {
				arr[k] = tempArr[j];
				j++;
			} else {
				arr[k] = tempArr[i];
				i++;
			}
			k++;
		}

		while (i <= midIndex) {
			arr[k] = tempArr[i];
			i++;
			k++;
		}
	}
	public static void MergeSort(int[] arr, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int midIndex = (startIndex + endIndex) / 2;
			MergeSort(arr, startIndex, midIndex);
			MergeSort(arr, midIndex + 1, endIndex);
			Merge(arr, startIndex, midIndex, endIndex);
		}
	}
	public static void sort(int[] arr) {
		MergeSort(arr, 0, arr.length - 1);
	}
	public static void main(String[] args) {
		int[] arr = {1 ,4, 2, 3, 5, 8, 7, 6, 10 ,9};
		//int[] arr = {1 ,4, 2, 3};

		MergeSort.sort(arr);
		for (int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}