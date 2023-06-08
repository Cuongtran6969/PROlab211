/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Validate {
    final static Scanner SCANNER = new Scanner(System.in);
    
    /**
     * validate input data
     * 
     * @param messInfo          notify to user input
     * @param messageErrorRange notify when input value out of range
     * @param messageInvalidate notify when input value wrong format
     * @param min               minimum value
     * @param max               maximum value
     * @return the integers number validate
     */
    public static int getInt(
            String messInfo,
            String messageErrorRange,
            String messageInvalidate,
            int min, int max
    ) {
        while (true) {
            try {
                System.out.println(messInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messageErrorRange);
            } catch (NumberFormatException e) {
                System.out.println(messageInvalidate);
            }
        }
    }
}
