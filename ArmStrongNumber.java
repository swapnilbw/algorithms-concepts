package com.example;

public class ArmStrongNumber {

	public static void main(String[] args) {
		ArmStrongNumber obj = new ArmStrongNumber();
		//obj.findAmrStrongNumbers();
		System.out.println(obj.isNumerArmStrongNum(100));
	}
	/**
	 * This method print all 3 digit ArmStrong numbers
	 */
	private void findAmrStrongNumbers(){
		
		for(int i =100 ; i<=999 ; i++){
			
			String s = String.valueOf(i);
			char [] chrArr = s.toCharArray();
			int armStrongNumber = 0;
			for(char eachChar:chrArr){
				// convert to int 
				int eachDigit = Integer.valueOf(""+eachChar);
				armStrongNumber =armStrongNumber + ( eachDigit * eachDigit * eachDigit);
			}
			if(i==armStrongNumber)
				System.out.println(armStrongNumber);
		}
	}
	
	// find armstrong number
	private boolean isNumerArmStrongNum(int inputNo){
		
		// abc if == a*a*a + b*b*b + c*c*c
		
		int result = 0;
		int armStrongNum = inputNo;
		int eachDigit = 0;
		while(inputNo!=0){
			eachDigit = inputNo % 10;
			result = result + ( eachDigit * eachDigit * eachDigit);
			inputNo = inputNo /10;
		}
		return armStrongNum == result;
	}
	// find armstrong number using recursion
	
}
