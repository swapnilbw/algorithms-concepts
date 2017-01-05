package com.example;

public class FindAllSubStrings {

	public static void main(String[] args) {
		FindAllSubStrings obj = new FindAllSubStrings();
		String inputString = "abb";
		// obj.printAllSubStrings(inputString);
		System.out.println(obj.printAllSubStringUsingRecursion("abb"));
	}

	private void printAllSubStrings(String inputString) {

		// abcd = a ab ac ad b bc bd

		int stringLength = inputString.length();
		for (int i = 0; i < stringLength; i++) {
			/// System.out.println("i "+ i);
			for (int j = i + 1; j <= stringLength; j++) {
				// System.out.println("j " +j + " stringLength
				// "+(stringLengthvoid-i));
				String result = inputString.charAt(i) + inputString.substring(j);
				System.out.println(result);
			}
		}
	}

	private String printAllSubStringUsingRecursion(String inputString) {
		/*
		 * for (int i = 0; i < inputString.length(); i++) {
		 * if(inputString.length()==0) return "";
		 */
		if(inputString.length()==0) return "";

		
		return  inputString.charAt(0) + printAllSubStringUsingRecursion(inputString.substring(1));
		// }
		// return "";
	}
}
