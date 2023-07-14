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
public class Decimal {

    /**
     * Convert decimal to binary
     * 
     * @param decimal the decimal number be inputed by user
     * @return binary string
     */
    public static String toBinaryString(String decimal) {
        String binary = Integer.toBinaryString(Integer.parseInt(decimal));
        return binary;
    }

    /**
     * Convert decimal to hexadecimal
     * 
     * @param decimal decimal number be inputed by user
     * @return hexadecimal string
     */
    public static String toHexadecimalString(String decimal) {
        String hexadecimal = Integer.toHexString(Integer.parseInt(decimal))
                .toUpperCase();
        return hexadecimal;
    }
}
