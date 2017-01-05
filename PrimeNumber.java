package com.example;

public class PrimeNumber {

	public static void main(String[] args) {
		PrimeNumber pnum = new PrimeNumber();
		System.out.println(pnum.isNumberPrime(11));

	}

	private boolean isNumberPrime(int num) {
		// if number is divisible by same number and 1 , then only it is prime
		// number
		if(num<1) return false;
		for (int i = 2; i < num; i++) {
			if(num%i==0) return false;
		}
		return true;
	}

}
