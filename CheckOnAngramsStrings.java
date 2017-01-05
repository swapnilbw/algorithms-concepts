package com.example;

public class CheckOnAngramsStrings {

	public static void main(String[] args) {
		
		CheckOnAngramsStrings obj = new CheckOnAngramsStrings();
		String firstString = "sony12";
		String secondString = "22no1ys";

		boolean areAnagram = obj.checkForAngrams(firstString, secondString);
		System.out.println(areAnagram);
	}

	/**
	 * This method check if input strings are Angram.
	 * 
	 * @param firstString
	 * @param secondString
	 * @return boolean result
	 */
	public  boolean checkForAngrams(String firstString, String secondString) {

		if (secondString==null || secondString.isEmpty() || secondString==null || secondString.isEmpty() || !firstString.equalsIgnoreCase(secondString))
			return false;

		char[] firstCharArr = firstString.toCharArray();
		for (char eachChar : firstCharArr) {
			int charIndex = secondString.indexOf(eachChar);
			if (charIndex == -1) {
				// strings are not Anagrams
				return false;
			} else {
				// remove found char from second string
				secondString = secondString.substring(0, charIndex)
						+ secondString.substring(charIndex + 1, secondString.length());
			}
		}
		return true;

	}
}
