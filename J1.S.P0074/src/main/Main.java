/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import bo.logicMatrix;
import constant.Iconstant;
import entity.Matrix;
import exceptions.InvalidSizeMatrixException;
import util.Validate;
/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        logicMatrix logicMatrix = new logicMatrix();
        while (true) {
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = Validate.getInt(
                    "Enter your choice: ",
                    "Not empty input",
                    "This option is not available!",
                    "Invalid input!",
                    1, 4
            );
            Matrix firstMatrix = new Matrix();
            Matrix secondMatrix = new Matrix();
            Matrix resultsMatrix;
            switch (choice) {
                case 1:
                    try{
                    logicMatrix.createMatrix(
                            firstMatrix, secondMatrix,
                            Iconstant.ADDITION
                    );
                    System.out.println("=======Result=======");
                    firstMatrix.displayMatrix();
                    System.out.println("+");
                    secondMatrix.displayMatrix();
                    resultsMatrix = firstMatrix.addition(secondMatrix);
                    System.out.println("=");
                    resultsMatrix.displayMatrix();
                    }catch(InvalidSizeMatrixException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try{
                    logicMatrix.createMatrix(
                            firstMatrix, secondMatrix,
                            Iconstant.SUBTRACTION
                    );
                    System.out.println("=======Result=======");
                    firstMatrix.displayMatrix();
                    System.out.println("-");
                    secondMatrix.displayMatrix();
                    resultsMatrix = firstMatrix.subtraction(secondMatrix);
                    System.out.println("=");
                    resultsMatrix.displayMatrix();
                    }catch(InvalidSizeMatrixException e) {
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                case 3:
                    try{
                    logicMatrix.createMatrix(
                            firstMatrix, secondMatrix,
                            Iconstant.MULTIPLICATION
                    );
                    System.out.println("=======Result=======");
                    firstMatrix.displayMatrix();
                    System.out.println("*");
                    secondMatrix.displayMatrix();
                    resultsMatrix = firstMatrix.multiplication(secondMatrix);
                    System.out.println("=");
                    resultsMatrix.displayMatrix();
                    }catch(InvalidSizeMatrixException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
}
