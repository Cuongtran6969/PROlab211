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
     * @param messInfo            the message to be printed instructing the user to input
     * @param messErrorRange      the message will be printed if the String parse
     *                            value is out of range
     * @param messErrorInvalidate the message will be printed if the String does
     *                            not contain a portable integer
     * @param min                 minimum limit value
     * @param max                 maximum limit value
     * @return the valid integer value scanned from the input
     */
    public static int getInt(
            String messInfo, String messErrorRange,
            String messErrorInvalidate, int min, int max) {
        do {
            try {
                System.out.print(messInfo);
                String input = SCANNER.nextLine();
                if (input.isEmpty()) {
                    return 0;
                } else {
                    int number = Integer.parseInt(input);
                    if (number >= min && number <= max) {
                        return number;
                    }
                    System.out.println(messErrorRange);
                }

            } catch (NumberFormatException e) {
                System.out.println(messErrorInvalidate);
            }

        } while (true);
    }
}
