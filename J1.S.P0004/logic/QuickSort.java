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
public class InsertionSort {
    
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
     * check type sort to sort ascending or descending by quick sort
     * 
     * @param arr      the array want to sort
     * @param left     index of the left most element to be sorted
     * @param right    index of the right most element to be sorted
     * @param typeSort the type will sort is ascending or descending
     */
    public static void sortArrayByQuickSort(
            int arr[], int left, int right, final String typeSort
    ) {
        int middle = (left + right) / 2;
        int i = left;
        int j = right;
        int pri = arr[middle];
        switch (typeSort) {
            case IConstant.ASC:
                while (i <= j) {
                    while (arr[i] < pri) {
                        i++;
                    }
                    while (arr[j] > pri) {
                        j--;
                    }
                    if (i <= j) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        i++;
                        j--;
                    }
                }

                if (left < j) {
                    sortArrayByQuickSort(arr, left, j, IConstant.ASC);
                }
                if (right > i) {
                    sortArrayByQuickSort(arr, i, right, IConstant.ASC);
                }
                break;
            case IConstant.DESC:
                while (i <= j) {
                    while (arr[i] > pri) {
                        i++;
                    }
                    while (arr[j] < pri) {
                        j--;
                    }
                    if (i <= j) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        i++;
                        j--;
                    }
                }

                if (left < j) {
                    sortArrayByQuickSort(arr, left, j, IConstant.DESC);
                }
                if (right > i) {
                    sortArrayByQuickSort(arr, i, right, IConstant.DESC);
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
