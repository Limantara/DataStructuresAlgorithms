class IterativeBinarySearch {
	public static boolean search(int[] arr, int target) {
		int startIndex = 0;
		int endIndex = arr.length - 1;

		while (startIndex <= endIndex) {
			int midIndex = (startIndex + endIndex) / 2;

			if (target == arr[midIndex])
				return true;
			else if (target < arr[midIndex]) 
				endIndex = midIndex - 1;
			else if (target > arr[midIndex])
				startIndex = midIndex + 1; 
		}

		return false;
	}
	public static void main(String[] args) {
		int[] sortedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


		System.out.println(IterativeBinarySearch.search(sortedArr, 0));
		System.out.println(IterativeBinarySearch.search(sortedArr, 2));
	}
}