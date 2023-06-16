/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import util.Validate;
import constant.IConstant;
import logic.BubbleSort;
/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int arrLength;
        arrLength = Validate.getInt(
                "Enter number of array: ",
                "Input value out of range!",
                "Invalid number!",
                0, Integer.MAX_VALUE);
        bubbleSort.generateRandomArray(arrLength);
        System.out.println("Unsorted array: ");
        bubbleSort.displayArray();
        
        System.out.println("Ascending sort: ");
        bubbleSort.sortArray(IConstant.ASC);
        bubbleSort.displayArray();
        
        System.out.println("Descending sort: ");
        bubbleSort.sortArray(IConstant.DESC);
        bubbleSort.displayArray();
    }
}
