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
     *
     * @param messageInfo
     * @param messageErrorOutOFRange
     * @param messageErrorInvalidNumber
     * @param min
     * @param max
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
     *
     * @param messageInfo
     * @param messageErrorInvalidString
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
     *
     * @param messageInfo
     * @param messageErrorOutOFRange
     * @param messageErrorInvalidString
     * @param min
     * @param max
     * @return
     */
    public static double getDouble(
            String messageInfo,
            String messageErrorOutOFRange,
            String messageErrorInvalidString,
            int min,
            int max
    ) {
        while (true) {
            try {
                System.out.println(messageInfo);
                double inputDouble = constant.SCANNER.nextDouble();
                constant.SCANNER.nextLine();
                if (inputDouble >= min || inputDouble <= max) {
                    return inputDouble;
                }
                System.out.println(messageErrorOutOFRange);
            } catch (Exception e) {
                System.out.println(messageErrorInvalidString);
            }
        }
    }
    public static String getStringByRegex(
            String messageInfo,
            String messageErrorInvalidString,
            String regex
    ) {
      while(true) {
        try{
            System.out.println(messageInfo);
            String stringValue = constant.SCANNER.nextLine();
            if(stringValue.matches(regex)) {
              return stringValue;
            }
        } catch (Exception e){
            System.out.println(e);   
        }
          System.out.println(messageErrorInvalidString);
      }
    }
    //return double variable
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
                }else{
                    System.out.println("Input must be in range [" + min + "," + max + "]");
                }
            } catch (NumberFormatException e) {
                System.out.println(salaryInvalid);
            }
        } while (true);
    
    }
    
    //return valid date
    public static Date getDate(
            String messageInfo,
            String messageError,
            String regex
    ) {
      while(true) {
       try{
         System.out.println(messageInfo);
         String stringDate = constant.SCANNER.nextLine();
         //create format date from regex
         SimpleDateFormat format = new SimpleDateFormat(regex);
         format.setLenient(false);
         //convert string to Date
         Date date = format.parse(stringDate);
         //get current date
         Date currentDate = new Date();
         //if date than current date
         if(date.after(currentDate)) {
             System.out.println("Date can't be future");
         }else{ 
            return date;
         }
       } catch (Exception e){
           System.out.println(messageError);
       }
      }
    }
    
}
