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
    private final Scanner SCANNER = new Scanner(System.in);
    private final String REGEX_INTEGER = "\\d+";
    
    /**
     * validate input data
     * 
     * @param messInfo          notify to user input
     * @param messageErrorRange notify when input value out of range
     * @param messageInvalidate notify when input value wrong format
     * @param min               limit min 
     * @param max               limit max
     * @return the integers number validate
     */
    public int getInt(
            String messInfo,
            String messageErrorRange,
            String messageInvalidate,
            double min,
            double max
    ) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int number = 0;
        while (flag) {
            System.out.print(messInfo);
            String numberStr = scanner.nextLine().trim();
            if (numberStr.matches(REGEX_INTEGER)) {
                number = Integer.valueOf(numberStr);
                if (number >= min && number <= max) {
                    flag = false;
                } else {
                    System.out.println(messageErrorRange);
                }
            } else {
                System.out.println(messageInvalidate);
            }
        }
        return number;
    }
}
