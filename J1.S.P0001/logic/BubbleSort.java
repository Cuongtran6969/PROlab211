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
    
    /**
     * random value for each element of array in range 0 to array length
     *
     * @param arrayLength the number of array to create a random array
     * @return array have value random
     */
    public static int[] randomArray(int arrayLength) {
        int[] arr = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arrayLength);
        }
        return arr;
    }
    
    /**
     * check type sort to sort ascending or descending by bubble sort
     * 
     * @param arr      the array want to sort
     * @param typeSort the type will sort is ascending or descending
     */
    public static void sortArray(int arr[], final String typeSort) {
        switch (typeSort) {
            case IConstant.ASC:
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[i] > arr[j]) {
                            int temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }
                }
                break;
            case IConstant.DESC:
                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[i] < arr[j]) {
                            int temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }
                }
                break;
        }
    }
    
    /**
     * display value of each element of array
     *
     * @param arr array want to display
     */
    public static void displayArray(int arr[]) {
        System.out.print("The array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
