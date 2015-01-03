/**
 * Sort - Implementation of sorting algorithms
 *
 * @author Edwin Limantara
 * @version 1.0 December 2014
 */

public class Sort {

	/**
	 * Sorts the specified integer array into ascending order.
	 *
	 * <p> <i>Bubble sort</i> is an in-place sorting algorithm with quadratic 
	 * time-complexity in worst and average cases, but linear time-complexity in 
	 * best case.
	 *
	 * @param arr the array to be sorted.
	 */
	public static void Bubble(int[] arr) {
	
		boolean swapped = true;
		
		while(swapped) {
			
			swapped = false;
		
			for(int i = 1; i < arr.length; i++) {
			
				if(arr[i - 1] > arr[i]) {
					
					int temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
					swapped = true;
					
				}
				
			}
		
		}
		
	}
	
	/**
	 * Sorts the specified integer array into ascending order.
	 *
	 * <p> <i>Insertion sort</i> is an in-place sorting algorithm with quadratic 
	 * time-complexity in worst and average cases, but linear time-complexity in 
	 * best case.
	 *
	 * @param arr the array to be sorted.
	 */
	public static void Insertion(int[] arr) {
	
		for(int i = 1; i < arr.length; i++) {
		
			int j = i;
			
			while(j > 0 && arr[j - 1] > arr[j]) {
					
				int temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
				j--;
				
			}
		
		}
	
	}
	
	/**
	 * Sorts the specified integer array into ascending order.
	 *
	 * <p> <i>Selection sort</i> is an in-place sorting algorithm with quadratic 
	 * time-complexity.
	 *
	 * @param arr the array to be sorted.
	 */
	public static void Selection(int[] arr) {
	
		for(int i = 0; i < arr.length - 1; i++) {
		
			int minElementIndex = i;
						
			for(int j = i+1; j < arr.length; j++) {
			
				if(arr[j] < arr[minElementIndex]) {
				
					minElementIndex = j;
				
				}
			
			}
			
			int temp = arr[i];
			arr[i] = arr[minElementIndex];
			arr[minElementIndex] = temp;
			
		}
			
	}
	
	/**
	 * Sorts the specified integer array into ascending order.
	 *
	 * <p> <i>Merge sort</i> is a divide and conquer sorting algorithm with <i>n log(n)</i> 
	 * time-complexity. <i>Merge sort</i> is <strong>not</strong> an in-place sorting algorithm.
	 *
	 * @param arr the array to be sorted.
	 * @param startIndex index of the first element of the currently working part of the array. (Changes during recursion)
	 * @param endIndex index of the last element of the currently working part of the array. (Changes during recursion)
	 */
	public static void Merge(int[] arr, int startIndex, int endIndex) {
		
		if(startIndex < endIndex) {
		
			int midIndex = (startIndex + endIndex) / 2;
			Merge(arr, startIndex, midIndex);
			Merge(arr, midIndex + 1, endIndex);
			MergeSort(arr, startIndex, midIndex, endIndex);
			
		}
		
	}
	
	/**
	 * The core function of <i>Merge sort</i> that actually does the sorting.
	 */
	private static void MergeSort(int[] arr, int startIndex, int midIndex, int endIndex) {
	
		int[] copy = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			
			copy[i] = arr[i];
			
		}
		
		int i = startIndex;
		int j = midIndex + 1;
		int k = startIndex;
		
		while(i <= midIndex && j <= endIndex) {
		
			if(copy[i] <= copy[j]) {
			
				arr[k] = copy[i];
				i++;
				
			}
			else {
			
				arr[k] = copy[j];
				j++;
				
			}
			
			k++;
		
		}
		
		while(i <= midIndex) {
		
			arr[k] = copy[i];
			k++;
			i++;
		
		}
	
	}
	
	/**
	 * Sorts the specified integer array into ascending order.
	 *
	 * <p> <i>Quick sort</i> is a divide and conquer sorting algorithm with <i>n log(n)</i> 
	 * time-complexity in average and best cases, but quadratic in worst case. <i>Quick sort</i>
	 * <strong> is</strong> an in-place sorting algorithm. 
	 *
	 * @param arr the array to be sorted.
	 * @param startIndex index of the first element of the currently working part of the array. (Changes during recursion)
	 * @param endIndex index of the last element of the currently working part of the array. (Changes during recursion)
	 */
	public static void Quick(int[] arr, int startIndex, int endIndex) {
	
		if(startIndex < endIndex) {
		
			int midIndex = Partition(arr, startIndex, endIndex);
			Quick(arr, startIndex, midIndex - 1);
			Quick(arr, midIndex + 1, endIndex);
		
		}
	
	}
	
	private static int Partition(int[] arr, int startIndex, int endIndex) {
	
		int pivot = arr[endIndex];
		int pivotIndex = startIndex;
		
		for(int i = startIndex; i < endIndex; i++) {
		
			if(arr[i] <= pivot) {
			
				int temp = arr[i];
				arr[i] = arr[pivotIndex];
				arr[pivotIndex] = temp;
				pivotIndex++;
			
			}
		
		}
		
		int temp = arr[endIndex];
		arr[endIndex] = arr[pivotIndex];
		arr[pivotIndex] = temp;
		
		return pivotIndex;
	
	}
	
}