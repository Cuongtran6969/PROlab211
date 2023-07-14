/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;


public class Fibonacci {
    
    /**
     * Use recursive function to print out the Fibonacci number 
     * 
     * @param remainingStep  The number of step remaining to print out
     *                       in the sequence.
     * @param previousNumber The previous number in the sequence
     * @param currentNumber  The current number in the sequence
     * @return The current number in the sequence
     *                      
     */

    public static int caculateFibonacci(
            int remainingStep,
            int previousNumber,
            int currentNumber
    ) {
        if (remainingStep < 1) {
            return currentNumber;
        }
        System.out.print(currentNumber + " ");
        return caculateFibonacci(
                remainingStep - 1,
                currentNumber,
                previousNumber + currentNumber
        );
    }

}



