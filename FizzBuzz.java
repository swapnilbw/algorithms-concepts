package com.example;

public class FizzBuzz {

	public static void main(String[] args) {
		FizzBuzz obj = new FizzBuzz();
		obj.printFizzBuzzNumbers();
	}
	/**
	 * This method print fizzbuzz for numbers upto 50
	 * number of multiple of 3 prints fizz
	 * number of multiple of 5 print buzz
	 * and number of both multiple of 3 and 5 print fizzbuzz
	 */
	private void printFizzBuzzNumbers(){
		
		for(int i=0;i<=50;i++){
			
			// if number is multiple of 3
			if(i>0 && i%3==0 && i%5==0){
				System.out.println("fizzbuzz");
			}else if(i>0 && i%3==0){
				System.out.println("fizz");
			}else if(i>0 && i%5==0){
				System.out.println("buzz");
			}else {
				System.out.println(i);
			}
		}
	}
}
