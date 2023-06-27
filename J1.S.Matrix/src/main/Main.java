/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import constant.Iconstant;
import logic.LogicMatrix;
import util.Validate;
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
            int choice = validate.getInt(
                    "Enter your choice: ",
                    "This option is not available!",
                    "Invalid input!",
                    1, 4
            );

            int[][] matrix1, matrix2, matrixResult;
            boolean validCalcualte;
            switch (choice) {
                case 1:
                    matrix1 = logicMatrix.createMatrix(1);
                    matrix2 = logicMatrix.createMatrix(2);
                    validCalcualte = logicMatrix.checkValidateCalculate(
                            matrix1, matrix2, Iconstant.ADDITION
                    );
                    if (validCalcualte) {
                        System.out.println("-----------Result-----------");
                        logicMatrix.displayMatrix(matrix1);
                        System.out.println("+");
                        logicMatrix.displayMatrix(matrix2);
                        System.out.println("=");
                        matrixResult = logicMatrix.additionMatrix(
                                matrix1, matrix2
                        );
                        logicMatrix.displayMatrix(matrixResult);
                    } else {
                        System.out.println(
                                "Cannot perform subtraction on two matrices, "
                                + "need number col of this matrix equal number "
                                + "col other matrix"
                        );
                    }
                    break;
                case 2:
                    matrix1 = logicMatrix.createMatrix(1);
                    matrix2 = logicMatrix.createMatrix(2);
                    validCalcualte = logicMatrix.checkValidateCalculate(
                            matrix1, matrix2, Iconstant.SUBTRACTION
                    );
                    if (validCalcualte) {
                        System.out.println("-----------Result-----------");
                        logicMatrix.displayMatrix(matrix1);
                        System.out.println("-");
                        logicMatrix.displayMatrix(matrix2);
                        System.out.println("=");
                        matrixResult = logicMatrix.subtractionMatrix(
                                matrix1, matrix2
                        );
                        logicMatrix.displayMatrix(matrixResult);
                    } else {
                        System.out.println(
                                "Cannot perform subtraction on two matrices, "
                                + "need number col of this matrix equal number "
                                + "col other matrix"
                        );
                    }
                    break;
                case 3:
                    matrix1 = logicMatrix.createMatrix(1);
                    matrix2 = logicMatrix.createMatrix(2);
                    validCalcualte = logicMatrix.checkValidateCalculate(
                            matrix1, matrix2, Iconstant.MULTIPLICATION
                    );
                    if (validCalcualte) {
                        System.out.println("-----------Result-----------");
                        logicMatrix.displayMatrix(matrix1);
                        System.out.println("*");
                        logicMatrix.displayMatrix(matrix2);
                        System.out.println("=");
                        matrixResult = logicMatrix.multiplicationMatrix(
                                matrix1, matrix2
                        );
                        logicMatrix.displayMatrix(matrixResult);
                    } else {
                        System.out.println(
                                "Cannot perform multipcation on two matrices, "
                                + "need number col of this matrix equal number "
                                + "row of other matrix"
                        );
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
}
