package main;

import util.Validate;
import constant.Regex;
import entity.Binary;
import entity.Decimal;
import entity.Hexadecimal;
import static util.Validate.getInt;

public class Main {

    /**
     * Display the convert form
     *
     * @param rootBase the root base need to convert
     * @param toCase1  the form number 1 which root base convert to
     * @param toCase2  the form number 2 which root base convert to
     * @return the option that user choose
     */
    private static int displayConvertForm(
            String rootBase,
            String toCase1,
            String toCase2
    ) {
        System.out.println("1. Convert from " + rootBase + " to " + toCase1);
        System.out.println("2. Convert from " + rootBase + " to " + toCase2);
        int result = getInt(
                "Enter your choice: ",
                "Please enter number from 1-2",
                "Invalid number",
                1, 2);
        return result;
    }

    /**
     * 
     * 
     * @param rootBase           the root base that user want to change
     * @param toCaseFirst        the first base that root base be changed to 
     * @param toCaseSecond       the second base that root base changed to
     * @param resultToCaseFirst  the result after root base be changed to first 
     *                           base
     * @param resultToCaseSecond the result after root base be changed to second
     *                           base
     */
    public static void convertBetweenBases(
            String rootBase,
            String toCaseFirst,
            String toCaseSecond,
            String resultToCaseFirst,
            String resultToCaseSecond
    ) {
        int choice = displayConvertForm(rootBase, toCaseFirst, toCaseSecond);
        switch (choice) {
            case 1:
                System.out.println(toCaseFirst + ": " + resultToCaseFirst);
                break;
            case 2:
                System.out.println(toCaseSecond + ": " + resultToCaseSecond);
                break;
        }

    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("------------------------------");
            System.out.println("");
            System.out.println("1-[BIN] convert to [...]");
            System.out.println("2-[DEC] convert to [...]");
            System.out.println("3-[HEX] convert to [...]");
            System.out.println("4-EXIT");
            int option = Validate.getInt(
                    "Enter the option: ",
                    "Please enter number from 1-4",
                    "Invalid number",
                    1, 4);
            switch (option) {
                case 1:
                    String binary = Validate.getString(
                            "Enter Binary number: ",
                            "Must be enter 0 or 1",
                            "Not be empty",
                            Regex.REGEX_BINARY
                    );
                    convertBetweenBases(
                            "Binary",
                            "Decimal",
                            "Hexadecimal",
                            Binary.toDecimalString(binary),
                            Binary.toHexadecimalString(binary)
                    );
                    break;
                case 2:
                    String decimal = Validate.getString(
                            "Enter Decimal number: ",
                            "Must be enter 0-9",
                            "Not be empty",
                            Regex.REGEX_DECIMAL
                    );
                    convertBetweenBases(
                            "Decimal",
                            "Binary",
                            "Hexadecimal",
                            Decimal.toBinaryString(decimal),
                            Decimal.toHexadecimalString(decimal)
                    );
                    break;
                case 3:
                    String hexadecimal = Validate.getString(
                            "Enter Hexadecimal number: ",
                            "Must be enter 0-9 A-F",
                            "Not be empty",
                            Regex.REGEX_HEXADECIMAL
                    );
                    convertBetweenBases(
                            "Hexadecimal",
                            "Decimal",
                            "Binary",
                            Hexadecimal.toDecimalString(hexadecimal),
                            Hexadecimal.toBinaryString(hexadecimal)
                    );
                    break;
                case 4:
                    return;
            }
        }
    }

}
