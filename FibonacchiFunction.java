package com.example;

public class FibonacchiFunction {

	public static void main(String[] args) {
		byte a = 'a';
		System.out.println(MySingleToneClass.INSTANCE.pleaseCallMe());
		System.out.println(a);
		FibonacchiFunction fibObj = new FibonacchiFunction();
		int inputNumber = 6;
		int resulto = fibObj.calculateFibonachi(inputNumber);
		System.out.println(resulto);
		int result = fibObj.findFibonachiUsingIteration(inputNumber);
		System.out.println(result);
	}

	private int calculateFibonachi(int inputNumber) {
		if (inputNumber == 0)
			return 0;
		else if (inputNumber == 1)
			return 1;

		return calculateFibonachi(inputNumber - 1)
				+ calculateFibonachi(inputNumber - 2);
	}

	private int findFibonachiUsingIteration(int inputNumber) {

		int result = 0;
		int n0 = 0;
		int n1 = 1;
		for (int i = 1; i < inputNumber; i++) {
			result = n0 + n1;
			n0 = n1;
			n1 = result;
		}
		return result;

	}
}
