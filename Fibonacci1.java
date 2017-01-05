package com.example;
/**
 * this class print the Fibonacci series numbers
 * @author swapnilbw
 *
 */
public class Fibonacci1 {

	int result;
	public static void main(String[] args) {
		Fibonacci1 obj = new Fibonacci1();
		obj.fibonacciWithoutRecursion();
	}
	/**
	 * Method to print fibonacci series
	 * e.g. 0 1 1 2 5 7 13
	 */
	private void printFibonacciNumbers(int n0, int n1){
		
		// exit condition
		if(n0>=100) return ;
		
		System.out.println(n0);
		result = n0 + n1;
		n0= n1;
		n1= result;
		
		printFibonacciNumbers(n0,n1);
		
	}
	private void anotherWayFibSeries(int n0,int n1){
		System.out.println(n0);
		if(n0>100) return;
		anotherWayFibSeries(n1,n0+n1);
	}
	private void fibonacciWithoutRecursion(){
		
		int n0 = 0;
		int n1 = 1;
		int result = 0;
				
		
		while(n0<=100){
			System.out.println(n0);
			result = n0+ n1;
			n0 = n1;
			n1 = result;
		}
		
	}
}
