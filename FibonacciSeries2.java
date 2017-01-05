package com.example;

public class FibonacciSeries2 {

	public static void main(String[] args) {

		printFibonacciSeriesUsingIteration(0,1);
		
		//printFibonacciSericesUsingRecursion();
	}
	static int result = 0;
	/*
	 * This method print fibonacci series using iteration.
	 * series 0 1 1 2 3 5 8 13 ... 
	 */
	private static void printFibonacciSericesUsingRecursion() {
		// first + second = third and so 
		int n0 = 0;
		int n1 = 1;
		int result = 0;
		
		while(result <100){
			System.out.println(n0);
			result = n0 + n1;
			n0 = n1;
			n1 = result;
		}
		
	}
   /**
    * This method print fibonacci series less than 100 using method recursion
    */
	private static void printFibonacciSeriesUsingIteration(int input,int nextNum) {
		// get result using recursion , method goes on stack until condition met
		System.out.println(input);
		// return condition 
		if(nextNum > 100) return ;
		result = input + nextNum;
		printFibonacciSeriesUsingIteration(nextNum,result);
		
	}

}
