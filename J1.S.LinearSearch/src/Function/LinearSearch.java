/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author acer
 */
public class LinearSearch {
    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public LinearSearch(int[] array) {
        this.arr = array;
    }

    /**
     * generate array have value is random in range from 0 to array length
     */
    public void generateRandomArray() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(arr.length);
        }
    }

    /**
     * display value of array
     */
    public void displayArray() {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * @param key the value want to search
     * @return the array list contain index of find value
     */
    public ArrayList search(int key) {
        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                indexList.add(i);
            }
        }
        return indexList;
    }
}
