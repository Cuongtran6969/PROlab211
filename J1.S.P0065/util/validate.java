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
public class validate {
    private static final Scanner SCANNER = new Scanner(System.in);
   
    /**
     * return a String after validate
     * 
     * @param messageInfo  notification to user start input
     * @param messageEmpty notification when input empty value
     * @return a string validate not empty
     */
    public static String getString(
            String messageInfo,
            String messageEmpty
    ) {
        while (true) {
            System.out.print(messageInfo);
            String content = SCANNER.nextLine().trim();
            if (content.isEmpty()) {
                System.out.println(messageEmpty);
            } else {
                return content;
            }
        }
    }

    /**
     * return a double variable validate
     * 
     * @param messageInfo         notification to user start input
     * @param messageSmallThanMin notification if smaller than min
     * @param messageBigThanMax   notification if bigger than min
     * @param messageInvalid      notification invalid number
     * @param min                 limit min
     * @param max                 limit max
     * @return a double variable valid, between min to max
     */
    public static double getDouble(
            String messageInfo,
            String messageSmallThanMin,
            String messageBigThanMax,
            String messageInvalid,
            int min,
            int max
    ) {
        while (true) {
            try {
                double doubleNumber;
                doubleNumber = Double.parseDouble(
                        getString(messageInfo, messageInvalid));
                if (doubleNumber < min) {
                    System.out.println(messageSmallThanMin);
                } else if (doubleNumber > max) {
                    System.out.println(messageBigThanMax);
                } else {
                    return doubleNumber;
                }
            } catch (NumberFormatException e) {
                System.out.println(messageInvalid);
            }
        }
    }
    
    /**
     * return a boolean true or false, if (y, Y) is true, if(n, N) is false
     * 
     * @param messageInfo    notification to user start input
     * @param messageEmpty   notification when input empty value
     * @param messageInvalid notification when input invalid value
     * @return a boolean variable 
     */
    public static boolean checkYesNo(
            String messageInfo,
            String messageEmpty,
            String messageInvalid
    ) {
        while (true) {
            String results = getString(messageInfo, messageEmpty);
            if (results.length() == 1) {
                char resultChar = results.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }
            System.out.println(messageInvalid);
        }
    }
}
