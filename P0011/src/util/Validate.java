package util;

import java.util.Scanner;

public class Validate {

    private final static Scanner SCANNER = new Scanner(System.in);

    /**
     * Get the valid integer number 
     * 
     * @param messageInfo               the message to be printed instructing 
     *                                  the user to input
     * @param messeageErroroutOfRange   the message will be printed if the 
     *                                  string parse value is out of range
     * @param messageErrorInvalidNumber the message will be printed if the
     *                                  string does not contain a passable 
     *                                  integer
     * @param min                       minimum limit value
     * @param max                       maximum limit value
     * @return the valid integer value scanned from the input
     */
    public static int getInt(
            String messageInfo,
            String messeageErroroutOfRange,
            String messageErrorInvalidNumber,
            int min, int max
    ) {
        while (true) {
            try {
                System.out.print(messageInfo);
                int number = Integer.parseInt(SCANNER.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println(messeageErroroutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(messageErrorInvalidNumber);
            }
        }
    }

    /**
     * Get the valid string
     * 
     * @param messageInfo               the message to be printed instructing 
     *                                  the user to input
     * @param messageErrorInvalidString the message will be printed if the 
     *                                  string does not contain a passable
     * @param messageErrorEmptyString   the message will be printed if the 
     *                                  string is empty
     * @param REGEX                     the pattern to check string is valid 
     *                                  or not
     * @return the valid string value scanned from the input                               
     */
    public static String getString(
        String messageInfo,
        String messageErrorInvalidString,
        String messageErrorEmptyString,
        String REGEX
    ){
        while(true){
            System.out.println(messageInfo);
            String result = SCANNER.nextLine().trim();
            if(result.matches(REGEX)){
                return result;
            }
            System.out.println(messageErrorInvalidString);
        }
    }
       
}
