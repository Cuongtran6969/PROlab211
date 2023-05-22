/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import constant.constant;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class getValidInput {

    /**
     * check valid input value and return value is integer pass condition is in
     * a range min to max, and no error occurs
     *
     * @param messageInfo               message for user input
     * @param messageErrorOutOFRange    message error when value out of range
     * @param messageErrorInvalidNumber message when occur error
     * @param min                       value return must big than min
     * @param max                       value return must small than max
     * @return
     */
    public static int getInt(
            String messageInfo,
            String messageErrorOutOFRange,
            String messageErrorInvalidNumber,
            int min,
            int max
    ) {
        do {
            try {
                System.out.println(messageInfo);
                int inputNumber = Integer.parseInt(constant.SCANNER.nextLine());
                if (inputNumber >= min || inputNumber <= max) {
                    return inputNumber;
                }
                System.out.println(messageErrorOutOFRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        } while (true);
    }

    /**
     * check value input is a string, check empty, check exception and return
     * invalid string
     *
     * @param messageInfo               message for user input
     * @param messageErrorInvalidString message when occur error
     * @return
     */
    public static String getString(
            String messageInfo,
            String messageErrorInvalidString
    ) {
        while (true) {
            try {
                System.out.println(messageInfo);
                String inputString = constant.SCANNER.nextLine();
                if (inputString.equals("")) {
                    System.out.println("Input can't be empty");
                } else {
                    return inputString;
                }

            } catch (Exception e) {
                System.out.println(messageErrorInvalidString);
            }
        }
    }

    /**
     * return value input is data type is double, between min and max and and no
     * error occurs
     *
     * @param messageInfo   message for user input
     * @param salaryInvalid message when occur error
     * @param min value     return must big than min
     * @param max value     return must small than max
     * @return
     */
    public static double getDouble(
            String messageInfo,
            String salaryInvalid,
            double min,
            double max
    ) {
        do {
            try {
                System.out.println(messageInfo);
                double inputNumber = Integer.parseInt(constant.SCANNER.nextLine());
                if (inputNumber >= min || inputNumber <= max) {
                    return inputNumber;
                } else {
                    System.out.println("Input must be in range [" + min + "," + max + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println(salaryInvalid);
            }
        } while (true);
    }

    /**
     * return a string have if input value matches with parameter is regular
     * expression and catch error if occur a error in reading input
     *
     * @param messageInfo               message for user input
     * @param messageErrorInvalidString message when occur error
     * @param regex                     regular express to check string matches
     * @return
     */
    public static String getStringByRegex(
            String messageInfo,
            String messageErrorInvalidString,
            String regex
    ) {
        while (true) {
            try {
                System.out.println(messageInfo);
                String stringValue = constant.SCANNER.nextLine();
                if (stringValue.matches(regex)) {
                    return stringValue;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(messageErrorInvalidString);
        }
    }

    /**
     * use SimpleDateFormat to create a format according to the regular express
     * and set date in strict mode, covert string to format date, checks if it
     * is a date in the future, the function will give an error and ask the user
     * to enter it again, otherwise will return this date
     *
     * @param messageInfo  message for user input
     * @param messageError message if occur error
     * @param regex        regular express of format date
     * @return
     */
    public static Date getDate(
            String messageInfo,
            String messageError,
            String regex
    ) {
        while (true) {
            try {
                System.out.println(messageInfo);
                String stringDate = constant.SCANNER.nextLine();
                SimpleDateFormat format = new SimpleDateFormat(regex);
                format.setLenient(false);
                Date date = format.parse(stringDate);
                Date currentDate = new Date();
                if (date.after(currentDate)) {
                    System.out.println("Date can't be future");
                } else {
                    return date;
                }
            } catch (Exception e) {
                System.out.println(messageError);
            }
        }
    }
}
