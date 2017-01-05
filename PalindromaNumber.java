package com.example;

public class PalindromaNumber {

	public static void main(String[] args) {
		PalindromaNumber obj = new PalindromaNumber();
		System.out.println(obj.checkIfPalindroma(123));
	}

	private boolean checkIfPalindroma(int inNum){
		// 121 is Palindroma
		return inNum == getReverseNumber(inNum);
	}
	
	private int getReverseNumber(int inNum){
		StringBuilder strBld = new StringBuilder(String.valueOf(inNum));
		String reverseString = strBld.reverse().toString();
		return Integer.parseInt(reverseString);
	}
	
	private int getReverseWithoutString(int inNum){
		int reversenum = 0;
		return reversenum;
		// 123
		
	}
}
