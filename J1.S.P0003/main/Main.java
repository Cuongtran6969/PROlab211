/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import util.Validate;
import logic.InsertionSort;
import constant.IConstant;
/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        int arrLength;
        arrLength = Validate.getInt(
                "Enter number of array: ",
                "Input value out of range!",
                "Invalid number!",
                0, Integer.MAX_VALUE);
        int[] arr = InsertionSort.randomArray(arrLength);
        System.out.println("Unsorted array: ");
        InsertionSort.displayArray(arr);
        
        System.out.println("Ascending sort: ");
        InsertionSort.sortArray(arr, IConstant.ASC);
        InsertionSort.displayArray(arr);
        
        System.out.println("Descending sort: ");
        InsertionSort.sortArray(arr, IConstant.DESC);
        InsertionSort.displayArray(arr);
    }
}
