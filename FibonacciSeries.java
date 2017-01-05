package com.example;

public class FibonacciSeries{

	int result;
	 int temp ;
	 int preResult;
     private void printFibonacciSeries(){
         int result =0;
         int preResult =0;
         int tmp = 0;
         while(result<=100){
          	System.out.println(result);
          	tmp = result;
         	result = result + preResult;
         	preResult = tmp;
         	if(result==0) result =1;
 	}
         
     }
     private int printFibonacciUsingRecursion(int n,int nPlus){
        // add return condition

        
        	result = n + nPlus;
            if(n >100 ) return 0;

        	System.out.println(n);
        	n = nPlus;
        	nPlus = result;
        	
        	printFibonacciUsingRecursion(n,nPlus);
        	return result;

     }
     public static void main(String []args){
        FibonacciSeries fibObj = new FibonacciSeries();
        fibObj.printFibonacciUsingRecursion(0,1);
     }
     
}
