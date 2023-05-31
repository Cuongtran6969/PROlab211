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

    public static String getValidString(
            String message,
            String validInput
    ) {
        while (true) {
            try {
                System.out.print(message);
                String stringInput = SCANNER.nextLine();
                if (stringInput.equals("")) {
                    System.out.println("Input can't be empty");
                } else {
                    return stringInput;
                }
            } catch (Exception e) {
                System.out.println(validInput);
            }
        }
    }

    public static float getFloat(
            String messageInfo,
            String messageErrorOutOFRange,
            String messageErrorInvalidNumber,
            int min,
            int max
    ) {
        do {
            try {
                System.out.print(messageInfo);
                Float inputNumber = Float.parseFloat(SCANNER.nextLine());
                if (inputNumber >= min || inputNumber <= max) {
                    return inputNumber;
                }
                System.out.println(messageErrorOutOFRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

    public static boolean getUserYesNoChoice(
            String message,
            String messageError
    ) {
        while (true) {
            System.out.print(message);
            String userInput = SCANNER.nextLine();
            switch (userInput) {
                case "N":
                    return false;
                case "Y":
                    return true;
                default:
                    System.out.println(messageError);
                    break;
            }
        }
    }
}
