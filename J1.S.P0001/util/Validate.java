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
        private static final Scanner SCANNER = new Scanner(System.in);
    
    /**
     * Get a valid integer input from the user within a specified range.
     *
     * @param messInfo            notify to user input
     * @param messErrorRange      notify when input value out of range
     * @param messErrorInvalidate notify when input value wrong format
     * @param min                 minimum limit
     * @param max                 maximum limit
     * @return the integers number validate
     */
    public static int getInt(
            String messInfo,
            String messErrorRange, 
            String messErrorInvalidate,
            int min, int max
    ) {
        do {
            try {
                System.out.print(messInfo);
                int number = Integer.parseInt(SCANNER.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messErrorRange);
            } catch (NumberFormatException e) {
                System.out.println(messErrorInvalidate);
            }
        } while (true);
    
}
