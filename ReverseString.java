package com.example;

public class ReverseString {

	static int strLength = 0;
	/**
	 * This method reverse given input string and prints output.
	 */
	private static void reverseAndPrintString(String inputStr){
		
		char[] strArr = inputStr.toCharArray();
		
		for(int i=(strArr.length-1);i>=0;i--){
			System.out.println(strArr[i]);
		}
	}
	
	public static void main(String[] args) {
		//reverseAndPrintString("ABC");
		reverseStringUsingRecursion("ABC");
	}
	
	private static void reverseStringUsingRecursion(String inputStr){
		strLength = inputStr.length();
		if(strLength==0) return;
		String result = ""+inputStr.charAt(strLength-1);
		System.out.println(result);
		reverseStringUsingRecursion(inputStr.substring(0, strLength-1));
	}
	private static String reverseStringRecursively(String inStr){
		 
		if(inStr.length() < 2 ){
			return inStr;
		}
		
		//return inStr.charAt(inStr.length()-1) + reverseStringRecursively(inStr.substring(0,inStr.length()-1));
		return reverseStringRecursively(inStr.substring(1)) + inStr.charAt(1);
	}
}
