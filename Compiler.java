package com.example;

import java.util.Stack;

import org.apache.commons.codec.CharEncoding;

/**
 * This class validate code syntax
 * for example : {[{(())}]} is valid because of matching opening close brackets.
 * @author swapnilbw
 *
 */
public class Compiler {

	public static void main(String[] args) {
		Compiler obj = new Compiler();
		System.out.println(obj.checkPatternUsingOneStack("{{}}()[][]{[]}"));
	}
	private boolean compileStringIfValid(String inputStr){
		char[] arr = inputStr.toCharArray();
		Stack<Character> leftBracket = new Stack<>();
		Stack<Character> rightBracket = new Stack<>();
		
		if(arr.length %2 != 0){
			return false;
		}
		else {
			int counter = 0;
			for(char eachChar : arr){
				// add left side of brackets to one stack
				if(counter<arr.length/2){
					leftBracket.push(eachChar);
				}else{
					rightBracket.push(eachChar);
				}
				counter++;
			}
			while(leftBracket.isEmpty()){
				if(leftBracket.pop()!=rightBracket.pop()) return false;
			}
			return true;
		}
		
	}

	private boolean checkPatternUsingOneStack(String inputStr){
		char[] charArr = inputStr.toCharArray();
		Stack<Character> symbolStack = new Stack<>();
		
		if( charArr.length %2 != 0 ) return false;
		
		for(char eachChar : charArr){
			if(eachChar == '{' || eachChar == '(' || eachChar == '['){
				symbolStack.add(eachChar);
			}else{
				if(symbolStack.isEmpty()){
					return false;
				}
				if(eachChar == '}' && '{' != symbolStack.pop()){
					return false;
				}else if( eachChar == ']' && '[' != symbolStack.pop()){
					return false;
				}else if( eachChar == ')' && '(' != symbolStack.pop()){
					return false;
				}
			}
			
		}
		
		return symbolStack.isEmpty();
	}
}
