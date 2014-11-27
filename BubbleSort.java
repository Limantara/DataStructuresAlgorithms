class BubbleSort {
	public static void sort(int[] arr) {
		boolean swapped = true;

		while(swapped) {
			swapped = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i+1] < arr[i]) {
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {1 ,4, 2, 3, 5, 8, 7, 6, 9 ,10};

		BubbleSort.sort(arr);
		for (int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}