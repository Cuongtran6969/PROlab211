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
public class SelectionSort {
    
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
        int min;
        switch (typeSort) {
            case IConstant.ASC:
                for (int i = 1; i < arr.length; i++) {
                    int last = arr[i];
                    int j = i;
                    while (j > 0 && arr[j - 1] > last) {
                        arr[j] = arr[j - 1];
                        j = j - 1;
                    }
                    arr[j] = last;
                }
                break;
            case IConstant.DESC:
                for (int i = 1; i < arr.length; i++) {
                    int last = arr[i];
                    int j = i;
                    while (j > 0 && arr[j - 1] < last) {
                        arr[j] = arr[j - 1];
                        j = j - 1;
                    }
                    arr[j] = last;
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
