package com.example;

public class Factorial {

	public static void main(String[] args) {
		Factorial ft = new Factorial();
		System.out.println(ft.findFactorialUsingRecursion(5));
	}

	/**
	 * This method find factorial of given number
	 * n = n * (n-1) * (n-2) * .. * 1;
	 * @param num
	 * @return
	 */
	private void findFactorialUsingIteration(int num){
		int factorial = 1;
		for(int i=0;i<num;i++){
			factorial = factorial * (num-i);
		}
		System.out.println(factorial);
		
	}
	
	private int findFactorialUsingRecursion(int num){
		// return condition
		if(num==1) return 1;
		
		return num * findFactorialUsingRecursion(num-1);
	}
}
