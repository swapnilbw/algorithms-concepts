package com.example;

import java.util.StringTokenizer;

/**
 * This class finds if a substring is present in given string
 * @author swakchau
 *
 */
public class FindStringContent {

	public static void main(String[] args) {
		FindStringContent obj = new FindStringContent();
		boolean contains = obj.containString("given test string is a String","te st");
		contains = obj.containswithoutUsingAPI("given test string is a String","test");
		//"a".contains("b");
		System.out.println(contains);
	}

	private boolean containString(String string, String string2) {
		StringTokenizer strTokenizer = new StringTokenizer(string);
		while(strTokenizer.hasMoreTokens()){
			if(string2.equals(strTokenizer.nextToken())) {
				return true;
			}
		}
		return false;
	}
	private boolean containswithoutUsingAPI(String origStr,String subStr){
		char[] origCharArr = origStr.toCharArray();
		char[] subStrArr = subStr.toCharArray();
		int subCharLength = subStrArr.length;
		int matchingCounter = 0;
		boolean matchFound = false;
		for (int j = 0; j < origCharArr.length; j++) {
			 if(origCharArr[j] ==subStrArr[matchingCounter]){
				 matchingCounter++;
				 matchFound = true;
			 }else if(matchingCounter<subCharLength){
				 if(matchFound) {
					 matchFound = false;
					 matchingCounter=0;
				 }
			 }
			 if(matchingCounter==subCharLength) return true;
		}
		return false;
	}
	
}
