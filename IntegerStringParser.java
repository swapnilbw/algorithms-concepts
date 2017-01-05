package com.example;

/**
 * This class convert given integer String to int number
 * @author swapnilbw
 *
 */
public class IntegerStringParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(parseString("75689"));
	}
	
	private static int parseString(String inputNum){
		
		int result = 0;
		while(inputNum.length()>0){
			
			result = result *10 + Integer.valueOf(""+inputNum.charAt(0));
			inputNum = inputNum.substring(1);
		}
		return result;
	}

}
