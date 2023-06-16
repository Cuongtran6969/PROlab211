/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import java.util.Random;
import constant.IConstant;
/**
 *
 * @author HP
 */
public class BubbleSort {
    private int arr[];
    
    /**
     * random value for each element of array in range 0 to array length
     *
     * @param arrayLength the number of array to create a random array
     */
    public void generateRandomArray(int arrayLength) {
        arr = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arrayLength);
        }
    }
    
    /**
     * check type sort to sort ascending or descending by bubble sort
     * 
     * @param TYPE_SORT the type will sort is ascending or descending
     */
    public void sortArray(final String TYPE_SORT) {
        switch (TYPE_SORT) {
            case IConstant.ASC:
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[i] > arr[j]) {
                            swap(i, j);
                        }
                    }
                }
                break;
            case IConstant.DESC:
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[i] < arr[j]) {
                            swap(i, j);
                        }
                    }
                }
                break;
        }
    }
    
    /**
     * display value of each element of array
     */
    public void displayArray() {
        System.out.print("The array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void swap(int firstSecond, int secondIndex) {
        int temp = arr[firstSecond];
        arr[firstSecond] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}


