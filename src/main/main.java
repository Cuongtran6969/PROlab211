/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.EmployeeManagement;
import java.util.Scanner;
import util.getValidInput;
/**
 *
 * @author HP
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        EmployeeManagement dssv = new EmployeeManagement();
        do{
            displayMenu();
            int choice = getValidInput.getInt(
                    "Enter your choice",
                    "Numeric value out of range",
                    "Invalid integer number",
                    1, 5);
            switch(choice) {
                case 1:
                    dssv.addNewEmployee();
                    break;
                case 2:
                    dssv.updateEmployee();
                    break;
                case 3: 
                    dssv.removeEmployee();
                    break;
                case 4:
                    dssv.searchEmployee();
                    break;
                case 5: 
                    dssv.sortListEmployee();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }while (true);
    }
    
    public static void displayMenu() {
        System.out.println("Choose your action: \n"
                + "1. Add employees.\n"
                + "2. Update employees.\n"
                + "3. Remove employees.\n"
                + "4. Search employees.\n"
                + "5. Sort employees by salary.\n"
                + "6. Exit.\n");
    }
    
}
