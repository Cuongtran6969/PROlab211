package main;

import java.util.Scanner;
import Validator.Validator;
import Function.LinearSearch;
import java.util.ArrayList;


/*
 *
 * @author THAYCACAC
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int length = Validator.getInt(
                "Enter number of array: ",
                "The number must be positive",
                "The number is wrong format",
                1, Integer.MAX_VALUE
        );
        LinearSearch searcher = new LinearSearch(new int[length]);
        searcher.generateRandomArray();
        System.out.print("The array: ");
        searcher.displayArray();
        int valueSearch = Validator.getInt(
                "Enter search value: ",
                "",
                "The number is wrong format",
                Integer.MIN_VALUE, Integer.MAX_VALUE
        );
        ArrayList foundIndex = searcher.search(valueSearch);
        if (foundIndex.size() > 0) {
            System.out.print("Found " + valueSearch + " at index: ");
            for (int i = 0; i < foundIndex.size(); i++) {
                System.out.print(
                    foundIndex.get(i)
                );
                if(i < foundIndex.size() - 1) {
                    System.out.print(", ");
                }
            }
        } else {
            System.out.println(
                    "Not found " + valueSearch + " in array"
            );
        }
    }
}
