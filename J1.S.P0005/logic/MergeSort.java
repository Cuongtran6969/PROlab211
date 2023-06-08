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
public class MergeSort {
    
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
     *  we check if the index "left" is less than the index "right", 
     *  then we continue to divide the array into two parts recursively call 
     *  the "sortArray" function for each split and keep dividing until the
     *  array is split into the smallest possible pieces, Finally, we call 
     *  the function "sortArrayByMergeSort" to concatenate the sorted parts
     *  together according to the sort specified in the string "typeSort".
     * 
     * @param arr      the array want to sort
     * @param left     index of the left most element to be sorted
     * @param right    index of the right most element to be sorted
     * @param typeSort the type will sort is ascending or descending
     */
    public static void sortArray(
            int arr[], int left, int right, final String typeSort
    ) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            sortArray(arr, left, middle, typeSort);
            sortArray(arr, middle + 1, right, typeSort);
            sortArrayByMergeSort(arr, left, middle, right, typeSort);
        }
    }
    
    /**
     * check type sort to sort ascending or descending by merge Sort
     * 
     * @param arr      the array want to sort
     * @param left     index of the left most element to be sorted
     * @param middle   index of middle array
     * @param right    index of the right most element to be sorted
     * @param typeSort the type will sort is ascending or descending
     */
    public static void sortArrayByMergeSort(
            int arr[], int left, int middle, int right, final String typeSort
    ) {
       int lengthArr1 = middle - left + 1;
       int lengthArr2 = right-middle;
       int[] leftArray = new int[lengthArr1];
       int[] rightArray = new int[lengthArr2];
       for(int i=0; i<lengthArr1; i++) {
         leftArray[i] = arr[left+i];
       }
       for(int i=0; i<lengthArr2; i++) {
         rightArray[i] = arr[middle+1+i];
       }
       int n=0;
       int m=0;
       int k=left;
       switch(typeSort) {
            case IConstant.ASC:
                while (m < leftArray.length && n < rightArray.length) {
                    if (leftArray[m] <= rightArray[n]) {
                        arr[k] = leftArray[m];
                        m++;
                    } else {
                        arr[k] = rightArray[n];
                        n++;
                    }
                    k++;
                }
                while (m < leftArray.length) {
                    arr[k] = leftArray[m];
                    m++;
                    k++;
                }
                while (n < rightArray.length) {
                    arr[k] = rightArray[n];
                    n++;
                    k++;
                }
                break;
            case IConstant.DESC:
                while (m < leftArray.length && n < rightArray.length) {
                    if (leftArray[m] >= rightArray[n]) {
                        arr[k] = leftArray[m];
                        m++;
                    } else {
                        arr[k] = rightArray[n];
                        n++;
                    }
                    k++;
                }
                while (m < leftArray.length) {
                    arr[k] = leftArray[m];
                    m++;
                    k++;
                }
                while (n < rightArray.length) {
                    arr[k] = rightArray[n];
                    n++;
                    k++;
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
