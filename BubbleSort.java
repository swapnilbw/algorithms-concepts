package com.example;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {10,23,18,4,77,99,6};
		//int arr[] = {10,23,18};
		bubbleSortMe(arr);
	}

	private static void bubbleSortMe(int[] arr) {
		
		// start from index 1 (i) , check with i+1 index value, swap values of right side is bigger
		int swapVariable = 0;
		for(int i=0;i < arr.length ;i++){
			for(int j =0;j < arr.length-(i+1) ; j++){
				 if(arr[j] > arr[j+1]) {
					 swapVariable = arr[j+1];
					 arr[j+1] = arr[j];
					 arr[j]  = swapVariable; 
				 }
			}
		}
		//print sorted array
		for(int i =0 ; i < arr.length;i++){
			System.out.println(arr[i]);
		}
	}

}
