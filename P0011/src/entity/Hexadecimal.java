/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import constant.Regex;

/**
 *
 * @author dangx
 */
public class Hexadecimal {

    /**
     * Convert hexadecimal to decimal
     * 
     * @param hexadecimal the hexadecimal number be inputed by user
     * @return decimal string
     */
    public static String toDecimalString(String hexadecimal) {
        int decimalNumber = 0;
        for (int i = 0; i < hexadecimal.length(); i++) {
            char c = hexadecimal.charAt(i);
            int d = 0;
            //find index of c
            for (int j = 0; j < Regex.HEXDIGITS.length; j++) {
                if (c == Regex.HEXDIGITS[j]) {
                    d = j;
                }
            }
            decimalNumber = decimalNumber * 16 + d;
        }
        return String.valueOf(decimalNumber);
    }

    /**
     * Convert hexadecimal to binary
     * 
     * @param hexadecimal the hexadecimal number be inputed by user
     * @return binary string
     */
    public static String toBinaryString(String hexadecimal) {
        String binary = Integer.toBinaryString(Integer.parseInt(toDecimalString(hexadecimal)));
        return binary;
    }

}
