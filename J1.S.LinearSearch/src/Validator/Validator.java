/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import java.util.Scanner;

/**
 *
 * @author acer
 */
public class Validator {
    static Scanner sc = new Scanner(System.in);
    
    /**
     *
     * @param messInfo            the message to be printed instructing the user
     *                            to input
     * @param messErrorRange      the message will be printed if value is out 
     *                            of range
     * @param messErrorInvalidate the message will be printed if Invalidate
     *                            input
     * @param min                 minimum limit value
     * @param max                 maximum limit value
     * @return the valid integer value scanned from the input
     */
    public static int getInt(
            String messInfo, String messErrorRange,
            String messErrorInvalidate, int min, int max
    ) {
        do {
            try {
                System.out.print(messInfo);
                int number = Integer.parseInt(sc.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messErrorRange);
            } catch (NumberFormatException e) {
                System.out.println(messErrorInvalidate);
            }

        } while (true);
    }

   
}
