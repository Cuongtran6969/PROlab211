/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import logic.LogicMatrix;
import util.Validate;
import constant.Iconstant;
/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        LogicMatrix logicMatrix = new LogicMatrix();
        Validate validate = new Validate();
        while (true) {
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.println();
            int choice = validate.getInt(
                    "Enter your choice: ",
                    "This option is not available!",
                    "Invalid input!",
                    1, 4);
            int[][] matrix1, matrix2;
            switch (choice) {
                case 1:
                    matrix1 = logicMatrix.createMatrix(1);
                    matrix2 = logicMatrix.createMatrix(2);
                    logicMatrix.additionMatrix(
                            matrix1, matrix2, Iconstant.ADDITION
                    );
                    break;
                case 2:
                    matrix1 = logicMatrix.createMatrix(1);
                    matrix2 = logicMatrix.createMatrix(2);
                    logicMatrix.subtractionMatrix(
                            matrix1, matrix2, Iconstant.SUBTRACTION
                    );
                    break;
                case 3:
                    matrix1 = logicMatrix.createMatrix(1);
                    matrix2 = logicMatrix.createMatrix(2);
                    logicMatrix.multiplicationMatrix(
                            matrix1, matrix2, Iconstant.MULTIPLICATION
                    );
                    break;
                case 4:
                    return;
            }
        }
    }
}
