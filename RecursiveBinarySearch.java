class RecursiveBinarySearch {
	public static boolean search(int[] arr, int target, int startIndex, int endIndex) {
		
		if (startIndex <= endIndex) {
			int midIndex = (startIndex + endIndex) / 2;

			if (target == arr[midIndex])
				return true;
			else if (target < arr[midIndex])
				return search(arr, target, startIndex, midIndex-1);
			else if (target > arr[midIndex])
				return search(arr, target, midIndex+1, endIndex);
		}

		return false;
	}
	public static void main(String[] args) {
		int[] sortedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


		System.out.println(RecursiveBinarySearch.search(sortedArr, 0, 0, sortedArr.length-1));
		System.out.println(RecursiveBinarySearch.search(sortedArr, 2, 0, sortedArr.length-1));
	}
}