/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import util.Validate;
import logic.SelectionSort;
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
        int[] arr = SelectionSort.randomArray(arrLength);
        System.out.println("Unsorted array: ");
        SelectionSort.displayArray(arr);
        
        System.out.println("Ascending sort: ");
        SelectionSort.sortArray(arr, IConstant.ASC);
        SelectionSort.displayArray(arr);
        
        System.out.println("Descending sort: ");
        SelectionSort.sortArray(arr, IConstant.DESC);
        SelectionSort.displayArray(arr);
    }
}
