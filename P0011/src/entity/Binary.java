/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author dangx
 */
public class Binary {

    /**
     * Convert binary to decimal
     * 
     * @param binary the binary number be inputed by user
     * @return decimal string
     */
    public static String toDecimalString(String binary) {
        int decimal = 0;
        int power = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            char c = binary.charAt(i);
            //tra ve so nguyen tuong ung cua ky tu da cho
            int digit = Character.getNumericValue(c);
            decimal += digit * Math.pow(2, power);
            power++;
        }
        return String.valueOf(decimal);
    }

    /**
     * Convert binary to hexadecimal
     * 
     * @param binary the binary number be inputed by user
     * @return hexadecimal string
     */
    public static String toHexadecimalString(String binary) {
        String hexadecimal = Integer.toHexString(
                Integer.parseInt(toDecimalString(binary))).toUpperCase();
        return hexadecimal;
    }
}
