class InsertionSort {
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {

			int j = i;
			while (j > 0) {
				if (arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
				j--;
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {1 ,4, 2, 3, 5, 8, 7, 6, 9 ,10};

		InsertionSort.sort(arr);
		for (int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}