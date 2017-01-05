package com.example;

public class ReverseInt {

	public static void main(String[] args) {
		System.out.println(reverseInt(123456));
	}
	
	private static int reverseInt(int inputInt){
		
		int result = 0;
		
		while(inputInt != 0){
			
			result = result *10 + inputInt %10;
			inputInt = inputInt / 10 ;
		}
		return result;
	}
}
